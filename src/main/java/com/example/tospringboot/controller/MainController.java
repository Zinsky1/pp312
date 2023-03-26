package com.example.tospringboot.controller;


import com.example.tospringboot.model.User;
import com.example.tospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class MainController {

    @GetMapping
    public String home() {
        return "home";
    }

    private final UserService userService;


    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }


    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }


    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);

        return "redirect:/users/list";
    }



    @GetMapping("/{id}")
    public String getUSer(@PathVariable("id") int id, Model model) {
        model.addAttribute("user" ,userService.getUser(id));
        return "get";
    }



    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users/list";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "update";
    }


    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/users/list";
    }
}
