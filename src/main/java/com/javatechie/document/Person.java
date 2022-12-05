package com.javatechie.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@AllArgsConstructor
@Data
@RedisHash("Persons")
public class Person implements Serializable {

    private static final long SerialVersionUID = 1L;
    @Id
    private Integer id;
    private String firstname;
    private String lastname;
}