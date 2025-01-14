package java.io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Sensor;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Measurement
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-14T09:57:24.496581260Z[GMT]")


public class Measurement   {
  @JsonProperty("value")

  private Float value = null;

  @JsonProperty("raining")

  private Boolean raining = null;

  @JsonProperty("sensor")

  private Sensor sensor = null;


  public Measurement value(Float value) { 

    this.value = value;
    return this;
  }

  /**
   * Значение температуры
   * @return value
   **/
  
  @Schema(required = true, description = "Значение температуры")
  
  @NotNull
  public Float getValue() {  
    return value;
  }



  public void setValue(Float value) { 

    this.value = value;
  }

  public Measurement raining(Boolean raining) { 

    this.raining = raining;
    return this;
  }

  /**
   * Флаг, указывающий на наличие осадков
   * @return raining
   **/
  
  @Schema(required = true, description = "Флаг, указывающий на наличие осадков")
  
  @NotNull
  public Boolean isRaining() {  
    return raining;
  }



  public void setRaining(Boolean raining) { 

    this.raining = raining;
  }

  public Measurement sensor(Sensor sensor) { 

    this.sensor = sensor;
    return this;
  }

  /**
   * Get sensor
   * @return sensor
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public Sensor getSensor() {  
    return sensor;
  }



  public void setSensor(Sensor sensor) { 

    this.sensor = sensor;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Measurement measurement = (Measurement) o;
    return Objects.equals(this.value, measurement.value) &&
        Objects.equals(this.raining, measurement.raining) &&
        Objects.equals(this.sensor, measurement.sensor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, raining, sensor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Measurement {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    raining: ").append(toIndentedString(raining)).append("\n");
    sb.append("    sensor: ").append(toIndentedString(sensor)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
