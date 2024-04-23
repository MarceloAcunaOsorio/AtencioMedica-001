package com.atencionmedica.consultamedica.Service;


import java.util.Optional;
import java.util.List;
import com.atencionmedica.consultamedica.Model.AtencionMedica;



public interface AtencionMedicaService
{
    //obtiene un listado de la clase AtencionMedica
   List<AtencionMedica>getAllConsulta();


   //obtiene el id de los datos que estan en la clase AtencionMedica
   Optional<AtencionMedica>getConsultaById(int idconsulta);


   //crear
   AtencionMedica createConsulta(AtencionMedica consulta);


   //actualizar
   AtencionMedica updateConsulta(int idconsulta,AtencionMedica consulta);


   //eliminar
   void deleteConsulta(int idconsulta);

}
