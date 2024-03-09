package com.inditex.services.impl;

import com.inditex.exception.PriceServiceException;
import com.inditex.model.entities.PriceEntity;
import com.inditex.model.request.PriceRequest;
import com.inditex.model.response.PriceResponse;
import com.inditex.repository.IPriceRepository;
import com.inditex.services.IPriceService;
import com.inditex.utils.PriceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceServiceImpl implements IPriceService {

    @Autowired
    IPriceRepository priceRepository;

    @Override
    public List<PriceResponse> getFindPrice(PriceRequest priceRequest) {
        List<PriceResponse> listOut = new ArrayList<>();
        try {
            List<PriceEntity> priceEntityBranId = priceRepository.findPricesByBrandIdAndProductIdAndDateRange
                    (priceRequest.getBrandId(), priceRequest.getProductId(), priceRequest.getAppDate());
            listOut = PriceConverter.convertPriceEntityToDto(priceEntityBranId);
        } catch (Exception e) {
            throw new PriceServiceException(e.getLocalizedMessage(), e);
        }
        return listOut;
    }

}