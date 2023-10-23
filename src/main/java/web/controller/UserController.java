package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }
//    @GetMapping()
//    public String getUserById(@RequestParam(value = "id", required = false) Long id, ModelMap model) {
//        model.addAttribute("users", userService.getUserById(id));
//        return "users";
//    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String getEditableUser(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("usertoupdate", userService.getUserById(id));
        model.addAttribute("userId", id);
        return "edit";
    }
    @PostMapping("/edit(id=${user.getId()})")
    public String editUser(@RequestParam(value = "id") Long id, @ModelAttribute("usertoupdate") User user) {
        userService.updateUser(userService.getUserById(id));
        return "redirect:/users";
    }
    @PostMapping("/delete(id=${user.getId()})")
    public String deleteUser(@RequestParam(value = "id") Long id) {
        userService.removeUser(userService.getUserById(id));
        return "redirect:/users";
    }
}
