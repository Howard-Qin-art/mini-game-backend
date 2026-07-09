package com.example.minigame.dto;

public class GameRecordRequest {
    private Long userId;
    private String gameType;
    private Integer score;
    private Integer timeSeconds;
    private Integer stars;

    public GameRecordRequest() {}

    public GameRecordRequest(Long userId, String gameType, Integer score, Integer timeSeconds, Integer stars) {
        this.userId = userId;
        this.gameType = gameType;
        this.score = score;
        this.timeSeconds = timeSeconds;
        this.stars = stars;
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
}