package id.my.hendisantika.springbootparkingsystem.service;

import id.my.hendisantika.springbootparkingsystem.repository.HistoryRepository;
import id.my.hendisantika.springbootparkingsystem.repository.ParkingSlotRepository;
import id.my.hendisantika.springbootparkingsystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
