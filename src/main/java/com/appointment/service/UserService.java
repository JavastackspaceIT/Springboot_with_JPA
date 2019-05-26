package com.appointment.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.appointment.dao.UserRepository;
import com.appointment.exception.UserException;
import com.appointment.exception.UserNotFoundException;
import com.appointment.model.StudentForm;
import com.appointment.model.User;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository repository;

	/*
	 * @PostConstruct public void initDB() { List<User> users = new ArrayList<>();
	 * users.add(new User(111, "x", "IT", 23)); users.add(new User(675, "y", "IT",
	 * 24)); users.add(new User(432, "z", "CIVIL", 26)); users.add(new User(88, "p",
	 * "IT", 23)); users.add(new User(765, "q", "GOVT", 20));
	 * repository.saveAll(users); }
	 */

	public List<User> getUsers() {
		return repository.findAll();
	}

	public List<User> getUserByProfession(String profession) {
		return repository.findByProfession(profession);
	}

	public long getCounts(int age) {
		return repository.countByAge(age);
	}

	public List<User> deleteUser(String name) {
		return repository.deleteByName(name);
	}

	public Integer deleteUser(Integer integer) throws UserNotFoundException {
		int response = 0;
		try {
			repository.deleteById(integer);
			response = 1;
		} catch (Exception exception) {
			throw new UserNotFoundException("User Not found  ");
		}
		return response;
	}

	public List<User> findByMultiCondition(String profession, int age) {
		return repository.findByProfessionAndAge(profession, age);
	}

	public List<User> getUsersIgnoreCase(String profession) {
		return repository.findByProfessionIgnoreCase(profession);
	}

	// sort
	public List<User> getUserSort(String field) {
		return repository.findAll(new Sort(field));
	}

	// pagination
	public Page<User> getPaginatedUser() {
		return repository.findAll(new PageRequest(0, 3));
	}

	// custom Query
	public List<User> getUsersCustomQuery() {
		return repository.getUsersCustomQuery();
	}

	public int createStudent(StudentForm studentDto) throws UserException {
		User user = new User();
		int status = 0;
		try {
			BeanUtils.copyProperties(studentDto, user);
			repository.save(user);
			status = 1;
		} catch (Exception e) {
			throw new UserException("Exception while saving the user records ");
		}
		return status;
	}

	public int updateStudent(StudentForm studentDto) throws UserException {
		User user = new User();
		int status = 0;
		try {
			List<User> userList = repository.findByProfession(studentDto.getProfession());
			for (User userL : userList) {
				user.setAge(studentDto.getAge());
				repository.save(user);
			}

			status = 1;
		} catch (Exception e) {
			throw new UserException("Exception while saving the user records ");
		}
		return status;
	}
}
