package com.projectpl.safeapi.service.user;


import com.projectpl.safeapi.errors.exceptions.UserNotFoundException;
import com.projectpl.safeapi.persistance.entity.User;
import com.projectpl.safeapi.persistance.dto.UserDto;
import com.projectpl.safeapi.errors.exceptions.UserAlreadyExistException;
import com.projectpl.safeapi.persistance.entity.VerificationToken;
import com.projectpl.safeapi.persistance.repository.UserRepository;
import com.projectpl.safeapi.persistance.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUserClientAccount(final UserDto accountDto) throws UserAlreadyExistException {

        if (emailExists(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + accountDto.getEmail());
        }
        final User user = new User();

        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setRole("ROLE_CLIENT");
        return userRepository.save(user);
    }

    @Override
    public User registerNewUserStoreAccount(UserDto accountDto) throws UserAlreadyExistException {

        if (emailExists(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + accountDto.getEmail());
        }

        final User user = new User();

        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setRole("ROLE_STORE");
        return userRepository.save(user);
    }


    @Override
    public void createVerificationToken(User user, String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        verificationTokenRepository.save(myToken);
    }

    @Override
    public VerificationToken getVerificationToken(final String existingVerificationToken) {
        VerificationToken vToken = verificationTokenRepository.findByToken(existingVerificationToken);
        vToken.updateToken(UUID.randomUUID()
                .toString());
        vToken = verificationTokenRepository.save(vToken);
        return vToken;
    }

    @Override
    public void saveRegisteredUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(String verificationToken) {
        User user = verificationTokenRepository.findByToken(verificationToken).getUser();
        return user;
    }


    @Override
    public VerificationToken generateNewVerificationToken(String existingToken) {
        return null;
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.valueOf(id)));
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public void deleteUserById(long id) {
        userRepository.deleteUserById(id);

    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}