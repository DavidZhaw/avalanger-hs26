package ch.zhaw.avalanger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.avalanger.model.Avalange;
import ch.zhaw.avalanger.model.AvalangeCreateDTO;
import ch.zhaw.avalanger.model.AvalangeState;
import ch.zhaw.avalanger.repository.AvalangeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/avalange")
@RequiredArgsConstructor 
public class AvalangeController {
    private final AvalangeRepository avalangeRepository;

    @GetMapping({ "", "/{country}" })
    public ResponseEntity<List<Avalange>> getAllAvelanges(@PathVariable(required = false) String country,
            @RequestParam(required = false) AvalangeState state) {
        if (country != null && state != null) {
            return ResponseEntity.ok(avalangeRepository.findByCountryAndState(country, state));
        } else if (country != null) {
            return ResponseEntity.ok(avalangeRepository.findByCountry(country));
        } else if (state != null) {
            return ResponseEntity.ok(avalangeRepository.findByState(state));
        } else {
            return ResponseEntity.ok(avalangeRepository.findAll());
        }
    }

    @PostMapping 
    public ResponseEntity<Avalange> createAvalange(@RequestBody AvalangeCreateDTO avalange) {
        Avalange avalangeToSave = new Avalange(avalange.getCountry(), avalange.getDescription());
        Avalange savedAvalange = avalangeRepository.save(avalangeToSave);
        return ResponseEntity.ok(savedAvalange);
    }
}
