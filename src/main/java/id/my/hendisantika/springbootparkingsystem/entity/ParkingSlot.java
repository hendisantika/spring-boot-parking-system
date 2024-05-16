package id.my.hendisantika.springbootparkingsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-parking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/17/24
 * Time: 06:16
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 10)
    private String name;

    @NotBlank
    @Size(max = 4)
    private String floor;

    @Size(max = 20)
    private String username = null;

    @Size(max = 20)
    private String vehicleRegisterationNumber = null;

    private LocalDateTime entryTime = null;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ESize size;

    public ParkingSlot(ESize size) {
        this.size = size;
    }
}
