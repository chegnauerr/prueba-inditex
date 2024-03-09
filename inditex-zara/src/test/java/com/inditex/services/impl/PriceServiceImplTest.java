package com.inditex.services.impl;

import com.inditex.exception.PriceServiceException;
import com.inditex.model.entities.BrandEntity;
import com.inditex.model.entities.PriceEntity;
import com.inditex.model.request.PriceRequest;
import com.inditex.model.response.PriceResponse;
import com.inditex.repository.IPriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class PriceServiceImplTest {

    @Mock
    private IPriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPrice() {
        PriceRequest priceRequest = new PriceRequest();
        priceRequest.setBrandId(1L);
        priceRequest.setProductId(35455L);
        priceRequest.setAppDate(LocalDateTime.parse("2024-06-14T10:00:00"));

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(1L);
        brandEntity.setName("zara");
        PriceEntity priceEntity1 = new PriceEntity();
        priceEntity1.setId(1L);
        priceEntity1.setBrand(brandEntity);
        priceEntity1.setProductId(35455L);
        priceEntity1.setStartDate(LocalDateTime.parse("2024-06-14T00:00:00"));
        priceEntity1.setEndDate(LocalDateTime.parse("2024-06-14T12:00:00"));
        priceEntity1.setPrice(35.50);

        List<PriceEntity> priceEntities = new ArrayList<>();
        priceEntities.add(priceEntity1);

        when(priceRepository.findPricesByBrandIdAndProductIdAndDateRange(1L, 35455L, LocalDateTime.parse("2024-06-14T10:00:00")))
                .thenReturn(priceEntities);

        List<PriceResponse> priceResponses = priceServiceImpl.getFindPrice(priceRequest);

        assertEquals(1, priceResponses.size());
        assertEquals(35.50, priceResponses.get(0).getPrice());
    }

    @Test
    public void testPriceServiceException() {
        PriceRequest priceRequest = new PriceRequest();
        priceRequest.setBrandId(1L);
        priceRequest.setProductId(1L);
        priceRequest.setAppDate(LocalDateTime.parse("2024-03-09T12:00:00"));

        when(priceRepository.findPricesByBrandIdAndProductIdAndDateRange(1L, 1L,LocalDateTime.parse("2024-03-09T12:00:00")))
                .thenThrow(new RuntimeException("Error occurred in repository"));

        assertThrows(PriceServiceException.class, () -> {
            priceServiceImpl.getFindPrice(priceRequest);
        });
    }

}