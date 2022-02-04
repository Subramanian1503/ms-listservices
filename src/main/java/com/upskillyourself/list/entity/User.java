package com.upskillyourself.list.entity;

import com.upskillyourself.list.exchange.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String name;

    private String emailId;

    private String phoneNumber;

    private String profilePicture;

    public UserResponse convertEntityToResponse() {
        UserResponse user = new UserResponse();
        user.setId(this.id);
        user.setName(this.name);
        user.setEmailId(this.emailId);
        user.setPhoneNumber(this.phoneNumber);
        user.setProfilePicture(this.profilePicture);
        return user;
    }

}
