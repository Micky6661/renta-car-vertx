package py.com.rentacar.models.Operacion;

import py.com.rentacar.models.Cliente.Cliente;
import py.com.rentacar.models.Users;

import java.util.Date;
import java.util.List;

public class RentaDTO {

    private Integer id;
    private Cliente cliente;
    private Date fechaOperacion;
    private EstadoRenta estadoRenta;
    private Users users;
    private String observacion;
    private Long montoTotal;
    private List<DetalleRenta> detalleRentaList;
}
