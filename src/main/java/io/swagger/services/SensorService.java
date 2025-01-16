package java.io.swagger.services;

import io.swagger.model.Measurement;
import io.swagger.model.Sensor;
import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.swagger.repository.MeasurementRepository;
import java.io.swagger.repository.SensorRepository;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService
{
    private static final Logger logger = LoggerFactory.getLogger(SensorService.class);

    public static Sensor sensorsPost(Connection connection, String name)
    {
        return  new Sensor();
    }

    public static List<Sensor> sensorsGet(Connection connection)
    {
        return  new ArrayList<>();
    }
}
