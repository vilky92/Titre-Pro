package com.cjsecurite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjsecurite.model.direction.Direction;

public interface DirectionRepository extends JpaRepository<Direction, Long>{

}
