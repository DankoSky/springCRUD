package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    private final UserService userService;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/login")
    public String loginPage(@ModelAttribute User user) {
        return "login";
    }

    @GetMapping(value = "user/{id}")
    public String SuccessLoginUser(Model model, @PathVariable("id") int id) {
        User user = userService.show(id);
        model.addAttribute("user",user);
        return "user/show-user";

    }

    @GetMapping(value = "/admin")
    public String SuccessLoginAdmin(Model model) {
        List<String> messages = new ArrayList<>();
        messages.add("Success Login by Admin");
        model.addAttribute("messages", messages);
        return "admin/hello-admin";
    }
}
