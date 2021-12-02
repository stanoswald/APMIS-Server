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

        Student student = studentService.selectByNo("211906426");
        System.out.println(student);

        List<Student> students = studentService.selectByDorm(dormService.selectById("615"));
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    @Test
    public void testMyDormInfo(){
        Map<String, Object> stringObjectMap = studentService.myDormInfo("615");
        System.out.println(stringObjectMap);
    }
}
