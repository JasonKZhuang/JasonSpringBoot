package com.jasonz.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Jason Zhuang
 * @version Create Date：Aug 22, 2018 9:44:01 AM
 */
@NoRepositoryBean
public interface ICustomRepository<T,ID extends Serializable>	   
{
	public void truncateTable(String tableName);
	
	public int insertBatch(List<T> entityList);
}
