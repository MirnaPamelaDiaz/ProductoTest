package test.producto;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import test.producto.entity.Producto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductoApplicationTests {

    @Autowired
    private WebTestClient client;

    @Test
    @Order(4)
    void listarProductosTest() {
        client.get().uri("/api/producto")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON_VALUE)
                .expectBodyList(Producto.class);
    }

    @Test
    @Order(2)
    void verProductoTest() {
        client.get()
                .uri("/api/producto/2")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON_VALUE)
                .expectBody(Producto.class);
    }

    @Test
    @Order(1)
    void crearProductoTest() {
        Producto producto = new Producto(null, "vaso", 30, 2000d, "vaso azul");

        client.post()
                .uri("/api/producto/")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(producto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(String.class);

    }

    @Test
    @Order(3)
    void modificarProductoTest() {
        Producto producto = new Producto(2, "vaso", 3000, 1000d, "vaso verde");

        client.put()
                .uri("/api/producto/2")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(producto)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class);

    }

    @Test
    @Order(5)
    void deleteTest() {
        client.delete()
                .uri("/api/producto/8")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class);
    }


}
