package mx.uam.tsis.proyecto.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import mx.uam.tsis.proyecto.api.dto.ServicioDto;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ListaServiciosDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-04T20:52:40.169-05:00[America/Mexico_City]")


public class ListaServiciosDto   {
  @JsonProperty("listaServicios")
  @Valid
  private List<ServicioDto> listaServicios = null;

  public ListaServiciosDto listaServicios(List<ServicioDto> listaServicios) {
    this.listaServicios = listaServicios;
    return this;
  }

  public ListaServiciosDto addListaServiciosItem(ServicioDto listaServiciosItem) {
    if (this.listaServicios == null) {
      this.listaServicios = new ArrayList<ServicioDto>();
    }
    this.listaServicios.add(listaServiciosItem);
    return this;
  }

  /**
   * Get listaServicios
   * @return listaServicios
   **/
  @Schema(description = "")
      @Valid
    public List<ServicioDto> getListaServicios() {
    return listaServicios;
  }

  public void setListaServicios(List<ServicioDto> listaServicios) {
    this.listaServicios = listaServicios;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListaServiciosDto listaServiciosDto = (ListaServiciosDto) o;
    return Objects.equals(this.listaServicios, listaServiciosDto.listaServicios);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listaServicios);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListaServiciosDto {\n");
    
    sb.append("    listaServicios: ").append(toIndentedString(listaServicios)).append("\n");
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
