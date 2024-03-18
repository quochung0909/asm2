package org.nqh.asm2.service.impl;

import org.nqh.asm2.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hungnqfx19911@funix.edu.vn");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
        System.out.println("Send email success");
    }

    @Override
    public void sendHtmlMessage(String to, String subject, String html) {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setFrom("quochung9920@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        javaMailSender.send(message);
    }

}
