package models;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class IssueDao {
	SqlSessionFactory factory;
	
	public IssueDao() throws IOException{
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream is = Resources.getResourceAsStream("Mybatis-config.xml");
		factory = builder.build(is);
	}
	
	public int addData(Map map) {
		SqlSession sql = factory.openSession();
		try {
			int r = sql.insert("issue.addData", map);
			if(r ==1)
				sql.commit();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public List<Map> getAllData() {
		SqlSession sql =factory.openSession();	
		try {
			List<Map> p = sql.selectList("issue.getAllData");
			return p;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Map getOneByNo(int no) {
		SqlSession session = factory.openSession();
		try {
			
			return session.selectOne("issue.getOneData", no);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
