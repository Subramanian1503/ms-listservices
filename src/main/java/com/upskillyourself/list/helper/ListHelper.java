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

package com.upskillyourself.list.helper;

import com.upskillyourself.list.exchange.request.UserRequest;
import com.upskillyourself.list.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ListHelper {

    private final UserRepository userRepository;

    public ListHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkWhetherEmailIdExists(UserRequest request) {
        return this.userRepository.findUserByEmailId(request.getEmailId()).isPresent();
    }
}
