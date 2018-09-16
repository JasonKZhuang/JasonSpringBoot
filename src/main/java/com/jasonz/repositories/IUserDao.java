package com.jasonz.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jasonz.entities.UserRecord;

/** 
* @author Jason Zhuang
* @version Create Date：Aug 15, 2018 11:20:47 AM 
*/
public interface IUserDao extends CrudRepository<UserRecord, Integer>
{

}
