package ru.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.students.entity.Session;
import ru.students.entity.Student;
import ru.students.repository.SessionRepository;

@RestController
@RequestMapping(value = "session")
public class SessionController {

    @Autowired SessionRepository sessionRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    public void addSession(@RequestBody Session session)  {
        sessionRepository.save(session);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST, consumes = "application/json")
    public void deleteSession(@RequestBody Session session)  {
        sessionRepository.delete(session);
    }

}
