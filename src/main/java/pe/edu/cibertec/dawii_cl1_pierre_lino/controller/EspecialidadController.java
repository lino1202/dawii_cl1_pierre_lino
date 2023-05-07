package pe.edu.cibertec.dawii_cl1_pierre_lino.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.dawii_cl1_pierre_lino.model.bd.Especialidad;
import pe.edu.cibertec.dawii_cl1_pierre_lino.service.EspecialidadService;

import java.util.List;

@Controller
@RequestMapping("/Especialidad")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/frmMantEspecialidad")
    public String frmMantEspecialidad(Model model){
        model.addAttribute("listaEspecialidad", especialidadService.listarEspecialidad());
        return "Especialidad/frmMantEspecialidad";
    }

    @GetMapping("/listarEspecialidad")
    @ResponseBody
    public List<Especialidad> listarEspecialidad(){
        return especialidadService.listarEspecialidad();
    }
}
