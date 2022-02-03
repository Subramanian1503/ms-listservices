package com.upskillyourself.list.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document("user")
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String name;

    private String profilePicture;

}
