package com.demo.apirest.service;

import com.demo.apirest.repository.OfferRepository;
import com.demo.apirest.model.Offer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static com.demo.apirest.service.TestOffers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OfferServiceTest {

    @Mock
    private OfferRepository offerRepository;

    @InjectMocks
    private OfferService offerService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void retrieve_an_offer(){
        when(offerRepository.findAll()).thenReturn(aListOfOffers());
        Offer foundOffer = offerService.getOfferBy(
                35455L,
                1,
                new GregorianCalendar(2020, Calendar.JUNE, 14, 10, 0,0).getTime());
        assertNotNull(foundOffer);
        assertEquals(offer1.getPrice(), foundOffer.getPrice());
        assertEquals(offer1.getStartDate(), foundOffer.getStartDate());
        assertEquals(offer1.getEndDate(), foundOffer.getEndDate());
    }

    @Test
    void retrieve_the_right_offer_with_the_highest_priority(){
        when(offerRepository.findAll()).thenReturn(aListOfOffers());
        Offer foundOffer = offerService.getOfferBy(
                35455L,
                1,
                new GregorianCalendar(2020, Calendar.JUNE, 14, 16, 0,0).getTime());
        assertNotNull(foundOffer);
        assertEquals(offer2.getPrice(), foundOffer.getPrice());
        assertEquals(offer2.getStartDate(), foundOffer.getStartDate());
        assertEquals(offer2.getEndDate(), foundOffer.getEndDate());
    }

    private List<Offer> aListOfOffers(){
        List<Offer> offersList = new ArrayList<>();
        offersList.add(offer1);
        offersList.add(offer2);
        offersList.add(offer3);
        offersList.add(offer4);
        return offersList;
    }
}
