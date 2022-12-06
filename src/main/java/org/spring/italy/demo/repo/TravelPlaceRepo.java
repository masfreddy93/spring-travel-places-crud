package org.spring.italy.demo.repo;

import org.spring.italy.demo.pojo.TravelPlace;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TravelPlaceRepo extends JpaRepository<TravelPlace, Integer>{
	
}
