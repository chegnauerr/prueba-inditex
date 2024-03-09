package com.inditex.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PriceRequest {

    @ApiModelProperty(notes = "ID del producto", example = "35455")
    private Long productId;

    @ApiModelProperty(notes = "ID del brand", example = "1")
    private Long brandId;

    @ApiModelProperty(notes = "App data", example = "2020-06-15T10:00:00")
    private LocalDateTime appDate;
}
