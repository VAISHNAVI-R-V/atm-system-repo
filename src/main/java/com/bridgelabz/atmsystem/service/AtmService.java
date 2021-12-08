package com.bridgelabz.atmsystem.service;

import com.bridgelabz.atmsystem.entity.AtmEntity;
import com.bridgelabz.atmsystem.exception.AtmCustomException;
import com.bridgelabz.atmsystem.repository.AtmRepository;
import com.bridgelabz.atmsystem.dto.AtmDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Purpose : To implement AtmService class in atm-system Program.
 *
 * @author : VAISHNAVI R. VISHWAKARMA.
 * @since  : 5-12-2021.
 */

@Service
public class AtmService {

    private static final String ATM_ADDED_SUCCESSFULLY = "Atm Added Successfully!";

    @Autowired
    private AtmRepository atmRepository;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * @purpose : To get the list of all card details.
     *
     * @return : AtmDto card details as per regex pattern.
     */
    public List<AtmDto> getAllAtm() {
        return atmRepository.findAll()
                .stream()
                .map(atmEntity -> modelMapper.map(atmEntity, AtmDto.class))
                .collect((Collectors.toList()));
//        return atmRepository
//                .findAll()
//                .stream()
//                .map(atmEntity -> {
//                    AtmDto atmDto = new AtmDto();
//                    atmDto.setCardNumber(atmEntity.getCardNumber());
//                    atmDto.setCardName(atmEntity.getCardName());
//                    atmDto.setCvv(atmEntity.getCvv());
//                    return atmDto;
//                })
//                .collect(Collectors.toList());
    }

    /**
     * @purpose : To add single or multiple card details in the data.
     *
     * @param atmDto : atmDto is used to add card details as per regex pattern.
     * @return : message that is atm card is added successfully!
     */
    public String addAtm(AtmDto atmDto) {
        AtmEntity atmEntity = modelMapper.map(atmDto, AtmEntity.class);
        atmRepository.save(atmEntity);
        return ATM_ADDED_SUCCESSFULLY;

//        AtmEntity atmEntity = new AtmEntity();
//        atmEntity.setCardNumber(atmDto.getCardNumber());
//        atmEntity.setCardName(atmDto.getCardName());
//        atmEntity.setCvv(atmDto.getCvv());
//        atmRepository.save(atmEntity);
//        return ATM_ADDED_SUCCESSFULLY;
    }

    /**
     * @purpose : To Update single or multiple card details in the data.
     *
     * @param id     : As per id card details will be updated.
     * @param atmDto : atmDto is used to update card details as per regex pattern.
     * @return : atm repo interface through atmDto class to save all updated card details.
     */
    public AtmEntity updateAtm(int id, AtmDto atmDto) {
        Optional<AtmEntity> atmDetails = atmRepository.findById(id);
        if (atmDetails.isPresent()) {
        AtmEntity cardUpdate = atmRepository.findById(id).get();
        modelMapper.map(atmDto, cardUpdate);
        return atmRepository.save(cardUpdate);
    }
    throw new AtmCustomException("Atm card details are not found by this id : "+id);

//        AtmEntity cardUpdate =atmRepository.findById(id).get();
//        cardUpdate.setCardNumber(atmDto.getCardNumber());
//        cardUpdate.setCardName(atmDto.getCardName());
//        cardUpdate.setCvv(atmDto.getCvv());
//        return atmRepository.save(cardUpdate);
//    throw new AtmServiceCustomException("Atm records are not found by this id : " + id);
//}
    }

    /**
     * @purpose : To Delete single or multiple card details in the data.
     *
     * @param id : As per id card details will be deleted.
     * @return : atm repo interface through atmDto class to delete card details.
     */
    public AtmEntity delete(int id) {
        Optional<AtmEntity> atmEntity = atmRepository.findById(id);
        if (atmEntity.isPresent()) {
        AtmEntity cardDelete = atmRepository.findById(id).get();
        atmRepository.delete(cardDelete);
        return cardDelete;
    }
        throw new AtmCustomException("Atm card details are not existed by this id : " + id);
    }
}