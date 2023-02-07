package test.producto.dto;

import lombok.Data;

@Data
public class ProductoRequestDto {

    private Integer id;

    private  String nombre;

    private Integer cantidad;

    private Double precio;

    private String descripcion;
}
