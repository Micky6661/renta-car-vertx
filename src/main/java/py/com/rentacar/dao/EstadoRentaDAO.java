package py.com.rentacar.dao;

import py.com.rentacar.models.Operacion.EstadoRenta;

import java.util.List;

public class EstadoRentaDAO extends DbUtils<EstadoRenta> {

    public static final String TABLE = "EstadoRenta";

    public List<EstadoRenta> getEstados() {
        List<EstadoRenta> rentaList = null;
        try {
            rentaList = this.findAll(TABLE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rentaList;
    }

}
