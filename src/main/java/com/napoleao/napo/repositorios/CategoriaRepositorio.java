package com.napoleao.napo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.napoleao.napo.entities.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{}
