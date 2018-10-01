package py.com.rentacar.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Miguel Martinez
 **/
@Entity
@Table(name = "Modelo")
public class Modelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

//    @OneToMany(mappedBy = "modelo", fetch = FetchType.LAZY)
//    private List<Vehiculo> vehiculosList;

    public Modelo() {
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

    @Override
    public String toString() {
        return "Modelo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
