package com.yntaniq.mail.service;

import com.yntaniq.mail.EmailHtmlSender;
import com.yntaniq.mail.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

/**
 * Created by pelibossian on 14/10/16.
 */
@Service
public class EmailSenderService {
    @Autowired
    EmailHtmlSender emailHtmlSender;

    @Autowired
    EmailSender emailSender;


    public EmailSenderService() {
    }

    @Scheduled(cron = "0 0 18 * * *")// (fixedDelay = 2500)// (cron = "0 15 10 15 * ?")"0 0 8-10 * * *"
    public void systemSendEmail() {
        com.yntaniq.mail.EmailStatus emailStatus = emailSender.sendPlainText("pelibossian@gmail.com","namak","namaki parunakutyun");

        Context context = new Context();
        context.setVariable("title", "Lorem Ipsum");
        context.setVariable("description", "Lorem Lorem Lorem");
        emailStatus = emailHtmlSender.send("pelibossian@gmail.com", "Title of email", "email/template-1", context);
    }
}
