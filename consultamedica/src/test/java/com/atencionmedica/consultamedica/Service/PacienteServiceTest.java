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
    //Anotación que inyecta automáticamente dependencias mock en el objeto de prueba.
    @InjectMocks
    private PacienteServiceImpl pacienteServicio;



    //Anotación que crea un objeto mock para la dependencia.
    @Mock
    private PacienteRepository pacienteRepositorioMock;


    @Test
    public void guardarPacienteTest()
    {
        //Arrange
        //Se crea un objeto paciente con el nombre "José Rondon". Se configura el comportamiento del mock del repositorio para devolver este paciente cuando se llame al método save.
        Paciente paciente = new Paciente();
        paciente.setNombre("Jose Randon");


        when(pacienteRepositorioMock.save(any())).thenReturn(paciente);

        //Act
        //Se llama al método guardarPaciente del servicio.
        Paciente resultado = pacienteServicio.createUsuario(paciente);



        //Assert
        //Se verifica que el resultado del servicio sea el paciente creado. Esta prueba asegura que el servicio interactúe correctamente con el repositorio al guardar un paciente.
        assertEquals("Jose Randon",resultado.getNombre());
    }
}
