package com.transglobe.demo.dao.mybatis;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.transglobe.demo.model.TabGrComp;

public interface TabGrCompMapper {
    
    @Select("SELECT CMPID, CMPNAME, GROUPID, CMPADDR, ZIP, AREACODE, CMPTEL, UPDT, USERID, JOBCLASS, EMAIL, FAXNUM, CMPNUM"
            + " FROM ADP.TAB_GR_COMP WHERE CMPID = #{cmpId,jdbcType=INTEGER}")
    Optional<TabGrComp> selectTabGrCompByCmpId(@Param("cmpId") Integer cmpId);

    @Select("SELECT CMPID, CMPNAME, GROUPID, CMPADDR, ZIP, AREACODE, CMPTEL, UPDT, USERID, JOBCLASS, EMAIL, FAXNUM, CMPNUM"
            + " FROM ADP.TAB_GR_COMP ORDER BY CMPID")
    List<TabGrComp> selectAllTabGrComp();

    @Insert("INSERT INTO ADP.TAB_GR_COMP(CMPID, CMPNAME, GROUPID, CMPADDR, ZIP, AREACODE, CMPTEL, UPDT, USERID, JOBCLASS, EMAIL, FAXNUM, CMPNUM) "
            + "VALUES (#{cmpId,jdbcType=INTEGER}, #{cmpName,jdbcType=VARCHAR}, #{groupId,jdbcType=VARCHAR}"
            + ", #{cmpAddr,jdbcType=VARCHAR}, #{zip,jdbcType=INTEGER}, #{areaCode,jdbcType=VARCHAR}"
            + ", #{cmpTel,jdbcType=VARCHAR}, #{upDt,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}"
            + ", #{jobClass,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{faxNum,jdbcType=VARCHAR}"
            + ", #{cmpNum,jdbcType=VARCHAR})")
    int insertTabGrComp(TabGrComp tabGrComp);

    @Update
    ({"<script>",
        "UPDATE ADP.TAB_GR_COMP",
        "  <set>"+
                "    <if test='cmpName!=null'>cmpname=#{cmpName,jdbcType=VARCHAR},</if>"+
                "    <if test='groupId!=null'>groupid=#{groupId,jdbcType=VARCHAR},</if>"+
                "    <if test='cmpAddr!=null'>cmpaddr=#{cmpAddr,jdbcType=VARCHAR},</if>"+
                "    <if test='zip!=null'>zip=#{zip,jdbcType=INTEGER},</if>"+
                "    <if test='areaCode!=null'>areacode=#{areaCode,jdbcType=VARCHAR},</if>"+
                "    <if test='cmpTel!=null'>cmptel=#{cmpTel,jdbcType=VARCHAR},</if>"+
                "    <if test='upDt!=null'>updt=#{upDt,jdbcType=INTEGER},</if>"+
                "    <if test='userId!=null'>userid=#{userId,jdbcType=VARCHAR},</if>"+
                "    <if test='jobClass!=null'>jobclass=#{jobClass,jdbcType=VARCHAR},</if>"+
                "    <if test='email!=null'>email=#{email,jdbcType=VARCHAR},</if>"+
                "    <if test='faxNum!=null'>faxnum=#{faxNum,jdbcType=VARCHAR},</if>"+
                "    <if test='cmpNum!=null'>cmpnum=#{cmpNum,jdbcType=VARCHAR},</if>"+
        "  </set>"+
        "where CMPID=#{cmpId,jdbcType=INTEGER}",
        "</script>"})
    int updateTabGrCompByCmpId(TabGrComp tabGrComp);

    @Delete("DELETE FROM ADP.TAB_GR_COMP WHERE CMPID = #{cmpId,jdbcType=INTEGER}")
    int deleteTabGrCompByCmpId(@Param("cmpId") Integer cmpId);

}
