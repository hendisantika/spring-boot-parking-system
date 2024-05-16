package id.my.hendisantika.springbootparkingsystem.controller;

import id.my.hendisantika.springbootparkingsystem.entity.ParkingSlot;
import id.my.hendisantika.springbootparkingsystem.payload.request.ParkingRequest;
import id.my.hendisantika.springbootparkingsystem.service.ParkingSlotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-parking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/17/24
 * Time: 06:48
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/parking")
@RequiredArgsConstructor
public class ParkingSlotController {

    private final ParkingSlotService parkingSlotService;

    @PostMapping("/add")
    public ResponseEntity<?> addParkingSlot(@Valid @RequestBody ParkingSlot parkingSlot) {
        return parkingSlotService.addParkingSlot(parkingSlot);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findParkingSlotByName(@PathVariable("name") String name) {
        return parkingSlotService.findParkingSlotByName(name);
    }

    @GetMapping("/floor/{floor}")
    public ResponseEntity<?> findParkingSlotByFloor(@PathVariable("floor") String floor) {
        return parkingSlotService.findParkingSlotByFloor(floor);
    }

    @PostMapping("/park")
    public ResponseEntity<?> allocateParkingSlotToUser(@Valid @RequestBody ParkingRequest parkingRequest) {
        return parkingSlotService.allocateParkingSlotToUser(parkingRequest);
    }

    @PostMapping("/unpark/{id}")
    public ResponseEntity<?> deallocateParkingSlotToUser(@PathVariable("id") Long id) {
        return parkingSlotService.deallocateParkingSlot(id);
    }
}
