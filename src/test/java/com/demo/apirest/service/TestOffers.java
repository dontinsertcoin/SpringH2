package com.demo.apirest.service;

import com.demo.apirest.model.Offer;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestOffers {
    public static final Offer offer1 = new Offer(
            1,
            new GregorianCalendar(2020, Calendar.JUNE, 14, 0,0,0).getTime(),
            new GregorianCalendar(2020, Calendar.DECEMBER, 31, 23, 59,59).getTime(),
            1,
            35455L,
            0,
            35.5,
            "EUR");

    public static final Offer offer2 = new Offer(
            1,
            new GregorianCalendar(2020,Calendar.JUNE, 14, 15,0,0).getTime(),
            new GregorianCalendar(2020, Calendar.JUNE, 14, 18, 30,0).getTime(),
            1,
            35455L,
            1,
            25.45,
            "EUR");

    public static final Offer offer3 = new Offer(
            1,
            new GregorianCalendar(2020,Calendar.JUNE, 15, 0,0,0).getTime(),
            new GregorianCalendar(2020, Calendar.JUNE, 15, 11, 0,0).getTime(),
            1,
            35455L,
            1,
            30.5,
            "EUR");

    public static final Offer offer4 = new Offer(
            1,
            new GregorianCalendar(2020,Calendar.JUNE, 15, 16,0,0).getTime(),
            new GregorianCalendar(2020, Calendar.DECEMBER, 31, 23, 59,59).getTime(),
            1,
            35455L,
            1,
            38.95,
            "EUR");
}
