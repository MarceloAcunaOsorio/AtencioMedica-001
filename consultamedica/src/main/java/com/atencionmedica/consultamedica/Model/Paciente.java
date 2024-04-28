package com.atencionmedica.consultamedica.Model;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;


@Entity
@Table(name = "Pacientex")
public class Paciente extends RepresentationModel<Paciente>
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

    @Column(name = "MotivoConsulta")
    private String motivo_Consulta;


    @Column(name = "Diagnostico")
    private String diagnostico;


    @Column(name = "Observacion")
    private String observacion;

    //@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private AtencionMedica consulta;

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

    public String getPrevision()
    {
       return prevision;
    }

    public String getDiagnostico()
    {
        return diagnostico;
    }

    public String getMotivoConsulta()
    {
        return motivo_Consulta;
    }

    public String getObservacion()
    {
        return observacion;
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

    public void setMotivoConsulta(String Motivo_Consulta)
    {
        this.motivo_Consulta = Motivo_Consulta;
    }

    public void setObservacion(String observacion)
    {
       this.observacion = observacion;
    }

    public void setDiagnostico(String diagnostico)
    {
        this.diagnostico = diagnostico;
    }

}
