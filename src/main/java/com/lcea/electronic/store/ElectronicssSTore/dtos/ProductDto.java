package com.lcea.electronic.store.ElectronicssSTore.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

    private String productId;
    private String title;

    private String description;
    private int price;
    private int discountPrice;
    private int quantity;
    private Date addedDate;
    private boolean live;
    private boolean stock;
}
