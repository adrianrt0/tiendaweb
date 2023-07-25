package uis.edu.backendCliente.services;

import java.util.List;

import uis.edu.backendCliente.models.Cliente;

public interface IClienteServicio {
    
    public List<Cliente> getClientes();

    public Cliente getCliente(Integer id);

    public Cliente grabarCliente(Cliente cliente);

    public void delete(Integer id);
    
}
