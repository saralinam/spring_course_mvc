package com.lina.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
    //@Valid helps that our attribute will be validated, if validation will be successful
    //we will see result on "show-emp-details-view.jsp", if not we have to go back & fix the issue on
    //"ask-emp-details-view.jsp" page
    //Than we will add "BindingResult", with the help of BindingResult we will see the
    // result was successful or not
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp,
                                 BindingResult bindingResult){

        System.out.println("surname length = "+emp.getSurname().length());

       if(bindingResult.hasErrors()){
           return "ask-emp-details-view";
       }
        else{
            return "show-emp-details-view";
       }

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
