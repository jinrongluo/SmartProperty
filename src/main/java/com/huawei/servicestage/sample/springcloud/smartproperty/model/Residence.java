package com.huawei.servicestage.sample.springcloud.smartproperty.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Residence {

	@Id
    @GeneratedValue
	private int id;
	private String userName;
	private String propertyId;
	private String layoutId;
	
	public Residence() {
		
	}

	public Residence(String userName, String propertyId, String layoutId) {
		this.userName = userName;
		this.propertyId = propertyId;
		this.layoutId = layoutId;
	}


	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}
	
}
