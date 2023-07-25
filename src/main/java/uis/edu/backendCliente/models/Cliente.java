package uis.edu.backendCliente.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = Cliente.TABLE_NAME)
@Setter
@Getter
public class Cliente {

    public static final String TABLE_NAME = "cliente";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcliente;
    private String documento;
    private String tipdoc;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String email;

    public Cliente(int idcliente, String documento, String tipdoc, String nombres, String apellidos
    , String direccion, String email){
        this.idcliente = idcliente;
        this.documento = documento;
        this.tipdoc = tipdoc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente [idcliente=" + idcliente + ", documento=" + documento + ", tipdoc=" + tipdoc + ", nombres="
                + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", email=" + email + "]";
    }

    
}
