package com.activxg.todolist.model;

import com.activxg.todolist.constant.Provider;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;
    @Enumerated(EnumType.STRING)
    private Provider provider;

}
