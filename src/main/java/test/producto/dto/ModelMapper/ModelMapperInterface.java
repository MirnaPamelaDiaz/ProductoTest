package test.producto.dto.ModelMapper;

import test.producto.dto.ProductoRequestDto;
import test.producto.dto.ProductoResponseDto;
import test.producto.entity.Producto;

import java.util.List;

public interface ModelMapperInterface {
   List<ProductoResponseDto> listarProductosAProductosResDto(List<Producto> productos);

   Producto productoReqDtoAProducto(ProductoRequestDto productoRequestDto);

   ProductoResponseDto productoResDtoAProducto(Producto producto);
}
