package com.project.track_yourself.Controller;

import com.project.track_yourself.Entity.Memory;
import com.project.track_yourself.Service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/track")
@CrossOrigin(origins = "http://localhost:3000")
public class TrackController {

    @Autowired
    TrackService trackService;

    @GetMapping("/memories")
    public ResponseEntity<List<Memory>> getAllMemories(){
        return new ResponseEntity<> (trackService.getAllMemories() , HttpStatus.OK);
    }

    @GetMapping("/memories/{id}")
    public ResponseEntity<Memory> getMemory(@PathVariable Long id){
        Optional<Memory> memory_store = trackService.getMemory(id);
        if(memory_store.isPresent()){
            return new ResponseEntity<>(memory_store.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(memory_store.get() , HttpStatus.NOT_FOUND);

    }

    @GetMapping("/memories/month/{id}")
    public ResponseEntity<List<Memory>> getMemoryByMonth(@PathVariable int id){
        List<Memory> memories = trackService.getMemoryByMonth(id);
        if (memories.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(memories , HttpStatus.OK);
    }

    @PostMapping("/memories")
    public ResponseEntity<String> addMemory(@RequestBody Memory memory){
        trackService.addMemory(memory);
        return ResponseEntity.ok("Added successfully");

    }

    @DeleteMapping("/memories/{id}")
    public ResponseEntity<String > deleteMemory(@PathVariable  Long id){
        try{
            trackService.deleteMemory(id);
            return ResponseEntity.ok("Deleted Successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }

    @PutMapping("/memories/{id}")
    public ResponseEntity<String> putMemory(@PathVariable Long id, @RequestBody Memory memory){
        try{
            trackService.updateMemory(id,memory);
            return ResponseEntity.ok("Memory updated successfully");
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }


    }

    @DeleteMapping("/memories/deleteAll")
    public ResponseEntity<String> deleteAllMemory(){
        trackService.deleteAllMemory();
        return new ResponseEntity<>("Deleted succesfully", HttpStatus.OK);
    }


}
