package com.upskillyourself.list.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("task")
@AllArgsConstructor
public class Task {

    @Id
    private String id;

    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String description;

}
