package com.example.TrainDetails.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrainDetails.Repository.TrainRepository;
import com.example.TrainDetails.models.TrainDetails;


@RestController
@RequestMapping("/search")
public class UserController {
	
	
	private TrainRepository trainRepository;
	
	
	Logger log = LoggerFactory.getLogger(TrainController.class);

	
	@Autowired
	public UserController (TrainRepository trainRepository) {
		this.trainRepository = trainRepository;
	}
	
	@GetMapping("/viewalltrains")
    public List<TrainDetails> getTrains(){
		log.info("the available trains are  viewed");
	return trainRepository.findAll();
	
}
	@GetMapping("/findAllTrains/{id}")
    public Optional<TrainDetails> getTrains(@PathVariable String id){
		log.info("the available trains are  viewed by id");
	return trainRepository.findById(id);
}
	@RequestMapping(value="/getby/{origin}/{destination}",method=RequestMethod.GET)
	public List<TrainDetails> getdetailsByDestination(@PathVariable("origin") String origin,
			@PathVariable("destination") String destination){
		return trainRepository.findBySort(origin,destination);
	}
	
	
	
	
}
