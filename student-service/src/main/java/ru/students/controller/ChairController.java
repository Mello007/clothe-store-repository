package ru.students.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.students.entity.Chair;
import ru.students.entity.Student;
import ru.students.repository.ChairRepository;


@RestController
@RequestMapping(value = "chair")
public class ChairController {
    @Autowired ChairRepository chairRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    public void addStudent(@RequestBody Chair chair)  {
        chairRepository.save(chair);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST, consumes = "application/json")
    public void deleteStudent(@RequestBody Chair chair)  {
        chairRepository.delete(chair);
    }

}
