package org.spring.italy.demo.serv;

import java.util.List;
import java.util.Optional;

import org.spring.italy.demo.pojo.TravelPlace;
import org.spring.italy.demo.repo.TravelPlaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelPlaceService {
	
	@Autowired
	private TravelPlaceRepo travelPlaceRepo;
	
	
	public void save(TravelPlace travelPlace) {
		
		travelPlaceRepo.save(travelPlace);
	}
	public List<TravelPlace> findAll(){
		
		return travelPlaceRepo.findAll();
	}
	public Optional<TravelPlace> getTpById(int id){
		
		return travelPlaceRepo.findById(id);
	}
	public void deleteTPbyId(int id) {
		
		travelPlaceRepo.deleteById(id);
	}
	public void delete(TravelPlace tp) {
		
		travelPlaceRepo.delete(tp);
	}
}
