package org.example.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.config.HibernateConfig;
import org.example.dao.CourseDao;
import org.example.entity.Course;

import java.util.List;

public class CourseDaoImpl implements CourseDao {

    EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManager();

    @Override
    public String saveCourse(Course newCourse) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newCourse);
        entityManager.getTransaction().commit();
        entityManager.close();
        return newCourse + " successfully saved!";
    }

    @Override
    public Course getCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        // with method
//        Course course = entityManager.find(Course.class, id);

        // with query
        Query query = entityManager
                .createQuery("select c from Course c where c.id = :id")
                .setParameter("id", id);
        Course course = (Course) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public String updateCourse(Long oldId, Course newCourse) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int updatedRows = entityManager.createQuery("update Course c set c.courseName = :courseName, " +
                        "c.price = :price where c.id = :oldId")
                .setParameter("courseName", newCourse.getCourseName())
                .setParameter("price", newCourse.getPrice())
                .setParameter("oldId", oldId).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Course with id: " + oldId + " successfully updated!\n" + updatedRows;

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
