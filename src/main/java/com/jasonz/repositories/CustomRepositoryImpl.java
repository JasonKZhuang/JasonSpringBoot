package com.jasonz.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.PersistenceProvider;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jason Zhuang
 * @version Create Date：Aug 22, 2018 9:56:10 AM
 */
@Repository
@Transactional(readOnly = false)
public class CustomRepositoryImpl<T, ID extends Serializable> 
		extends SimpleJpaRepository<T, ID>
		implements ICustomRepository<T, ID>
{
	private final int batchSize = 1000;
	private JpaEntityInformation<T, ?> entityInformation;
	private EntityManager localEM;
	private PersistenceProvider provider;
	
	public PersistenceProvider getProvider()
	{
		return provider;
	}

	public void setProvider(PersistenceProvider provider)
	{
		this.provider = provider;
	}

	//@Autowired
	public CustomRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) 
	{
		super(entityInformation, entityManager);
		this.localEM = entityManager;
		this.entityInformation = entityInformation;
		this.provider = PersistenceProvider.fromEntityManager(entityManager);
	}
	
	@Autowired
	public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) 
	{
		    super(domainClass, entityManager);
		    // This is the recommended method for accessing inherited class dependencies.
		    this.localEM = entityManager;
	}
	
	public JpaEntityInformation<T, ?> getEntityInformation()
	{
		return entityInformation;
	}


	@Override
	public void truncateTable(String tableName)
	{
		localEM.flush();
		localEM.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate();
		localEM.clear();
	}

	@Override
	@Transactional
	public int insertBatch(List<T> entities)
	{
		try
		{
			int length = entities.size();
			for (int i = 0; i < length; i++)
			{
				if (i > 0 && i % batchSize == 0)
				{
					localEM.flush();
					localEM.clear();
				}
				localEM.persist(entities.get(i));
			}
			localEM.flush();
			localEM.clear();
		} catch (Exception exp)
		{
			exp.printStackTrace();
			localEM.clear();
			return -1;
		}

		return 0;
	}

}
