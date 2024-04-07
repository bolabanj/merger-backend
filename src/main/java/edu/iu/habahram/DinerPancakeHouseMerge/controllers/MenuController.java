package edu.iu.habahram.DinerPancakeHouseMerge.controllers;


import edu.iu.habahram.DinerPancakeHouseMerge.model.CompositeIterator;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Details;
@RestController
@CrossOrigin
@RequestMapping("/Menu")
public class MenuController {
    CompositeIterator iterator;
    MergerRepository mergerRepository;
    List<MenuItemRecord> buffer ;

    public MenuController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
        this.buffer = mergerRepository.getTheMenuItems();
    }
    @GetMapping("/vegetarian")
    public List<MenuItemRecord> VegetarianMenuItems() {
        List<MenuItemRecord> result = new ArrayList<>();
     for(MenuItemRecord item : buffer){
         if(item.vegetarian()){
                result.add(item);
         }


    }
    return result;
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> BreakfastMenuItems() {
        return mergerRepository.getTheBreakfast();
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> LunchMenuItems() {
        return mergerRepository.getTheLunch();
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> DinnerMenuItems() {

        return mergerRepository.getTheDinner();
    }


}
