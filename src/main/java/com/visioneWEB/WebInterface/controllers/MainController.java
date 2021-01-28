package com.visioneWEB.WebInterface.controllers;

import com.visioneWEB.WebInterface.models.*;
import com.visioneWEB.WebInterface.models.Class;
import com.visioneWEB.WebInterface.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.sql.Time;
import java.sql.Date;

@Controller
public class MainController {

    @Autowired
    private usersRepository userRepository;

    @Autowired
    private groupesRepository groupesRepository;


    @Autowired
    private biometricsRepository biometricsRepository;

    @Autowired
    private usersRepository usersRepository;

    @Autowired
    private classroomRepository classroomRepository;

    @Autowired
    private classRepository classRepository;

    @Autowired
    private timetablesRepository timetablesRepository;

    @Autowired
    private partOfDayRepository partOfDayRepository;

    @Autowired
    private notificationDataRepository notificationDataRepository;



    @GetMapping("/")
    public String home(Model model) {
        Iterable<notificationsDatas>Disease = notificationDataRepository.findAllByTypess(Type.Disease);
        Iterable<notificationsDatas>Excess = notificationDataRepository.findAllByTypess(Type.Excess);
        Iterable<notificationsDatas>Late = notificationDataRepository.findAllByTypess(Type.Late);
        Iterable<notificationsDatas>Unknown = notificationDataRepository.findAllByTypess(Type.Unknown);
        Iterable<users>teachers = userRepository.findAllByStatus(Status.teacher);
        Iterable<users>user = userRepository.findAll();
        Iterable<groupes>groupes=groupesRepository.findAll();
        Iterable<Class>classes= classRepository.findAll();
        Iterable<classroom>classrooms= classroomRepository.findAll();

        model.addAttribute("Disease",Disease);
        model.addAttribute("Excess", Excess);
        model.addAttribute("Late", Late);
        model.addAttribute("Unknown", Unknown);

        model.addAttribute("groupesForSelect",groupes);
        model.addAttribute("user", user);
        model.addAttribute("statusValues", Status.values());
        model.addAttribute("dayValues", Day.values());
        model.addAttribute("parityValues", Parity.values());
        model.addAttribute(new users());
        model.addAttribute(new partOfDay());
        model.addAttribute(new groupes());
        model.addAttribute("teachers", teachers);
        model.addAttribute("classes", classes);
        model.addAttribute("classrooms", classrooms);
        return "home";
    }





    @PostMapping("/addClass")
    public String addClass(@RequestParam String addClass, Model model){

        Class classObject = new Class(addClass);
        classRepository.save(classObject);


        /*Iterable<biometrics>teachers = biometricsRepository.findAll();
        biometricsRepository.deleteAll(teachers);


        Iterable<Class>teachers2 = classRepository.findAll();
        classRepository.deleteAll(teachers2);


        Iterable<classroom>teachers3 = classroomRepository.findAll();
        classroomRepository.deleteAll(teachers3);

        Iterable<groupes>teachers4 = groupesRepository.findAll();
        groupesRepository.deleteAll(teachers4);

        Iterable<partOfDay>teachers5 = partOfDayRepository.findAll();
        partOfDayRepository.deleteAll(teachers5);

        Iterable<timetables>teachers6 = timetablesRepository.findAll();
        timetablesRepository.deleteAll(teachers6);

        Iterable<users>teachers7 = usersRepository.findAll();
        usersRepository.deleteAll(teachers7);*/

        return "redirect:/";
    }



    @PostMapping("/addClassroom")
    public String addClassroom(@RequestParam String  addAddres, Model model){

        classroom classroomObject = new classroom(addAddres, false);
        classroomRepository.save(classroomObject);

        return "redirect:/";
    }



    @PostMapping("/addGroup")
    public String addGroup(@RequestParam String addGroup, Model model){






        groupes groupesObject = new groupes(addGroup);

        timetables timetablesObject = new timetables(groupesObject);


        groupesRepository.save(groupesObject);

        timetablesRepository.save(timetablesObject);

        return "redirect:/";
    }



    //Добавление пользователя
    //Загрузка изображения




    //C:\\Users\\Automatik\\Documents\\IntelliJ IDEA\\WebInterface\\src\\main\\resources\\static\\uploadPhotos
    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploadPhotos";

