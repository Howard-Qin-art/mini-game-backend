package com.example.minigame.dto;

import java.time.LocalDateTime;

public class GameRecordDTO {
    private Long id;
    private Long userId;
    private String gameType;
    private Integer score;
    private Integer timeSeconds;
    private Integer stars;
    private LocalDateTime createdAt;

    public GameRecordDTO() {}

    public GameRecordDTO(Long id, Long userId, String gameType, Integer score, Integer timeSeconds, Integer stars, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.gameType = gameType;
        this.score = score;
        this.timeSeconds = timeSeconds;
        this.stars = stars;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTimeSeconds() {
        return timeSeconds;
    }

    public void setTimeSeconds(Integer timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}