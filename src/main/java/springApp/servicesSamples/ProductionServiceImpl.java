package springApp.servicesSamples;

import springApp.daoSamples.CategoryDao;
import springApp.daoSamples.ProductionDao;

public class ProductionServiceImpl implements ProductionService
{
	private ProductionDao productionDao;
	
	private CategoryDao   categoryDao;
	
	public ProductionDao getProductionDao()
	{
		return productionDao;
	}

	public void setProductionDao(ProductionDao productionDao)
	{
		this.productionDao = productionDao;
	}

	public CategoryDao getCategoryDao()
	{
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao)
	{
		this.categoryDao = categoryDao;
	}

	@Override
	public void getList()
	{
		System.out.println("==>This is getList method from Production Service.");
		
	}
	
	
	

}
