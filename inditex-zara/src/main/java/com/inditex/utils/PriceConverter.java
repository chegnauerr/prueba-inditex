package com.inditex.utils;

import com.inditex.model.entities.BrandEntity;
import com.inditex.model.entities.PriceEntity;
import com.inditex.model.response.PriceResponse;

import java.util.ArrayList;
import java.util.List;

public abstract class PriceConverter {

    public static List<PriceResponse> convertPriceEntityToDto(List<PriceEntity> price) {
        List<PriceResponse> priceResponseList = new ArrayList();

        for (PriceEntity priceIte : price) {
            PriceResponse priceResponse = new PriceResponse();
            BrandEntity brand = priceIte.getBrand();
            priceResponse.setBrandId(brand.getId());
            priceResponse.setStartDate(priceIte.getStartDate());
            priceResponse.setEndDate(priceIte.getEndDate());
            priceResponse.setPriceList(priceIte.getPriceList());
            priceResponse.setProductId(priceIte.getProductId());
            priceResponse.setPrice(priceIte.getPrice());
            priceResponseList.add(priceResponse);
        }
        return priceResponseList;
    }
}
