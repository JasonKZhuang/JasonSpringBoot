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
@Table(name = "test")
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

	public String getCompanyId()
	{
		return companyId;
	}

	public void setCompanyId(String companyId)
	{
		this.companyId = companyId;
	}

	public String getShareClassId()
	{
		return shareClassId;
	}

	public void setShareClassId(String shareClassId)
	{
		this.shareClassId = shareClassId;
	}

	public String getLegalName()
	{
		return legalName;
	}

	public void setLegalName(String legalName)
	{
		this.legalName = legalName;
	}
    
	
}
