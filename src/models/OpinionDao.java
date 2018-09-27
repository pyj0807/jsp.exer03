package models;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class OpinionDao extends MybatisDao{

	public OpinionDao() throws IOException {
		super();
	}
	
	public int addOne(Map a) {
		SqlSession sql = factory.openSession();
		try {
			int i = sql.insert("opinion.addOne",a);
			if(i==1) {
				sql.commit();
			}
			return i;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			sql.close();
		}
	}
	
	public List<Map> getSomeByIno(int ino) {
		SqlSession sql = factory.openSession();
		try {
			List<Map> list = sql.selectList("opinion.getSomeByIno",ino);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sql.close();
		}
	}
	// «÷¿ÃΩ¥ 
	public List<Map> hotissue() {
		SqlSession sql = factory.openSession();
		try {
			List<Map> p = sql.selectList("opinion.getCountByChoice2");
			return p;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	// ≥ª∞° ¿«∞ﬂ ≥≤±‰ ¿ÃΩ¥
	public List<Map> myissue(String id) {
		SqlSession sql = factory.openSession();
		try {
			return sql.selectList("opinion.getSomeByTalker",id);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	 
}
