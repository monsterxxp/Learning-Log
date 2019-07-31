package com.smallking.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * @program: learning-log
 * @description: 实体类监听类
 * @author: smallking
 * @create: 2019-07-28 23:39
 **/
public class EntityEventListener {

    public EntityEventListener() {
    }
    /**
    * @Description:  监听新增操作
    * @Param:  entity
    * @Author: smallking
    * @Date:  2019-07-29
    */
    @PrePersist
    public void prePersist(Object entity) {
        if (entity instanceof CreateListenable) {
            if (((CreateListenable) entity).getCreatedTime() == null) {
                ((CreateListenable) entity).setCreatedTime(new Date(System.currentTimeMillis()));
            }
        }
    }
    /**
     * @Description:  监听修改操作
     * @Param:  entity
     * @Author: smallking
     * @Date:  2019-07-29
     */
    @PreUpdate
    public void preUpdate(Object entity) {
        if (entity instanceof UpdateListenable) {
            if (((UpdateListenable) entity).getUpdatedTime() == null) {
                ((UpdateListenable) entity).setUpdatedTime(new Date(System.currentTimeMillis()));
            }
        }
    }
}
