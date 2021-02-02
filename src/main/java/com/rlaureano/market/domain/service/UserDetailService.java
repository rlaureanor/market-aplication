package com.rlaureano.market.domain.service;

import com.rlaureano.market.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.rlaureano.market.domain.User user = userRepository.findByNombre(username);
        List<GrantedAuthority> roles= new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));
        //return new User("Rogelio", "{noop}rlaureano", new ArrayList<>());
        //return new User(user.getName(),"{noop}"+user.getPassword(), roles);
        return new User(user.getName(),user.getPassword(), roles);

    }
    public com.rlaureano.market.domain.User save(com.rlaureano.market.domain.User users){
        return userRepository.save(users);
    }

}
