package com.demo.apirest.controller;

import com.demo.apirest.service.OfferService;
import com.demo.apirest.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping
    public ResponseEntity<Offer> createOffer (@RequestBody Offer offer){
        offerService.createoffer(offer);
        return new ResponseEntity<>(offer, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}/{brandId}/{date}")
    public ResponseEntity<Offer> searchOfferBy(@PathVariable("productId") Long productId,
                               @PathVariable("brandId") int brandId,
                               @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date date){
        return new ResponseEntity<>(offerService.getOfferBy(productId, brandId, date), HttpStatus.FOUND);
    }
}
