package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import web.model.User;
import web.service.UserService;


@Controller
public class HelloController {
    private UserService service;

    public HelloController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", service.getListUser());
        return "allUsers";
    }
    @GetMapping(value = "/newUser")
    public String addNewUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "user-info";
    }
    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/userId")
    public String getUserId(ModelMap model) {
        model.addAttribute("user", new User());
        return "user-change";
    }
    @PostMapping(value = "/changeUser")
    public String changeUser(@ModelAttribute("user") User user) {
        service.mergeUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/idUserOnDelete")
    public String getIdUserOnDelete(ModelMap model) {
        model.addAttribute("user", new User());
        return "user-delete";
    }
    @PostMapping(value = "/removeUser")
    public String removeUser(@ModelAttribute("user") User user) {
        service.deleteById(user.getId());
        return "redirect:/";
    }
}