package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/")
    public String ShowIndex(Model model) {
        model.addAttribute("users", userService.listUsers());

        return "index";
    }

    @GetMapping("/create")
    public String ShowCreate(){
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("salary") int salary) {
        userService.createUser(new User(firstName, lastName, salary));
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") long id){
        userService.dropUser(id);
        return "delete";
    }

    @GetMapping("/update")
    public String updateUser(){
        //model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("salary")int salary) {
        if (userService.getUserById(id) != null) {
            userService.editSalary(id, salary);
        }
        return "redirect:/";
    }




}
