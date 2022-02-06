package com.upskillyourself.list.repository;

import com.upskillyourself.list.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findUserByEmailId(String emailId);

    User deleteUserByEmailId(String emailId);
}
