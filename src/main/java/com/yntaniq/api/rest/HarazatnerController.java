package com.yntaniq.api.rest;

import com.yntaniq.domain.Harazatner;
import com.yntaniq.service.HarazatnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/das/v1/harazatner")
public class HarazatnerController {

    @Autowired
    private HarazatnerService harazatnerService;

    @RequestMapping(method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Harazatner>> getAll() {
        Collection<Harazatner> harazatners = harazatnerService.getAllHarazatner();
        if(harazatners == null)  {
            harazatners = new ArrayList<>();
        }
        return new ResponseEntity<Collection<Harazatner>>(harazatners, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getHarazatneriAndam( @PathVariable("id") Long id) {
        Harazatner harazatner = harazatnerService.getHarazatner(id);
        if(harazatner == null)  {
            return new ResponseEntity<String>("ID NOT FOUND", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Harazatner>(harazatner, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setHarazatneriAndam( @RequestBody Harazatner harazatner) {
        Harazatner retHarazatner = harazatnerService.createHarazatner(harazatner);
        if(retHarazatner == null)  {
            return new ResponseEntity<String>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Harazatner>(retHarazatner, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateHarazatneriAndam(  @PathVariable("id") Long id, @RequestBody Harazatner rharazatner) {
        Harazatner harazatner = harazatnerService.getHarazatner(id);

        if(harazatner == null){
            return new ResponseEntity<Harazatner>(HttpStatus.NOT_FOUND );
        }
        harazatner.mofify(rharazatner);
        harazatnerService.updateHarazatner(harazatner);

        return new ResponseEntity<Harazatner>(harazatner, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Harazatner> deleteHarazatneriAndam(  @PathVariable("id") Long id) {
        Harazatner harazatner = harazatnerService.getHarazatner(id);
        if(harazatner == null){
            return new ResponseEntity<Harazatner>( HttpStatus.NOT_FOUND );
        }
        harazatnerService.deleteHarazatner(id);
        return new ResponseEntity<Harazatner>(harazatner, HttpStatus.OK);
    }

}
