package com.asdasd.mjeesh.springsecuritydemo.security;

import com.asdasd.mjeesh.springsecuritydemo.model.Status;
import com.asdasd.mjeesh.springsecuritydemo.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public final class UserFactory {

    private UserFactory() {  }

    public static UserDetails fromUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getRole().getAuthorities()
        );
    }
}
