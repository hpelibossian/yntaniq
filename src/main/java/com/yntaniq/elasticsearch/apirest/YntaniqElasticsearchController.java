package com.yntaniq.elasticsearch.apirest;

import com.yntaniq.elasticsearch.service.YntaniqElasticsearchService;
import com.yntaniq.elasticsearch.domain.YntaniqElasticsearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/das/v1/elasticsearch/yntaniq")
public class YntaniqElasticsearchController {

    @Autowired
    private YntaniqElasticsearchService yntaniqElasticsearchService;

    @RequestMapping(method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<YntaniqElasticsearch>> getAll() {
        Collection<YntaniqElasticsearch> yntaniqElasticsearchs = yntaniqElasticsearchService.findAll();
        if(yntaniqElasticsearchs == null)  {
            yntaniqElasticsearchs = new ArrayList<>();
        }
        return new ResponseEntity<Collection<YntaniqElasticsearch>>(yntaniqElasticsearchs, HttpStatus.OK);
    }

    @RequestMapping(value = "/{anun}", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<YntaniqElasticsearch>>  getYntaniqiAndam( @PathVariable("anun") String anun) {
        Collection<YntaniqElasticsearch> yntaniq = yntaniqElasticsearchService.findByAnun(anun);
        if(yntaniq == null)  {
            return new ResponseEntity<Collection<YntaniqElasticsearch>>(yntaniq, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Collection<YntaniqElasticsearch>>(yntaniq,  HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setYntaniqiAndam( @RequestBody YntaniqElasticsearch yntaniq) {
        YntaniqElasticsearch retYntaniq = yntaniqElasticsearchService.add(yntaniq);
        if(retYntaniq == null)  {
            return new ResponseEntity<String>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<YntaniqElasticsearch>(retYntaniq, HttpStatus.OK);
    }

}
