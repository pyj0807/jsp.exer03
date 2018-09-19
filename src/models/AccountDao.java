package models;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AccountDao {
	SqlSessionFactory factory;

	public AccountDao() throws IOException{
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream is = Resources.getResourceAsStream("Mybatis-config.xml");
		factory = builder.build(is);
	}
	
	
	public Map getAccountById(String id){
		SqlSession sql = factory.openSession();
		try {
			Map p = sql.selectOne("account.getAccountById",id);
			return p;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sql.close();
		}
	}
	
	// �α��ο�
	public Map loginCheck(Map map){
		SqlSession sql = factory.openSession();
		try {
			Map p = sql.selectOne("account.loginCheck",map);
			System.out.println(p);
			return p;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	// ����
	public int addAccount(Map map) {
		SqlSession sql = factory.openSession();
		try {
			int r = sql.insert("account.addAccount",map);
			if(r==1) {
				sql.commit();
			}
			return r;
			
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}



	
	
	//selectOne�� null üũ,  selectlist�� -1,-1�� üũ
	
	
}
