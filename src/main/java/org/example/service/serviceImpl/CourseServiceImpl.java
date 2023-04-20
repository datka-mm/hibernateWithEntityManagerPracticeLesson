package org.example.service.serviceImpl;

import org.example.dao.CourseDao;
import org.example.dao.daoImpl.CourseDaoImpl;
import org.example.entity.Course;
import org.example.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    CourseDao dao = new CourseDaoImpl();

    @Override
    public String saveCourse(Course newCourse) {
        return dao.saveCourse(newCourse);
    }

    @Override
    public Course getCourseById(Long id) {
        return dao.getCourseById(id);
    }

    @Override
    public String updateCourse(Long oldId, Course newCourse) {
        return dao.updateCourse(oldId, newCourse);
    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }

    @Override
    public String deleteCourseById(Long id) {
        return null;
    }
}
