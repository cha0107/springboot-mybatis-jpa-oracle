package com.transglobe.demo.service;

import java.util.List;

import com.transglobe.demo.model.TabAttr;

public interface TabAttrService {

	List<TabAttr> findTabAttrByAttrNo(String attrNo);

	List<TabAttr> findAllTabAttr();

	int saveTabAttr(TabAttr tabAttr);

	int modifyTabAttr(TabAttr tabAttr);

	int deleteTabAttr(String attrNo);
}
