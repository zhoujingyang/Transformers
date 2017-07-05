package com.platform.model;

import lombok.Data;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by zjy on 17/7/3.
 */

@Data
@Entity
public class TestDemo {

    @Id
    private long id;

    private String name;
    private int age;
    private String sex;

}
