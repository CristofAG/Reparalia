package mx.uam.tsis.proyecto.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Respuesta en caso de error
 */
@Schema(description = "Respuesta en caso de error")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-21T15:29:56.516895-05:00[America/Mexico_City]")


public class ErrorDto   {
  @JsonProperty("timestamp")
  private String timestamp = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("error")
  private String error = null;

  @JsonProperty("mensaje")
  private String mensaje = null;

  public ErrorDto timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Estampa de tiempo del error (UTC)
   * @return timestamp
   **/
  @Schema(example = "2017-01-13T17:09:42.411", description = "Estampa de tiempo del error (UTC)")
  
    public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public ErrorDto status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Código HTTP del error
   * minimum: 100
   * maximum: 599
   * @return status
   **/
  @Schema(example = "500", required = true, description = "Código HTTP del error")
      @NotNull

  @Min(100) @Max(599)   public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public ErrorDto error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Mensaje enviado por el backend
   * @return error
   **/
  @Schema(example = "RuntimeException", description = "Mensaje enviado por el backend")
  
    public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public ErrorDto mensaje(String mensaje) {
    this.mensaje = mensaje;
    return this;
  }

  /**
   * Mensaje del error
   * @return mensaje
   **/
  @Schema(example = "Se produjo un error al acceder a la BD", required = true, description = "Mensaje del error")
      @NotNull

    public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDto errorDto = (ErrorDto) o;
    return Objects.equals(this.timestamp, errorDto.timestamp) &&
        Objects.equals(this.status, errorDto.status) &&
        Objects.equals(this.error, errorDto.error) &&
        Objects.equals(this.mensaje, errorDto.mensaje);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, status, error, mensaje);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDto {\n");
    
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    mensaje: ").append(toIndentedString(mensaje)).append("\n");
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
