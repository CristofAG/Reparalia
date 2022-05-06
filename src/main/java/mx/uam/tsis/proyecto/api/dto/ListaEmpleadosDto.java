package mx.uam.tsis.proyecto.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import mx.uam.tsis.proyecto.api.dto.EmpleadoDto;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ListaEmpleadosDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-04T20:52:40.169-05:00[America/Mexico_City]")


public class ListaEmpleadosDto   {
  @JsonProperty("listaEmpleados")
  @Valid
  private List<EmpleadoDto> listaEmpleados = null;

  public ListaEmpleadosDto listaEmpleados(List<EmpleadoDto> listaEmpleados) {
    this.listaEmpleados = listaEmpleados;
    return this;
  }

  public ListaEmpleadosDto addListaEmpleadosItem(EmpleadoDto listaEmpleadosItem) {
    if (this.listaEmpleados == null) {
      this.listaEmpleados = new ArrayList<EmpleadoDto>();
    }
    this.listaEmpleados.add(listaEmpleadosItem);
    return this;
  }

  /**
   * Get listaEmpleados
   * @return listaEmpleados
   **/
  @Schema(description = "")
      @Valid
    public List<EmpleadoDto> getListaEmpleados() {
    return listaEmpleados;
  }

  public void setListaEmpleados(List<EmpleadoDto> listaEmpleados) {
    this.listaEmpleados = listaEmpleados;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListaEmpleadosDto listaEmpleadosDto = (ListaEmpleadosDto) o;
    return Objects.equals(this.listaEmpleados, listaEmpleadosDto.listaEmpleados);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listaEmpleados);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListaEmpleadosDto {\n");
    
    sb.append("    listaEmpleados: ").append(toIndentedString(listaEmpleados)).append("\n");
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
