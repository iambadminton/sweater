package com.example.sweater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by Sanya on 25.01.2019.
 */
@Service // помечаем его аннотацией сервис, чтобы спринг создал его автоматически, без нашей помощи
public class MailSender {
    @Autowired
    private JavaMailSender mailSender;
    // в текущей версии спринга javamailsender почему-то поломатый, поэтому нужно создать еще один класс-конфиг MailConfig


    @Value("${spring.mail.username")
    private String username; // получаем значение для того, чтобы указать отправителя

    // метод для отсылки почты
    public void send(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }
}
