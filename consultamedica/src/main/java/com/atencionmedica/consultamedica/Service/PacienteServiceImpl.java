package com.atencionmedica.consultamedica.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atencionmedica.consultamedica.Model.Paciente;
import com.atencionmedica.consultamedica.Repository.PacienteRepository;


import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService
{
   @Autowired
   private PacienteRepository pacienterepository;


   @Override
   public List<Paciente>getAllUsuarios()
   {
     return pacienterepository.findAll();
   } 

   @Override
   public Optional<Paciente>getUsuarioById(int idPaciente)
   {
     return pacienterepository.findById(idPaciente);
   }


     //crear
     @Override
     public Paciente createUsuario(Paciente paciente)
     {
         return pacienterepository.save(paciente);
     }

    //actualizar
    public Paciente updateUsuario (int idPaciente,Paciente paciente)
    {
        if(pacienterepository.existsById(idPaciente))
        {
            paciente.setIdPaciente(idPaciente);
            return pacienterepository.save(paciente);
        }
        else
        {
            return null;
        }
    }



    //borrar usuario
    @Override
    public void deleteUsuario(int idPaciente)
    {
        pacienterepository.deleteById(idPaciente);
    }


}
