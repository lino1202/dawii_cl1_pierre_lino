package pe.edu.cibertec.dawii_cl1_pierre_lino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dawii_cl1_pierre_lino.model.bd.Usuario;
import pe.edu.cibertec.dawii_cl1_pierre_lino.repository.UsuarioRepository;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    //private RolRepository rolRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder
            = new BCryptPasswordEncoder();

    /*public Usuario buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }*/
    public Usuario buscarUsuarioPorNomusuario(String nomUsuario){
        return usuarioRepository.findByNomusuario(nomUsuario);
    }
    public Usuario guardarUsuario(Usuario usuario){
        usuario.setPassusuario(bCryptPasswordEncoder.encode(usuario.getPassusuario()));
        usuario.setNomusuario(usuario.getNomusuario());
        return usuarioRepository.save(usuario);
    }
}
