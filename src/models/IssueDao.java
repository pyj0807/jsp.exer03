package models;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class IssueDao {
	SqlSessionFactory factory;
	
	public IssueDao() throws IOException{
		super();
	}
	
	public int addData(Map map) {
		SqlSession sql = factory.openSession();
		try {
			int r = sql.insert("addData", map);
			if(r ==1)
				sql.commit();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public List<Map> getAllDatas() {
		SqlSession sql =factory.openSession();	
		try {
			List<Map> p = sql.selectList("getAllData");
			return p;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
