package org.dysonpair.reps.web;

import org.dysonpair.reps.model.RepSet;
import org.dysonpair.reps.service.RepSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
public class RepSetController {

    private final RepSetService repSetService;

    @Autowired
    public RepSetController(RepSetService repSetService) {
        this.repSetService = repSetService;
    }

    @GetMapping(value = UrlSchema.REP_SET, produces = APPLICATION_JSON_VALUE)
    public List<RepSet> getAll() {
        return repSetService.getAll();
    }

    @PostMapping(value = UrlSchema.REP_SET, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public RepSet createRepSet(@RequestBody RepSet repSet) {
        return repSetService.create(repSet);
    }

    @CrossOrigin
    @DeleteMapping(value = UrlSchema.REP_SET, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteRepSet(@RequestBody RepSet repSet) {
        repSetService.delete(repSet);
    }
}
