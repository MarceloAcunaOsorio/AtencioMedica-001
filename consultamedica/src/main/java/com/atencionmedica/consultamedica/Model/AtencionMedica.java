package com.atencionmedica.consultamedica.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "AtencionMedica")
public class AtencionMedica 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idconsulta;
  
    @Column(name = "Motivo")
    private String motivo;

    @Column(name = "Diagnostico")
    private String diagnostico;

    @Column(name = "Observaciones")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;    


  //getter
  public int getIdConsulta()
  {
    return idconsulta;
  }

  public String getMotivo()
  {
    return motivo;
  }

  public String getDiagnostico()
  {
    return diagnostico;
  }

  public String getObservaciones()
  {
    return observaciones;
  }


  //setter
  public void setIdConsulta(int idConsulta)
  {
     this.idconsulta = idConsulta;
  }

  public void setMotivo(String motivo)
  {
    this.motivo = motivo;
  }

  public void setDiagnostico(String diagnostico)
  {
    this.diagnostico = diagnostico;
  }

  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }


}
