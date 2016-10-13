package com.yntaniq.api.rest;

import com.yntaniq.domain.Ynkerner;
import com.yntaniq.service.YnkernerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/das/v1/ynkerner")
public class YnkernerController {

    @Autowired
    private YnkernerService ynkernerService;

    @RequestMapping(method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Ynkerner>> getAll() {
        Collection<Ynkerner> ynkerners = ynkernerService.getAllYnkerner();
        if(ynkerners == null)  {
            ynkerners = new ArrayList<>();
        }
        return new ResponseEntity<Collection<Ynkerner>>(ynkerners, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getYnkerneriAndam( @PathVariable("id") Long id) {
        Ynkerner ynkerner = ynkernerService.getYnkerner(id);
        if(ynkerner == null)  {
            return new ResponseEntity<String>("ID NOT FOUND", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Ynkerner>(ynkerner, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setYnkerneriAndam( @RequestBody Ynkerner ynkerner) {
        Ynkerner retYnkerner = ynkernerService.createYnkerner(ynkerner);
        if(retYnkerner == null)  {
            return new ResponseEntity<String>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Ynkerner>(retYnkerner, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateYnkerneriAndam(  @PathVariable("id") Long id, @RequestBody Ynkerner rynkerner) {
        Ynkerner ynkerner = ynkernerService.getYnkerner(id);

        if(ynkerner == null){
            return new ResponseEntity<Ynkerner>(HttpStatus.NOT_FOUND );
        }
        ynkerner.mofify(rynkerner);
        ynkernerService.updateYnkerner(ynkerner);

        return new ResponseEntity<Ynkerner>(ynkerner, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Ynkerner> deleteYnkerneriAndam(  @PathVariable("id") Long id) {
        Ynkerner ynkerner = ynkernerService.getYnkerner(id);
        if(ynkerner == null){
            return new ResponseEntity<Ynkerner>( HttpStatus.NOT_FOUND );
        }
        ynkernerService.deleteYnkerner(id);
        return new ResponseEntity<Ynkerner>(ynkerner, HttpStatus.OK);
    }

}
