package com.jasonz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jasonz.dao.IShareCompanyRepository;
import com.jasonz.entities.ShareCompany;

/** 
* @author Jason Zhuang
* @version Create Date：Aug 7, 2018 4:41:14 PM 
*/
@RestController
public class SpringBootJdbcController
{
	@Autowired  
    public JdbcTemplate jdbc;  
	
	
	@Autowired
	private IShareCompanyRepository repository;
	
	
    @RequestMapping("/insertsc")  
    public String insertsc()
    {  
        String sql = "insert into test(companyid,LegalName) "
        		+ " values ('aaaaaaa','bbbbb1bbb') ";
    	jdbc.execute(sql);  
        return"data inserted Successfully";  
    }  
    
    
    @GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNew (@RequestParam String companyId
			, @RequestParam String companyName) 
    {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		ShareCompany sc = new ShareCompany();
		sc.setCompanyId(companyId);
		sc.setLegalName(companyName);
		repository.save(sc);
		
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<ShareCompany> getAll() 
	{
		// This returns a JSON or XML with the users
		return repository.findAll();
	}
}
