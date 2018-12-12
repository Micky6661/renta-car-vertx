package py.com.rentacar.controllers;

import py.com.rentacar.dao.DetalleRentaDAO;
import py.com.rentacar.models.Operacion.DetalleRenta;

import javax.inject.Inject;
import java.util.List;

public class DetalleRentaController {

    @Inject
    DetalleRentaDAO detalleRentaDAO;

  /*  @Inject
    Logger logger;*/

    public void createDetalleRentas(List<DetalleRenta> inserted, Integer id) {
        try {
            for (DetalleRenta detalle : inserted) {
                detalle.setRentaId(id);
                detalleRentaDAO.insert(detalle);
            }
        } catch (Exception e) {
/*
            logger.error("Error en DetalleRentaDAO method CREATE. " + e.getMessage());
*/
            e.printStackTrace();
        }
    }

    public void createDetalleRentas(List<DetalleRenta> inserted) {
        try {
            for (DetalleRenta detalle : inserted) {
                detalleRentaDAO.insert(detalle);
            }
        } catch (Exception e) {
/*
            logger.error("Error en DetalleRentaDAO method CREATE. " + e.getMessage());
*/
            e.printStackTrace();
        }
    }

    public void destroyDetalleRentas(List<DetalleRenta> deleted) {
        try {
            for (DetalleRenta detalle : deleted) {
                detalleRentaDAO.delete(DetalleRenta.class, detalle.getId());
            }
        } catch (Exception e) {
/*
            logger.error("Error en DetalleRentaDAO method DESTROY. " + e.getMessage());
*/
            e.printStackTrace();
        }
    }
}
