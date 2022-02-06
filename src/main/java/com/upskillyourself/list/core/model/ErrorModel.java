package com.upskillyourself.list.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class ErrorModel extends OutputModel{

    private String code;

    private String message;

    private LocalDateTime timeStamp;
}
