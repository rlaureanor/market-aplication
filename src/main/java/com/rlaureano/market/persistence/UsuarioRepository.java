package com.rlaureano.market.persistence;

import com.rlaureano.market.domain.User;
import com.rlaureano.market.domain.repository.UserRepository;
import com.rlaureano.market.persistence.crud.UsuarioCrudRepository;
import com.rlaureano.market.persistence.entity.Usuario;
import com.rlaureano.market.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByNombre(String name) {
        return userMapper.toUser(usuarioCrudRepository.findByNombre(name));
    }
    public User save(User user){
        Usuario usuario = userMapper.toUsuario(user);
        return userMapper.toUser(usuarioCrudRepository.save(usuario));
    }
}
