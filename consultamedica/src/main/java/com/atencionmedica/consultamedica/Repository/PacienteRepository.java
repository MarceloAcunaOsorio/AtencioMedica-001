package com.atencionmedica.consultamedica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atencionmedica.consultamedica.Model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> 
{

}
