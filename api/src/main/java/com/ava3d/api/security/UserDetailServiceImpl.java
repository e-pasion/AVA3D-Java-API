package com.ava3d.api.security;

import com.ava3d.api.entity.UsuarioEntity;
import com.ava3d.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         UsuarioEntity usuarioEntity= usuarioRepository
                 .findOneByEmail(email)
                 .orElseThrow(() -> new UsernameNotFoundException("El usuario con email "+email+" no existe."));
        return new UserDetailsImpl(usuarioEntity);
    }
}
