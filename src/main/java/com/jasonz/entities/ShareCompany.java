/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jasonz.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kaizhi Zhuang
 */
@Entity
@Table(name = "ShareCompany")
public class ShareCompany implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ShareClassId", nullable = false, length = 11 )
	private int shareClassId;

    @Column(name = "LegalName", length = 100)
    private String legalName;

	public int getShareClassId()
	{
		return shareClassId;
	}

	public void setShareClassId(int shareClassId)
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
