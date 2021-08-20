package com.transglobe.demo.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;
import com.transglobe.demo.exception.RecordNotFoundException;
import com.transglobe.demo.http.api.ResultEntity;
import com.transglobe.demo.model.TabAttr;
import com.transglobe.demo.service.TabAttrService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SuppressWarnings("unchecked")
public class TabAttrControllerTests {

    @Autowired
    private TabAttrController tabAttrController;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    TabAttrService tabAttrService;

    private TabAttr tabAttr = new TabAttr("UT", "UnitTestData");

    // 為了避免測試之間的副作用，MockitoAnnotations.initMocks（this）靜態方法必須被調用。
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

//
//    @Test
//    public void testGetTabAttrByAttrNo() {
////        Optional<TabAttr> mockOptional = Optional.ofNullable(tabAttr);
////        doReturn(mockOptional).when(tabAttrService).findTabAttrByAttrNo("UT");
//
////        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/api/tabAttr/{attrNo}");
////        Map<String, Object> uriParams = new HashMap<String, Object>();
////        uriParams.put("attrNo", "UT");
////
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON);
////        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
////        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
////        ParameterizedTypeReference<ResultEntity> typeRef = new ParameterizedTypeReference<ResultEntity>() {};
////        ResponseEntity<ResultEntity> response = restTemplate.exchange(
////                builder.buildAndExpand(uriParams).toUri().toString(), 
////                HttpMethod.GET, httpEntity, typeRef);
////        ResultEntity resultEntity = response.getBody();
////        LinkedHashMap data = (LinkedHashMap)resultEntity.getData();
////        
////        TabAttr data =  (TabAttr)JSON.parseObject(new JSONObject(data).toString(), new TypeReference<TabAttr>() {});
////
////        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertEquals("UT", data.getAttrNo());
////        assertEquals("UnitTestData", data.getAttrName());
//
//         Optional<TabAttr> mockOptional = Optional.ofNullable(tabAttr);
//         doReturn(mockOptional).when(tabAttrService).findTabAttrByAttrNo("UT");
//        
//         ResponseEntity<?> entity = tabAttrController.findTabAttrByAttrNo("UT");
//         ResultEntity resultEntity = (ResultEntity) entity.getBody();
//         TabAttr data = (TabAttr)resultEntity.getData();
//        
//         assertEquals(HttpStatus.OK, entity.getStatusCode());
//         assertEquals("UT", data.getAttrNo());
//         assertEquals("UnitTestData", data.getAttrName());
//    }
//
//    @Test
//    public void testGetAllAttr() {
//        List<TabAttr> mockList = Arrays.asList(new TabAttr("T1", "Test1"), new TabAttr("T2", "Test2"), new TabAttr("T3", "Test3"));
//        doReturn(mockList).when(tabAttrService).findAllTabAttr();
//
//        ResponseEntity<?> entity = tabAttrController.findAllTabAttr();
//        ResultEntity resultEntity = (ResultEntity) entity.getBody();
//        List<TabAttr> tabAttrList = (List<TabAttr>) resultEntity.getData();
//
//        // verify(tabAttrController, times(1)).getAllAttr();
//        assertEquals(HttpStatus.OK, entity.getStatusCode());
//        assertEquals(3, tabAttrList.size());
//        assertEquals(tabAttrList, mockList);
//    }
//
//    @Test
//    public void testCreateTabAttr() {
//        doReturn(1).when(tabAttrService).createTabAttr(ArgumentMatchers.any(TabAttr.class));
//        ResponseEntity<?> createResEntity = tabAttrController.createTabAttr(tabAttr);
//
//        assertEquals(HttpStatus.OK, createResEntity.getStatusCode());
//    }
//
//    @Test(expected = Exception.class)
//    public void testCreateTabAttrException() {
//        doThrow(Exception.class).when(tabAttrService).createTabAttr(tabAttr);
//        tabAttrController.createTabAttr(tabAttr);
//    }
//
//    @Test
//    public void testUpdateTabAttr() {
//        doReturn(1).when(tabAttrService).updateTabAttr(tabAttr);
//        ResponseEntity<?> updResentity = tabAttrController.updateTabAttr(tabAttr.getAttrNo(), tabAttr);
//
//        assertEquals(HttpStatus.OK, updResentity.getStatusCode());
//    }
//
//    @Test
//    public void testDeleteTabAttr() {
//        doReturn(1).when(tabAttrService).deleteTabAttr(ArgumentMatchers.any(String.class));
//        ResponseEntity<?> entity = tabAttrController.deleteTabAttr(tabAttr.getAttrNo());
//
//        assertEquals(HttpStatus.OK, entity.getStatusCode());
//    }
//
//    @Test(expected = RecordNotFoundException.class)
//    public void testDeleteTabAttrNoData() {
//        doReturn(0).when(tabAttrService).deleteTabAttr(ArgumentMatchers.any(String.class));
//        ResponseEntity<?> entity = tabAttrController.deleteTabAttr(tabAttr.getAttrNo());
//        ResultEntity resultEntity = (ResultEntity) entity.getBody();
//
//        assertEquals(HttpStatus.OK, entity.getStatusCode());
//        assertEquals("No Data Delete", resultEntity.getMessage());
//    }

}
