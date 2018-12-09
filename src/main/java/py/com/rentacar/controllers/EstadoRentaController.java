package py.com.rentacar.controllers;

import py.com.rentacar.dao.EstadoRentaDAO;
import py.com.rentacar.models.Operacion.EstadoRenta;

import javax.inject.Inject;
import java.util.List;

public class EstadoRentaController {

    @Inject
    EstadoRentaDAO estadoRentaDAO;

    public List<EstadoRenta> getEstadosRenta() {
        List<EstadoRenta> estadoRentas = null;
        try {
            estadoRentas = estadoRentaDAO.getEstados();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estadoRentas;
    }
}
