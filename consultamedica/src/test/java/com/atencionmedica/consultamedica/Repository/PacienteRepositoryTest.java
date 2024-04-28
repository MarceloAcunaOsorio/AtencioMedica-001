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
        Paciente paciente = new Paciente();
        paciente.setNombre("John Doe");


        //Act
        Paciente resultado = pacienteRepositorio.save(paciente);


        //Assert
        assertNotNull(resultado.getIdPaciente());
        assertEquals("John Doe",resultado.getNombre());

    }

}
