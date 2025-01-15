package java.io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.SensorsApi;
import io.swagger.model.MeasurementResponse;
import io.swagger.model.Sensor;
import io.swagger.model.SensorRegistrationResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.swagger.services.SensorService;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-14T09:57:24.496581260Z[GMT]")
@RestController
public class SensorsApiController implements SensorsApi
{
    private static final Logger log = LoggerFactory.getLogger(SensorsApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final SensorService sensorService;

    @Autowired
    public SensorsApiController(ObjectMapper objectMapper, HttpServletRequest request, SensorService sensorService)
    {
        this.objectMapper = objectMapper;
        this.request = request;
        this.sensorService = sensorService;
    }

    @Override
    public ResponseEntity<List<MeasurementResponse>> sensorsGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                List<MeasurementResponse> measurements = sensorService.getAllMeasurements(); // получить данные сенсора
                return new ResponseEntity<>(measurements, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Ошибка при получении измерений", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<SensorRegistrationResponse> sensorsPost(
            @Parameter(name = "Sensor", description = "", required = true)
            @Valid @RequestBody Sensor sensor
    ) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {
            try {
                SensorRegistrationResponse response = sensorService.registerSensor(sensor); // Регистрация сенсора
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } catch (Exception e) {
                log.error("Ошибка при регистрации сенсора", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
