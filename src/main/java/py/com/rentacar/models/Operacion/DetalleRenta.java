package py.com.rentacar.models.Operacion;

import py.com.rentacar.models.Vehiculo.Vehiculo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Detalle_Renta")
public class DetalleRenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "renta_id", nullable = false)
    private Renta renta;

    @ManyToOne()
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    @Column(name = "fecha_inicio")
    private Date fechaInicioRenta;

    @Column(name = "fecha_fin")
    private Date fechaFinRenta;

    @Column(name = "monto")
    private Long monto;

    public DetalleRenta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Renta getRenta() {
        return renta;
    }

    public void setRenta(Renta renta) {
        this.renta = renta;
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

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }
}
