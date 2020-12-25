package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import web.model.User;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImp UserServiceImp;

    @Autowired
    public UserController(UserServiceImp UserServiceImp) {
        this.UserServiceImp = UserServiceImp;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", UserServiceImp.getAllUsers());
        return "users/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("user", UserServiceImp.show(id));
        return  "users/show";

    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user ,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "users/new";

        UserServiceImp.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model ,@PathVariable("id") int id){
        model.addAttribute("user", UserServiceImp.show(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user,BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if(bindingResult.hasErrors())
            return "users/edit";

        UserServiceImp.update(id,user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        UserServiceImp.delete(id);
        return "redirect:/users";
    }
}
