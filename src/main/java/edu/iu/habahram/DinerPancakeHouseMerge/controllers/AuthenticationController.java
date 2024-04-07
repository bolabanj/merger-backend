package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Details;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
//@RequestMapping("/signup")
public class AuthenticationController {

    UserRepository userRepository = new UserRepository();
    @PostMapping("/signup")
    public boolean signup(@RequestBody Details details){
        try{
            userRepository.save(details);
            return true;
        }
        catch(Exception e){
            throw new RuntimeException(e);

        }
    }
}
