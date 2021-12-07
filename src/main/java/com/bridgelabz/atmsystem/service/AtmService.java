package com.bridgelabz.atmsystem.service;

import com.bridgelabz.atmsystem.entity.AtmEntity;
import com.bridgelabz.atmsystem.repository.AtmRepo;
import com.bridgelabz.atmsystem.dto.AtmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Purpose : To implement atm-system Program.
 *
 * @author : VAISHNAVI R. VISHWAKARMA.
 * @since  : 5-12-2021.
 */

@Service
public class AtmService {

    private static final String ATM_ADDED_SUCCESSFULLY = "Atm Added Successfully!";

    @Autowired
    private AtmRepo atmRepo;

    /**
     * @purpose : To get the list of all card details.
     *
     * @return : AtmDto card details as per regex pattern.
     */
    public List<AtmDto> getAllAtm() {
        return atmRepo
                .findAll()
                .stream()
                .map(atmEntity -> {
                    AtmDto atmDto = new AtmDto();
                    atmDto.setCardNumber(atmEntity.getCardNumber());
                    atmDto.setCardName(atmEntity.getCardName());
                    atmDto.setCvv(atmEntity.getCvv());
                    return atmDto;
                })
                .collect(Collectors.toList());
    }

    /**
     * @purpose : To add single or multiple card details in the data.
     *
     * @param atmDto : atmDto is used to add card details as per regex pattern.
     * @return : message that is atm card is added successfully!
     */
    public String addAtm(AtmDto atmDto) {
        AtmEntity atmEntity = new AtmEntity();
        atmEntity.setCardNumber(atmDto.getCardNumber());
        atmEntity.setCardName(atmDto.getCardName());
        atmEntity.setCvv(atmDto.getCvv());
        atmRepo.save(atmEntity);
        return ATM_ADDED_SUCCESSFULLY;
    }

    /**
     * @purpose : To Update single or multiple card details in the data.
     *
     * @param id : As per id card details will be updated.
     * @param atmDto : atmDto is used to update card details as per regex pattern.
     * @return : atm repo interface through atmDto class to save all updated card details.
     */
    public AtmEntity updateAtm(int id, AtmDto atmDto) {
        AtmEntity cardUpdate = atmRepo.findById(id).get();
        cardUpdate.setCardNumber(atmDto.getCardNumber());
        cardUpdate.setCardName(atmDto.getCardName());
        cardUpdate.setCvv(atmDto.getCvv());
        return atmRepo.save(cardUpdate);
    }

    /**
     * @purpose : To Delete single or multiple card details in the data.
     *
     * @param id : As per id card details will be deleted.
     * @return : atm repo interface through atmDto class to delete card details.
     */
    public AtmEntity delete(int id) {
        AtmEntity cardDelete = atmRepo.findById(id).get();
        atmRepo.delete(cardDelete);
        return cardDelete;
    }
}