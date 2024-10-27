package com.project.track_yourself.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Memory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime time;

    private int month;

    private String title;


    @PrePersist
    private void setTime(){
        this.time = LocalDateTime.now();
        this.month = this.time.getMonthValue();
    }

    @PreUpdate
    private void setMonth() {
        if(time !=null)
    {
        this.month = LocalDateTime.now().getMonthValue();
    }
}






    private String description;
}
