package com.yx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yx.dao.CourseMapper;
import com.yx.dao.ScMapper;
import com.yx.dao.StudentMapper;
import com.yx.dao.TeacherMapper;
import com.yx.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootTest
class ExerciseDay02ApplicationTests {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ScMapper scMapper;
    
    @Test
    void test01() throws ParseException {
        List<Student> students = studentMapper.selectList(
            new QueryWrapper<Student>()
                .likeRight("sname", "张")
                .gt("sage",
                    new SimpleDateFormat("yyyy-MM-dd").parse("2010-01-01"))
                .select("sid", "sname", "sage"));
        System.out.println(students);
    }
    
    @Test
    void test02() {
        List<Student> students = studentMapper.selectList(
            new QueryWrapper<Student>()
                .likeRight("sname", "张")
                .select("sid", "sname", "sage"));
        System.out.println(students);
    }
}
