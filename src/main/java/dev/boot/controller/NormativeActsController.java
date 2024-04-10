package dev.boot.controller;


import dev.boot.dto.NormativeActDTO;
import dev.boot.service.NormativeActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/normative-acts")
public class NormativeActsController {
    private final NormativeActService normativeActService;

    @Autowired
    public NormativeActsController(NormativeActService normativeActService) {
        this.normativeActService = normativeActService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('PUBLIC')")
    public Optional<NormativeActDTO> findById(@PathVariable(name = "id") long id) {
        return normativeActService.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('PUBLIC')")

    public Iterable<NormativeActDTO> findAll() {
        return normativeActService.findAll();
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('CREATE_ACT')")

    public ResponseEntity<NormativeActDTO> save(@RequestBody NormativeActDTO normativeActsDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(normativeActService.save(normativeActsDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('EDIT_ACT')")

    public ResponseEntity<NormativeActDTO> update(@PathVariable(name = "id") Long id, @RequestBody NormativeActDTO normativeActDTO) {
        NormativeActDTO updated = normativeActService.update(id, normativeActDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('AMEND_ACT')")

    public ResponseEntity<NormativeActDTO> updateExistedAct(@PathVariable(name = "id") Long id,  @RequestBody NormativeActDTO normativeActDTO) {
        NormativeActDTO updated = normativeActService.update1(id,normativeActDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public void delete(@PathVariable(name = "id") long baseId){
        normativeActService.delete(baseId);
    }
}