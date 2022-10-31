package com.ServiCont.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ServiCont.entities.Empresa;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
}