    @PostMapping("/addUser")
    public String addUserPost(@RequestParam String name, @RequestParam Status status,
                              @RequestParam("imageFile") MultipartFile[] files,
                              @RequestParam boolean addDisease, @RequestParam String userName,
                              @RequestParam String surname, Model model){


        String pathPhoto = "///";


        StringBuilder fileNames = new StringBuilder();
        for(MultipartFile file:files){

            Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename());
            try {
                Files.write(fileNameAndPath,file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            pathPhoto = fileNames.toString();
            System.out.println(pathPhoto);

        }


        model.addAttribute("msg","Successfully uploaded files" + fileNames.toString());
        System.out.println(name);
        System.out.println(status);
        System.out.println(fileNames.toString());
        System.out.println(addDisease);




        biometrics biometricsObject = new biometrics(pathPhoto, false);

        biometricsRepository.save(biometricsObject);


        users userObject = new users(userName, surname, status, addDisease, biometricsObject);

        usersRepository.save(userObject);


        if (status.equals(Status.student)){

            groupes addStudentToGroup = groupesRepository.findByName(name);
            addStudentToGroup.getUsers().add(userObject);
            groupesRepository.save(addStudentToGroup);
        }

        return "redirect:/";
    }






    //---------------------------------------------------------------------------
    // Добавляем пару

    @PostMapping("/addPartOfDay")
    public String addPartOfDay(@RequestParam String name, @RequestParam Day day,
                               Model model, @RequestParam Parity parity,
                               @RequestParam users userID, @RequestParam Class classID,
                               @RequestParam classroom classroomID, @RequestParam int numberoflesson,
                               @RequestParam int firstweekofperiod,@RequestParam int lastweekofperiod){

        System.out.println(name);
        System.out.println(day.ordinal());
        System.out.println(parity);
        System.out.println(userID.getName());
        System.out.println(classID.getName());
        System.out.println(classroomID.getAddres());
        System.out.println(numberoflesson);
        System.out.println(firstweekofperiod);
        System.out.println(lastweekofperiod);



        Time[] times_start = {Time.valueOf("8:30:00"),Time.valueOf("10:15:00"),Time.valueOf("12:30:00"),Time.valueOf("14:15:00")};
        Time[] times_end = {Time.valueOf("10:00:00"),Time.valueOf("11:45:00"),Time.valueOf("14:00:00"),Time.valueOf("15:45:00")};

        //Date firstMondaySQL = Date.valueOf("2021-01-25");


        LocalDate firstMonday = LocalDate.of(2021, 1,25);
        System.out.println(firstMonday);



        List<timetables>timetableID = timetablesRepository.findAllByGroupID(groupesRepository.findByName(name));

        System.out.println(timetableID.get(0).getTimetableID());




        for (int i = firstweekofperiod; i <= lastweekofperiod; i++) {
            System.out.println(i + "----------");

            if (i%2==0 && parity.equals(Parity.even)) {
                System.out.println(firstMonday.plusDays(day.ordinal() + 7*i));

                Date dateSQL = Date.valueOf(firstMonday.plusDays(day.ordinal() + 7*i));



                partOfDay partOfDayObject = new partOfDay(dateSQL,times_start[numberoflesson-1],
                        times_end[numberoflesson-1], parity, day,i,numberoflesson, timetableID.get(0),
                        userID, classID,classroomID);
                partOfDayRepository.save(partOfDayObject);
            }

            if (i%2==1 && parity.equals(Parity.odd)) {
                System.out.println(firstMonday.plusDays(day.ordinal() + 7*i));


                Date dateSQL = Date.valueOf(firstMonday.plusDays(day.ordinal() + 7*(i-1)));



                partOfDay partOfDayObject = new partOfDay(dateSQL,times_start[numberoflesson-1],
                        times_end[numberoflesson-1], parity, day,i,numberoflesson, timetableID.get(0),
                        userID, classID,classroomID);
                partOfDayRepository.save(partOfDayObject);
            }

            if (parity.equals(Parity.no_matter)) {
                System.out.println(firstMonday.plusDays(day.ordinal() + 7*(i-1)));




                Date dateSQL = Date.valueOf(firstMonday.plusDays(day.ordinal() + 7*(i-1)));



                partOfDay partOfDayObject = new partOfDay(dateSQL,times_start[numberoflesson-1],
                        times_end[numberoflesson-1], parity, day,i,numberoflesson, timetableID.get(0),
                        userID, classID,classroomID);
                partOfDayRepository.save(partOfDayObject);
            }
        }

        return "redirect:/";
    }


    @PostMapping("/deleteall")
    public String deleteall( Model model){

        Iterable<biometrics>teachers = biometricsRepository.findAll();
        biometricsRepository.deleteAll(teachers);


        Iterable<Class>teachers2 = classRepository.findAll();
        classRepository.deleteAll(teachers2);


        Iterable<classroom>teachers3 = classroomRepository.findAll();
        classroomRepository.deleteAll(teachers3);

        Iterable<groupes>teachers4 = groupesRepository.findAll();
        groupesRepository.deleteAll(teachers4);

        Iterable<partOfDay>teachers5 = partOfDayRepository.findAll();
        partOfDayRepository.deleteAll(teachers5);

        Iterable<timetables>teachers6 = timetablesRepository.findAll();
        timetablesRepository.deleteAll(teachers6);

        Iterable<users>teachers7 = usersRepository.findAll();
        usersRepository.deleteAll(teachers7);

        return "redirect:/";
    }

}