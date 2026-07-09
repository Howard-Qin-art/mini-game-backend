package com.example.minigame.dto;

public class LeaderboardDTO {
    private Long userId;
    private String username;
    private Integer totalScore;
    private Integer gamesPlayed;
    private Integer rank;

    public LeaderboardDTO() {}

    public LeaderboardDTO(Long userId, String username, Integer totalScore, Integer gamesPlayed, Integer rank) {
        this.userId = userId;
        this.username = username;
        this.totalScore = totalScore;
        this.gamesPlayed = gamesPlayed;
        this.rank = rank;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}