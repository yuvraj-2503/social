package com.meta.server.users.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import com.meta.common.users.PhoneNumber;
import com.meta.common.users.UserDetails;

import java.util.Optional;

/**
 * @author Yuvraj Singh
 */
@Repository
@EnableAsync
public interface UsersRepository extends MongoRepository<UserDetails, String> {
    Optional<UserDetails> findByEmailId(String emailId);
    Optional<UserDetails> findByPhoneNumber(PhoneNumber phoneNumber);
}
