package com.example.swagger.services;

import io.swagger.model.Sensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
