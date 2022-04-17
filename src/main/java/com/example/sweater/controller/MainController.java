package com.example.sweater.controller;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


@Controller
@EnableWebMvc
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepo.findAll();


        if (filter != null && !(filter.isEmpty())) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid @ModelAttribute Message message,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file) throws IOException {
        message.setAuthor(user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errosrMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errosrMap);
            model.addAttribute("message", message);
        } else {

            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);
                if (uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                //обезопасим себя от коллизий и создадим уникальное имя файла:
                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + file.getOriginalFilename();
                message.setFilename(resultFilename);

                // теперь надо этот файл загрузить:
                file.transferTo(new File(uploadPath + "/" + resultFilename));

            }
            messageRepo.save(message);
            model.addAttribute("message", null);
        }
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }


    @GetMapping("/user-messages/{user}")
    public String userMessages(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model
    ) {
        Set<Message> messages = user.getMessages();
        model.addAttribute("messages", messages);
        model.addAttribute("isCurrentUser", currentUser.equals(user));
        return "userMessages";
    }

}
