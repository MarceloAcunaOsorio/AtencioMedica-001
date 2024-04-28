package com.atencionmedica.consultamedica.Controller;

import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.atencionmedica.consultamedica.Model.Paciente;
import com.atencionmedica.consultamedica.Service.PacienteServiceImpl;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(PacienteController.class)
public class PacienteControllerTest 
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteServiceImpl pacienteServicioMock;

    @Test
    public void obtenerTodosTest() throws Exception
    {
         //Arrange
        //creacion de paciente1
        Paciente paciente1 = new Paciente();
        paciente1.setNombre("John");
        paciente1.setIdPaciente(1);



        //creacion de paciente2
        Paciente paciente2 = new Paciente();
        paciente2.setNombre("Doe");
        paciente2.setIdPaciente(2);

        List<Paciente> pacientes = Arrays.asList(paciente1, paciente2);
        when(pacienteServicioMock.getAllUsuarios()).thenReturn(pacientes);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.aMapWithSize(2)))
        .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[0].nombre", Matchers.is("John")))
        .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[1].nombre", Matchers.is("Doe")));
    }

}
