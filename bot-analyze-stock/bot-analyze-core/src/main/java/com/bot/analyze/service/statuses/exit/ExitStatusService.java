package com.bot.analyze.service.statuses.exit;

import com.game.bot.entity.UserInfo;
import com.game.bot.entity.enums.UserStatusEnum;
import com.game.bot.service.UserService;
import com.game.bot.service.statuses.chatting.JustChattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.game.bot.entity.enums.UserStatusEnum.EXIT;

@Service
public class ExitStatusService extends JustChattingService {

    @Autowired
    private UserService userService;

    @Override
    public UserStatusEnum getSupportedStatus() {
        return EXIT;
    }

    @Override
    public Optional<String> getResponse(UserInfo userInfo, String userMessage) {
        return super.getResponse(userInfo, userMessage);
    }
}
