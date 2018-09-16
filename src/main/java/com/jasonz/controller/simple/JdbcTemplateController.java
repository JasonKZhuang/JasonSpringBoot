package com.jasonz.controller.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @author Jason Zhuang
* @version Create Date：Aug 7, 2018 4:41:14 PM 
*/
@RestController
public class JdbcTemplateController
{
	@Autowired  
    public JdbcTemplate jdbc;  
	
    @RequestMapping("/add")  
    public String add()
    {  
        String sql = "insert into test(companyid,LegalName) "
        		+ " values ('aaaaaaa','bbbbb1bbb') ";
    	jdbc.execute(sql);  
        return"data inserted Successfully";  
    }  
}
