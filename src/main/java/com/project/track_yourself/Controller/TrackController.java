package com.project.track_yourself.Controller;

import com.project.track_yourself.Entity.Memory;
import com.project.track_yourself.Service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    TrackService trackService;

    @GetMapping("/memories")
    public List<Memory> getAllMemories(){
        return trackService.getAllMemories();
    }

    @PostMapping("/memories")
    public String addMemory(@RequestBody Memory memory){
        trackService.addMemory(memory);
        return "Memory added successfully";

    }

    @DeleteMapping("/memories/{id}")
    public void deleteMemory(@PathVariable  Long id){
        trackService.deleteMemory(id);
    }

    @PutMapping("/memories/{id}")
    public String putMemory(@PathVariable Long id, @RequestBody Memory memory){
        trackService.updateMemory(id,memory);
        return "Memory updated successfully";

    }


}
