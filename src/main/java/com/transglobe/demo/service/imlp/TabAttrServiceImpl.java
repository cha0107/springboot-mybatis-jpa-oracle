package com.transglobe.demo.service.imlp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transglobe.demo.dao.jpa.TabAttrRepository;
import com.transglobe.demo.dao.mybatis.TabAttrMapper;
import com.transglobe.demo.model.TabAttr;
import com.transglobe.demo.service.TabAttrService;

@Service
public class TabAttrServiceImpl implements TabAttrService {

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
		return tabAttrRepository.findAllByOrderByAttrNoAsc();
	}

	@Override
	public int createTabAttr(TabAttr tabAttr) {
		return tabAttrMapper.insertTabAttr(tabAttr);
	}

	@Override
	public int updateTabAttr(TabAttr tabAttr) {
		return tabAttrMapper.updateTabAttrByAttrNo(tabAttr);
	}

	@Override
	public int deleteTabAttr(String attrNo) {
		return tabAttrMapper.deleteTabAttrByAttrNo(attrNo);
	}

}
