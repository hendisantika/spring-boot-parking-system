package id.my.hendisantika.springbootparkingsystem.service;

import id.my.hendisantika.springbootparkingsystem.repository.ConfirmationTokenRepository;
import id.my.hendisantika.springbootparkingsystem.repository.RoleRepository;
import id.my.hendisantika.springbootparkingsystem.repository.UserRepository;
import id.my.hendisantika.springbootparkingsystem.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    private final ConfirmationTokenRepository confirmationTokenRepository;

    private final EmailService emailService;

    private final JwtUtils jwtUtils;
}
