package com.project.track_yourself.Service;

import com.project.track_yourself.Entity.Memory;
import com.project.track_yourself.Repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {

    @Autowired
    TrackRepository trackRepository;

    public List<Memory> getAllMemories(){
        return trackRepository.findAll();
    }

    public Optional<Memory> getMemory(Long id){
        Optional<Memory> findMemory = trackRepository.findById(id);
        return findMemory;
    }

    public Memory addMemory(Memory memory){
        return trackRepository.save(memory);
    }



    public void deleteMemory(Long id){
        Memory memory = trackRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        trackRepository.delete(memory);
    }

    public void updateMemory(Long id , Memory memory){
        Memory existingMemory = trackRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not found to update"));
        existingMemory.setId(id);
        existingMemory.setTime(memory.getTime());
        existingMemory.setDescription(memory.getDescription());
        trackRepository.save(existingMemory);
    }

    public List<Memory> getMemoryByMonth(int month){
        return trackRepository.findByMonth(month);
    }

        public void deleteAllMemory(){
            trackRepository.deleteAll();
        }





}
