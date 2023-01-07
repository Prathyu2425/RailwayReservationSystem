package com.example.TrainReservation.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.TrainDetails.models.TrainDetails;
import com.example.TrainReservation.model.AuthenticationRequest;
import com.example.TrainReservation.model.AuthenticationResponse;
import com.example.TrainReservation.model.JwtUtil;
import com.example.TrainReservation.model.Reservation;
import com.example.TrainReservation.model.User1;
import com.example.TrainReservation.repository.ReservationRepository;
import com.example.TrainReservation.repository.UserRepo;
import com.example.TrainReservation.service.MyUserDetailsService;

@RestController

@RequestMapping("/orders")
public class ReservationController {
	
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private UserRepo repo;
	
	
	public ReservationController (ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	
	
	  @Autowired 
	  RestTemplate restTemplate;
	 
	
	 
	Logger logger = LoggerFactory.getLogger(ReservationController.class);    
	

	
	
	@GetMapping("/{pnr}")
	public List<Reservation> getBypnr(@PathVariable long pnr){
		logger.info("THE RESERVATION WITH PNR IS VIEWED");
		return reservationRepository.findByPnr( pnr);
	}

	@PostMapping("/addOrder")
	public String addTicket(@RequestBody Reservation add) {
		add.setPnr();
		reservationRepository.save(add);
		logger.info("BOOKED TICKET SUCCESSFULLY");
	return "Booked ticket with pnrNo. :  " + add.getpnr();
    }
	
	@GetMapping("/findAllPass")
    public List<Reservation> getPassenger(){
		logger.info("ALL BOOKED TICKETS ARE VIEWED");
	return reservationRepository.findAll();
	}
	
	

		
	 @DeleteMapping("/delete/{pnr}")
	 public String deleteTicket (@PathVariable long pnr) {
		 reservationRepository.deleteByPnr(pnr);
		 logger.info("THE RESERVATION IS DELETED WITH PNR");
		return "Order deleted with pnrNo. : "+pnr;
		}




// http://localhost:2222/orders/addOrder
// http://localhost:2222/orders/delete/{pnr}
// http://localhost:2222/orders/{pnr}
	//-----------Train-details---------

	
	  //Rest API to add Train details
	  
	  
	  //Rest API to get all Train details
	  
	  @GetMapping("/viewalltrains")
		public List<TrainDetails> getTrains(){
			
			//logger implementation
	       logger.info("[viewalltrains] info message added");
	       logger.debug("[viewalltrains] debug message added");
	        
			return Arrays.asList(restTemplate.getForObject("http://TrainDetails/search/viewalltrains",TrainDetails[].class));
		}
	  
	  
	  
	  
	
	  
	  //Rest API to get User Train by Id
	  
	  @GetMapping("/findallTrains/{id}") 
	  public TrainDetails getTrains(@PathVariable("Id") String id){
	  
	  //logger implementation logger.info("[viewalltrains/id] info message added");
	  logger.debug("[viewalltrains/id] debug message added");
	  
	 return restTemplate.getForObject(
	  "http://TrainDetails/search/findallTrains/"+id,TrainDetails.class) ;
	  }
	  
	  
	  
	  //Rest API to get User details by Name
	  
	  @GetMapping("/train/{id}") 
	  public TrainDetails getTrainsbyId(@PathVariable String id)
	  {
	  
	  //logger implementation
	  logger.info("[viewtrainbyname/Name] info message added");
	  logger.debug("[viewtrainbyname/Name] debug message added");
	  
	 return restTemplate.getForObject("http://TrainDetails/search/train"+id,
	 TrainDetails.class); }
	  
	  
	  
	  
	  
	 
	  
	  
	  
	  //--------auth-controller--------------
	  
	  @PostMapping("/reg")
	    private ResponseEntity<?> subscribe(@RequestBody AuthenticationRequest request)
	    {
	        System.out.println("Naaju");
	        String username = request.getUsername();
	        String password = request.getPassword();

	 


	        User1 model = new User1();
	        model.setUsername(username);
	        model.setPassword(password);

	 

	 

	        try {
	            repo.save(model);
	        } catch (Exception e) {
	            return ResponseEntity.ok(new AuthenticationResponse("Error while subsribing the user with username " + username));
	        }
	            return ResponseEntity.ok(new AuthenticationResponse("client subscribed with username " + username));
	    }

	 

	    @RequestMapping(value="/authenticate", method=RequestMethod.POST)
	    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest  authenticationRequest) throws Exception {
	        try
	        {
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	    }
	        catch (BadCredentialsException e) {
	            throw new Exception("Incorrect username or password", e);
	        }

	 


	        final UserDetails userDetails = userDetailsService
	                .loadUserByUsername(authenticationRequest.getUsername());

	 

	 

	        final String jwt = jwtTokenUtil.generateToken(userDetails);

	 

	 

	        return ResponseEntity.ok(new AuthenticationResponse(jwt));
	    }
}
	 