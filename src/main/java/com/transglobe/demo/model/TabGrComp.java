package com.transglobe.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "TAB_GR_CMOP實體類")
@Entity
@Table(schema = "ADP", name = "TAB_GR_CMOP")
public class TabGrComp implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "CMPID")
    @Id
    @Column(name = "CMPID", nullable = false)
    private Integer cmpId;

    @ApiModelProperty(value = "CMPNAME")
    @Column(name = "CMPNAME")
    private String cmpName;

    @ApiModelProperty(value = "GROUPID")
    @Column(name = "GROUPID")
    private String groupId;

    @ApiModelProperty(value = "CMPADDR")
    @Column(name = "CMPADDR")
    private String cmpAddr;

    @ApiModelProperty(value = "ZIP")
    @Column(name = "ZIP")
    private Integer zip;

    @ApiModelProperty(value = "AREACODE")
    @Column(name = "AREACODE")
    private String areaCode;

    @ApiModelProperty(value = "CMPTEL")
    @Column(name = "CMPTEL")
    private String cmpTel;

    @ApiModelProperty(value = "UPDT")
    @Column(name = "UPDT")
    private Integer upDt;

    @ApiModelProperty(value = "USERID")
    @Column(name = "USERID")
    private String userId;

    @ApiModelProperty(value = "JOBCLASS")
    @Column(name = "JOBCLASS")
    private String jobClass;

    @ApiModelProperty(value = "EMAIL")
    @Column(name = "EMAIL")
    private String email;

    @ApiModelProperty(value = "FAXNUM")
    @Column(name = "FAXNUM")
    private String faxNum;

    @ApiModelProperty(value = "CMPNUM")
    @Column(name = "CMPNUM")
    private String cmpNum;

    public TabGrComp(Integer cmpId, String cmpName, String groupId, String cmpAddr, Integer zip, String areaCode,
            String cmpTel, Integer upDt, String userId, String jobClass, String email, String faxNum, String cmpNum) {
        super();
        this.cmpId = cmpId;
        this.cmpName = cmpName;
        this.groupId = groupId;
        this.cmpAddr = cmpAddr;
        this.zip = zip;
        this.areaCode = areaCode;
        this.cmpTel = cmpTel;
        this.upDt = upDt;
        this.userId = userId;
        this.jobClass = jobClass;
        this.email = email;
        this.faxNum = faxNum;
        this.cmpNum = cmpNum;
    }

    public Integer getCmpId() {
        return cmpId;
    }

    public void setCmpId(Integer cmpId) {
        this.cmpId = cmpId;
    }

    public String getCmpName() {
        return cmpName;
    }

    public void setCmpName(String cmpName) {
        this.cmpName = cmpName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getCmpAddr() {
        return cmpAddr;
    }

    public void setCmpAddr(String cmpAddr) {
        this.cmpAddr = cmpAddr;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCmpTel() {
        return cmpTel;
    }

    public void setCmpTel(String cmpTel) {
        this.cmpTel = cmpTel;
    }

    public Integer getUpDt() {
        return upDt;
    }

    public void setUpDt(Integer upDt) {
        this.upDt = upDt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaxNum() {
        return faxNum;
    }

    public void setFaxNum(String faxNum) {
        this.faxNum = faxNum;
    }

    public String getCmpNum() {
        return cmpNum;
    }

    public void setCmpNum(String cmpNum) {
        this.cmpNum = cmpNum;
    }

}
