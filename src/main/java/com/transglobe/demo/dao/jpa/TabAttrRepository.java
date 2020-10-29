package com.transglobe.demo.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transglobe.demo.model.TabAttr;

public interface TabAttrRepository extends JpaRepository<TabAttr, String>{

}
