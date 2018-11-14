package py.com.rentacar.models.Operacion;

import py.com.rentacar.models.Vehiculo.Vehiculo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Detalle_Renta")
public class DetalleRenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "renta_id", nullable = false)
    @Column(name = "renta_id")
    private Integer rentaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    @Column(name = "fecha_inicio")
    private Date fechaInicioRenta;

    @Column(name = "fecha_fin")
    private Date fechaFinRenta;

    public DetalleRenta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRentaId() {
        return rentaId;
    }

    public void setRentaId(Integer rentaId) {
        this.rentaId = rentaId;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getFechaInicioRenta() {
        return fechaInicioRenta;
    }

    public void setFechaInicioRenta(Date fechaInicioRenta) {
        this.fechaInicioRenta = fechaInicioRenta;
    }

    public Date getFechaFinRenta() {
        return fechaFinRenta;
    }

    public void setFechaFinRenta(Date fechaFinRenta) {
        this.fechaFinRenta = fechaFinRenta;
    }
}
