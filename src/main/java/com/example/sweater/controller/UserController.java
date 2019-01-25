package com.example.sweater.controller;

import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Sanya on 22.01.2019.
 */
@Controller
@RequestMapping("/user")
//@PreAuthorize("hasAuthority('ADMIN')") // проверяем перед выполнением любого из методов наличие у него прав
// для работы @PreAuthority нужно добавить аннотацию @EnableGlobalMethodSecurity в класс WebSecurityConfig
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')") // проверяем перед выполнением любого из методов наличие у него прав
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList"; // возвращаем файл
    }

    @PreAuthorize("hasAuthority('ADMIN')") // проверяем перед выполнением любого из методов наличие у него прав
    @GetMapping("{user}") // здесь у нас будет маппинг /user/5
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')") // проверяем перед выполнением любого из методов наличие у него прав
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user, Model model) { // параметр на форме имеет имя userId

        userService.saveUser(user, username, form);
        return "redirect:/user";
    }


    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){ // ожидаем пользователя из контекста, чтобы мы его не получали из БД
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());

        //возвращаем пользователю форму profile
        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(@AuthenticationPrincipal User user,@RequestParam String password, String email) {
        userService.updateProfile(user,password,email);
        return "redirec:/user/profile";
    }
}
