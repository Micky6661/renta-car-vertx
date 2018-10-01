package py.com.rentacar.dao;

import py.com.rentacar.models.Vehiculo;

import java.util.List;

public class VehiculoDAO extends DbUtils<Vehiculo> {

    public static final String TABLE_NAME = "Vehiculo";

    public List<Vehiculo> getVehiculos() {
        List<Vehiculo> vehiculoList = null;
        try {
            vehiculoList = this.findAll(TABLE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vehiculoList;
    }
}
