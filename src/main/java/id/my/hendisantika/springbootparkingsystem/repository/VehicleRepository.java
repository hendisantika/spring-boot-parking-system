package id.my.hendisantika.springbootparkingsystem.repository;

import id.my.hendisantika.springbootparkingsystem.entity.Vehicle;
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
 * Time: 06:21
 * To change this template use File | Settings | File Templates.
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query(value = "SELECT * FROM vehicle WHERE registeration_number = ?1",
            nativeQuery = true)
    Optional<Vehicle> findByRegisterationNumber(String registerationNumber);

    List<Vehicle> findByUsername(String username);
}
