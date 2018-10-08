package py.com.rentacar.models.Operacion;

import py.com.rentacar.models.Cliente.Cliente;
import py.com.rentacar.models.Users;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Renta")
public class Renta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "fecha_operacion")
    private Date fechaOperacion;

    @ManyToOne()
    @JoinColumn(name = "estado_id", nullable = false)
    private EstadoRenta estadoRenta;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "monto_total")
    private Long montoTotal;

    public Renta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public EstadoRenta getEstadoRenta() {
        return estadoRenta;
    }

    public void setEstadoRenta(EstadoRenta estadoRenta) {
        this.estadoRenta = estadoRenta;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Long montoTotal) {
        this.montoTotal = montoTotal;
    }
}
