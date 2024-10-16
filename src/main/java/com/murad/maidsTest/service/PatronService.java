package com.murad.maidsTest.service;

import com.murad.maidsTest.model.Patron;
import com.murad.maidsTest.repository.PatronRepository;
import com.murad.maidsTest.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronService {


    @Autowired
    private PatronRepository patronRepository;

    public Patron savePatron(Patron patron) {
        return patronRepository.save(patron);
    }


    public Patron getPatron(long patronId) {
        return patronRepository.findById(patronId).orElseThrow(() -> new RuntimeException("Not Found"));
    }


    public List<Patron> getPatrons() {
        return patronRepository.findAll();
    }


    public Patron updatePatron(long patronId, Patron patron) {
        Patron existingPatron = this.getPatron(patronId);
        existingPatron.setName(patron.getName());
        existingPatron.setAddress(patron.getAddress());
        existingPatron.setPhone(patron.getPhone());
        patronRepository.save(existingPatron);
        return existingPatron;
    }


    public Patron deletePatron(long patronId) {
        Patron existingPatron = this.getPatron(patronId);
        patronRepository.deleteById(patronId);
        return existingPatron;
    }


}
