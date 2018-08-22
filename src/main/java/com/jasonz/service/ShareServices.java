package com.jasonz.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jasonz.dao.ISharePriceDao;
import com.jasonz.entities.SharePrice;
import com.jasonz.utils.JDateUtils;
import com.jasonz.utils.StaticUtils;

/**
 * @author Jason Zhuang
 * @version Create Date：Aug 21, 2018 1:49:04 PM
 */
@Service
public class ShareServices
{
	//@Autowired
	private ISharePriceDao spDao;

	//@Autowired
	//private IUserDao userRepository;

	public void importFiles()
	{
		spDao.deleteAll();
		//spDao.truncateTable("SharePrice");

		List<String> files = StaticUtils.getCSVDataFileNames();
		for (String name : files)
		{
			importFile(name);
		}

	}

	private void importFile(String fileName)
	{
		List<SharePrice> entityList = new ArrayList<>();
		try
		{
			BufferedReader br = null;
			try
			{
				br = new BufferedReader(new FileReader(fileName));
				// =================================//
				String line;
				br.readLine();
				br.readLine();
				while ((line = br.readLine()) != null)
				{
					line = line.replace("\"", "");
					String[] data = line.split(",");
					SharePrice spBean = new SharePrice();
					spBean.setShareClassId(fileName.substring(fileName.lastIndexOf("\\")+1, fileName.indexOf(".")));
					spBean.setAsOfDate(JDateUtils.convertStringToDate("yyyy/MM/dd",data[0]));
					spBean.setClosePrice(Double.parseDouble(data[1]));
					spBean.setVolumn((long)Double.parseDouble(data[2]) );
					spBean.setOpenPrice(Double.parseDouble(data[3]));
					spBean.setDayHigh(Double.parseDouble(data[4]));
					spBean.setDayLow(Double.parseDouble(data[5]));
					entityList.add(spBean);
					spDao.save(spBean);
				}
				// =================================//
			} catch (Exception exp)
			{
				exp.printStackTrace();
			} finally
			{
				if (br != null)
				{
					br.close();
				}
			}
			
			//spDao.insertBatch(entityList);
			
		} catch (Exception exc)
		{
			exc.printStackTrace();
		}
	}

}
