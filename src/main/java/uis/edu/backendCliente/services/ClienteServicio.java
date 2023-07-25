package uis.edu.backendCliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uis.edu.backendCliente.models.Cliente;
import uis.edu.backendCliente.repositories.ClienteRepositorio;

@Service
@Transactional
public class ClienteServicio implements IClienteServicio{

    @Autowired
    private ClienteRepositorio clienteRepo;

    @Override
    public void delete(Integer id) {
        
        clienteRepo.deleteById(id);
        
    }

    @Override
    public Cliente getCliente(Integer id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente grabarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    

}
