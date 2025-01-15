package java.io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import java.io.swagger.configuration.NotUndefined;
import javax.validation.constraints.*;

/**
 * Sensor
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-14T09:57:24.496581260Z[GMT]")


public class Sensor
{
  @JsonProperty("name")

  private String name = null;


  public Sensor name(String name)
  {
    this.name = name;
    return this;
  }

  /**
   * Имя сенсора
   * @return name
   **/
  
  @Schema(required = true, description = "Имя сенсора")
  
  @NotNull
  public String getName() { return name; }



  public void setName(String name) { this.name = name; }

  @Override
  public boolean equals(java.lang.Object o)
  {
    if (this == o)
      return true;

    if (o == null || getClass() != o.getClass())
      return false;

    Sensor sensor = (Sensor) o;
    return Objects.equals(this.name, sensor.name);
  }

  @Override
  public int hashCode() { return Objects.hash(name); }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sensor {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
