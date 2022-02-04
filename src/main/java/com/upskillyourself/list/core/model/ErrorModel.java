package com.upskillyourself.list.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorModel extends OutputModel{

    private String code;

    private String message;

    private LocalDateTime timeStamp;
}
