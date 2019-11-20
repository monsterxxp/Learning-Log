package com.smallking.listener;

import java.util.Date;

/**
 * @program: learning-log
 * @description: 数据创建监听类
 * @author: smallking
 * @create: 2019-07-28 23:41
 **/
public interface CreateListenable {

    void setCreatedTime(Date val);

    Date getCreatedTime();

    void setCreatedId(String userId);

    String getCreatedId();
}
