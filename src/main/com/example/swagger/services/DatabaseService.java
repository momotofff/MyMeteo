package com.example.swagger.services;

import io.swagger.model.Measurement;
import io.swagger.model.Sensor;
import io.swagger.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DatabaseService
{
    private final String url;
    private final String user;
    private final String password;

    Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, user, password);
    }

    public DatabaseService(String url, String user, String password)
    {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public User usersRegisterPost(String name, String email) throws SQLException
    {
        Connection connection = getConnection();
        return UserService.usersRegisterPost(connection, name, email);
    }

    public List<Sensor> sensorsGet() throws SQLException
    {
        Connection connection = getConnection();
        return SensorService.sensorsGet(connection);
    }

    public Sensor sensorsPost(Sensor sensor) throws SQLException
    {
        Connection connection = getConnection();
        return SensorService.sensorsPost(connection, sensor.getName());
    }

    public Measurement measurementsPost(String name, String email) throws SQLException
    {
        Connection connection = getConnection();
        return MeasurementService.measurementsPost(connection, name, email);
    }

    public List<Measurement> measurementsRainyDaysCountGet(String name, String email) throws SQLException
    {
        Connection connection = getConnection();
        return MeasurementService.measurementsRainyDaysCountGet(connection, name, email);
    }
}
