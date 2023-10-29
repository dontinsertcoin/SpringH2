package com.demo.apirest.controller;

import com.demo.apirest.model.Offer;
import com.demo.apirest.service.TestOffers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OfferControllerTest {

    private static final String BASE_URL = "/api/offers";

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext applicationContext;

    @BeforeEach
    void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    void persist_offer() throws Exception {
        MvcResult mvcGetResult = persistOffer(TestOffers.offer1);
        assertEquals(mvcGetResult.getResponse().getStatus(), 201);
    }

    @Test
    void retrieve_an_offer_from_database() throws Exception {
        persist_offer();
        MvcResult mvcPostResult = getOfferFor("35455","1","2020-06-18T10:00:00");
        Offer foundOffer = new ObjectMapper().readValue(mvcPostResult.getResponse().getContentAsString(), Offer.class);
        assertEquals(302, mvcPostResult.getResponse().getStatus());
        Assertions.assertEquals(TestOffers.offer1.getPrice(), foundOffer.getPrice());
        Assertions.assertEquals(TestOffers.offer1.getStartDate(), foundOffer.getStartDate());
        Assertions.assertEquals(TestOffers.offer1.getEndDate(), foundOffer.getEndDate());
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(object);
    }

    private MvcResult persistOffer(Offer offer) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapToJson(offer))
        ).andReturn();
    }

    private MvcResult getOfferFor(String productId, String brandId, String date) throws Exception {
        return mockMvc.perform(
                MockMvcRequestBuilders.get(BASE_URL + "/" + productId + "/" + brandId + "/" + date)
        ).andReturn();
    }
}