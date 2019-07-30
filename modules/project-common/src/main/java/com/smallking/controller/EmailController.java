package com.smallking.controller;

import com.smallking.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import java.io.File;

@RestController
@RequestMapping("/email")
public class EmailController {
    
    @RequestMapping("sendSimpleEmail")
    public void sendSimpleEmail() {
//        EmailUtils.sendHtmlEmail("简单的邮件", "130302055@qq.com", "<p style='color:#42b983'>使用Spring Boot发送HTML格式邮件。</p>");
//        EmailUtils.sendSimpleEmail("简单的邮件", "130302055@qq.com", "测试内容");
//        EmailUtils.sendAttachmentsMail("简单的邮件", "130302055@qq.com", "测试内容", "application.yml", new File("modules/project-web/src/main/resources/application.yml"));
        Context context = new Context();
        context.setVariable("id", 123);
        context.setVariable("name", "smallking");
        EmailUtils.sendTemplateEmail("简单的邮件", "130302055@qq.com","emailTemplate",context);
    }
}