/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jasonz.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kaizhi Zhuang
 */
@Entity
@Table(name = "sharecompany")
public class ShareCompany implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "CompanyId", nullable = false, length = 20 )
    private String companyId;
    
    @Column(name = "ShareClassId", length = 20)
    private String shareClassId;

    @Column(name = "LegalName", length = 100)
    private String legalName;
    
    @Column(name="HeadquarterPhone")
    private String headquarterPhone;

    @Column(name="HeadquarterFax")
    private String headquarterFax;
    
    @Column(name="ContactEmail")
    private String contactEmail;
    
    @Column(name="StyleBox")
    private Integer styleBox;
    
    @Column(name="HeadquarterAddressLine")
    private String headquarterAddressLine;
    
    @Column(name="HeadquarterHomepage")
    private String headquarterHomepage;
    
    @Column(name="ShortDescription")
    private String shortDescription;

    @Column(name="MediumDescription")
    private String mediumDescription;
    
    @Column(name="RiskFreeIndexId")
    private String riskFreeIndexId;
    
    @Column(name="HeadquarterCountry")
    private String headquarterCountry;
    
    @Column(name="HeadquarterProvince")
    private String headquarterProvince;

    @Column(name="HeadquarterCity")
    private String headquarterCity;
    
    @Column(name="FiscalYearEnd")
    private Integer fiscalYearEnd;
    
    @Column(name="HeadquarterPostalCode")
    private String headquarterPostalCode;
    
    @Column(name="ListingCountry")
    private String listingCountry;
    
    @Column(name = "CurrencyId")
    private String currencyId;
    
    @Column(name = "MorningstarIndustryCode")
    private Integer morningstarIndustryCode;

    @Column(name="MorningstarIndustryGroupCode")
    private Integer morningstarIndustryGroupCode;

    @Column(name = "MorningstarSectorCode")
    private Integer morningstarSectorCode;

    @Column(name="MorningstarEconomySphereCode")
    private Integer morningstarEconomySphereCode;
    
    @Column(name="CountryId", length=10)
    private String countryId;

	/**
	 * @return the companyId
	 */
	public String getCompanyId()
	{
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId)
	{
		this.companyId = companyId;
	}

	/**
	 * @return the shareClassId
	 */
	public String getShareClassId()
	{
		return shareClassId;
	}

	/**
	 * @param shareClassId the shareClassId to set
	 */
	public void setShareClassId(String shareClassId)
	{
		this.shareClassId = shareClassId;
	}

	/**
	 * @return the legalName
	 */
	public String getLegalName()
	{
		return legalName;
	}

	/**
	 * @param legalName the legalName to set
	 */
	public void setLegalName(String legalName)
	{
		this.legalName = legalName;
	}

	/**
	 * @return the headquarterPhone
	 */
	public String getHeadquarterPhone()
	{
		return headquarterPhone;
	}

	/**
	 * @param headquarterPhone the headquarterPhone to set
	 */
	public void setHeadquarterPhone(String headquarterPhone)
	{
		this.headquarterPhone = headquarterPhone;
	}

	/**
	 * @return the headquarterFax
	 */
	public String getHeadquarterFax()
	{
		return headquarterFax;
	}

	/**
	 * @param headquarterFax the headquarterFax to set
	 */
	public void setHeadquarterFax(String headquarterFax)
	{
		this.headquarterFax = headquarterFax;
	}

	/**
	 * @return the contactEmail
	 */
	public String getContactEmail()
	{
		return contactEmail;
	}

	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail)
	{
		this.contactEmail = contactEmail;
	}

	/**
	 * @return the headquarterAddressLine
	 */
	public String getHeadquarterAddressLine()
	{
		return headquarterAddressLine;
	}

	/**
	 * @param headquarterAddressLine the headquarterAddressLine to set
	 */
	public void setHeadquarterAddressLine(String headquarterAddressLine)
	{
		this.headquarterAddressLine = headquarterAddressLine;
	}

	/**
	 * @return the headquarterHomepage
	 */
	public String getHeadquarterHomepage()
	{
		return headquarterHomepage;
	}

	/**
	 * @param headquarterHomepage the headquarterHomepage to set
	 */
	public void setHeadquarterHomepage(String headquarterHomepage)
	{
		this.headquarterHomepage = headquarterHomepage;
	}

	/**
	 * @return the shortDescription
	 */
	public String getShortDescription()
	{
		return shortDescription;
	}

	/**
	 * @param shortDescription the shortDescription to set
	 */
	public void setShortDescription(String shortDescription)
	{
		this.shortDescription = shortDescription;
	}

	/**
	 * @return the mediumDescription
	 */
	public String getMediumDescription()
	{
		return mediumDescription;
	}

	/**
	 * @param mediumDescription the mediumDescription to set
	 */
	public void setMediumDescription(String mediumDescription)
	{
		this.mediumDescription = mediumDescription;
	}

	/**
	 * @return the riskFreeIndexId
	 */
	public String getRiskFreeIndexId()
	{
		return riskFreeIndexId;
	}

	/**
	 * @param riskFreeIndexId the riskFreeIndexId to set
	 */
	public void setRiskFreeIndexId(String riskFreeIndexId)
	{
		this.riskFreeIndexId = riskFreeIndexId;
	}

	/**
	 * @return the headquarterCountry
	 */
	public String getHeadquarterCountry()
	{
		return headquarterCountry;
	}

	/**
	 * @param headquarterCountry the headquarterCountry to set
	 */
	public void setHeadquarterCountry(String headquarterCountry)
	{
		this.headquarterCountry = headquarterCountry;
	}

	/**
	 * @return the headquarterProvince
	 */
	public String getHeadquarterProvince()
	{
		return headquarterProvince;
	}

	/**
	 * @param headquarterProvince the headquarterProvince to set
	 */
	public void setHeadquarterProvince(String headquarterProvince)
	{
		this.headquarterProvince = headquarterProvince;
	}

	/**
	 * @return the headquarterCity
	 */
	public String getHeadquarterCity()
	{
		return headquarterCity;
	}

	/**
	 * @param headquarterCity the headquarterCity to set
	 */
	public void setHeadquarterCity(String headquarterCity)
	{
		this.headquarterCity = headquarterCity;
	}


	/**
	 * @return the fiscalYearEnd
	 */
	public Integer getFiscalYearEnd()
	{
		return fiscalYearEnd;
	}

	/**
	 * @param fiscalYearEnd the fiscalYearEnd to set
	 */
	public void setFiscalYearEnd(Integer fiscalYearEnd)
	{
		this.fiscalYearEnd = fiscalYearEnd;
	}

	/**
	 * @return the headquarterPostalCode
	 */
	public String getHeadquarterPostalCode()
	{
		return headquarterPostalCode;
	}

	/**
	 * @param headquarterPostalCode the headquarterPostalCode to set
	 */
	public void setHeadquarterPostalCode(String headquarterPostalCode)
	{
		this.headquarterPostalCode = headquarterPostalCode;
	}

	/**
	 * @return the listingCountry
	 */
	public String getListingCountry()
	{
		return listingCountry;
	}

	/**
	 * @param listingCountry the listingCountry to set
	 */
	public void setListingCountry(String listingCountry)
	{
		this.listingCountry = listingCountry;
	}

	/**
	 * @return the currencyId
	 */
	public String getCurrencyId()
	{
		return currencyId;
	}

	/**
	 * @param currencyId the currencyId to set
	 */
	public void setCurrencyId(String currencyId)
	{
		this.currencyId = currencyId;
	}

	/**
	 * @return the morningstarIndustryCode
	 */
	public Integer getMorningstarIndustryCode()
	{
		return morningstarIndustryCode;
	}

	/**
	 * @param morningstarIndustryCode the morningstarIndustryCode to set
	 */
	public void setMorningstarIndustryCode(Integer morningstarIndustryCode)
	{
		this.morningstarIndustryCode = morningstarIndustryCode;
	}

	/**
	 * @return the morningstarIndustryGroupCode
	 */
	public Integer getMorningstarIndustryGroupCode()
	{
		return morningstarIndustryGroupCode;
	}

	/**
	 * @param morningstarIndustryGroupCode the morningstarIndustryGroupCode to set
	 */
	public void setMorningstarIndustryGroupCode(Integer morningstarIndustryGroupCode)
	{
		this.morningstarIndustryGroupCode = morningstarIndustryGroupCode;
	}

	/**
	 * @return the morningstarSectorCode
	 */
	public Integer getMorningstarSectorCode()
	{
		return morningstarSectorCode;
	}

	/**
	 * @param morningstarSectorCode the morningstarSectorCode to set
	 */
	public void setMorningstarSectorCode(Integer morningstarSectorCode)
	{
		this.morningstarSectorCode = morningstarSectorCode;
	}

	/**
	 * @return the morningstarEconomySphereCode
	 */
	public Integer getMorningstarEconomySphereCode()
	{
		return morningstarEconomySphereCode;
	}

	/**
	 * @param morningstarEconomySphereCode the morningstarEconomySphereCode to set
	 */
	public void setMorningstarEconomySphereCode(Integer morningstarEconomySphereCode)
	{
		this.morningstarEconomySphereCode = morningstarEconomySphereCode;
	}

	/**
	 * @return the countryId
	 */
	public String getCountryId()
	{
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(String countryId)
	{
		this.countryId = countryId;
	}

	/**
	 * @return the styleBox
	 */
	public Integer getStyleBox()
	{
		return styleBox;
	}

	/**
	 * @param styleBox the styleBox to set
	 */
	public void setStyleBox(Integer styleBox)
	{
		this.styleBox = styleBox;
	}

	
	
}
