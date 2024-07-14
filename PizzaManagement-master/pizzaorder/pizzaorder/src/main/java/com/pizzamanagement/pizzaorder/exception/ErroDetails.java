package com.pizzamanagement.pizzaorder.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErroDetails {
    private String Message;
    private String Details;
}
