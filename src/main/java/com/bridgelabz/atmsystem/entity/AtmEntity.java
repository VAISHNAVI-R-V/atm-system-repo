package com.bridgelabz.atmsystem.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.intellij.lang.annotations.Pattern;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

/**
 * Purpose : To implement atm-system Program.
 *
 * @author : VAISHNAVI R. VISHWAKARMA.
 * @since  : 5-12-2021.
 */
@Entity
@Table(name = "atm")
@Data
public class AtmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cardNumber;
    private String cardName;
    private String cvv;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}


