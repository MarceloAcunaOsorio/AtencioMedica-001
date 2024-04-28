package com.atencionmedica.consultamedica.Model;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

//import java.util.List;
//import java.util.ArrayList;

@Entity
@Table(name = "Pacientex")
public class Paciente 
{
    @Valid

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente")
    private int idPaciente;

    @Column(name = "Rut")
    private String rut;
    
    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Edad")
    private int edad;

    @Column(name = "Prevision")
    private String prevision;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AtencionMedica consulta;

    //@OneToMany(mappedBy = "paciente",cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    //private List<AtencionMedica> atencionMedica = new ArrayList<>();



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

    public String setPrevision()
    {
       return prevision;
    }

    public AtencionMedica getconsulta()
    {
        return consulta;
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

    public void setPrevision(String prevision)
    {
        this.prevision = prevision;
    }

    public void setConsulta(AtencionMedica consulta)
    {
        this.consulta = consulta;
    }



}
