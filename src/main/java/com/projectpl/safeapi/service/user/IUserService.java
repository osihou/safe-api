package com.projectpl.safeapi.service.user;

import com.projectpl.safeapi.persistance.entity.User;
import com.projectpl.safeapi.persistance.dto.UserDto;
import com.projectpl.safeapi.exceptions.UserAlreadyExistException;
import com.projectpl.safeapi.persistance.entity.VerificationToken;

public interface IUserService {
    User registerNewUserAccount(UserDto userDto)
            throws UserAlreadyExistException;

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String token);

    void saveRegisteredUser(User user);

    User getUser(String verificationToken);

}