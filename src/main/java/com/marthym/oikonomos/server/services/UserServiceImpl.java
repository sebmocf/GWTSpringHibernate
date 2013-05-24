package com.marthym.oikonomos.server.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.marthym.oikonomos.client.services.UserService;
import com.marthym.oikonomos.server.repositories.UserRepository;
import com.marthym.oikonomos.shared.model.User;

@Service("userService")
public class UserServiceImpl extends RemoteServiceServlet implements UserService{
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUser(String userId) {
		return userRepository.findOne(userId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveUser(String userId, String firstName, String lastName, String password, Date registration, Date lastlogin) throws Exception {
		User user = userRepository.findOne(userId);
		if (user == null) {
			user = new User(userId, firstName, lastName, password, registration, lastlogin);
			user = userRepository.save(user);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateUser(String userId, String firstName, String lastName, String password, Date lastlogin) throws Exception {
		User user = userRepository.findOne(userId);
		if (user != null) {
			user.setUserFirstname(firstName);
			user.setUserLastname(lastName);
			user.setUserPassword(password);
			user.setUserLastLoginDate(lastlogin);
			userRepository.save(user);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteUser(String employeeId) throws Exception {
		User user = userRepository.findOne(employeeId);
		if (user != null)
			userRepository.delete(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveOrUpdateUser(String userId, String firstName, String lastName, String password, Date registration, Date lastlogin) throws Exception {
		User user = new User(userId, firstName, lastName, password, registration, lastlogin);
		userRepository.save(user);
	}

}
