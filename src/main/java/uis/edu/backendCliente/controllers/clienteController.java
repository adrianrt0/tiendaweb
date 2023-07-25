package uis.edu.backendCliente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uis.edu.backendCliente.models.Cliente;
import uis.edu.backendCliente.services.ClienteServicio;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/clientes")
public class clienteController {

    @Autowired
    private ClienteServicio clienteService;
    
    @GetMapping("/list")
    public List<Cliente> consultarTodo(){
        return (clienteService.getClientes());
    }

    @GetMapping("/list/{id}")
    public Cliente buscarPorId(@PathVariable Integer id){
        return clienteService.getCliente(id);
    }

    @PostMapping("/")
    public ResponseEntity<Cliente> agregar(@RequestBody Cliente cliente){
        Cliente obj = clienteService.grabarCliente(cliente);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Cliente> editar(@RequestBody Cliente cliente){
        Cliente obj = clienteService.getCliente(cliente.getIdcliente());
        if(obj != null){
            obj.setDireccion(cliente.getDireccion());
            obj.setApellidos(cliente.getApellidos());
            obj.setDocumento(cliente.getDocumento());
            obj.setEmail(cliente.getEmail());
            obj.setNombres(cliente.getNombres());
            obj.setTipdoc(cliente.getTipdoc());
            clienteService.grabarCliente(obj);
        } else{
            return new ResponseEntity<Cliente>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
         return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    public ResponseEntity<Cliente> eliminar(@PathVariable Integer id){
        Cliente obj = clienteService.getCliente(id);
        if(obj != null){
            clienteService.delete(id);
        } else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Cliente>(obj, HttpStatus.OK);


    }


}