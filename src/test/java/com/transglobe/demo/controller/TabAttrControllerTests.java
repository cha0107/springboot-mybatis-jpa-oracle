package com.transglobe.demo.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.transglobe.demo.http.api.CommonResponse;
import com.transglobe.demo.dao.jpa.TabAttrRepository;
import com.transglobe.demo.dao.mybatis.TabAttrMapper;
import com.transglobe.demo.model.TabAttr;

@SpringBootTest
@RunWith(SpringRunner.class)
@SuppressWarnings("unchecked")
public class TabAttrControllerTests {

    @SpyBean
    private TabAttrController tabAttrController;

    @MockBean
    private TabAttrMapper tabAttrMapper;

    @MockBean
    private TabAttrRepository tabAttrRepository;

    private TabAttr tabAttr = new TabAttr("UT", "UnitTestData");

    @Test
    public void testGetTabAttrByAttrNo() {
        Optional<TabAttr> mockOptional = Optional.ofNullable(tabAttr);
        
        doReturn(mockOptional).when(tabAttrRepository).findById("UT");

        ResponseEntity<?> entity = tabAttrController.getTabAttrByAttrNo("UT");
        CommonResponse response = (CommonResponse) entity.getBody();
        TabAttr data = (TabAttr)response.getData();

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals("UT", data.getAttrNo());
        assertEquals("UnitTestData", data.getAttrName());
    }

    @Test
    public void testGetAllAttr() {
        List<TabAttr> mockList =
                Arrays.asList(new TabAttr("T1", "Test1"), new TabAttr("T2", "Test2"), new TabAttr(
                        "T3", "Test3"));
        doReturn(mockList).when(tabAttrRepository).findAll();

        ResponseEntity<?> entity = tabAttrController.getAllAttr();
        CommonResponse response = (CommonResponse) entity.getBody();
        List<TabAttr> tabAttrList = (List<TabAttr>) response.getData();

        verify(tabAttrController, times(1)).getAllAttr();
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(3, tabAttrList.size());
        assertEquals(tabAttrList, mockList);
    }

    @Test
    public void testCreateTabAttr() {
        doReturn(1).when(tabAttrMapper).insertTabAttr(tabAttr);
        ResponseEntity<?> createResEntity = tabAttrController.createTabAttr(tabAttr);

        assertEquals(HttpStatus.OK, createResEntity.getStatusCode());
    }

    @Test(expected = Exception.class)
    public void testCreateTabAttrException() {
        doThrow(Exception.class).when(tabAttrMapper).insertTabAttr(tabAttr);
        tabAttrController.createTabAttr(tabAttr);
    }

    @Test
    public void testUpdateTabAttr() {
        doReturn(1).when(tabAttrMapper).updateTabAttrByAttrNo(tabAttr);
        ResponseEntity<?> updResentity = tabAttrController.updateTabAttr(tabAttr);

        assertEquals(HttpStatus.OK, updResentity.getStatusCode());
    }

    @Test
    public void testDeleteTabAttr() {
        doReturn(1).when(tabAttrMapper).deleteTabAttrByAttrNo(tabAttr.getAttrNo());
        ResponseEntity<?> entity = tabAttrController.deleteTabAttr(tabAttr);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void testDeleteTabAttrNoData() {
        doReturn(0).when(tabAttrMapper).deleteTabAttrByAttrNo(tabAttr.getAttrNo());
        ResponseEntity<?> entity = tabAttrController.deleteTabAttr(tabAttr);
        CommonResponse response = (CommonResponse) entity.getBody();

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals("No Data Delete", response.getMessage());
    }

}
