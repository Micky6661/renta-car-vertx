package py.com.rentacar.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Miguel Martinez
 **/
@Entity
@Table(name = "Marca")
public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

//    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY)
//    private List<Vehiculo> vehiculosList;

    public Marca(Integer id, String descripcion, List<Vehiculo> vehiculosList) {
        this.id = id;
        this.descripcion = descripcion;
//        this.vehiculosList = vehiculosList;
    }

    public Marca() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//    public List<Vehiculo> getVehiculosList() {
//        return vehiculosList;
//    }
//
//    public void setVehiculosList(List<Vehiculo> vehiculosList) {
//        this.vehiculosList = vehiculosList;
//    }
}
