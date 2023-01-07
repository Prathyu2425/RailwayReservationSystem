package com.example.TrainDetails.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.TrainDetails.Repository.TrainRepository;
import com.example.TrainDetails.exception.TrainIdNotFoundException;
import com.example.TrainDetails.models.TrainDetails;

@RestController
@RequestMapping("/search")
public class TrainController {
	

	Logger log = LoggerFactory.getLogger(TrainController.class);
	
	@Autowired
	private TrainRepository trainRepository;
	
	@Autowired
	public TrainController(TrainRepository trainRepository) {
		this.trainRepository = trainRepository;
	}
	@PostMapping("/addTrain")
	public void saveTrain(@RequestBody TrainDetails id) { 
		//convert the body of the HTTP request to the java class object
		trainRepository.save(id);
		log.info("the train is added");
		
		
	}
	@GetMapping("/{id}")
	public TrainDetails getTrain(@PathVariable String id) throws TrainIdNotFoundException{
		log.info("the available train is  viewed");
		return trainRepository.findById(id).orElseThrow(()->new TrainIdNotFoundException("Id:" +id+ "Not found"));
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTrain(@PathVariable String id) {
		trainRepository.deleteById(id);
		log.info("the train is deleted");
		return "Train deleted with id : " + id;
	}
	
	@PutMapping("/update/{id}")
	public TrainDetails updateTrain(@PathVariable("id") String id, @RequestBody TrainDetails t) {
		t.setId(id);
		trainRepository.save(t);
		log.info("the train is  updated");
		return t;

	}




	}

	
	
	
	
	
	

