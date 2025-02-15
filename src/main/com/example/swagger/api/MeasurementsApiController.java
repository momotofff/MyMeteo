package com.example.swagger.api;

import io.swagger.api.MeasurementsApi;
import io.swagger.model.Measurement;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@DependsOn("dbService")
public class MeasurementsApiController implements MeasurementsApi
{

    private static final Logger log = LoggerFactory.getLogger(MeasurementsApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MeasurementsApiController(ObjectMapper objectMapper, HttpServletRequest request)
    {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<Measurement> measurementsPost(
            @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema())
            @Valid @RequestBody Measurement body
) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json"))
        {
            try
            {
                return new ResponseEntity<Measurement>(objectMapper.readValue("{\n  \"raining\" : true,\n  \"sensor\" : {\n    \"name\" : \"name\",\n    \"id\" : 0\n  },\n  \"value\" : 0.8008282\n}", Measurement.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e)
            {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Measurement>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Measurement>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Integer> measurementsRainyDaysCountGet()
    {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json"))
        {
            try
            {
                return new ResponseEntity<Integer>(objectMapper.readValue("0", Integer.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e)
            {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Integer>(HttpStatus.NOT_IMPLEMENTED);
    }

}
