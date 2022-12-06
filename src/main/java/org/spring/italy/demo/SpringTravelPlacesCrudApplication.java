package org.spring.italy.demo;



import java.util.List;

import org.spring.italy.demo.pojo.TravelPlace;
import org.spring.italy.demo.serv.TravelPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTravelPlacesCrudApplication implements CommandLineRunner{

	@Autowired
	private TravelPlaceService travelPlaceService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringTravelPlacesCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		//inserimento
		TravelPlace tp1 = new TravelPlace("Zanzibar", "Un paradiso nascosto");
		TravelPlace tp2 = new TravelPlace("Hawaii", "Vieni a surfare");
		TravelPlace tp3 = new TravelPlace("Amsterdam", "Vieni a rilassarti ;)");
		
		travelPlaceService.save(tp1);
		travelPlaceService.save(tp2);
		travelPlaceService.save(tp3);
		
		
		//lettura
		List<TravelPlace> tps = travelPlaceService.findAll();
		System.out.println(tps);
	}
}
