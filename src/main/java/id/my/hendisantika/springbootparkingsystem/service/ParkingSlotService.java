package id.my.hendisantika.springbootparkingsystem.service;

import id.my.hendisantika.springbootparkingsystem.entity.ParkingSlot;
import org.springframework.http.ResponseEntity;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-parking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/17/24
 * Time: 06:31
 * To change this template use File | Settings | File Templates.
 */
public interface ParkingSlotService {
    ResponseEntity<?> addParkingSlot(ParkingSlot parkingSlot);

    ResponseEntity<?> findParkingSlotByName(String name);

    ResponseEntity<?> findParkingSlotByFloor(String floor);

    ResponseEntity<?> allocateParkingSlotToUser(ParkingRequest parkingRequest);

    ResponseEntity<?> deallocateParkingSlot(Long id);

    ResponseEntity<?> findEmptyParkingSlot();
}
