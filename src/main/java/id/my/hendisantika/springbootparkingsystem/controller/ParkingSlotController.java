package id.my.hendisantika.springbootparkingsystem.controller;

import id.my.hendisantika.springbootparkingsystem.service.ParkingSlotService;
import lombok.RequiredArgsConstructor;
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

}
