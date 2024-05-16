package id.my.hendisantika.springbootparkingsystem.service;

import id.my.hendisantika.springbootparkingsystem.entity.ParkingSlot;
import id.my.hendisantika.springbootparkingsystem.repository.HistoryRepository;
import id.my.hendisantika.springbootparkingsystem.repository.ParkingSlotRepository;
import id.my.hendisantika.springbootparkingsystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-parking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/17/24
 * Time: 06:32
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public ResponseEntity<?> addParkingSlot(ParkingSlot parkingSlot) {
        Optional<ParkingSlot> parkingSlot1 = parkingSlotRepository.findByName(parkingSlot.getName());
        if (parkingSlot1.isPresent()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Parking Slot exist!"));
        }
        parkingSlotRepository.save(parkingSlot);
        return ResponseEntity.ok(new MessageResponse("Parking Slot added successfully!"));
    }

    @Override
    public ResponseEntity<?> findParkingSlotByName(String name) {
        Optional<ParkingSlot> parkingSlot = parkingSlotRepository.findByName(name);
        if (parkingSlot.isPresent()) {
            return ResponseEntity.ok(parkingSlot);
        }

        return ResponseEntity.ok("No parking slot present with name: " + name);
    }
}
