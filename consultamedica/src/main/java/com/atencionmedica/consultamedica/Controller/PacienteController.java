package com.atencionmedica.consultamedica.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.slf4j.Logger;

import com.atencionmedica.consultamedica.Model.Paciente;
import com.atencionmedica.consultamedica.Service.PacienteService;


@RestController
@RequestMapping("/pacientes")
public class PacienteController 
{
    private static final Logger log = LoggerFactory.getLogger(PacienteController.class); 


    @Autowired
    public PacienteService pacienteservice;

     //mostrar listado de todos los pacientes
     @GetMapping
     public List<Paciente>getAllUsuarios()
     {   log.info("GET /pacientes");
         log.info("Retornando Todos los usuarios");  
         return pacienteservice.getAllUsuarios();
     }



    //buscar paciente
    @GetMapping("/{idPaciente}")
    public ResponseEntity<Object>getUsuarioById(@PathVariable int idPaciente)
    {
        Optional<Paciente> paciente = pacienteservice.getUsuarioById(idPaciente);
        if(paciente.isEmpty())
        {
           log.error("No se encuentro el Paciente con ID {}", idPaciente);
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No se encontro el Paciente con ID " + idPaciente));
        }
        return ResponseEntity.ok(paciente);
    }


     //crear
     @PostMapping
     public ResponseEntity<Object> createUsuario(@Validated @RequestBody Paciente paciente)
     {
       Paciente createdUsuario = pacienteservice.createUsuario(paciente);
       if(createdUsuario == null)
       {
         log.error("Error al crear el Paciente {idPaciente}", paciente);
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Error al crear el Paciente"));
       }
       return ResponseEntity.ok(createdUsuario);
     }




     //Actualizar
    @PutMapping("/{idPaciente}")
    public Paciente updUsuario(@PathVariable int idPaciente, @RequestBody Paciente paciente)
    {
        return pacienteservice.updateUsuario(idPaciente, paciente);
    }




    
    @DeleteMapping("/{idPaciente}")
    public void deleteUsuario(@PathVariable int idPaciente)
    {
        pacienteservice.deleteUsuario(idPaciente);
    }
    
    static class ErrorResponse
    {
        private final String message;

        public ErrorResponse(String message)
        {
            this.message = message;
        }

        public String getMessage()
        {
            return message;
        }
    }

 
}
