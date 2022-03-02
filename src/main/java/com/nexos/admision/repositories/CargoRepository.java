package com.nexos.admision.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.admision.models.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long> {

}
