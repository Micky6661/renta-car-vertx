package py.com.rentacar.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Miguel Martinez
 **/
@Entity
@Table(name = "Vehiculo")
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @Column(name = "marca_id")
//    private Integer marcaId;
//
//    @Column(name = "modelo_id")
//    private Integer modeloId;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "chasis")
    private String chasis;

    @Column(name = "motor")
    private String motor;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    public Vehiculo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Integer getMarcaId() {
//        return marcaId;
//    }
//
//    public void setMarcaId(Integer marcaId) {
//        this.marcaId = marcaId;
//    }
//
//    public Integer getModeloId() {
//        return modeloId;
//    }
//
//    public void setModeloId(Integer modeloId) {
//        this.modeloId = modeloId;
//    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
