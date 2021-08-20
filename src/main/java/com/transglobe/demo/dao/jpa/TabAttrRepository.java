package com.transglobe.demo.dao.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.transglobe.demo.model.TabAttr;

public interface TabAttrRepository extends JpaRepository<TabAttr, String> {
    
    List<TabAttr> findAllByOrderByAttrNoAsc();
}
