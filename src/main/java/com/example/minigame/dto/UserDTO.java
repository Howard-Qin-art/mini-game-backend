package com.example.minigame.dto;

public class UserDTO {
    private Long id;
    private String username;
    private Integer totalScore;
    private Integer gamesPlayed;

    public UserDTO() {}

    public UserDTO(Long id, String username, Integer totalScore, Integer gamesPlayed) {
        this.id = id;
        this.username = username;
        this.totalScore = totalScore;
        this.gamesPlayed = gamesPlayed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}