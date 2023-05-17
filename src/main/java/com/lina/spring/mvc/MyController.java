package com.lina.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller

@RequestMapping("/employee")   //it connects all the urls in this class (with methods)
public class MyController {

    @RequestMapping("/")  //   /employee/
    public String showFirstView(){
        return "first-view";
    }


    @RequestMapping("/askDetails")  //   /employee/askDetails
    public String askEmployeeDetails(Model model){


        //1. method to add employee
//        Employee emp =new Employee();
//        emp.setName("Jordan");
//        emp.setSurName("Adam");
//        emp.setSalary(1500);

        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }



    @RequestMapping("/showDetails")
    public String showEmpDetails(@ModelAttribute("employee") Employee emp){

        String name = emp.getName();
        emp.setName(name);

        String surname = emp.getSurname();
        emp.setSurname(surname+"!");

        int salary = emp.getSalary();
        emp.setSalary(salary*5);


        return "show-emp-details-view";
    }









    //    @RequestMapping("/showDetails")
//    public String showEmpDetails(@RequestParam("employeeName") String empName, Model model){
//
//        empName = "Mr. " + empName + "!";
//        model.addAttribute("nameAttribute", empName);
//
//
//        return "show-emp-details-view";
//    }

//    @RequestMapping("/showDetails")
//    public String showEmpDetails(HttpServletRequest request, Model model){
//
//        String empName = request.getParameter("employeeName");
//        empName = "Mr. " + empName;
//        model.addAttribute("nameAttribute", empName);
//
//        model.addAttribute("description", "- math instructor");
//
//
//        return "show-emp-details-view";
//    }



}
