package com.example.TrainDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.TrainDetails.Controller.TrainController;
import com.example.TrainDetails.Repository.TrainRepository;
import com.example.TrainDetails.exception.TrainIdNotFoundException;
import com.example.TrainDetails.models.TrainDetails;
import com.example.TrainDetails.service.TrainService;

import java.util.stream.Stream;

@SpringBootTest
class TrainDetailsApplicationTests {
    
	private static final String Main = null;

	@Autowired
	
	private TrainService trainService;
	
	@Autowired
	private TrainController traincontroller;
	
	@MockBean
	private TrainRepository trainrepository;
	
	@Test
	public void getTrainTest()  {
		when(trainrepository.findAll())
		       .thenReturn(Stream
		                 .of(new TrainDetails("1", "AMT EXPRESS", "10AM", "Badnera", "Amravati", "100"),
				           new TrainDetails("2", "NGP EXPRESS", "11AM", "PUNE", "Nagpur", "500"))
		                   .collect(Collectors.toList()));
assertEquals(2, trainService.getContact().size()); 
}
	@Test
	public void saveTrainTest() {
		TrainDetails train = new TrainDetails("3", " EXPRESS", "10AM", "HYDRABAD", "NAGPUR", "500");
		when(trainrepository.save(train)).thenReturn(train);
		assertEquals(train, trainService.addTrain(train));

	}
	@Test
	public void deleteUserTest() {
		TrainDetails train = new TrainDetails("1", "AMT EXPRESS", "10AM", "Badnera", "Amravati", "100");
		trainService.deleteTrain(train);
		verify(trainrepository, times(1)).delete(train);
	}
	
	@Test
	public void UpdateTrain() {
		TrainDetails train = new TrainDetails("6", "Express", "11AM", "Hyderabad", "Nagpur", "200");
		trainService.updateTrain(train);
		verify(trainrepository, times(1)).save(train);
	}
	@Test
	void getTrainByIdTest(){
	    try
	    {
	        String id = "2";
	        TrainDetails train = traincontroller.getTrain(id);
	        if(null != train) {
	            verify(trainrepository).findById(train.getId());
	        }
	    }
	    catch (TrainIdNotFoundException e) {
	        System.out.println("exception occured"+ e);
	    }
	
	}
}

