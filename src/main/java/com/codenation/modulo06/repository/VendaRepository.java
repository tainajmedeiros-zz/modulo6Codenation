package com.codenation.modulo06.repository;

import com.codenation.modulo06.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    Venda findById(long id);
}
