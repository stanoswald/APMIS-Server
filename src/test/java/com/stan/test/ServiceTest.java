package com.stan.test;

import com.stan.pojo.Student;
import com.stan.service.DormService;
import com.stan.service.StudentService;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ServiceTest {
    StudentService studentService = new StudentService();
    DormService dormService = new DormService();

    @Test
    public void testStudentService() {
    }

    @Test
    public void testMyDormInfo(){
        Map<String, Object> stringObjectMap = studentService.myDormInfo("18615");
        System.out.println(stringObjectMap);
    }
}
