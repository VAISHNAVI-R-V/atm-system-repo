package com.bridgelabz.atmsystem.repository;

import com.bridgelabz.atmsystem.entity.AtmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose : To implement atm-system Program.
 *
 * @author : VAISHNAVI R. VISHWAKARMA.
 * @since  : 5-12-2021.
 */
public interface AtmRepo extends JpaRepository<AtmEntity, Integer> {

}
