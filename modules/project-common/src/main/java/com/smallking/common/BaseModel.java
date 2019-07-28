package com.smallking.common;

import com.smallking.listener.EntityEventListener;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: learning-log
 * @description: 基础Model类
 * @author: smallking
 * @create: 2019-07-28 23:32
 **/

@EntityListeners({EntityEventListener.class})
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 3381061073011090142L;

    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR")
    protected String id;

    public BaseModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
