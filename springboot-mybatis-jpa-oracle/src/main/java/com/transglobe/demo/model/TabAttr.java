package com.transglobe.demo.model;

import java.io.Serializable;

public class TabAttr implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String attrNo;

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
