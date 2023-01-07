package com.example.TrainDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrainDetails.Repository.TrainRepository;
import com.example.TrainDetails.exception.TrainIdNotFoundException;
import com.example.TrainDetails.models.TrainDetails;

@Service
public class TrainService {


    @Autowired
    private TrainRepository trainRepository;

public TrainDetails addTrain (TrainDetails train) {
    return trainRepository.save(train);
}

 

public List<TrainDetails> getContact(){
    List<TrainDetails> train = trainRepository.findAll();
    System.out.println("Getting data from DB: " +train);
    return train;
}

 

public TrainDetails getTrainbyId(String id)throws TrainIdNotFoundException{
    return trainRepository.findById(id).orElseThrow(()->new TrainIdNotFoundException("Id:"+id+"Not found"));
}

 

public void deleteTrain(TrainDetails train) {
    trainRepository.delete(train);
}



public TrainDetails updateTrain(TrainDetails train) {
	return trainRepository.save(train);
	
	
}
	// TODO Auto-generated method stub
	
}




 


