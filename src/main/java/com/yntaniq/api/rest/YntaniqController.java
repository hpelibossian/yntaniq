package com.yntaniq.api.rest;

import com.yntaniq.domain.Yntaniq;
import com.yntaniq.service.YntaniqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/das/v1/yntaniq")
public class YntaniqController {

    @Autowired
    private YntaniqService yntaniqService;

    @RequestMapping(method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Yntaniq>> getAll() {
        Collection<Yntaniq> yntaniqs = yntaniqService.getAllYntaniq();
        if(yntaniqs == null)  {
            yntaniqs = new ArrayList<>();
        }
        return new ResponseEntity<Collection<Yntaniq>>(yntaniqs, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getYntaniqiAndam( @PathVariable("id") Long id) {
        Yntaniq yntaniq = yntaniqService.getYntaniq(id);
        if(yntaniq == null)  {
            return new ResponseEntity<String>("ID NOT FOUND", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Yntaniq>(yntaniq, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setYntaniqiAndam( @RequestBody Yntaniq yntaniq) {
        Yntaniq retYntaniq = yntaniqService.createYntaniq(yntaniq);
        if(retYntaniq == null)  {
            return new ResponseEntity<String>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Yntaniq>(retYntaniq, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateYntaniqiAndam(  @PathVariable("id") Long id, @RequestBody Yntaniq ryntaniq) {
        Yntaniq yntaniq = yntaniqService.getYntaniq(id);

        if(yntaniq == null){
            return new ResponseEntity<Yntaniq>(HttpStatus.NOT_FOUND );
        }
        yntaniq.mofify(ryntaniq);
        yntaniqService.updateYntaniq(yntaniq);

        return new ResponseEntity<Yntaniq>(yntaniq, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Yntaniq> deleteYntaniqiAndam(  @PathVariable("id") Long id) {
        Yntaniq yntaniq = yntaniqService.getYntaniq(id);
        if(yntaniq == null){
            return new ResponseEntity<Yntaniq>( HttpStatus.NOT_FOUND );
        }
        yntaniqService.deleteYntaniq(id);
        return new ResponseEntity<Yntaniq>(yntaniq, HttpStatus.OK);
    }

}
