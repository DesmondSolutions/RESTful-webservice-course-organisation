package com.desmond.springboot.resource;


import com.desmond.springboot.entity.InstructorDetails;
import com.desmond.springboot.service.InstructorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructorDetails")
public class InstructorDetailsController {

    private InstructorDetailsService instructorDetailsService;
    @Autowired
    public InstructorDetailsController(InstructorDetailsService instructorDetailsService) {
        this.instructorDetailsService = instructorDetailsService;
    }

    @PostMapping
    public ResponseEntity<InstructorDetails> addDetails(@RequestBody InstructorDetails details){
        return  new ResponseEntity<>(instructorDetailsService.saveInstructorDetails(details), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InstructorDetails>> getAllDetails(){
        return new ResponseEntity<List<InstructorDetails>>(instructorDetailsService.getAllInstructorDetails(), HttpStatus.OK);
    }

    @GetMapping("/{instructorDetailsId}")
    public ResponseEntity<InstructorDetails> getDetail(@PathVariable("instructorDetailsId") final int id){
     return new ResponseEntity<>(instructorDetailsService.getInstructorDetailsById(id), HttpStatus.OK);
    }
    @PutMapping("/{instructorDetailsId}")
    public ResponseEntity<InstructorDetails> updateDetails(@PathVariable("instructorDetailsId") final int id, @RequestBody InstructorDetails details){
        return new ResponseEntity<>(instructorDetailsService.editInstructorDetails(id, details), HttpStatus.OK);
    }

    @DeleteMapping("/{instructorDetailsId}")
    public ResponseEntity<InstructorDetails> deleteDetails(@PathVariable("instructorDetailsId") final int id){
        return new ResponseEntity<>(instructorDetailsService.deleteInstructorDetails(id), HttpStatus.OK);
    }

}
