package com.jasonz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasonz.dao.IUserRepository;
import com.jasonz.entities.UserRecord;

/** 
* @author Jason Zhuang
* @version Create Date：Aug 15, 2018 11:19:39 AM 
*/

@Service
public class UserService
{
	@Autowired
    private IUserRepository userRepository;  
    
	public List<UserRecord> getAllUsers()
    {  
        List<UserRecord>userRecords = new ArrayList<>();
        
        userRepository.findAll().forEach(userRecords::add);  
        
        return userRecords;  
    }
	
    public Optional<UserRecord> getUser(int id)
    {
        return userRepository.findById(id);
    }  
    
    public void addUser(UserRecord userRecord)
    {
        userRepository.save(userRecord);  
    }  
    
    public void delete(int id)
    {  
        userRepository.deleteById(id); 
    }  
}
