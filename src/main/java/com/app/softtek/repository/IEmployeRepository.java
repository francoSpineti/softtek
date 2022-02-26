package com.app.softtek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.softtek.entity.Employe;

@Repository
public interface IEmployeRepository extends JpaRepository<Employe, Long>{

}
