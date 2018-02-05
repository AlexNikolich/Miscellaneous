package com.alex.liman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.alex.liman.entity.RoomEntity;
import com.alex.liman.repository.RoomRepository;


@Component
public class H2Bootstrap implements CommandLineRunner{

	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		System.out.println("POPUNJAVA TABLICU!!!!!!!!!!!!!!!!!!!!!!");
		
		roomRepository.save(new RoomEntity(405,"200"));
		roomRepository.save(new RoomEntity(406,"220"));
		roomRepository.save(new RoomEntity(407,"250"));
		
		System.out.println("PRINTA TABLICU!!!!!!!!!!!!!!!!!!!!!!");
		
		Iterable<RoomEntity> itr = roomRepository.findAll();
		for(RoomEntity room: itr){
			System.out.println(room.getRoomNumber());
		}
	}

}
