package com.jasonz.dao;

import org.springframework.data.repository.CrudRepository;

import com.jasonz.entities.SharePrice;

/** 
* @author Jason Zhuang
* @version Create Date：Aug 21, 2018 1:43:51 PM 
*/
public interface ISharePriceDao extends CrudRepository<SharePrice, Long>
{
	
}
