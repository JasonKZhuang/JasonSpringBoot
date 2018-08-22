package com.jasonz.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Jason Zhuang
 * 2018/08/21
 */
@JsonAutoDetect
@Entity
@Table(name = "SharePrice")
public class SharePrice implements Serializable
{
	private static final long serialVersionUID = -1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "RecId", nullable = false, length = 20 )
	private long recId;
	
	@Column(name = "ShareClassId", length = 20, nullable = false)
	private String shareClassId;

	@JsonFormat(pattern="yyyy/MM/dd")
	@Column(name = "AsOfDate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date asOfDate;
	
	@Column(name = "ClosePrice")
	private double closePrice;

	@Column(name = "Volumn")
	private long volumn;

	@Column(name = "OpenPrice")
	private double openPrice;

	@Column(name = "DayHigh")
	private double dayHigh;

	@Column(name = "DayLow")
	private double dayLow;

	
	public SharePrice()
	{
	}


	public long getRecId()
	{
		return recId;
	}


	public void setRecId(long recId)
	{
		this.recId = recId;
	}


	public String getShareClassId()
	{
		return shareClassId;
	}


	public void setShareClassId(String shareClassId)
	{
		this.shareClassId = shareClassId;
	}


	public Date getAsOfDate()
	{
		return asOfDate;
	}


	public void setAsOfDate(Date asOfDate)
	{
		this.asOfDate = asOfDate;
	}


	public double getClosePrice()
	{
		return closePrice;
	}


	public void setClosePrice(double closePrice)
	{
		this.closePrice = closePrice;
	}


	public long getVolumn()
	{
		return volumn;
	}


	public void setVolumn(long volumn)
	{
		this.volumn = volumn;
	}


	public double getOpenPrice()
	{
		return openPrice;
	}


	public void setOpenPrice(double openPrice)
	{
		this.openPrice = openPrice;
	}


	public double getDayHigh()
	{
		return dayHigh;
	}


	public void setDayHigh(double dayHigh)
	{
		this.dayHigh = dayHigh;
	}


	public double getDayLow()
	{
		return dayLow;
	}


	public void setDayLow(double dayLow)
	{
		this.dayLow = dayLow;
	}


}
