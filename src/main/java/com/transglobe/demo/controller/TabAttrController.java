package com.transglobe.demo.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.transglobe.demo.http.api.CommonResponse;
import com.transglobe.demo.constant.ReturnStatus;
import com.transglobe.demo.model.TabAttr;
import com.transglobe.demo.service.TabAttrService;

@Controller
@RequestMapping("/api")
public class TabAttrController {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(TabAttrController.class);

    @Autowired
    TabAttrService tabAttrService;

    @GetMapping(value = "/")
    public String index(ModelMap model) {
        return "index";
    }

    /**
     * @param message
     */
    private ResponseEntity<?> returnErrorResponse(String message) {
        CommonResponse res = new CommonResponse();
        res.setCode(ReturnStatus.ERROR.code());
        res.setMessage(message);
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/tabAttr/{attrNo}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<?> getTabAttrByAttrNo(@PathVariable("attrNo") String attrNo) {
        logger.debug("*** call getTabAttrByAttrNo() ***");
        CommonResponse res = new CommonResponse();
        try {
            Optional<TabAttr> tabAttr = tabAttrService.findTabAttrByAttrNo(attrNo);
            if (tabAttr.isPresent()) {
                res.setData(tabAttr.get());
                return new ResponseEntity<>(res, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new CommonResponse(200, "No Data"), HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.error(e.toString());
            return new ResponseEntity<>(returnErrorResponse("Query Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/tabAttr", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<?> getAllAttr() {
        logger.debug("*** call getAllAttr() ***");
        CommonResponse res = new CommonResponse();
        try {
            List<TabAttr> tabAttrData = tabAttrService.findAllTabAttr();
            res.setData(tabAttrData);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.toString());
            return new ResponseEntity<>(returnErrorResponse("Query Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/tabAttr", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<?> createTabAttr(@RequestBody TabAttr tabAttr) {
        logger.debug("*** call createTabAttr() ***");
        CommonResponse res = new CommonResponse();
        try {
            int insCnt = tabAttrService.saveTabAttr(tabAttr);
            if (insCnt == 0) {
                return new ResponseEntity<>(new CommonResponse(200, "No Data Insert"), HttpStatus.OK);
            }
            res.setMessage("Insert Success");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.toString());
            return new ResponseEntity<>(returnErrorResponse("Insert Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/tabAttr", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<?> updateTabAttr(@RequestBody TabAttr tabAttr) {
        logger.debug("*** call updateTabAttr() ***");
        CommonResponse res = new CommonResponse();

        try {
            int updCnt = tabAttrService.modifyTabAttr(tabAttr);
            if (updCnt == 0) {
                return new ResponseEntity<>(new CommonResponse(200, "No Data Update"), HttpStatus.OK);
            }
            res.setMessage("Update Success");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.toString());
            return new ResponseEntity<>(returnErrorResponse("Update Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/tabAttr", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<?> deleteTabAttr(@RequestBody TabAttr tabAttr) {
        logger.debug("*** call deleteTabAttr() ***");
        CommonResponse res = new CommonResponse();

        try {
            int delCnt = tabAttrService.deleteTabAttr(tabAttr.getAttrNo());
            if (delCnt == 0) {
                return new ResponseEntity<>(new CommonResponse(200, "No Data Delete"), HttpStatus.OK);
            }
            res.setMessage("Delete Success");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.toString());
            return new ResponseEntity<>(returnErrorResponse("Detlete Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
