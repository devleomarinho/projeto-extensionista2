package com.projeto_extensionista2.pac_kids.repository;

import com.projeto_extensionista2.pac_kids.model.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
}
