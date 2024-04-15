package com.atencionmedica.consultamedica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atencionmedica.consultamedica.Model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> 
{

}
