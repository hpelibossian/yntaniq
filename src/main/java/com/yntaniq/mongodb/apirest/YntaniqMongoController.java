package com.yntaniq.mongodb.apirest;

import com.yntaniq.mongodb.repository.YntaniqMongoRepository;
import com.yntaniq.mongodb.domain.YntaniqMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/das/v1/mongo/yntaniq")
public class YntaniqMongoController {

    @Autowired
    private YntaniqMongoRepository yntaniqMongoRepository;

    @RequestMapping(method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<YntaniqMongo>> getAll() {
        Collection<YntaniqMongo> yntaniqMongos = yntaniqMongoRepository.findAll();
        if(yntaniqMongos == null)  {
            yntaniqMongos = new ArrayList<>();
        }
        return new ResponseEntity<Collection<YntaniqMongo>>(yntaniqMongos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<YntaniqMongo> create(@RequestBody YntaniqMongo user) {
        yntaniqMongoRepository.save(user);
        return new ResponseEntity<YntaniqMongo>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<YntaniqMongo> deleteYntaniqiAndam(  @PathVariable("id") String id) {
        if(!yntaniqMongoRepository.exists(id)) {
            return new ResponseEntity<YntaniqMongo>(HttpStatus.NOT_FOUND);
        }
        yntaniqMongoRepository.delete(id);
        return new ResponseEntity<YntaniqMongo>(HttpStatus.OK);
        /*
        YntaniqMongo yntaniq = yntaniqMongoRepository.getYntaniq(id);
        if(yntaniq == null){
            return new ResponseEntity<YntaniqMongo>( HttpStatus.NOT_FOUND );
        }*/
    }

    /*
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
    }*/

}
