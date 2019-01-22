package com.example.sweater.controller;

import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Sanya on 22.01.2019.
 */
@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')") // проверяем перед выполнением любого из методов наличие у него прав
// для работы @PreAuthority нужно добавить аннотацию @EnableGlobalMethodSecurity в класс WebSecurityConfig
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "userList"; // возвращаем файл
    }

    @GetMapping("{user}") // здесь у нас будет маппинг /user/5
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user, Model model) { // параметр на форме имеет имя userId
        user.setUsername(username);
        // прежде, чем обновлять роли пользователя, нам нужно получить список ролей, чтобы проверить, что они установлены
        // данному пользователю
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        // для начала очистим все роли пользователя
        user.getRoles().clear();
        // проверяем, что форма содержит роли для нашего пользователя
        for (String key : form.keySet()) {
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        // мы можем сохранить имя пользователя
        userRepo.save(user);
        return "redirect:/user";
    }
}
