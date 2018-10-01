package py.com.rentacar.service;

import com.google.gson.Gson;
import py.com.rentacar.controllers.VehiculoController;
import py.com.rentacar.models.Vehiculo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/api/vehiculos")
public class VehiculoService {

    VehiculoController controller = new VehiculoController();

    @GET
    public String findAll() {
        List<Vehiculo> vehiculoList;
        String json = null;
        try {
            vehiculoList = controller.getVehiculos();
            json = new Gson().toJson(vehiculoList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }
}
