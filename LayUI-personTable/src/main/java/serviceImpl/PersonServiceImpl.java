package serviceImpl;

import java.sql.SQLException;
import java.util.List;

import dao.IPersonDao;
import dao.impl.PersonDaoImpl;
import entity.Person;
import service.PersonService;

public class PersonServiceImpl  implements PersonService{
	private IPersonDao personDao=new PersonDaoImpl();

	@Override
	public List<Person> getAllPesonByPage(int page, int limit) throws SQLException {
		// TODO Auto-generated method stub
		return personDao.getAllPesonByPage(page,limit);
	}

	@Override
	public Long getPesonCount() throws SQLException {
		// TODO Auto-generated method stub
		return personDao.getPesonCount();
	}

	@Override
	public int deletePerson(int id) throws SQLException {
		// TODO Auto-generated method stub
		return personDao.deletePerson(id);
	}

	@Override
	public int updatePerson(Person person) throws SQLException {
		// TODO Auto-generated method stub
		return personDao.updatePerson(person);
	}
	
	
}
