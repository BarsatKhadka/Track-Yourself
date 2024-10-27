package com.project.track_yourself.Repository;

import com.project.track_yourself.Entity.Memory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Memory, Long> {
    List<Memory> findByMonth(int month);

    @Modifying
    @Query("DELETE FROM Memory")
    @Transactional
    void deleteAllMemory();


}
