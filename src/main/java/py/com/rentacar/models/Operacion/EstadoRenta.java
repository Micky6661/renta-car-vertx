package py.com.rentacar.models.Operacion;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Miguel Martinez
 **/
@Entity
@Table(name = "Estado_Renta")
public class EstadoRenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    public EstadoRenta() {
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
}
