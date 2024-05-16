package id.my.hendisantika.springbootparkingsystem.service;

import id.my.hendisantika.springbootparkingsystem.payload.request.LoginRequest;
import id.my.hendisantika.springbootparkingsystem.payload.request.SignupRequest;
import org.springframework.http.ResponseEntity;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-parking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/17/24
 * Time: 06:36
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    ResponseEntity<?> authenticateUser(LoginRequest loginRequest);

    ResponseEntity<?> registerUser(SignupRequest signUpRequest);

    ResponseEntity<?> logoutUser();

    ResponseEntity<?> getUserDetails(String username);

    ResponseEntity<?> confirmEmail(String confirmationToken);
}
