package com.transglobe.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel("TAB_ATTR實體類")
@Entity
@Table(schema = "NB", name = "TAB_ATTR")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TabAttr implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ATTRNO")
    @Id
    @Size(min = 1, max = 2)
    @NotBlank
    @Column(name = "ATTRNO", nullable = false)
    @JsonProperty("attr_no")
    private String attrNo;

    @ApiModelProperty(value = "ATTRNAME")
    @Size(min = 1, max = 30)
    @NotBlank
    @Column(name = "ATTRNAME")
    @JsonProperty("attr_name")
    private String attrName;

    public TabAttr() {
        super();
    }

    public TabAttr(String attrNo, String attrName) {
        super();
        this.attrNo = attrNo;
        this.attrName = attrName;
    }

    public String getAttrNo() {
        return attrNo;
    }

    public void setAttrNo(String attrNo) {
        this.attrNo = attrNo;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
    
    @Override
    public String toString() {
      return "TabAttr{" +
          "attrNo='" + attrNo +
          "', attrName='" + attrName + '\'' +
          '}';
    }

}
