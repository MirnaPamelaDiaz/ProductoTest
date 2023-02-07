package test.producto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
@SQLDelete(sql = "UPDATE producto SET alta=false WHERE id_producto = ?")
@Where(clause = "alta = true")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id;

    private  String nombre;

    private Integer cantidad;

    private Double precio;

    private String descripcion;

    private Boolean alta = true;

    public Producto(Integer id, String nombre, int cantidad, double precio, String descripcion) {
        this.id=id;
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.precio=precio;
        this.descripcion=descripcion;
    }
}
