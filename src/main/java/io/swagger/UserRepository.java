package java.io.swagger;

import io.swagger.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<SecurityProperties.User, Long>
{
    User findByUsername(String username); // Метод для поиска пользователя по имени
    User findByEmail(String email);
    User save(User user);
}
