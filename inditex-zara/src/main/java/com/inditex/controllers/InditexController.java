package com.inditex.controllers;

import com.inditex.model.request.PriceRequest;
import com.inditex.model.response.PriceResponse;
import com.inditex.services.IPriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Price API")
@RestController
public class InditexController {

    @Autowired
    IPriceService priceService;

    @PostMapping("/price")
    @ApiOperation(value = "Get Price", notes = "Precio final (pvp)")
    public ResponseEntity<?> getPrice(@Valid @RequestBody PriceRequest  priceRequest) {
        try {
            List<PriceResponse> priceDtoList;
            priceDtoList = priceService.getFindPrice(priceRequest);
            return new ResponseEntity<>(priceDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Error : " + e.getMessage());
        }
    }
}
