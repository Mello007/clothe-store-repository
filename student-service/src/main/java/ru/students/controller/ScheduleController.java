package ru.students.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.students.entity.Schedule;
import ru.students.entity.Student;
import ru.students.repository.ScheduleRepository;

@RestController
@RequestMapping(value = "schedule")
public class ScheduleController {

    @Autowired ScheduleRepository scheduleRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    public void addStudent(@RequestBody Schedule schedule)  {
        scheduleRepository.save(schedule);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST, consumes = "application/json")
    public void deleteStudent(@RequestBody Schedule schedule)  {
        scheduleRepository.delete(schedule);
    }

}
