package com.atencionmedica.consultamedica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atencionmedica.consultamedica.Model.AtencionMedica;

@Repository
public interface AtencionRepository extends JpaRepository<AtencionMedica,Integer> 
{

}
