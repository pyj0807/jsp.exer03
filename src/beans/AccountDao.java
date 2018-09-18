package beans;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AccountDao {
	SqlSessionFactory factory;

	public AccountDao() throws IOException{
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
	}
	
	public Map getidpass(String a) {
		SqlSession sql = factory.openSession();
		try {
			Map p = sql.selectOne("account.getidpass");
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Map getidname(String a) {
		SqlSession sql = factory.openSession();
		try {
			Map m = sql.selectOne("account.getidname");
			return m;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int adddata(Map map) {
		SqlSession sql = factory.openSession();
		try {
			
			int r = sql.insert("account.addData", map);
			if(r==1) 
				sql.commit();
			
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	
	
}
