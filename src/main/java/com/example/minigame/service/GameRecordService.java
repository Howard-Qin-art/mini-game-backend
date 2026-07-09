package com.example.minigame.service;

import com.example.minigame.dto.GameRecordDTO;
import com.example.minigame.dto.LeaderboardDTO;
import com.example.minigame.entity.GameRecord;
import com.example.minigame.entity.User;
import com.example.minigame.repository.GameRecordRepository;
import com.example.minigame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameRecordService {

    @Autowired
    private GameRecordRepository gameRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public GameRecordDTO saveRecord(Long userId, String gameType, Integer score, Integer timeSeconds, Integer stars) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("用户不存在"));

        GameRecord record = new GameRecord(user, gameType, score, timeSeconds, stars);
        GameRecord savedRecord = gameRecordRepository.save(record);

        userService.updateUserScore(userId, score);

        return convertToDTO(savedRecord);
    }

    public List<GameRecordDTO> getRecordsByUserId(Long userId) {
        return gameRecordRepository.findByUserIdWithUser(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<GameRecordDTO> getRecordsByUserIdAndGameType(Long userId, String gameType) {
        return gameRecordRepository.findByUserIdAndGameTypeWithUser(userId, gameType).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<GameRecordDTO> getLeaderboard(String gameType) {
        return gameRecordRepository.findTop10ByGameTypeOrderByScoreDescWithUser(gameType).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<GameRecordDTO> getRecentRecords(Long userId) {
        return gameRecordRepository.findTop5ByUserIdOrderByCreatedAtDescWithUser(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<LeaderboardDTO> getGlobalLeaderboard() {
        List<User> users = userRepository.findAll();
        users.sort((u1, u2) -> Integer.compare(u2.getTotalScore(), u1.getTotalScore()));

        List<LeaderboardDTO> leaderboard = new ArrayList<>();
        int rank = 1;
        for (User user : users) {
            leaderboard.add(new LeaderboardDTO(
                    user.getId(),
                    user.getUsername(),
                    user.getTotalScore(),
                    user.getGamesPlayed(),
                    rank++
            ));
        }
        return leaderboard;
    }

    private GameRecordDTO convertToDTO(GameRecord record) {
        return new GameRecordDTO(
                record.getId(),
                record.getUser().getId(),
                record.getGameType(),
                record.getScore(),
                record.getTimeSeconds(),
                record.getStars(),
                record.getCreatedAt()
        );
    }
}