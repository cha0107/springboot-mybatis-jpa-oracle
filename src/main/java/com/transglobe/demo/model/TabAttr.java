package com.transglobe.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "AD", name="TAB_ATTR")
public class TabAttr implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ATTRNO", nullable = false)	
	private String attrNo;
	
	@Column(name = "ATTRNAME") 
	private String attrName;

	public String getAttrNo() {
		return attrNo;
	}

	public void setAttrNo(String attrNo) {
		this.attrNo = attrNo;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

}
