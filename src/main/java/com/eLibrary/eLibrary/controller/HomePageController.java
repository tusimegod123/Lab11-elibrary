package com.eLibrary.eLibrary.controller;

import com.eLibrary.eLibrary.model.Student;
import com.eLibrary.eLibrary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomePageController {
   @Autowired



   private StudentService studentService;

   @GetMapping(value = {"/"})
   public String viewHomePage(){
       return "home/index";
   }

    @GetMapping(value = {"/students"})
    public String getStudents(Model model){
       model.addAttribute("students",studentService.findStudents());
        return "home/students";
    }

    @GetMapping(value = {"/register"})
        public String showRegistrationPage(Model model){
        model.addAttribute("s",new Student());
            return "home/register";
        }

    @PostMapping(value = {"/register"})
    public  String register(@ModelAttribute("student") Student student, Model model){
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer studentId, Model model) {
        Student st = studentService.findStudentById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + studentId));
        model.addAttribute("st", st);
        return "home/update-student";
    }

  @PostMapping(value = {"/update/{id}"})
    public  String editStudent(@ModelAttribute Student student, Model model, @PathVariable Integer id, Integer studentId, BindingResult result, @Valid Student st){
        if (result.hasErrors()) {
            st.setStudentId(id);
            return "home/update-student";
        }
       student.setStudentId(id);


       studentService.saveStudent(student);
       return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        Student student = studentService.findStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        studentService.delete(student);
        return "redirect:/students";
    }

//
//    @PostMapping(value = {"/students"})
//    public Student postStudent(@RequestBody Student student){
//        return studentService.saveStudent(student);
//    }
//
//    @GetMapping(value = {"/students"})
//    public ModelAndView getStudents(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("students",studentService.findStudents());
//        modelAndView.setViewName("students");
//        return modelAndView;
//    }
}

