package id.my.hendisantika.springbootparkingsystem.service;

import id.my.hendisantika.springbootparkingsystem.entity.Vehicle;
import id.my.hendisantika.springbootparkingsystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public ResponseEntity<?> addVehicle(Vehicle vehicle) {
        if (vehicleRepository.findByRegisterationNumber(vehicle.getRegisterationNumber()).isPresent()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Vehicle is already registered!"));
        }

        vehicleRepository.save(vehicle);
        return ResponseEntity.ok(new MessageResponse("Vehicle added successfully!"));
    }

    @Override
    public ResponseEntity<?> findVehicleByUser(String username) {
        List<Vehicle> allVehicles = vehicleRepository.findByUsername(username);

        if (allVehicles.isEmpty()) {
            return ResponseEntity.ok("User owns no vehicle");
        }

        return ResponseEntity.ok(allVehicles);
    }
}
