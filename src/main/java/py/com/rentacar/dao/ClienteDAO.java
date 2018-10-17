package py.com.rentacar.dao;

import py.com.rentacar.models.Cliente.Cliente;

import java.util.List;


public class ClienteDAO extends DbUtils<Cliente> {

    public static final String TABLE_NAME = "Cliente";


    public List<Cliente> getClientes() {
        List<Cliente> clienteList = null;
        try {
            clienteList = this.findAll(TABLE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clienteList;
    }

    public Cliente getClienteById(Integer id) {
        Cliente cliente = null;
        try {
            cliente = this.findById(Cliente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cliente;
    }

    public void deleteCliente(Integer id) {
        try {
            this.delete(Cliente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}