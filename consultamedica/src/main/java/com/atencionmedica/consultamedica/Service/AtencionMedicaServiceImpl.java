package com.atencionmedica.consultamedica.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atencionmedica.consultamedica.Model.AtencionMedica;
import com.atencionmedica.consultamedica.Repository.AtencionRepository;


import java.util.List;
import java.util.Optional;


@Service
public class AtencionMedicaServiceImpl implements AtencionMedicaService
{
    
        @Autowired
        private AtencionRepository atencionmedicarepository;
     
     
        @Override
        public List<AtencionMedica>getAllConsulta()
        {
          return atencionmedicarepository.findAll();
        } 
     
        @Override
        public Optional<AtencionMedica>getConsultaById(int idconsulta)
        {
          return atencionmedicarepository.findById(idconsulta);
        }
     
     
          //crear
          @Override
          public AtencionMedica createConsulta(AtencionMedica consulta)
          {
              return atencionmedicarepository.save(consulta);
          }
     
         //actualizar
         public AtencionMedica updateConsulta (int idconsulta,AtencionMedica consulta)
         {
             if(atencionmedicarepository.existsById(idconsulta))
             {
                 consulta.setIdConsulta(idconsulta);
                 return atencionmedicarepository.save(consulta);
             }
             else
             {
                 return null;
             }
         }
     
     
     
         //borrar usuario
         @Override
         public void deleteConsulta(int idconsulta)
         {
            atencionmedicarepository.deleteById(idconsulta);
         }
     
}
