package id.my.hendisantika.springbootparkingsystem.repository;

import id.my.hendisantika.springbootparkingsystem.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

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
public interface HistoryRepository extends JpaRepository<History, Long> {
}
