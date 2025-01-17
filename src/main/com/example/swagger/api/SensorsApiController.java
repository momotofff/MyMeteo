package com.example.swagger.api;

import io.swagger.api.SensorsApi;
import io.swagger.model.Sensor;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-16T11:52:43.332412975Z[GMT]")
@RestController
public class SensorsApiController implements SensorsApi
{
    private static final Logger log = LoggerFactory.getLogger(SensorsApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @Autowired
    public SensorsApiController(ObjectMapper objectMapper, HttpServletRequest request)
    {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<List<Sensor>> sensorsGet()
    {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json"))
        {
            try
            {
                return new ResponseEntity<List<Sensor>>(objectMapper.readValue("[ {\n  \"name\" : \"name\",\n  \"id\" : 0\n}, {\n  \"name\" : \"name\",\n  \"id\" : 0\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e)
            {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Sensor>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Sensor>>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Sensor> sensorsPost(
            @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema())
            @Valid @RequestBody Sensor body
) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json"))
        {
            try
            {
                return new ResponseEntity<Sensor>(objectMapper.readValue("{\n  \"name\" : \"name\",\n  \"id\" : 0\n}", Sensor.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e)
            {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Sensor>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Sensor>(HttpStatus.NOT_IMPLEMENTED);
    }
}
