package com.baizhi;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = GitemsApplication.class)
@RunWith(SpringRunner.class)
public class GitemsApplicationTests {
    @Autowired
    private EmpService empService;

    @Test
    public void test01() {
        empService.findPage(1, 6);
    }

    @Test
    public void test02() {
        empService.findAllSearch("name", "eq", "幻想", 1, 5);
    }

    @Test
    public void test03() {
        Emp emp = new Emp();
        emp.setName("aaa");
        empService.delete(emp);
    }

}
