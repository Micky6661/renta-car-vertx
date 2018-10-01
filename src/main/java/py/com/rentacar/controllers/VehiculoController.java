package py.com.rentacar.controllers;

import py.com.rentacar.dao.VehiculoDAO;
import py.com.rentacar.models.Vehiculo;

import java.util.List;

public class VehiculoController {

    VehiculoDAO dao = new VehiculoDAO();

    public List<Vehiculo> getVehiculos() {
        try {
            return dao.getVehiculos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
