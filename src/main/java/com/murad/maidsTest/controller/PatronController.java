package com.murad.maidsTest.controller;

import com.murad.maidsTest.model.Patron;
import com.murad.maidsTest.response.SuccessResponse;
import com.murad.maidsTest.service.PatronService;
import com.murad.maidsTest.service.PatronService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatronController extends BaseApiController {


    @Autowired
    private PatronService patronService;


    //get all the Patrons in the table in our database
    @GetMapping("/patrons")
    public SuccessResponse getPatrons() {
        return new SuccessResponse("success", patronService.getPatrons());

    }


    //get a single Patron by its id
    @GetMapping("/patrons/{id}")
    public SuccessResponse getPatron(@PathVariable long  id ) {
        Patron Patron = patronService.getPatron(id);
        return new SuccessResponse("success", Patron);

    }


    // insert a Patron into database
    @PostMapping("/patrons")
    public SuccessResponse savePatron(@Valid  @RequestBody Patron Patron) {
        Patron savedPatron = patronService.savePatron(Patron);
        return new SuccessResponse("success",savedPatron);

    }

    //update an existing Patron in the database
    @PutMapping("/patrons/{id}")
    public SuccessResponse updatePatron(@PathVariable long  id,@Valid  @RequestBody Patron Patron) {
        Patron updatedPatron = patronService.updatePatron(id, Patron);
        return new SuccessResponse("success", updatedPatron);
    }


    // delete an existing Patron in the database
    @DeleteMapping("/patrons/{id}")
    public SuccessResponse deletePatron(@PathVariable long  id ) {
        Patron deletedPatron = patronService.deletePatron(id);
        return new SuccessResponse("success", deletedPatron);
    }

}
