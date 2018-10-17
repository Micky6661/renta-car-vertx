package py.com.rentacar.controllers;

import py.com.rentacar.dao.ModeloDAO;
import py.com.rentacar.models.Vehiculo.Modelo;

import java.util.List;

public class ModeloController {

    ModeloDAO dao = new ModeloDAO();

    public List<Modelo> findAll() {
        try {
            return dao.getModelos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
