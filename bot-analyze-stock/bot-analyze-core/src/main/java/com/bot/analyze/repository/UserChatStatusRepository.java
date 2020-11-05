package com.bot.analyze.repository;


import com.bot.analyze.entity.UserChatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChatStatusRepository extends JpaRepository<UserChatStatus, Long> {
}
