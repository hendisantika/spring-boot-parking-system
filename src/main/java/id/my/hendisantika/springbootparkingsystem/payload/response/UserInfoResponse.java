package id.my.hendisantika.springbootparkingsystem.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-parking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/17/24
 * Time: 06:42
 * To change this template use File | Settings | File Templates.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
    private Long id;
    private String username;
    private String email;
    private String mobile;
    private String drivingLicense;
    private List<String> roles;
}
