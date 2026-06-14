package com.todocodearmy.pacientes.controller;

import com.todocodearmy.pacientes.model.Paciente;
import com.todocodearmy.pacientes.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pacientes")
@RestController
public class PacienteController {
    @Autowired
    private IPacienteService pacienteService;

    @PostMapping("/crear")
    public String crearPaciente(@RequestBody Paciente pac){
        pacienteService.savePaciente(pac);
        return "Paciente creado correctamente";
    }
    @GetMapping("/traer")
    public List<Paciente> traerPacientes(){
        return pacienteService.getPacientes();
    }
    @DeleteMapping("/borrar/{id}")
    public String deletePaciente(@PathVariable Long id){
        pacienteService.deletePaciente(id);
        return "Paciente borrado correctamente";
    }
    @PutMapping("/editar/{id}")
    public Paciente editPaciente(@PathVariable Long id_original, @RequestBody Paciente pacienteEditar){
        pacienteService.editPaciente(id_original, pacienteEditar);
        Paciente pacienteEditado = pacienteService.findPaciente(id_original);
        return pacienteEditado;
    }
    @GetMapping("/traer/{id}")
    public Paciente traerPaciente(@PathVariable Long id){
        return pacienteService.findPaciente(id);
    }

}
