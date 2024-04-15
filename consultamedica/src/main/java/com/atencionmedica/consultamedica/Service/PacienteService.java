package com.atencionmedica.consultamedica.Service;

import java.util.Optional;
import java.util.List;
import com.atencionmedica.consultamedica.Model.Paciente;

public interface PacienteService 
{
   //obtiene un listado de la clase usuario
   List<Paciente>getAllUsuarios();


   //obtiene el id de los datos que estan en la clase Usuario
   Optional<Paciente>getUsuarioById(int idPaciente);


   //crear
   Paciente createUsuario(Paciente paciente);


   //actualizar
   Paciente updateUsuario(int idPaciente,Paciente paciente);


   //eliminar
   void deleteUsuario(int idPaciente);
}
