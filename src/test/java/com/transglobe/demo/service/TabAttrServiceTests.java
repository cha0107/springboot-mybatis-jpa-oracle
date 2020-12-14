package com.transglobe.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.transglobe.demo.dao.jpa.TabAttrRepository;
import com.transglobe.demo.dao.mybatis.TabAttrMapper;
import com.transglobe.demo.model.TabAttr;
import com.transglobe.demo.service.imlp.TabAttrServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TabAttrServiceTests {

    @Autowired
    private TabAttrService tabAttrService;
    
    @SpyBean
    private TabAttrServiceImpl tabAttrServiceImpl;

    @MockBean(name = "tabAttrMapper")
    private TabAttrMapper tabAttrMapper;

    @MockBean
    private TabAttrRepository tabAttrRepository;

    private TabAttr tabAttr = new TabAttr("UT", "UnitTestData");
    
    // 為了避免測試之間的副作用，MockitoAnnotations.initMocks（this）靜態方法必須被調用。
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindTabAttrByAttrNo() {
        Optional<TabAttr> mockOptional = Optional.ofNullable(tabAttr);
        doReturn(mockOptional).when(tabAttrRepository).findById("UT");
        Optional<TabAttr> tabAttr = tabAttrService.findTabAttrByAttrNo("UT");
        
        assertEquals(true, tabAttr.isPresent());
        assertEquals("UT", tabAttr.get().getAttrNo());
        assertEquals("UnitTestData", tabAttr.get().getAttrName());
    }

    @Test
    public void testFindAllTabAttr() {
        List<TabAttr> mockList =
                Arrays.asList(new TabAttr("T1", "Test1"), new TabAttr("T2", "Test2"), new TabAttr(
                        "T3", "Test3"));
        doReturn(mockList).when(tabAttrRepository).findAll();

        List<TabAttr> tabAttrList = tabAttrService.findAllTabAttr();

        verify(tabAttrService, times(1)).findAllTabAttr();
        assertEquals(3, tabAttrList.size());
        assertEquals(tabAttrList, mockList);
    }

    @Test
    public void testSaveTabAttr() {
        doReturn(1).when(tabAttrMapper).insertTabAttr(tabAttr);
        int saveCnt = tabAttrService.createTabAttr(tabAttr);

        assertEquals(1, saveCnt);
    }

    @Test(expected = Exception.class)
    public void testSaveTabAttrException() {
        doThrow(Exception.class).when(tabAttrMapper).insertTabAttr(tabAttr);
        tabAttrService.createTabAttr(tabAttr);
    }

    @Test
    public void testModifyTabAttr() {
        doReturn(1).when(tabAttrMapper).updateTabAttrByAttrNo(tabAttr);
        int modifyCnt = tabAttrService.updateTabAttr(tabAttr);

        assertEquals(1, modifyCnt);
    }

    @Test
    public void testDeleteTabAttr() {
        doReturn(1).when(tabAttrMapper).deleteTabAttrByAttrNo(tabAttr.getAttrNo());
        int delCnt = tabAttrService.deleteTabAttr(tabAttr.getAttrNo());

        assertEquals(1, delCnt);
    }

    @Test
    public void testDeleteTabAttrNoData() {
        doReturn(0).when(tabAttrMapper).deleteTabAttrByAttrNo(tabAttr.getAttrNo());
        int delCnt = tabAttrService.deleteTabAttr(tabAttr.getAttrNo());

        assertEquals(0, delCnt);
    }

}
