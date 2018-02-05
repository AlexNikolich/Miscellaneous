package com.alex.liman.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alex.liman.entity.RoomEntity;



public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
	RoomEntity findById(Long id);

}
