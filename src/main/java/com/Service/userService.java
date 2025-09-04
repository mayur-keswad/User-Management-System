package com.Service;

import java.util.List;

import com.Entity.User;
import com.dto.UserDto;

public interface userService {


	void getuserInservice(User user);

	UserDto getuserByidinservice(int uid);

	UserDto updateUser(int id, User user);

	boolean deleteUser(int id);

	List<UserDto> getAllUsers();

}
