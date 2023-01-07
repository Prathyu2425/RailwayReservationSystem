package com.example.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.AdminModel;
import com.example.model.TrainDetails;
import com.example.model.UserModel;
import com.example.repository.AdminRepository;
import com.example.repository.TrainRepository;
import com.example.repository.UserRepository;


@RestController

@RequestMapping("/admin")
public class AdminController {
	
	    @Autowired
	    private RestTemplate restTemplate;

		@Autowired
		private AdminRepository adminrepo;
		
		@Autowired
		private TrainRepository trainrepo;
		
		@Autowired
		private UserRepository userrepo;
		
		//Adding Logger 
		Logger logger = LoggerFactory.getLogger(AdminController.class);
		
//--------------------------------------Admin-CRUD-----------------------------------------
		
		//Rest API to add Admin details
		@PostMapping("/registeradmin")
		public String addadmin(@RequestBody AdminModel admin) {
			adminrepo.save(admin);
			
			//logger implementation
	        logger.info("[registeradmin] info message added");
	        logger.warn("[registeradmin] warn message added");
	        logger.debug("registeradmin] debug message added");
	        logger.trace("[registeradmin] trace message added");
	        
			return "Admin with Id: "+admin.getId()+" have been Registered Successfully";
		}
		
		
		//Rest API to get Admin details by Id
		@GetMapping("/viewadminprofile/{id}")
		public Optional<AdminModel> getadmin(@PathVariable("id") String id){
			
			//logger implementation
	        logger.info("[viewadminprofile/id] info message added");
	        logger.debug("[viewadminprofile/id] debug message added");
        
			return adminrepo.findById(id);
		}
		
		//Rest API to update Admin details by Id
		@PutMapping("/updateprofile/{id}")
		public String updateadmin(@PathVariable("id") String id, @RequestBody AdminModel adminmodel) {
			adminrepo.save(adminmodel);
			
			//logger implementation
	        logger.info("[updateprofile/id] info message added");
	        logger.debug("[updateprofile/id] debug message added");
	        
			return "Admin with id "+id+" have been updated successfully";
		}
		
		
		//Rest API to delete Admin details by Id
		@DeleteMapping("/deleteadmin/{id}")
		public String deleteadmin(@PathVariable String id) {
			adminrepo.deleteById(id);
			
			//logger implementation
	        logger.info("[deleteadmin/id] info message added");
	        logger.debug("[deleteadmin/id] debug message added");
	        
			return "Admin with id "+id+" have been deleted";
		}
		
		
//
		
		
//--------------------------------------Admin-Train---------------------------------------------
		
	   //Rest API to add Train details
		@PostMapping("/addTrain")
		public String savetrain(@RequestBody TrainDetails train) {
			this.restTemplate.postForObject("http://TrainDetails/search/addTrain", train, TrainDetails.class);
			
			//logger implementation
	        logger.info("[addtrain] info message added");
	        logger.debug("[addtrain] debug message added");
	        
			return "Added train with id:"+train.getId();
		}
		
		
	    //Rest API to get all Train details 
		@GetMapping("/viewalltrains")
		public List<TrainDetails> getTrains(){
			
			//logger implementation
	        logger.info("[viewalltrains] info message added");
	        logger.debug("[viewalltrains] debug message added");
	        
			return Arrays.asList(restTemplate.getForObject("http://TrainDetails/search/viewalltrains",TrainDetails[].class));
		}

		
		//Rest API to get User Train by Id
		@GetMapping("/viewalltrains/{id}")
		public TrainDetails getTrains(@PathVariable("trainNo") String id){
			
			//logger implementation
	        logger.info("[viewalltrains/id] info message added");
	        logger.debug("[viewalltrains/id] debug message added");
	        
			return restTemplate.getForObject("http://TrainDetails/user/viewalltrains/{id}/"+id,TrainDetails.class);	
		}
		
		
		//Rest API to get User details by Name
		@GetMapping("/train/{id}")
		public TrainDetails getTrainsbyId(@PathVariable String id){

			//logger implementation
	        logger.info("[viewtrainbyname/Name] info message added");
	        logger.debug("[viewtrainbyname/Name] debug message added");
			
			return restTemplate.getForObject("http://TrainDetails/search/"+id,TrainDetails.class);	
		}
		
		
		//Rest API to update Train details by Id
		@PutMapping("/updatetrain/{id}")
		public TrainDetails updateTrain(@PathVariable("id") String id, @RequestBody TrainDetails t) {
			this.restTemplate.put("http://TrainDetails/search/updatetrain/{id}",id,t,TrainDetails.class);
			t.setId(id);
			CrudRepository<AdminModel, String> trainRepository;
			
			//logger implementation
	        logger.info("[updatetrain/id] info message added");
	        logger.debug("[updatetrain/id] debug message added");
			
			return t;
		}
		
	
		//Rest API to delete User details by Id
		@DeleteMapping("/delete/{id}")
		public String deletetrain(@PathVariable String id) {
			
			this.restTemplate.delete("http://TrainDetails/search/delete/"+id,TrainDetails.class);
			
			//logger implementation
	        logger.info("[deletetrain/id] info message added");
	        logger.debug("[deletetrain/id] debug message added");
	        
			return "Train deleted[][] with id : " + id;
		}
		
}
