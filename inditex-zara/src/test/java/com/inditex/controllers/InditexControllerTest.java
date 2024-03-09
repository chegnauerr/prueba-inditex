package com.inditex.controllers;

import com.inditex.exception.PriceServiceException;
import com.inditex.model.request.PriceRequest;
import com.inditex.model.response.PriceResponse;
import com.inditex.services.IPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class InditexControllerTest {

    @Mock
    private IPriceService priceService;

    @InjectMocks
    private InditexController inditexController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSuccess() {
        PriceRequest priceRequest = new PriceRequest();

        List<PriceResponse> priceResponses = new ArrayList<>();

        when(priceService.getFindPrice(priceRequest)).thenReturn(priceResponses);

        ResponseEntity<?> responseEntity = inditexController.getPrice(priceRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(priceResponses, responseEntity.getBody());
    }

    @Test
    public void testPrice_Exception() {
        PriceRequest priceRequest = new PriceRequest();

        when(priceService.getFindPrice(priceRequest)).thenThrow(new PriceServiceException("Service Exception"));

        ResponseEntity<?> responseEntity = inditexController.getPrice(priceRequest);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Error : Service Exception", responseEntity.getBody());
    }
}