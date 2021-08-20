package com.transglobe.demo.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.transglobe.demo.exception.RecordNotFoundException;
import com.transglobe.demo.http.api.ResultEntity;
import com.transglobe.demo.model.TabGrComp;
import com.transglobe.demo.service.TabGrCompService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "TAB_GR_COMP管理")
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/api")
public class TabGrCompController {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(TabGrCompController.class);

    @Autowired
    TabGrCompService tabGrCompService;

    @ApiOperation(value = "取得單一TAB_GR_COMP")
    @GetMapping(value = "/tabGrComp/{cmpId}")
    public ResponseEntity<Object> findTabGrCompByCmpId(@PathVariable @NotBlank @Size(min = 1, max = 2) Integer cmpId) {
        logger.info("*** call findTabGrCmopByAttrNo() ***");
        
        ResultEntity res = new ResultEntity();
        Optional<TabGrComp> tabGrComp = tabGrCompService.findTabGrCompByCmpId(cmpId);
        if (tabGrComp.isPresent()) {
            res.setData(tabGrComp.get());
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("TabGrCmop record not found by AttrNo.");
        }
    }

    @ApiOperation(value = "取得TAB_GR_COMP", notes = "列出所有 TAB_GR_COMP")
    @GetMapping(value = "/tabGrComp")
    public ResponseEntity<Object> findAllTabGrCmop() {
        logger.info("*** call findAllAttr() ***");
        
        ResultEntity res = new ResultEntity();
        List<TabGrComp> tabGrCompData = tabGrCompService.findAllTabGrComp();
        res.setData(tabGrCompData);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @ApiOperation(value = "新增TAB_GR_COMP")
    @PostMapping(value = "/tabGrComp")
    public ResponseEntity<Object> createTabGrCmop(@RequestBody @Valid TabGrComp tabGrComp) {
        logger.info("*** call createTabGrCmop() ***");
        int insCnt = tabGrCompService.createTabGrComp(tabGrComp);
        if (insCnt == 0) {
            throw new RecordNotFoundException("No Data Insert");
        }
        return new ResponseEntity<>(new ResultEntity("Insert Success"), HttpStatus.OK);
    }
    
    @ApiOperation(value = "修改TAB_GR_COMP", notes = "修改TAB_GR_COMP內容")
    @PutMapping(value = "/tabGrComp")
    public ResponseEntity<Object> updateTabGrCmop(@RequestBody @Valid TabGrComp tabGrComp) {
        logger.info("*** call updateTabGrCmop() ***");
        int updCnt = tabGrCompService.updateTabGrComp(tabGrComp);
        if (updCnt == 0) {
            throw new RecordNotFoundException("No Data Update");
        }
        return new ResponseEntity<>(new ResultEntity("Update Success"), HttpStatus.OK);
    }

    @ApiOperation(value = "刪除TAB_GR_COMP")
    @DeleteMapping(value = "/tabGrComp/{cmpId}")
    public ResponseEntity<Object> deleteTabGrCmop(@PathVariable @NotBlank @Size(min = 1, max = 2) Integer cmpId) {
        logger.info("*** call deleteTabGrCmop() ***");

        int delCnt = tabGrCompService.deleteTabGrComp(cmpId);
        if (delCnt == 0) {
            throw new RecordNotFoundException("No Data Delete");
        }
        return new ResponseEntity<>(new ResultEntity("Delete Success"), HttpStatus.OK);
    }
}
