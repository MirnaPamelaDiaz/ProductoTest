package test.producto.service;

import org.springframework.http.ResponseEntity;
import test.producto.dto.ProductoResponseDto;
import test.producto.entity.Producto;

import java.util.List;

public interface ProductoService {

    ResponseEntity<List<Producto>> listarProductos();

    ResponseEntity<Producto> productoPorId(Integer id);

    ResponseEntity<String> crearProducto(Producto producto);

    ResponseEntity<String> modificarProducto(Producto producto, Integer id);

    ResponseEntity<String> eliminarProducto(Integer id);
}
