package com.transglobe.demo.service;

import java.util.List;
import java.util.Optional;
import com.transglobe.demo.model.TabGrComp;

public interface TabGrCompService {

    Optional<TabGrComp> findTabGrCompByCmpId(Integer cmpId);

	List<TabGrComp> findAllTabGrComp();
	
	int createTabGrComp(TabGrComp tabGrComp);

	int updateTabGrComp(TabGrComp tabGrComp);

	int deleteTabGrComp(Integer cmpId);
}
