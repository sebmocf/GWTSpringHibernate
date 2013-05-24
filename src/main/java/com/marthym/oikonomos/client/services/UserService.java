package com.marthym.oikonomos.client.services;

import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.marthym.oikonomos.shared.model.User;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("springGwtServices/userService")
public interface UserService extends RemoteService {
	
	public User findUser(String userId);
	public void saveUser(String userId, String firstName, String lastName, String password, Date registration, Date lastlogin) throws Exception;
	public void updateUser(String userId, String firstName, String lastName, String password, Date lastlogin) throws Exception;
	public void saveOrUpdateUser(String userId, String firstName, String lastName, String password, Date registration, Date lastlogin) throws Exception;
	public void deleteUser(String userId) throws Exception;

}
