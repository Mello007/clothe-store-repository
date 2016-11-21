package ru.students.service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.students.entity.Student;

@Service
public class StudentService {

//    @Autowired SessionFactory sessionFactory;
//
//    public Student findStudent(String name){
//        Query query = sessionFactory.openSession().
//                createQuery("from Student WHERE name = :name").
//                setParameter("name", name);
//        return (Student) query.uniqueResult();
//    }
}
