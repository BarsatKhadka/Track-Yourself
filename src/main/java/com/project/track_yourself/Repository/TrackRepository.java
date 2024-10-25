package com.project.track_yourself.Repository;

import com.project.track_yourself.Entity.Memory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Memory, Long> {

}
