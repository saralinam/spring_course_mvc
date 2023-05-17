package com.lina.spring.mvc;

import com.lina.spring.mvc.validation.CheckEmail;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

@RequestMapping
public class Employee {
    @Size(min = 3, message = "name must at least 3 symbols or more")
    private String name;
//    @NotNull(message = "surname is required field") // if you don't wright anything, still works,
    //because by default length will be 0
//    @NotEmpty(message = "surname is required field") //if you don't wright anything, it'll give you error message
    // but if you trick typing spaces, it'll work, because by spaces are not empty

    @NotBlank(message = "surname is required field") //@NotBlank shouldn't be empty and shouldn't be
    // filled with spaces
    private String surname;
    @Min(value=1000, message = "must be greater  than 999")
    @Max(value =2500, message = "must be less than 2501")
    private int salary;
    private String department;
    private Map<String, String> departments;
    private String carBrand;
    private Map<String, String> carBrands;
    private String[] languages;
    private Map<String, String> languageList;

    @CheckEmail(value = "gmail.com", message = "email must ends with gmail.com")
    private String email;

    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "please use pattern xxx-xx-xx")
    private String phoneNumber;


    //constructor no arguments

    public Employee() {
        departments = new HashMap<>();
        departments.put("IT", "Information Technology");
        departments.put("HR", "Human Resources");
        departments.put("Sales", "Sales");

        //for carBrand radio button
        carBrands = new HashMap<>();
        carBrands.put("BMW", "BMW");
        carBrands.put("Audi", "Audi");
        carBrands.put("Mercedes-Benz", "MB");

        // for Languages checkbox
        languageList = new HashMap<>();
        languageList.put("English", "EN");
        languageList.put("Deutsch", "DE");
        languageList.put("French", "FR");


    }

    //getter-setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Map<String, String> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(Map<String, String> carBrands) {
        this.carBrands = carBrands;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Map<String, String> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(Map<String, String> languageList) {
        this.languageList = languageList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //toString()


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
