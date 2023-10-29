package com.demo.apirest.service;

import com.demo.apirest.repository.OfferRepository;
import com.demo.apirest.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public Offer createoffer(Offer offer){
        return offerRepository.save(offer);
    }

    public List<Offer> getAllOffers(){
        return offerRepository.findAll();
    }

    public Offer getOfferBy(Long productId, int brandId, Date date) {
        List<Offer> filteredOffers = this.getAllOffers().stream().filter(offer ->
                isRequestedProduct(offer, productId, brandId)
        ).toList();
        Optional<Offer> optionalOffer = this.findOfferByDate(date, filteredOffers);
        return optionalOffer.orElseGet(null);
    }

    private Optional<Offer> findOfferByDate(Date date, List<Offer> offers) {
        List<Offer> offersInDate = offers.stream().filter(offer ->
            isBettweenDates(date, offer)
        ).sorted().toList();
        return offersInDate.isEmpty()? Optional.empty() : Optional.of(offersInDate.get(offersInDate.size()-1));
    }

    private boolean isRequestedProduct(Offer offer, Long productId, int brandId) {
        return offer.getProductId().equals(productId) && offer.getBrandId().equals(brandId);
    }

    private boolean isBettweenDates(Date date, Offer offer) {
        return date.before(offer.getEndDate()) && date.after(offer.getStartDate());
    }
}
