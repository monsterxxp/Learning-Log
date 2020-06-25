package com.smallking.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration//1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling// 2.开启定时任务
public class SaticScheduleTask {

    @Autowired
    private SimpMessagingTemplate template;

    //3.添加定时任务
    //广播推送消息
    @Scheduled(fixedRate = 10000)
    public void sendTopicMessage() {
        System.out.println("后台广播推送！");
        this.template.convertAndSend("/topic/upload/asd1","哈哈哈哈，文件接受成功");
    }
}