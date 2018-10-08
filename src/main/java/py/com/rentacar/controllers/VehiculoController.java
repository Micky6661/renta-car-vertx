package py.com.rentacar.controllers;

import py.com.rentacar.dao.VehiculoDAO;
import py.com.rentacar.models.Vehiculo.Vehiculo;

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

    public void createVehiculo(Vehiculo vehiculo) {
        try {
            dao.insert(vehiculo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateVehiculo(Vehiculo vehiculo, String id) {
        try {
            dao.update(vehiculo, Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteVehiculo(String id) {
        try {
            dao.deleteVehiculo(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vehiculo getVehiculoById(String id) {
        Vehiculo vehiculo = null;
        try {
            vehiculo = dao.getVehiculoById(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehiculo;
    }
}
