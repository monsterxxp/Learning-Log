package com.smallking.listener;

import java.util.Date;

/**
 * @program: learning-log
 * @description: 数据更新监听类
 * @author: smallking
 * @create: 2019-07-28 23:48
 **/
public interface UpdateListenable {

    void setUpdatedTime(Date val);

    Date getUpdatedTime();
}
