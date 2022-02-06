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
