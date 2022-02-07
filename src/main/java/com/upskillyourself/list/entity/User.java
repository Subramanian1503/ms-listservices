/*
 * *
 *  * *******************************************************************************
 *  * Copyright ©2022.
 *   Upskillyourself - All rights reserved.
 *  *
 *  * All information contained herein is, and remains the property of Upskillyourself.
 *  * Upskillyourself including, without limitation, all software and other elements thereof,
 *  * are owned or controlled exclusively by Upskillyourself and protected by copyright, patent
 *  * and other laws. Use without permission is prohibited.
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  *
 *  * For further information contact Upskillyourself at info@Upskillyourself.com.
 *  * *******************************************************************************
 *
 */

package com.upskillyourself.list.entity;

import com.upskillyourself.list.exchange.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.audit4j.core.annotation.DeIdentify;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    @DeIdentify
    private String name;

    @DeIdentify
    private String emailId;

    @DeIdentify
    private String phoneNumber;

    @DeIdentify
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
