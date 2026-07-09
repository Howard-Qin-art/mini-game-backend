package com.example.minigame.repository;

import com.example.minigame.entity.GameRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRecordRepository extends JpaRepository<GameRecord, Long> {
    @Query("SELECT gr FROM GameRecord gr JOIN FETCH gr.user WHERE gr.user.id = :userId")
    List<GameRecord> findByUserIdWithUser(@Param("userId") Long userId);
    
    @Query("SELECT gr FROM GameRecord gr JOIN FETCH gr.user WHERE gr.user.id = :userId AND gr.gameType = :gameType")
    List<GameRecord> findByUserIdAndGameTypeWithUser(@Param("userId") Long userId, @Param("gameType") String gameType);
    
    @Query("SELECT gr FROM GameRecord gr JOIN FETCH gr.user WHERE gr.gameType = :gameType ORDER BY gr.score DESC")
    List<GameRecord> findTop10ByGameTypeOrderByScoreDescWithUser(@Param("gameType") String gameType);
    
    @Query("SELECT gr FROM GameRecord gr JOIN FETCH gr.user WHERE gr.user.id = :userId ORDER BY gr.createdAt DESC")
    List<GameRecord> findTop5ByUserIdOrderByCreatedAtDescWithUser(@Param("userId") Long userId);
    
    List<GameRecord> findByUserId(Long userId);
    List<GameRecord> findByUserIdAndGameType(Long userId, String gameType);
    List<GameRecord> findTop10ByGameTypeOrderByScoreDesc(String gameType);
    List<GameRecord> findTop5ByUserIdOrderByCreatedAtDesc(Long userId);
}