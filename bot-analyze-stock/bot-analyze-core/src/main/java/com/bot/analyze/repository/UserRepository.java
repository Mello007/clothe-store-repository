package com.bot.analyze.repository;


import com.bot.analyze.dto.SourceEnum;
import com.bot.analyze.entity.BotUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<BotUser, Long> {

    Optional<BotUser> findByUserIdAndSource(String userId, SourceEnum sourceEnum);

}
