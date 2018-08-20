package com.wang.service;

import com.wang.dao.ChildrenMapper;
import com.wang.dao.WifeMapper;
import com.wang.model.Children;
import com.wang.model.ChildrenExample;
import com.wang.model.Wife;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Wifeservice {
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
    public void a(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
//        ChildrenMapper children=sqlSession.getMapper(ChildrenMapper.class);
//        children.selectByPrimaryKey(1);
        Children children=(Children) sqlSession.selectOne("com.wang.dao.ChildrenMapper.selectByPrimaryKey",3);
        System.out.println(children.getWife().getWifename());


    }
        @Test
    public void deleteByPrimaryKey() {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Wife wife=new Wife();
//            wife.setId(1);
             wife=(Wife)sqlSession.selectOne("com.wang.dao.WifeMapper.selectByPrimaryKey","1");
//            List<Children> childrenList=wife.getChildrenList();

            System.out.println(wife.getChildrenList());

        }


}
