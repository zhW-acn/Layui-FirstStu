package service;

import java.sql.SQLException;
import java.util.List;

import entity.Person;

public interface PersonService {
	List<Person> getAllPesonByPage(int page,int limit) throws SQLException;
	Long getPesonCount() throws SQLException;
	int deletePerson(int id) throws SQLException;
	int updatePerson(Person person) throws SQLException;
}
