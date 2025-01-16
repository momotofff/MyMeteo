package java.io.swagger.services;

import io.swagger.model.Measurement;
import io.swagger.model.User;
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
