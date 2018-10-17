package py.com.rentacar.controllers;

import py.com.rentacar.dao.MarcaDAO;
import py.com.rentacar.models.Vehiculo.Marca;

import java.util.List;

public class MarcaController {

    MarcaDAO dao = new MarcaDAO();

    public List<Marca> findAll() {
        try {
            return dao.getMarcas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
