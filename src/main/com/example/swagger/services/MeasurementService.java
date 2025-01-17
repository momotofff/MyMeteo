package com.example.swagger.services;

import io.swagger.model.Measurement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MeasurementService
{
    public static Measurement measurementsPost(Connection connection, String name, String email)
    {
        return  new Measurement();
    }

    public static List<Measurement> measurementsRainyDaysCountGet(Connection connection, String name, String email)
    {
        return new ArrayList<>();
    }
}
