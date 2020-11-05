package com.bot.analyze.service;


import com.bot.analyze.dto.UserInfo;
import com.bot.analyze.dto.UserStatusEnum;
import com.bot.analyze.entity.BotUser;
import com.bot.analyze.repository.UserRepository;
import com.bot.analyze.service.statuses.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.bot.analyze.dto.UserStatusEnum.WRITE_CURRENCY_TO_USE;

@Service
public class ChatProcessingService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private List<StatusService> statusServices;

    @Transactional
    public String createResponseForUser(UserInfo userInfo, String userMessage){
        Optional<BotUser> foundOptionalUser = userRepository.findByUserIdAndSource(userInfo.getUserId(), userInfo.getSource());
        BotUser foundBotUser;
        if (!foundOptionalUser.isPresent()){
            userService.createAndSave(userInfo);
            return buildResponseMessageForNewUser(userInfo, userMessage);
        } else {
            foundBotUser = foundOptionalUser.get();
            if (userInfo.getNewStatus() != null){
                foundBotUser.getChatStatus().setStatus(userInfo.getNewStatus());
            }
            //if user exists but currency is null, it means that user are registered but didn't provide his currency
            if (foundBotUser.getUserCurrency() == null && !WRITE_CURRENCY_TO_USE.equals(foundBotUser.getChatStatus().getStatus())){
                foundBotUser.getChatStatus().setStatus(UserStatusEnum.WRITE_CURRENCY_TO_USE_IF_DIDNOT_FILL);
            }
            userService.saveUser(foundBotUser);
            return buildResponseMessage(userInfo, userMessage, foundBotUser);
        }
    }

    private String buildResponseMessage(UserInfo userInfo, String userMessage, BotUser foundBotUser) {
        UserStatusEnum status = foundBotUser.getChatStatus().getStatus();
        Optional<StatusService> foundServiceForStatus = statusServices.stream().filter(statusService -> statusService.getSupportedStatus().equals(status)).findFirst();
        if (foundServiceForStatus.isPresent()) {
            StatusService statusService = foundServiceForStatus.get();
            return statusService.getResponse(userInfo, userMessage);
        } else {
            throw new IllegalArgumentException(String.format("Service for status %s not found!", status));
        }
    }

    private String buildResponseMessageForNewUser(UserInfo userInfo, String userMessage) {
        UserStatusEnum status = UserStatusEnum.NEW_USER_REGISTRATION;
        Optional<StatusService> foundServiceForStatus = statusServices.stream().filter(statusService -> statusService.getSupportedStatus().equals(status)).findFirst();
        if (foundServiceForStatus.isPresent()) {
            StatusService statusService = foundServiceForStatus.get();
            return statusService.getResponse(userInfo, userMessage);
        } else {
            throw new IllegalArgumentException(String.format("Service for status %s not found!", status));
        }
    }
}
