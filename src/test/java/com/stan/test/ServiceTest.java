package com.stan.test;

import com.stan.pojo.Dorm;
import com.stan.pojo.Student;
import com.stan.service.DormService;
import com.stan.service.StudentService;
import com.stan.service.UserService;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ServiceTest {
    UserService userService = new UserService();
    StudentService studentService = new StudentService();
    DormService dormService = new DormService();

    @Test
    public void testStudentService() {
        Student stu = studentService.getStudentInfo("211906426");
        System.out.println(stu);

        Map<String, Object> stringObjectMap = studentService.myDormInfo("18615");
        System.out.println(stringObjectMap);

        Dorm dorm = studentService.nearByDorm("18615", "617");
        System.out.println(dorm);
    }
}
