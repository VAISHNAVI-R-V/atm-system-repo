package com.bridgelabz.atmsystem.dto;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Purpose : To implement atm-system Program.
 *
 * @author : VAISHNAVI R. VISHWAKARMA.
 * @since  : 5-12-2021.
 */
@Data
public class AtmDto {

@NotNull
//@UniqueElements
//@Column(unique = true)
@Pattern(regexp = "^[0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}$",
        message = "Card Number Should have only 16 digit")
    private String cardNumber;

    @NotNull
    @Size(min = 3,
            message = "Name Should have at least 3 Characters")
    private String cardName;

    @NotNull
//    @UniqueElements
    @Pattern(regexp = "^[0-9]{3}$",
            message = "CVV Should have only 3 digit")
    private String cvv;
}
