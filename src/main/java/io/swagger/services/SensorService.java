package java.io.swagger.services;

import io.swagger.model.Measurement;
import io.swagger.model.MeasurementResponse;
import io.swagger.model.Sensor;
import io.swagger.model.SensorRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.swagger.repository.MeasurementRepository;
import java.io.swagger.repository.SensorRepository;
import java.util.List;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;
    private final MeasurementRepository measurementRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository, MeasurementRepository measurementRepository) {
        this.sensorRepository = sensorRepository;
        this.measurementRepository = measurementRepository;
    }

    public List<MeasurementResponse> getAllMeasurements() {
        List<Measurement> measurements = measurementRepository.findAll();
        return measurements.stream().map(measurement -> {
            MeasurementResponse response = new MeasurementResponse();
            response.setId(measurement.getSensor() != null ? measurement.getSensor().getId() : null); // Получение ID от Sensor
            response.setValue(measurement.getValue());
            response.setRaining(measurement.getRaining()); // Используем метод getRaining() вместо isRaining()
            return response;
        }).toList();
    }

    public SensorRegistrationResponse registerSensor(Sensor sensor) {
        Sensor savedSensor = sensorRepository.save(sensor); // Сохраняем сенсор в БД
        SensorRegistrationResponse response = new SensorRegistrationResponse();
        response.setId(savedSensor.getId());
        response.setName(savedSensor.getName());
        return response;
    }

    public List<Sensor> getAllSensors()
    {
        return sensorRepository.findAll(); // Получаем список всех сенсоров из БД
    }
}
