package py.com.rentacar.controllers;

import py.com.rentacar.dao.ClienteDAO;
import py.com.rentacar.models.Cliente.Cliente;

import java.util.List;

public class ClienteController {
    ClienteDAO dao = new ClienteDAO();

    public List<Cliente> getClientes() {
        try {
            return dao.getClientes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createCliente(Cliente cliente) {
        try {
            dao.insert(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCliente(Cliente cliente, String id) {
        try {
            dao.update(cliente, Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCliente(String id) {
        try {
            dao.deleteCliente(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cliente getClienteById(String id) {
        Cliente cliente = null;
        try {
            cliente = dao.getClienteById(Integer.parseInt(id));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
