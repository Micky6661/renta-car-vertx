package py.com.rentacar.controllers;

import py.com.rentacar.dao.RentaDAO;
import py.com.rentacar.models.Operacion.Renta;

import javax.inject.Inject;
import java.util.List;

public class RentaController {

    @Inject
    RentaDAO dao;

    public List<Renta> getRentas() {
        try {
            return dao.getRentas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Renta getRentasById(String id) {
        Renta renta = null;
        try {
            renta = dao.getRentaById(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renta;
    }

    public void createRenta(Renta renta) {
        try {
            dao.insert(renta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRenta(Renta renta, String id) {
        try {
            dao.update(renta, Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRenta(String id) {
        try {
            dao.delete(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
