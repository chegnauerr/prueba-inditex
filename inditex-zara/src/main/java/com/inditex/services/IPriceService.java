package com.inditex.services;

import com.inditex.exception.PriceServiceException;
import com.inditex.model.request.PriceRequest;
import com.inditex.model.response.PriceResponse;

import java.util.List;

public interface IPriceService {

    List<PriceResponse> getFindPrice(PriceRequest priceRequest) throws PriceServiceException;

}
