package com.atencionmedica.consultamedica.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.atencionmedica.consultamedica.Model.Paciente;
import com.atencionmedica.consultamedica.Repository.PacienteRepository;


@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest 
{
    @InjectMocks
    private PacienteServiceImpl pacienteServicio;



    @Mock
    private PacienteRepository pacienteRepositorioMock;


    @Test
    public void guardarPaciente()
    {
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setNombre("Jose Randon");


        when(pacienteRepositorioMock.save(any())).thenReturn(paciente);

        //Act
        Paciente resultado = pacienteServicio.createUsuario(paciente);



        //Assert
        assertEquals("Jose Randon",resultado.getNombre());
    }
}
