package com.jasonz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jasonz.entities.UserRecord;
import com.jasonz.service.UserService;

/**
 * @author Jason Zhuang
 * @version Create Date：Aug 15, 2018 11:35:03 AM
 */
@RestController
public class UserController
{
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public List<UserRecord> getAllUser()
	{
		List<UserRecord> retList = userService.getAllUsers();
		return retList;
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public void addUser(@RequestBody UserRecord userRecord)
	{
		userService.addUser(userRecord);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public Optional<UserRecord> getUser(@PathVariable String id)
	{
		Optional<UserRecord> retObject = userService.getUser(Integer.valueOf(id));
		return retObject;
	}
}
