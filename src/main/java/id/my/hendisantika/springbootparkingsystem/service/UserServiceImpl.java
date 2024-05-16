package id.my.hendisantika.springbootparkingsystem.service;

import id.my.hendisantika.springbootparkingsystem.entity.ConfirmationToken;
import id.my.hendisantika.springbootparkingsystem.entity.ERole;
import id.my.hendisantika.springbootparkingsystem.entity.Role;
import id.my.hendisantika.springbootparkingsystem.entity.User;
import id.my.hendisantika.springbootparkingsystem.payload.request.LoginRequest;
import id.my.hendisantika.springbootparkingsystem.payload.request.SignupRequest;
import id.my.hendisantika.springbootparkingsystem.payload.response.MessageResponse;
import id.my.hendisantika.springbootparkingsystem.payload.response.UserInfoResponse;
import id.my.hendisantika.springbootparkingsystem.repository.ConfirmationTokenRepository;
import id.my.hendisantika.springbootparkingsystem.repository.RoleRepository;
import id.my.hendisantika.springbootparkingsystem.repository.UserRepository;
import id.my.hendisantika.springbootparkingsystem.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        userDetails.getMobile(),
                        userDetails.getDrivingLicense(),
                        roles));
    }

    @Override
    public ResponseEntity<?> registerUser(SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getMobile(),
                signUpRequest.getDrivingLicense());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);

        ConfirmationToken confirmationToken = new ConfirmationToken(user);

        confirmationTokenRepository.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:5001/api/auth/confirm-account?token=" + confirmationToken.getConfirmationToken());
        emailService.sendEmail(mailMessage);

        System.out.println("Confirmation Token: " + confirmationToken.getConfirmationToken());

        return ResponseEntity.ok(new MessageResponse("Verify email by the link sent on your email address"));
    }

    @Override
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }

    @Override
    public ResponseEntity<?> getUserDetails(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<?> confirmEmail(String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            User user = userRepository.findByEmailIgnoreCase(token.getUserEntity().getEmail());
            user.setEnabled(true);
            userRepository.save(user);
            return ResponseEntity.ok(new MessageResponse("Email verified successfully!"));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Error: Couldn't verify email"));
    }
}
