package com.bridgelabz.atmsystem.controller;

import com.bridgelabz.atmsystem.entity.AtmEntity;
import com.bridgelabz.atmsystem.service.AtmService;
import com.bridgelabz.atmsystem.dto.AtmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose : To implement atm-system Program.
 *
 * @author : VAISHNAVI R. VISHWAKARMA.
 * @since  : 5-12-2021.
 */

@RestController(value = "/atm")
public class AtmController {

    @Autowired
    private AtmService atmService;

    /**
     * purpose : To get all atm details list.
     *
     * @return : atm service to get all atm.
     */
    @GetMapping(value = "/get-all-atm")
    public List<AtmDto> getAllAtm() {
        return atmService.getAllAtm();
    }

    /**
     * @purpose : To add atm card in atm-system program using http method.
     *
     * @param atmDto : atmDto is used to add card details as per regex pattern.
     * @return : atm service to add all atm details.
     */
    @PostMapping(value = "/add-atm")
    public String addAtm(@Valid @RequestBody AtmDto atmDto) {
        return atmService.addAtm(atmDto);
//   POST-->     http://localhost:8080/add-atm
    }

    /**
     * @purpose : To update atm card as per id number in atm-system program using http method.
     *
     * @param id : As per id card details will be updated.
     * @param atmDto : atmDto is used to update card details as per regex pattern.
     * @return : atm service to update atm details.
     */
    @PutMapping(value = "/update/{id}")
    public AtmEntity updateAtm(@PathVariable(value = "id") int id,
                              @Valid @RequestBody  AtmDto atmDto) {
        return atmService.updateAtm(id, atmDto);
//   PUT-->     http://localhost:8080/update/1
    }

    /**
     * @purpose : To update atm card as per id number in atm-system program using http method.
     *
     * @param id : As per id card details will be deleted.
     * @return : atm service to delete atm details.
     */
    @DeleteMapping("/delete/{id}")
    public AtmEntity delete(@PathVariable int id) {
        return atmService.delete(id);
//   DELETE-->     http://localhost:8080/delete/3
    }

}
