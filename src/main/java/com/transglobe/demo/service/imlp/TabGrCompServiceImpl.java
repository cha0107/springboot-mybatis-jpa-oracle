package com.transglobe.demo.service.imlp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.transglobe.demo.dao.mybatis.TabGrCompMapper;
import com.transglobe.demo.model.TabGrComp;
import com.transglobe.demo.service.TabGrCompService;

@Service
public class TabGrCompServiceImpl implements TabGrCompService {

	@Autowired
	TabGrCompMapper tabGrCompMapper;

	@Override
	public Optional<TabGrComp> findTabGrCompByCmpId(Integer cmpId) {
		return tabGrCompMapper.selectTabGrCompByCmpId(cmpId);
	}

	@Override
	public List<TabGrComp> findAllTabGrComp() {
		return tabGrCompMapper.selectAllTabGrComp();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int createTabGrComp(TabGrComp TabGrComp) {
		return tabGrCompMapper.insertTabGrComp(TabGrComp);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateTabGrComp(TabGrComp TabGrComp) {
		return tabGrCompMapper.updateTabGrCompByCmpId(TabGrComp);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteTabGrComp(Integer cmpId) {
		return tabGrCompMapper.deleteTabGrCompByCmpId(cmpId);
	}

}
