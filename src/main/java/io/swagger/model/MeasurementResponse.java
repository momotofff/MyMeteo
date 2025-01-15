package java.io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.Sensor;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import java.io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
/**
 * MeasurementResponse
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-14T09:57:24.496581260Z[GMT]")


public class MeasurementResponse
{
  @JsonProperty("id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer id = null;

  @JsonProperty("value")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Float value = null;

  @JsonProperty("raining")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Boolean raining = null;

  @JsonProperty("sensor")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Sensor sensor = null;


  public MeasurementResponse id(Integer id)
  {
    this.id = id;
    return this;
  }

  /**
   * Идентификатор измерения
   * @return id
   **/
  
  @Schema(description = "Идентификатор измерения")
  
  public Integer getId() {  
    return id;
  }



  public void setId(Integer id) { this.id = id; }

  public MeasurementResponse value(Float value)
  {
    this.value = value;
    return this;
  }

  /**
   * Значение температуры
   * @return value
   **/
  
  @Schema(description = "Значение температуры")
  
  public Float getValue() { return value; }


  public void setValue(Float value) { this.value = value; }

  public MeasurementResponse raining(Boolean raining)
  {
    this.raining = raining;
    return this;
  }

  /**
   * Флаг, указывающий на наличие осадков
   * @return raining
   **/
  
  @Schema(description = "Флаг, указывающий на наличие осадков")
  
  public Boolean isRaining() { return raining; }

  public void setRaining(Boolean raining) { this.raining = raining; }

  public MeasurementResponse sensor(Sensor sensor)
  {
    this.sensor = sensor;
    return this;
  }

  /**
   * Get sensor
   * @return sensor
   **/
  
  @Schema(description = "")
  
@Valid
  public Sensor getSensor() { return sensor; }

  public void setSensor(Sensor sensor) { this.sensor = sensor; }

  @Override
  public boolean equals(java.lang.Object o)
  {
    if (this == o)
      return true;

    if (o == null || getClass() != o.getClass())
      return false;

    MeasurementResponse measurementResponse = (MeasurementResponse) o;

    return Objects.equals(this.id, measurementResponse.id) &&
        Objects.equals(this.value, measurementResponse.value) &&
        Objects.equals(this.raining, measurementResponse.raining) &&
        Objects.equals(this.sensor, measurementResponse.sensor);
  }

  @Override
  public int hashCode() { return Objects.hash(id, value, raining, sensor); }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeasurementResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
  private String toIndentedString(java.lang.Object o)
  {
    if (o == null)
      return "null";

    return o.toString().replace("\n", "\n    ");
  }
}
