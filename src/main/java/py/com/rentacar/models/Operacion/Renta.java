package py.com.rentacar.models.Operacion;

import py.com.rentacar.models.Cliente.Cliente;
import py.com.rentacar.models.Users;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Renta")
public class Renta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "fecha_operacion")
    private Date fechaOperacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id", nullable = false)
    private EstadoRenta estadoRenta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "monto_total")
    private Long montoTotal;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "renta_id", referencedColumnName = "id")
    private List<DetalleRenta> detalleRentaList;

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

    public List<DetalleRenta> getDetalleRentaList() {
        return detalleRentaList;
    }

    public void setDetalleRentaList(List<DetalleRenta> detalleRentaList) {
        this.detalleRentaList = detalleRentaList;
    }

}
