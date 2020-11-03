package com.anton.service;

import com.anton.model.NotificationEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender mailSender;
    private final MailContentBuilder builder;

    @Autowired
    public MailService(JavaMailSender mailSender, MailContentBuilder builder) {
        this.mailSender = mailSender;
        this.builder = builder;
    }

    public void sendMail(NotificationEmail notificationEmail){
        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom("megumintheredmazoku@gmail.com");
            helper.setTo(notificationEmail.getRecipient());
            helper.setSubject(notificationEmail.getSubject());
            helper.setText(builder.build(notificationEmail.getBody()));
        };
        try {
            mailSender.send(preparator);
        }catch (MailException e){
            e.printStackTrace();
        }
    }
}
