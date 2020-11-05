package com.bot.analyze.service;

import com.bot.analyze.dto.LocalizationEnum;
import com.bot.analyze.dto.UserInfo;
import com.bot.analyze.dto.UserStatusEnum;
import com.bot.analyze.entity.BotUser;
import com.bot.analyze.entity.UserChatStatus;
import com.bot.analyze.repository.UserChatStatusRepository;
import com.bot.analyze.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserChatStatusRepository userChatStatusRepository;
    @Transactional
    public BotUser createAndSave(UserInfo userInfo){
        BotUser botUser = new BotUser();
        botUser.setSource(userInfo.getSource());
        botUser.setUserId(userInfo.getUserId());
        botUser.setChatId(userInfo.getChatId());
        botUser.setName(userInfo.getUserName());
        BotUser save = userRepository.save(botUser);
        UserChatStatus userChatStatus = createChatStatus(userInfo, save);
        save.setChatStatus(userChatStatus);
        userChatStatusRepository.save(userChatStatus);
        return save;
    }

    @Transactional
    public void updateStatusForUser(UserStatusEnum newStatus, UserInfo userInfo) {
        Optional<BotUser> foundUserOptional = userRepository.findByUserIdAndSource(userInfo.getUserId(), userInfo.getSource());
        if (foundUserOptional.isPresent()){
            BotUser botUser = foundUserOptional.get();
            UserChatStatus chatStatus = botUser.getChatStatus();
            chatStatus.setStatus(newStatus);
            chatStatus.setBotUser(botUser);
            userChatStatusRepository.save(chatStatus);
        } else {
            throw new IllegalStateException("Cannot find user with user id: " + userInfo.getUserId() + " and user name: " + userInfo.getUserName());
        }
    }

    @Transactional
    public void updateStatusForUser(UserStatusEnum newStatus, String statusMessage, UserInfo userInfo) {
        Optional<BotUser> foundUserOptional = userRepository.findByUserIdAndSource(userInfo.getUserId(), userInfo.getSource());
        if (foundUserOptional.isPresent()){
            BotUser botUser = foundUserOptional.get();
            UserChatStatus chatStatus = botUser.getChatStatus();
            chatStatus.setStatus(newStatus);
            chatStatus.setBotUser(botUser);
            chatStatus.setStatusMessage(statusMessage);
            userChatStatusRepository.save(chatStatus);
        } else {
            throw new IllegalStateException("Cannot find user with user id: " + userInfo.getUserId() + " and user name: " + userInfo.getUserName());
        }
    }

    @Transactional
    public void updateStatusForUser(UserStatusEnum newStatus, String statusMessage, BotUser botUser) {
        UserChatStatus chatStatus = botUser.getChatStatus();
        chatStatus.setStatus(newStatus);
        chatStatus.setStatusMessage(statusMessage);
        userChatStatusRepository.save(chatStatus);
    }

    @Transactional
    public void updateStatusForUser(UserStatusEnum newStatus, BotUser botUser) {
        UserChatStatus chatStatus = botUser.getChatStatus();
        chatStatus.setStatus(newStatus);
        chatStatus.setBotUser(botUser);
        userChatStatusRepository.save(chatStatus);
    }

    @Transactional
    public BotUser saveUser(BotUser userByBotUserInfo) {
        return userRepository.save(userByBotUserInfo);
    }

    @Transactional(readOnly = true)
    public BotUser getUserByUserInfo(UserInfo userInfo){
        return userRepository.findByUserIdAndSource(userInfo.getUserId(), userInfo.getSource()).orElseThrow(RuntimeException::new);
    }

    private UserChatStatus createChatStatus(UserInfo userInfo, BotUser save) {
        UserChatStatus userChatStatus = new UserChatStatus();
        userChatStatus.setStatus(userInfo.getNewStatus());
        userChatStatus.setBotUser(save);
        return userChatStatus;
    }

    @Transactional
    public void updateLocalizationForUser(LocalizationEnum localizationEnum, UserInfo userInfo) {
        Optional<BotUser> foundUserOptional = userRepository.findByUserIdAndSource(userInfo.getUserId(), userInfo.getSource());
        if (foundUserOptional.isPresent()){
            BotUser botUser = foundUserOptional.get();
            botUser.setLocalization(localizationEnum);
            userRepository.save(botUser);
        } else {
            log.error("Cannot find user with user id: " + userInfo.getUserId() + " and user name: " + userInfo.getUserName());
            throw new IllegalStateException("Cannot find user with user id: " + userInfo.getUserId() + " and user name: " + userInfo.getUserName());
        }
    }

    public String getUserLocale(UserInfo userInfo) {
        Optional<BotUser> foundUserOptional = userRepository.findByUserIdAndSource(userInfo.getUserId(), userInfo.getSource());
        if (foundUserOptional.isPresent()){
            BotUser botUser = foundUserOptional.get();
            return botUser.getLocalization().getLocalization();
        } else {
            log.error("Cannot find user with user id: " + userInfo.getUserId() + " and user name: " + userInfo.getUserName());
            return LocalizationEnum.EN.getLocalization();
        }
    }
}
