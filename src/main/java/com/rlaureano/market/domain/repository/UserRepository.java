package com.rlaureano.market.domain.repository;

import com.rlaureano.market.domain.User;

public interface UserRepository {

    User findByNombre(String name);
    User save(User user);
}
