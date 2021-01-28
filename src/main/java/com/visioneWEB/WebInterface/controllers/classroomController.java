package com.visioneWEB.WebInterface.controllers;

import com.visioneWEB.WebInterface.models.Class;
import com.visioneWEB.WebInterface.models.classroom;
import com.visioneWEB.WebInterface.repo.classRepository;
import com.visioneWEB.WebInterface.repo.classroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class classroomController {







   /* @PostMapping
    public String addClass(@RequestParam String addClass, Model model){
        Class classObject = new Class(addClass);
        classRepository.save(classObject);
        return "redirect:/";
    }*/
}

