package mx.uam.tsis.proyecto.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import mx.uam.tsis.proyecto.api.dto.UsuarioDto;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ListaUsuariosDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-04T20:52:40.169-05:00[America/Mexico_City]")


public class ListaUsuariosDto   {
  @JsonProperty("listaUsuarios")
  @Valid
  private List<UsuarioDto> listaUsuarios = null;

  public ListaUsuariosDto listaUsuarios(List<UsuarioDto> listaUsuarios) {
    this.listaUsuarios = listaUsuarios;
    return this;
  }

  public ListaUsuariosDto addListaUsuariosItem(UsuarioDto listaUsuariosItem) {
    if (this.listaUsuarios == null) {
      this.listaUsuarios = new ArrayList<UsuarioDto>();
    }
    this.listaUsuarios.add(listaUsuariosItem);
    return this;
  }

  /**
   * Get listaUsuarios
   * @return listaUsuarios
   **/
  @Schema(description = "")
      @Valid
    public List<UsuarioDto> getListaUsuarios() {
    return listaUsuarios;
  }

  public void setListaUsuarios(List<UsuarioDto> listaUsuarios) {
    this.listaUsuarios = listaUsuarios;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListaUsuariosDto listaUsuariosDto = (ListaUsuariosDto) o;
    return Objects.equals(this.listaUsuarios, listaUsuariosDto.listaUsuarios);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listaUsuarios);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListaUsuariosDto {\n");
    
    sb.append("    listaUsuarios: ").append(toIndentedString(listaUsuarios)).append("\n");
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
