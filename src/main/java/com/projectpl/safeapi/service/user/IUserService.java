package com.projectpl.safeapi.service.user;

import com.projectpl.safeapi.errors.exceptions.EmailExistsException;
import com.projectpl.safeapi.persistance.entity.User;
import com.projectpl.safeapi.persistance.dto.UserDto;
import com.projectpl.safeapi.errors.exceptions.UserAlreadyExistException;
import com.projectpl.safeapi.persistance.entity.VerificationToken;

public interface IUserService {


    User registerNewUserClientAccount(UserDto userDto)
            throws UserAlreadyExistException, EmailExistsException;

    User registerNewUserStoreAccount(UserDto userDto)
            throws UserAlreadyExistException, EmailExistsException;

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String token);

    void saveRegisteredUser(User user);

    User getUser(String verificationToken);

    VerificationToken generateNewVerificationToken(String existingToken);

    User getUserById(long id);

    Iterable<User> getAllUsers();

    void deleteUserById(long id);
}
