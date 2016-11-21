package ru.students.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.students.entity.Teacher;
import ru.students.repository.TeacherRepository;

@RestController
@RequestMapping(value = "teacher")
public class TeacherController {

    @Autowired TeacherRepository teacherRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    public void addStudent(@RequestBody Teacher teacher)  {
        teacherRepository.save(teacher);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST, consumes = "application/json")
    public void deleteStudent(@RequestBody Teacher teacher)  {
        teacherRepository.delete(teacher);
    }



}
