package com.example.contactbook.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public @Data class ContactBookEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer contactBookId;
    private String name;
    private String email;
    private String phoneNumber;
}
