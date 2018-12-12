package py.com.rentacar.controllers;

import py.com.rentacar.dao.RentaDAO;
import py.com.rentacar.models.Operacion.Renta;
import py.com.rentacar.models.Operacion.RentaDTO;

import javax.inject.Inject;
import java.util.List;

public class RentaController {

    @Inject
    RentaDAO dao;

    @Inject
    DetalleRentaController detalleRentaController;

   /* @Inject
    Logger logger;*/

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

    public void createRenta(RentaDTO renta) {
        try {
            Integer id = dao.insert(renta.getRenta());
            detalleRentaController.createDetalleRentas(renta.getInserted(), id);
        } catch (Exception e) {
            /*logger.error("Error al insertar " + e.getMessage());*/
            e.printStackTrace();
        }
    }

    public void updateRenta(RentaDTO renta) {
        try {
            detalleRentaController.createDetalleRentas(renta.getInserted());
            detalleRentaController.destroyDetalleRentas(renta.getDeleted());
            dao.update(renta.getRenta(), renta.getRenta().getId());
        } catch (Exception e) {
            /*logger.error("Error al actualizar. " + e.getMessage());*/
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
