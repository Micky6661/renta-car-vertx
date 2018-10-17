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
}
