package mx.uam.tsis.proyecto.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EmpleadoDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-04T20:52:40.169-05:00[America/Mexico_City]")
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EmpleadoDto   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("telefono")
  private String telefono = null;

  @JsonProperty("servicio")
  private String servicio = null;

  @JsonProperty("ubicacion")
  @Valid
  private List<Float> ubicacion = null;

  @JsonProperty("contrasena")
  private String contrasena = null;

  public EmpleadoDto id(Integer id) {
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

  public EmpleadoDto nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * nombre del usuario
   * @return nombre
   **/
  @Schema(example = "Juan", description = "nombre del usuario")
  
    public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public EmpleadoDto telefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * numero de telefono del usuario
   * @return telefono
   **/
  @Schema(example = "5512246687", description = "numero de telefono del usuario")
  
    public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public EmpleadoDto servicio(String servicio) {
    this.servicio = servicio;
    return this;
  }

  /**
   * area de trabajo
   * @return servicio
   **/
  @Schema(example = "Carpinteria", description = "area de trabajo")
  
    public String getServicio() {
    return servicio;
  }

  public void setServicio(String servicio) {
    this.servicio = servicio;
  }

  public EmpleadoDto ubicacion(List<Float> ubicacion) {
    this.ubicacion = ubicacion;
    return this;
  }

  public EmpleadoDto addUbicacionItem(Float ubicacionItem) {
    if (this.ubicacion == null) {
      this.ubicacion = new ArrayList<Float>();
    }
    this.ubicacion.add(ubicacionItem);
    return this;
  }

  /**
   * Ubicacion del empleado
   * @return ubicacion
   **/
  @Schema(description = "Ubicacion del empleado")
      @Valid
  @Size(min=1,max=2)   public List<Float> getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(List<Float> ubicacion) {
    this.ubicacion = ubicacion;
  }

  public EmpleadoDto contrasena(String contrasena) {
    this.contrasena = contrasena;
    return this;
  }

  /**
   * contraseña para acceder a la cuenta
   * @return contrasena
   **/
  @Schema(example = "4567", description = "contraseña para acceder a la cuenta")
  
    public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmpleadoDto empleadoDto = (EmpleadoDto) o;
    return Objects.equals(this.id, empleadoDto.id) &&
        Objects.equals(this.nombre, empleadoDto.nombre) &&
        Objects.equals(this.telefono, empleadoDto.telefono) &&
        Objects.equals(this.servicio, empleadoDto.servicio) &&
        Objects.equals(this.ubicacion, empleadoDto.ubicacion) &&
        Objects.equals(this.contrasena, empleadoDto.contrasena);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, telefono, servicio, ubicacion, contrasena);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmpleadoDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    servicio: ").append(toIndentedString(servicio)).append("\n");
    sb.append("    ubicacion: ").append(toIndentedString(ubicacion)).append("\n");
    sb.append("    contrasena: ").append(toIndentedString(contrasena)).append("\n");
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
