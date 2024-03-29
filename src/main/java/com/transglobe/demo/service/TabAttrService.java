package com.transglobe.demo.service;

import java.util.List;
import java.util.Optional;
import com.transglobe.demo.model.TabAttr;

public interface TabAttrService {

    Optional<TabAttr> findTabAttrByAttrNo(String attrNo);

	List<TabAttr> findAllTabAttr();
	
	int createTabAttr(TabAttr tabAttr);

	int updateTabAttr(TabAttr tabAttr);

	int deleteTabAttr(String attrNo);
}
