package com.smallking.utils;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtils {

    private final static Logger logger = Logger.getLogger(EmailUtils.class);

    @Autowired
    private JavaMailSender jms;

    @Autowired
    private TemplateEngine templateEngine;

    private static EmailUtils emailUtils;

    @Value("${spring.mail.username}")
    private String from;

    @PostConstruct
    public void init() {
        emailUtils = this;
        emailUtils.jms = this.jms;
        emailUtils.from = this.from;
        emailUtils.templateEngine = this.templateEngine;
    }

    public static void sendSimpleEmail(String subject, String to, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailUtils.from);
            // 接收地址
            message.setTo(to);
            // 标题
            message.setSubject(subject);
            // 内容
            message.setText(text);
            emailUtils.jms.send(message);
            logger.info("邮件发送成功！");
        } catch (Exception e) {
            logger.error("邮件发送失败，原因：");
            e.printStackTrace();
        }
    }

    public static void sendHtmlEmail(String subject, String to, String htmlText) {
        MimeMessage message = null;
        try {
            message = emailUtils.jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(emailUtils.from);
            // 接收地址
            helper.setTo(to);
            // 标题
            helper.setSubject(subject);
            // 带HTML格式的内容
            StringBuffer sb = new StringBuffer(htmlText);
            helper.setText(sb.toString(), true);
            emailUtils.jms.send(message);
            logger.info("邮件发送成功！");
        } catch (Exception e) {
            logger.error("邮件发送失败，原因：");
            e.printStackTrace();
        }
    }

    public static void sendAttachmentsMail(String subject, String to, String text, String attachmentFilename, File file) {
        MimeMessage message = null;
        try {
            message = emailUtils.jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(emailUtils.from);
            // 接收地址
            helper.setTo(to);
            // 标题
            helper.setSubject(subject);
            // 内容
            StringBuffer sb = new StringBuffer(text);
            helper.setText(sb.toString(), true);
            // 传入附件
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            helper.addAttachment(attachmentFilename, fileSystemResource);
            emailUtils.jms.send(message);
            logger.info("邮件发送成功！");
        } catch (Exception e) {
            logger.error("邮件发送失败，原因：");
            e.printStackTrace();
        }
    }

    public static void sendTemplateEmail(String subject, String to, String templateName, Context content) {
        MimeMessage message = null;
        try {
            message = emailUtils.jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(emailUtils.from);
            // 接收地址
            helper.setTo(to);
            // 标题
            helper.setSubject(subject);
            // 处理邮件模板
            String template = emailUtils.templateEngine.process(templateName, content);
            helper.setText(template, true);
            emailUtils.jms.send(message);
            logger.info("邮件发送成功！");
        } catch (Exception e) {
            logger.error("邮件发送失败，原因：");
            e.printStackTrace();
        }
    }
}
