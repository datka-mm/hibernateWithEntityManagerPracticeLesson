package org.example;

import org.example.entity.Course;
import org.example.service.CourseService;
import org.example.service.serviceImpl.CourseServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        CourseService courseService = new CourseServiceImpl();
//        System.out.println(courseService.saveCourse(new Course("JS", 12000)));
//        System.out.println(courseService.getCourseById(2L));
        System.out.println(courseService.updateCourse(2L, new Course("Js", 20000)));
    }
}
