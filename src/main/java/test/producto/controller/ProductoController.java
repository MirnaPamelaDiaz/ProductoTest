package test.producto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.producto.entity.Producto;
import test.producto.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoServicio;

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        return productoServicio.listarProductos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id) {
        return productoServicio.productoPorId(id);
    }

    @PostMapping("/")
    public ResponseEntity<String> guardarProductos(@RequestBody Producto producto) {
        return productoServicio.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id) {
        return productoServicio.modificarProducto(producto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Integer id) {
        return productoServicio.eliminarProducto(id);
    }

}
