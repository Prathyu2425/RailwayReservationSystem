package com.example.TrainReservation;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.TrainDetails.Controller.TrainController;
import com.example.TrainDetails.exception.TrainIdNotFoundException;
import com.example.TrainDetails.models.TrainDetails;
import com.example.TrainReservation.exception.TicketIdNotFoundException;
import com.example.TrainReservation.model.Reservation;
import com.example.TrainReservation.repository.ReservationRepository;
import com.example.TrainReservation.service.TrainReservationService;



@SpringBootTest
class TrainReservationApplicationTests {

	@Autowired
    private TrainReservationService trainReservationService;
	
	
    @MockBean 
    private ReservationRepository reservationRepository;
    
    @Test
    public void getTrainReservationTest() throws TicketIdNotFoundException, Exception {
        when(reservationRepository.findAll())
                       .thenReturn(Stream
                                   .of(new Reservation("1", "naaju", "female", "22", "vizag", "SBI","s1","4","BENGALURU","VISAKHAPATNAM",LocalDate.of(2023, 03, 30),123456789L),
                                           new Reservation("2","lahari", "female", "21", "chennai", "SBI","s3","4","VIZAG","BENGALURU",LocalDate.of(2022, 05, 11),123456456L))
                                     .collect(Collectors.toList()));
                      assertEquals(2, trainReservationService.getContact().size());
    }
    @Test
    public void saveTrainTest() throws TicketIdNotFoundException, Exception {
        Reservation reservation = new Reservation("3", "suguna", "male", "23", "vizag", "UNION","b1","3","NOIDA","MUMBAI",LocalDate.of(2023, 03, 30),123456789L);
    when(reservationRepository.save(reservation)).thenReturn(reservation);
    assertEquals(reservation, trainReservationService.addPassenger(reservation));    
    }
@Test
public void deleteUserTest() throws TicketIdNotFoundException, Exception {
    Reservation reservation = new Reservation("1", "akansha", "female", "24", "vizayanagaram", "APGVB","b3","5","VIZAG","CHENNAI",LocalDate.of(2023, 03, 30),123456789L);
    trainReservationService.deletePassenger(reservation);
    verify(reservationRepository, times(1)).delete((reservation)); 
}

}






