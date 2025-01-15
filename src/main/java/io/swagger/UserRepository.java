package java.io.swagger;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.swagger.model.User;


@Repository
public interface UserRepository extends JpaRepository<SecurityProperties.User, Long>
{
    User findByUsername(String username); // Метод для поиска пользователя по имени

    User save(User user);
}
