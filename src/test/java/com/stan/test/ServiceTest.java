package com.stan.test;

import com.stan.pojo.Dorm;
import com.stan.pojo.Repair;
import com.stan.pojo.Student;
import com.stan.pojo.Visitor;
import com.stan.service.DormService;
import com.stan.service.PropService;
import com.stan.service.StudentService;
import com.stan.service.UserService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceTest {
    UserService userService = new UserService();
    StudentService studentService = new StudentService();
    DormService dormService = new DormService();
    PropService propService = new PropService();

    @Test
    public void testStudentService() {
        Student stu = studentService.getStudentInfo("211906426");
        System.out.println(stu);

        Map<String, Object> stringObjectMap = studentService.myDormInfo("18615");
        System.out.println(stringObjectMap);

        Dorm dorm = studentService.nearByDorm("18615", "617");
        System.out.println(dorm);

        Map<String, ArrayList<Map<String, String>>> propList = propService.getPropList();
        System.out.println(propList);

        for (Visitor v : studentService.visitorInfo("211906426")) {
            System.out.println(v);
        }

    }

    @Test
    public void testRepairReg() {
        boolean b = studentService.repairReg
                (new Repair(null, "18615", "211906426", "3", "testing", null));

        System.out.println(b);
    }
}
