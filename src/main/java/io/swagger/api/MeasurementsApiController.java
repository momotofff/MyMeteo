package java.io.swagger.api;

import java.io.swagger.model.Measurement;
import java.io.swagger.model.MeasurementResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-14T09:57:24.496581260Z[GMT]")
@RestController
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

    public ResponseEntity<MeasurementResponse> measurementsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema())
                                                                @Valid @RequestBody Measurement body
) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json"))
        {
            try
            {
                return new ResponseEntity<MeasurementResponse>(objectMapper.readValue("{\n  \"raining\" : true,\n  \"sensor\" : {\n    \"name\" : \"name\"\n  },\n  \"id\" : 0,\n  \"value\" : 6.0274563\n}", MeasurementResponse.class), HttpStatus.NOT_IMPLEMENTED);
            }
            catch (IOException e)
            {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MeasurementResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MeasurementResponse>(HttpStatus.NOT_IMPLEMENTED);
    }
}
