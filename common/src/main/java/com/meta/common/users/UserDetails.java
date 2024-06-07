package com.meta.common.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yuvraj Singh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    private String userId;
    private String emailId;
    private String firstName;
    private String lastName;
    private PhoneNumber phoneNumber;
    private String about;
    private String avatarUrl;
    private UserStatus status;
    private String userName;
    private Long joinedDate;
    private Long lastSeen;
    private Long lastUpdatedOn;
}
