package com.example.minigame.controller;

import com.example.minigame.dto.GameRecordDTO;
import com.example.minigame.dto.GameRecordRequest;
import com.example.minigame.dto.LeaderboardDTO;
import com.example.minigame.service.GameRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/records")
@CrossOrigin(origins = "*")
public class GameRecordController {

    @Autowired
    private GameRecordService gameRecordService;

    @PostMapping
    public ResponseEntity<?> saveRecord(@RequestBody GameRecordRequest request) {
        try {
            GameRecordDTO record = gameRecordService.saveRecord(
                    request.getUserId(),
                    request.getGameType(),
                    request.getScore(),
                    request.getTimeSeconds(),
                    request.getStars()
            );
            return ResponseEntity.ok(record);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GameRecordDTO>> getRecordsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(gameRecordService.getRecordsByUserId(userId));
    }

    @GetMapping("/user/{userId}/game/{gameType}")
    public ResponseEntity<List<GameRecordDTO>> getRecordsByUserIdAndGameType(
            @PathVariable Long userId,
            @PathVariable String gameType) {
        return ResponseEntity.ok(gameRecordService.getRecordsByUserIdAndGameType(userId, gameType));
    }

    @GetMapping("/leaderboard/{gameType}")
    public ResponseEntity<List<GameRecordDTO>> getLeaderboard(@PathVariable String gameType) {
        return ResponseEntity.ok(gameRecordService.getLeaderboard(gameType));
    }

    @GetMapping("/user/{userId}/recent")
    public ResponseEntity<List<GameRecordDTO>> getRecentRecords(@PathVariable Long userId) {
        return ResponseEntity.ok(gameRecordService.getRecentRecords(userId));
    }

    @GetMapping("/global-leaderboard")
    public ResponseEntity<List<LeaderboardDTO>> getGlobalLeaderboard() {
        return ResponseEntity.ok(gameRecordService.getGlobalLeaderboard());
    }
}