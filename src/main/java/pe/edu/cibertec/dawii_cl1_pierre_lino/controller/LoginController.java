package pe.edu.cibertec.dawii_cl1_pierre_lino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.dawii_cl1_pierre_lino.model.bd.Usuario;
import pe.edu.cibertec.dawii_cl1_pierre_lino.service.UsuarioService;

@Controller
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private UsuarioService usuarioservice;
    @GetMapping("/login")
    public String login(){
        return "Auth/frmlogin";
    }
    @GetMapping("/registrar")
    public String registrar(){
        return "Auth/frmRegistroUsuario";
    }

    @GetMapping("/guardarAlumno")
    public String guardarUsuario (@ModelAttribute Usuario usuario){
        usuarioservice.guardarUsuario(usuario);
        return "Auth/login";
    }
}
