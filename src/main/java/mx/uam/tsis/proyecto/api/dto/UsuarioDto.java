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
 * UsuarioDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-04T20:52:40.169-05:00[America/Mexico_City]")
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioDto   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("telefono")
  private String telefono = null;

  @JsonProperty("correo")
  private String correo = null;

  @JsonProperty("ubicacion")
  @Valid
  private List<BigDecimal> ubicacion = null;

  @JsonProperty("contrasena")
  private String contrasena = null;

  public UsuarioDto id(Integer id) {
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

  public UsuarioDto nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * nombre del usuario
   * @return nombre
   **/
  @Schema(example = "Antonio", description = "nombre del usuario")
  
    public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public UsuarioDto telefono(String telefono) {
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

  public UsuarioDto correo(String correo) {
    this.correo = correo;
    return this;
  }

  /**
   * correo del usuario
   * @return correo
   **/
  @Schema(example = "antonio@mail.com", description = "correo del usuario")
  
    public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public UsuarioDto ubicacion(List<BigDecimal> ubicacion) {
    this.ubicacion = ubicacion;
    return this;
  }

  public UsuarioDto addUbicacionItem(BigDecimal ubicacionItem) {
    if (this.ubicacion == null) {
      this.ubicacion = new ArrayList<BigDecimal>();
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
  @Size(min=1,max=1)   public List<BigDecimal> getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(List<BigDecimal> ubicacion) {
    this.ubicacion = ubicacion;
  }

  public UsuarioDto contrasena(String contrasena) {
    this.contrasena = contrasena;
    return this;
  }

  /**
   * contraseña para acceder a la cuenta
   * @return contrasena
   **/
  @Schema(example = "1234", description = "contraseña para acceder a la cuenta")
  
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
    UsuarioDto usuarioDto = (UsuarioDto) o;
    return Objects.equals(this.id, usuarioDto.id) &&
        Objects.equals(this.nombre, usuarioDto.nombre) &&
        Objects.equals(this.telefono, usuarioDto.telefono) &&
        Objects.equals(this.correo, usuarioDto.correo) &&
        Objects.equals(this.ubicacion, usuarioDto.ubicacion) &&
        Objects.equals(this.contrasena, usuarioDto.contrasena);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, telefono, correo, ubicacion, contrasena);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsuarioDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    correo: ").append(toIndentedString(correo)).append("\n");
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
