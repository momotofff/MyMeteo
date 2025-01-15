package java.io.swagger.repository;

import io.swagger.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long>
{
    // добавьте дополнительные методы, если нужно
}
