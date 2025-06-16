package com.Krav.api.Infra.Notifications;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Emails {


    @Autowired
    private static JavaMailSender mailSender;


    public void SendEmail(List<String> emails, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();

        for(int i = 0; i < emails.toArray().length; i++) {
            message.setTo(emails.get(i));
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
        }
    }

}
