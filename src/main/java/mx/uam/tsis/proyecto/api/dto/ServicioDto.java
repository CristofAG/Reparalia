package mx.uam.tsis.proyecto.api.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ServicioDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-04T20:52:40.169-05:00[America/Mexico_City]")
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ServicioDto   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("Descripcion")
  private String descripcion = null;

  public ServicioDto id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * id del usuario
   * @return id
   **/
  @Schema(example = "1", description = "id del usuario")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ServicioDto nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * nombre del usuario
   * @return nombre
   **/
  @Schema(example = "Plomeria", description = "nombre del usuario")
  
    public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public ServicioDto descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Descripcion del servicio
   * @return descripcion
   **/
  @Schema(example = "Solución a problemas de tuberías", description = "Descripcion del servicio")
  
    public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServicioDto servicioDto = (ServicioDto) o;
    return Objects.equals(this.id, servicioDto.id) &&
        Objects.equals(this.nombre, servicioDto.nombre) &&
        Objects.equals(this.descripcion, servicioDto.descripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, descripcion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServicioDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
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
