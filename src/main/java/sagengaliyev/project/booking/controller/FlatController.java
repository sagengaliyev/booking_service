package sagengaliyev.project.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sagengaliyev.project.booking.dto.FlatDTO;
import sagengaliyev.project.booking.model.Flat;
import sagengaliyev.project.booking.service.FlatService;

import java.util.List;

@RestController
@RequestMapping("/flats")
public class FlatController {
    private final FlatService flatService;

    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    @GetMapping("/show")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<FlatDTO>> getFlats(){
        List<FlatDTO> flats = flatService.getInfo();
        return new ResponseEntity<>(flats, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Integer> deleteFlat(@RequestBody FlatDTO flatDTO){
        flatService.deleteById(flatDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/add",consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> addFlat(@RequestBody FlatDTO flatDTO){
        flatService.addFlat(flatDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/update",consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> updateFlat(@RequestBody FlatDTO flatDTO){
        flatService.updateById(flatDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/personal",consumes = "application/json")
    @ResponseBody
    public ResponseEntity<List<Flat>> showById(@RequestBody FlatDTO flatDTO){
        List<Flat> flat = flatService.getFlatById(flatDTO);
        if(!flat.isEmpty()) {
            return new ResponseEntity<>(flat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


}
