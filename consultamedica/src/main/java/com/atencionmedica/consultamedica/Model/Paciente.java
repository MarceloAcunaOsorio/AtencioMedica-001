package com.atencionmedica.consultamedica.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Paciente")
public class Paciente 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaciente;

    @Column(name = "Rut")
    private String rut;
    
    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Edad")
    private int edad;

    @Column(name = "idConsulta")
    private AtencionMedica idconsulta;



    //getter
    public int getIdPaciente()
    {
        return idPaciente; 
    }

    public String getRut()
    {
        return rut;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public int getEdad()
    {
        return edad;
    }

    public AtencionMedica getIdConsulta()
    {
        return idconsulta;
    }



    //setter
    public void setIdPaciente(int idPaciente)
    {
        this.idPaciente = idPaciente;
    }

    public void setRut(String rut)
    {
       this.rut = rut;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    public void setIdConsulta(AtencionMedica idconsulta)
    {
        this.idconsulta = idconsulta;
    }

}
