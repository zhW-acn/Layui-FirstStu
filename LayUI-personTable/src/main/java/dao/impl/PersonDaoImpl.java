package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dao.IPersonDao;
import entity.Person;
import util.JDBCUtil;





public class PersonDaoImpl implements IPersonDao {
	QueryRunner qr=new QueryRunner(JDBCUtil.getDataSource());
	
	@Override
	public List<Person> getAllPesonByPage(int page, int limit) throws SQLException {
		// TODO Auto-generated method stub
		List<Person> persons= qr.query("select * from t_person limit ?,? ",new BeanListHandler<Person>(Person.class),((page-1)*limit),limit);
		return persons;
	}

	@Override
	public Long getPesonCount() throws SQLException {
		// TODO Auto-generated method stub
		long  persons= qr.query("select count(*) from t_person",new ScalarHandler<>());
		return persons;
	}

	@Override
	public int deletePerson(int id) throws SQLException {
		// TODO Auto-generated method stub
		int i=qr.update("delete from t_person where id=?",id);
		return i;
	}

	@Override
	public int updatePerson(Person person) throws SQLException {
		// TODO Auto-generated method stub
		int i=qr.update("update t_person set username=?,password=? where id=?",person.getUsername(),person.getPassword(),person.getId());
		return i;
	}


}
