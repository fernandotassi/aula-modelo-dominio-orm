package com.napoleao.napo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.napoleao.napo.entities.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{}
