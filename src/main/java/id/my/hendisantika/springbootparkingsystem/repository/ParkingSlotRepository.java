package id.my.hendisantika.springbootparkingsystem.repository;

import id.my.hendisantika.springbootparkingsystem.entity.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-parking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/17/24
 * Time: 06:20
 * To change this template use File | Settings | File Templates.
 */
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {

    Optional<ParkingSlot> findByName(String name);

    Optional<ParkingSlot> findByUsername(String username);

    Optional<ParkingSlot> findById(Long id);

    List<ParkingSlot> findByFloor(String floor);

    @Query(value = "SELECT * FROM parking_slot WHERE username IS NULL",
            nativeQuery = true)
    List<ParkingSlot> findEmpyParkingSlot();
}
