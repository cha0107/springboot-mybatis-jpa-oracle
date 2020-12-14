package com.transglobe.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.transglobe.demo.exception.RecordNotFoundException;
import com.transglobe.demo.http.api.ResultEntity;
import com.transglobe.demo.model.TabAttr;
import com.transglobe.demo.service.TabAttrService;

@Api(tags = "TAB_ATTR管理")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Validated
@RequestMapping("/api")
public class TabAttrController {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(TabAttrController.class);

    @Autowired
    TabAttrService tabAttrService;

    @ApiOperation(value = "取得單一TAB_ATTR")
    @GetMapping(value = "/tabAttr/{attrNo}")
    public ResponseEntity<Object> findTabAttrByAttrNo(@PathVariable @NotBlank @Size(min = 1, max = 2) String attrNo) {
        logger.info("*** call findTabAttrByAttrNo() ***");
        
        ResultEntity res = new ResultEntity();
        Optional<TabAttr> tabAttr = tabAttrService.findTabAttrByAttrNo(attrNo);
        if (tabAttr.isPresent()) {
            res.setData(tabAttr.get());
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("TabAttr record not found by AttrNo.");
        }
    }

    @ApiOperation(value = "取得TAB_ATTR", notes = "列出所有 TAB_ATTR")
    @GetMapping(value = "/tabAttr")
    public ResponseEntity<Object> findAllTabAttr() {
        logger.info("*** call findAllAttr() ***");
        
        ResultEntity res = new ResultEntity();
        List<TabAttr> tabAttrData = tabAttrService.findAllTabAttr();
        res.setData(tabAttrData);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @ApiOperation(value = "新增TAB_ATTR")
    @PostMapping(value = "/tabAttr")
    public ResponseEntity<Object> createTabAttr(@RequestBody @Valid TabAttr tabAttr) {
        logger.info("*** call createTabAttr() ***");
        int insCnt = tabAttrService.createTabAttr(tabAttr);
        if (insCnt == 0) {
            throw new RecordNotFoundException("No Data Insert");
        }
        return new ResponseEntity<>(new ResultEntity("Insert Success"), HttpStatus.OK);
    }
    
    @ApiOperation(value = "修改TAB_ATTR", notes = "修改TAB_ATTR內容")
    @PutMapping(value = "/tabAttr/{attrNo}")
    public ResponseEntity<Object> updateTabAttr(@PathVariable String attrNo, @RequestBody @Valid TabAttr tabAttr) {
        logger.info("*** call updateTabAttr() ***");
        int updCnt = tabAttrService.updateTabAttr(tabAttr);
        if (updCnt == 0) {
            throw new RecordNotFoundException("No Data Update");
        }
        return new ResponseEntity<>(new ResultEntity("Update Success"), HttpStatus.OK);
    }

    @ApiOperation(value = "刪除TAB_ATTR")
    @DeleteMapping(value = "/tabAttr/{attrNo}")
    public ResponseEntity<Object> deleteTabAttr(@PathVariable @NotBlank @Size(min = 1, max = 2) String attrNo) {
        logger.info("*** call deleteTabAttr() ***");

        int delCnt = tabAttrService.deleteTabAttr(attrNo);
        if (delCnt == 0) {
            throw new RecordNotFoundException("No Data Delete");
        }
        return new ResponseEntity<>(new ResultEntity("Delete Success"), HttpStatus.OK);
    }
}
