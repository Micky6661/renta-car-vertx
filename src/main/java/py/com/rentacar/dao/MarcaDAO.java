package py.com.rentacar.dao;


import py.com.rentacar.models.Vehiculo.Marca;

import java.util.List;

public class MarcaDAO extends DbUtils<Marca> {

    public static final String TABLE_NAME = "Marca";

    public List<Marca> getMarcas() {
        List<Marca> marcasList = null;
        try {
            marcasList = this.findAll(TABLE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return marcasList;
    }
    
    public Marca getMarcaById(Integer id) {
        Marca marca = null;
        try {
            marca = this.findById(Marca.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return marca;
    }
    
    public void deleteMarca(Integer id) {
        try {
            this.delete(Marca.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
