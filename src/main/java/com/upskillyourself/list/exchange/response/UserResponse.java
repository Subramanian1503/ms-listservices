package com.upskillyourself.list.exchange.response;

import com.upskillyourself.list.core.model.OutputModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserResponse extends OutputModel {

    private String id;

    private String name;

    private String emailId;

    private String phoneNumber;

    private String profilePicture;

}
