package pe.edu.cibertec.dawii_cl1_pierre_lino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dawii_cl1_pierre_lino.model.bd.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Component
public class UsuarioDetalleService {

    @Autowired
    private UsuarioService usuarioService;


    public UserDetails cargarUsuariosXnombre(String nomusuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarUsuarioPorNomusuario(nomusuario);
        return usuarioPorAutenticacion(usuario, obtenerAutorizacionUsuario(usuario));
    }

    private List<GrantedAuthority> obtenerAutorizacionUsuario(Usuario usuario){
        Set<GrantedAuthority> usuarios = new HashSet<GrantedAuthority>();
        usuarios.add(new SimpleGrantedAuthority(usuario.getNomusuario()));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(usuarios);
        return grantedAuthorities;
    }
    private UserDetails usuarioPorAutenticacion(Usuario usuario, List<GrantedAuthority> authorityList){
        return new User(usuario.getNomusuario(), usuario.getPassusuario(),true,
                true,
                true,
                true, authorityList);
    }

}
