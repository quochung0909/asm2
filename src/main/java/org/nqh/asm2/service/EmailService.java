package org.nqh.asm2.service;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

    void sendHtmlMessage(String to, String subject, String html);

}
