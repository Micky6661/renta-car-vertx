package py.com.rentacar.dao;

import py.com.rentacar.models.Operacion.EstadoRenta;
import py.com.rentacar.models.Operacion.Renta;

import java.util.List;

public class RentaDAO extends DbUtils<Renta> {

    public static final String TABLE = "Renta";

    public List<Renta> getRentas() {
        List<Renta> rentaList = null;
        try {
            rentaList = this.findAll(TABLE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rentaList;
    }

    public Renta getRentaById(int id) {
        Renta renta = null;
        try {
            renta = this.getByAtribute(Renta.class, "Renta", String.valueOf(id), "id").get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return renta;
    }

    public void delete(int id) {
        try {
            this.delete(Renta.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
