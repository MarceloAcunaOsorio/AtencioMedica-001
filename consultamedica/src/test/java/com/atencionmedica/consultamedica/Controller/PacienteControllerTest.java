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
        paciente1.setRut("14.256.300-k");
        paciente1.setNombre("John");
        paciente1.setDireccion("la florida 1223");
        paciente1.setEdad(35);
        paciente1.setPrevision("Isapre");
        paciente1.setMotivoConsulta("fractura expuesta");
        paciente1.setDiagnostico("rotura de hueso con exposicion externa");
        paciente1.setObservacion("se operara y debera mantener el brazo sin movimiento");
        paciente1.setIdPaciente(1);



        //creacion de paciente2
        Paciente paciente2 = new Paciente();
        paciente2.setRut("14.256.254-k");
        paciente2.setNombre("Doe");
        paciente2.setDireccion("san miguel 1223");
        paciente2.setEdad(50);
        paciente2.setPrevision("Fonasa");
        paciente2.setMotivoConsulta("dolor de estomago");
        paciente2.setDiagnostico("una gastritis aguda");
        paciente2.setObservacion("dieta liviana");
        paciente2.setIdPaciente(2);

        List<Paciente> pacientes = Arrays.asList(paciente1, paciente2);
        when(pacienteServicioMock.getAllUsuarios()).thenReturn(pacientes);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientes"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(2)))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[0].rut", Matchers.is("14.256.300-k")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[0].nombre", Matchers.is("John")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[0].direccion", Matchers.is("la florida 1223")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[0].edad", Matchers.is(35)))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[0].prevision", Matchers.is("Isapre")))
               //.andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[0].motivo_Consulta", Matchers.is("fractura expuesta")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[0].diagnostico", Matchers.is("rotura de hueso con exposicion externa")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[0].observacion", Matchers.is("se operara y debera mantener el brazo sin movimiento")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[1].rut", Matchers.is("14.256.254-k")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[1].nombre", Matchers.is("Doe")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[1].direccion", Matchers.is("san miguel 1223")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[1].edad", Matchers.is(50)))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[1].prevision", Matchers.is("Fonasa")))
               //.andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[1].motivo_Consulta", Matchers.is("dolor de estomago")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[1].diagnostico", Matchers.is("una gastritis aguda")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[1].observacion", Matchers.is("dieta liviana")));
    }

}
