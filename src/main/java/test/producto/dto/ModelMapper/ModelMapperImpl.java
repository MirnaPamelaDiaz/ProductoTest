package test.producto.dto.ModelMapper;

import org.modelmapper.ModelMapper;
import test.producto.dto.ProductoRequestDto;
import test.producto.dto.ProductoResponseDto;
import test.producto.entity.Producto;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMapperImpl implements ModelMapperInterface{

private ModelMapper mm = new ModelMapper();

    @Override
    public List<ProductoResponseDto> listarProductosAProductosResDto(List<Producto> productos) {
        return productos.stream().map(this::productoResDtoAProducto).collect(Collectors.toList());
    }

    @Override
    public Producto productoReqDtoAProducto(ProductoRequestDto productoRequestDto) {
        return mm.map(productoRequestDto, Producto.class);
    }

    @Override
    public ProductoResponseDto productoResDtoAProducto(Producto producto) {
        return mm.map(producto,ProductoResponseDto.class);
    }
}
