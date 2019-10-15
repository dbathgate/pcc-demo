package io.pivotal.pccdemo.controller;

import io.pivotal.pccdemo.dao.StuffDao;
import io.pivotal.pccdemo.model.Stuff;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stuff")
@Slf4j
public class StuffController {

    @Autowired
    private StuffDao stuffDao;


    @PostMapping
    public ResponseEntity<Stuff> postStuff(@RequestBody Stuff stuff) {
        log.info("Stuff: {}", stuff);
        stuffDao.save(stuff);
        return ResponseEntity.ok(stuff);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stuff> getStuff(@PathVariable("id") String stuffId) {
        Optional<Stuff> stuff = stuffDao.findById(stuffId);

        if (!stuff.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(stuff.get());
    }
}
