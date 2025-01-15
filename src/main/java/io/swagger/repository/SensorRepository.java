package java.io.swagger.repository;

import io.swagger.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long>
{
    // добавьте дополнительные методы, если нужно
}
