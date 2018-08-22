package com.jasonz.dao;

import org.springframework.data.repository.CrudRepository;

import com.jasonz.entities.ShareCompany;

/**
 * @author Jason Zhuang
 * @version Create Date：Aug 7, 2018 4:51:40 PM
 */
public interface IShareCompanyRepository extends CrudRepository<ShareCompany, String>
										
{
	
}
