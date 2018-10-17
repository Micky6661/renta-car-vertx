package py.com.rentacar.dao;

import py.com.rentacar.models.Vehiculo.Vehiculo;

import java.util.List;

/**
 * @author Miguel Martinez
 **/
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

    public Vehiculo getVehiculoById(Integer id) {
        Vehiculo vehiculo = null;
        try {
            vehiculo = this.findById(Vehiculo.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vehiculo;
    }

    public void deleteVehiculo(Integer id) {
        try {
            this.delete(Vehiculo.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vehiculo getVehiculoByMatricula(String matricula) {
        List<Vehiculo> vehiculo = null;
        try {
            vehiculo = this.getByAtribute(Vehiculo.class, TABLE_NAME, matricula, "matricula");
            if (vehiculo != null && vehiculo.size() > 0) {
                return vehiculo.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Vehiculo getVehiculoByChasis(String chasis) {
        List<Vehiculo> vehiculo = null;
        try {
            vehiculo = this.getByAtribute(Vehiculo.class, TABLE_NAME, chasis, "chasis");
            if (vehiculo != null && vehiculo.size() > 0) {
                return vehiculo.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
