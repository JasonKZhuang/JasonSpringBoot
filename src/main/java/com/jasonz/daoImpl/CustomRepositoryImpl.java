package com.jasonz.daoImpl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jasonz.dao.ICustomRepository;

/**
 * @author Jason Zhuang
 * @version Create Date：Aug 22, 2018 9:56:10 AM
 */
@Repository
public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements ICustomRepository<T, ID>, Serializable
{
	private static final long serialVersionUID = 1L;

	private final int batchSize = 1000;

	private final EntityManager localEM;

	public CustomRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager)
	{
		super(entityInformation, entityManager);
		this.localEM = entityManager;
		// this.entityInformation = entityInformation;
		// this.provider =
		// DefaultPersistenceProvider.fromEntityManager(entityManager);
		// this.springDataRepositoryInterface = springDataRepositoryInterface;
	}

	public CustomRepositoryImpl(Class<T> domainClass, EntityManager em)
	{
		this(JpaEntityInformationSupport.getEntityInformation(domainClass, em), em);
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
