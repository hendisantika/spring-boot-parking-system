package id.my.hendisantika.springbootparkingsystem.service;

import id.my.hendisantika.springbootparkingsystem.entity.Vehicle;
import org.springframework.http.ResponseEntity;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-parking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/17/24
 * Time: 06:38
 * To change this template use File | Settings | File Templates.
 */
public interface VehicleService {
    ResponseEntity<?> addVehicle(Vehicle vehicle);

    ResponseEntity<?> findVehicleByUser(String username);

    ResponseEntity<?> findVehicleByRegistrationNumber(String registrationNumber);
}
