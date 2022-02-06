package com.upskillyourself.list.exchange.request;

import com.upskillyourself.list.core.model.InputModel;
import com.upskillyourself.list.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.audit4j.core.annotation.DeIdentify;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserRequest extends InputModel {

    @DeIdentify
    private String name;

    @DeIdentify
    private String emailId;

    @DeIdentify
    private String phoneNumber;

    @DeIdentify
    private String profilePicture;

    public User convertRequestToEntity() {
        User user = new User();
        user.setName(this.name);
        user.setProfilePicture(this.profilePicture);
        user.setEmailId(this.emailId);
        user.setPhoneNumber(this.phoneNumber);
        return user;
    }
}
