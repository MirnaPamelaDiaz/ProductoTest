package test.producto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import test.producto.entity.Producto;
import test.producto.repository.ProductoRepository;

import java.util.List;
@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository repository;

    @Override
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @Override
    public ResponseEntity<Producto> productoPorId(Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).orElseThrow());
    }

    @Override
    public ResponseEntity<String> crearProducto(Producto producto) {
        repository.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto creado");
    }

    @Override
    public ResponseEntity<String> modificarProducto(Producto producto, Integer id) {

        Producto productoMod = repository.findById(id).get();
        productoMod.setNombre(producto.getNombre());
        productoMod.setPrecio(producto.getPrecio());
        productoMod.setCantidad(producto.getCantidad());
        productoMod.setDescripcion(producto.getDescripcion());
        repository.save(productoMod);
        return ResponseEntity.status(HttpStatus.OK).body("Producto Modificado");
    }

    @Override
    public ResponseEntity<String> eliminarProducto(Integer id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Producto Eliminado");
    }
}
