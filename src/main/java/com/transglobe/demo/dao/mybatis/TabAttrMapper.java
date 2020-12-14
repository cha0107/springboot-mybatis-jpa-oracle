package com.transglobe.demo.dao.mybatis;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.transglobe.demo.model.TabAttr;

public interface TabAttrMapper {

    @Select("SELECT ATTRNO, ATTRNAME FROM NB.TAB_ATTR WHERE ATTRNO = #{attrNo}")
    List<TabAttr> selectTabAttrByAttrNo(@Param("attrNo") String attrNo);

    @Select("SELECT ATTRNO, ATTRNAME FROM NB.TAB_ATTR ORDER BY ATTRNO")
    List<TabAttr> selectAllTabAttr();

    @Insert("INSERT INTO NB.TAB_ATTR(ATTRNO, ATTRNAME) VALUES (#{attrNo}, #{attrName})")
    int insertTabAttr(TabAttr tabAttr);

    @Update("UPDATE	NB.TAB_ATTR	SET ATTRNAME = #{attrName} WHERE ATTRNO = #{attrNo}")
    int updateTabAttrByAttrNo(TabAttr tabAttr);

    @Delete("DELETE FROM NB.TAB_ATTR WHERE ATTRNO = #{attrNo}")
    int deleteTabAttrByAttrNo(@Param("attrNo") String attrNo);

}
