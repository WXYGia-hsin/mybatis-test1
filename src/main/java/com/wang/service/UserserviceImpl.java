package com.wang.service;

import com.wang.dao.UserMapper;
import com.wang.model.User;
import com.wang.model.UserExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class UserserviceImpl  {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws Exception{
       try {
           FileReader file=new FileReader("src/mybatis.cfg.xml");

           sqlSessionFactory=new SqlSessionFactoryBuilder().build(file);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } finally {
       }

   }
    @Test
    public void add(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=new User();
        user.setId(19);
        user.setUsername("haer");
        user.setPassword("156");
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.insertSelective(user);
//        userMapper.insert(user);
        //        sqlSession.insert("com.dao.UserMapper.insert",user);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testFindUserById() throws Exception{
       SqlSession sqlSession=sqlSessionFactory.openSession();
       UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
       User user=userMapper.selectByPrimaryKey(15);
        User user1=userMapper.selectByPrimaryKey(20);
        System.out.println(user.getUsername());
        sqlSession.close();
    }
    @Test
    public void testdeleteByPrimaryKey() throws Exception {
        //通过工厂创建会话
        SqlSession openSession = sqlSessionFactory.openSession();
        //通过会话的getMapper方法来实例化 接口
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        Integer list=mapper.deleteByPrimaryKey(19);
       openSession.commit();
       openSession.close();

       }
    @Test
    public void testcountByExample() throws Exception {
        //通过工厂创建会话
        SqlSession openSession = sqlSessionFactory.openSession();
        //通过会话的getMapper方法来实例化 接口
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        UserExample userExample=new UserExample();
        userExample.createCriteria();
        System.out.println(mapper.countByExample(userExample));
        openSession.commit();
        openSession.close();
        }
    @Test
    public void testdeleteByExample() throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        UserExample userExample=new UserExample();
        userExample.createCriteria().andIdEqualTo(18);
        mapper.deleteByExample(userExample);
        openSession.commit();
        openSession.close();
        }
    @Test
    public void testselectByExample() throws Exception {
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        UserExample userExample=new UserExample();
        userExample.createCriteria().andIdBetween(5,17);
        List<User> users=mapper.selectByExample(userExample);
        for (User u:users) {
            System.out.println(u.getId()+"  "+u.getUsername());
        }
        openSession.close();
    }

}
