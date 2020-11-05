package com.transglobe.demo.service.imlp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.transglobe.demo.dao.jpa.TabAttrRepository;
import com.transglobe.demo.model.TabAttr;
import com.transglobe.demo.dao.mybatis.TabAttrMapper;
import com.transglobe.demo.service.TabAttrService;

@Service
public class TableAttrServiceImpl implements TabAttrService {

	@Autowired
	TabAttrMapper tabAttrMapper;
	
	@Autowired
	TabAttrRepository tabAttrRepository;

	@Override
	public Optional<TabAttr> findTabAttrByAttrNo(String attrNo) {
		return tabAttrRepository.findById(attrNo);
	}

	@Override
	public List<TabAttr> findAllTabAttr() {
		return tabAttrRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveTabAttr(TabAttr tabAttr) {
		return tabAttrMapper.insertTabAttr(tabAttr);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int modifyTabAttr(TabAttr tabAttr) {
		return tabAttrMapper.updateTabAttrByAttrNo(tabAttr);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteTabAttr(String attrNo) {
		return tabAttrMapper.deleteTabAttrByAttrNo(attrNo);
	}

}
