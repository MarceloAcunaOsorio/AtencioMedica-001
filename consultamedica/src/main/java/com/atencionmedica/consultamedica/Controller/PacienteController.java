package com.atencionmedica.consultamedica.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atencionmedica.consultamedica.Model.Paciente;
import com.atencionmedica.consultamedica.Service.PacienteService;


@RestController
@RequestMapping("/pacientes")
public class PacienteController 
{
    private static final Logger log = LoggerFactory.getLogger(PacienteController.class); 


    @Autowired
    public PacienteService pacienteservice;

    /*
     //mostrar listado de todos los pacientes
     @GetMapping
     public List<Paciente>getAllUsuarios()
     {   log.info("GET /pacientes");
         log.info("Retornando Todos los usuarios");  
         return pacienteservice.getAllUsuarios();
     }
     */


     //mostrar listado
     @GetMapping
     public CollectionModel<EntityModel<Paciente>> getAllUsuarios()
     {
        log.info("GET /pacientes");
        log.info("Retornando todas los pacientes");
        List<Paciente> pacientes = pacienteservice.getAllUsuarios();

        List<EntityModel<Paciente>> pacienteResources = pacientes.stream()
        .map(paciente -> EntityModel.of(paciente,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPacienteById(paciente.getIdPaciente())).withSelfRel()
                ))
        .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsuarios());
        CollectionModel<EntityModel<Paciente>> resources = CollectionModel.of(pacienteResources, linkTo.withRel("pacientes")); 

        return resources;
     }




    /* 
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
    */


    //mostrar un paciente en escpecifico segun el ID
    @GetMapping("/{idPaciente}")
    public EntityModel<Paciente> getPacienteById(@PathVariable int idPaciente)
    {
       Optional<Paciente> paciente = pacienteservice.getUsuarioById(idPaciente);

       //verifica si la pelicula existe
       if(paciente.isPresent())
       {
         return EntityModel.of(paciente.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPacienteById(idPaciente)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsuarios()).withRel("All-pacientes"));
       }
       else
       {
         throw new PacienteNotFoundException("Paciente no encontrado con el  id: " + idPaciente);
       }
    }




    /* 
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
     */




     /*CREAR*/
     public EntityModel<Paciente> crearPaciente(@RequestBody Paciente paciente)
     {
         Paciente createdPaciente = pacienteservice.createUsuario(paciente);
         return EntityModel.of(createdPaciente,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPacienteById(createdPaciente.getIdPaciente())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsuarios()).withRel("all-pacientes"));
     }





     /*
     //Actualizar
    @PutMapping("/{idPaciente}")
    public Paciente updUsuario(@PathVariable int idPaciente, @RequestBody Paciente paciente)
    {
        return pacienteservice.updateUsuario(idPaciente, paciente);
    }
    */

      //Actualizar
      @PutMapping("/{idPaciente}")
      public EntityModel<Paciente> updatePaciente(@PathVariable int idPaciente, @RequestBody Paciente paciente)
      {
          Paciente updatePaciente = pacienteservice.updateUsuario(idPaciente, paciente);
          return EntityModel.of(updatePaciente,
                 WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPacienteById(idPaciente)).withSelfRel(),
                 WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsuarios()).withRel("all - pacientes"));
      }






    
    @DeleteMapping("/{idPaciente}")
    public void deleteUsuario(@PathVariable int idPaciente)
    {
        pacienteservice.deleteUsuario(idPaciente);
    }
    




     //controlar error
    static class ErrorResponse
    {
         //se declara una variable estatica de tipo string
        private final String message;


        //setter
        public ErrorResponse(String message)
        {
            this.message = message;
        }


        //getter
        public String getMessage()
        {
            return message;
        }
    }

 
}
