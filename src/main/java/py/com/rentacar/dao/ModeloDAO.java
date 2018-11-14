package py.com.rentacar.dao;


import py.com.rentacar.models.Vehiculo.Modelo;

import java.util.List;

public class ModeloDAO extends DbUtils<Modelo> {

    public static final String TABLE_NAME = "Modelo";

    public List<Modelo> getModelos() {
        List<Modelo> modelosList = null;
        try {
            modelosList = this.findAll(TABLE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return modelosList;
    }
    
    public Modelo getModeloById(Integer id) {
        Modelo modelo = null;
        try {
            modelo = this.findById(Modelo.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return modelo;
    }
    
    public void deleteModelo(Integer id) {
        try {
            this.delete(Modelo.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}
