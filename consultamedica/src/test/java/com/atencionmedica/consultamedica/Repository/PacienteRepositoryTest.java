package com.atencionmedica.consultamedica.Repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.atencionmedica.consultamedica.Model.Paciente;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PacienteRepositoryTest 
{

    @Autowired
    private PacienteRepository pacienteRepositorio;


    @Test
    public void guardarPaciente()
    {
        //Arrange
        //Se crea un objeto paciente con el nombre "John Doe".
        Paciente paciente = new Paciente();
        paciente.setNombre("John Doe");


        //Act
        // Se guarda el paciente en el repositorio utilizando el método save.
        Paciente resultado = pacienteRepositorio.save(paciente);


        //Assert
        // Se verifica que después de guardar, el paciente tenga un ID no nulo y que su nombre sea "John Doe". Esta prueba asegura que el repositorio funcione correctamente al guardar un estudiante.
        assertNotNull(resultado.getIdPaciente());
        assertEquals("John Doe",resultado.getNombre());

    }

}
