package com.upskillyourself.list.exchange.response;

import com.upskillyourself.list.core.model.OutputModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.audit4j.core.annotation.DeIdentify;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserResponse extends OutputModel {

    private String id;

    @DeIdentify
    private String name;

    @DeIdentify
    private String emailId;

    @DeIdentify
    private String phoneNumber;

    @DeIdentify
    private String profilePicture;

}
