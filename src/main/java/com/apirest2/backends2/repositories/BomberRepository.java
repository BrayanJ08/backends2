package com.apirest2.backends2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest2.backends2.models.Bomberos;

public interface UsuarioRepository extends JpaRepository<Bomberos, Long>{

}
