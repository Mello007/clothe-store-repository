package com.bot.analyze.dto;

public enum UserStatusEnum {

    START_WORK,

    /*
        General status
     */
    JUST_CHATTING,

    /*
        Subscribing to a game
     */
    //when user selects /sub command
    SUBSCRIBE_TO_GAME,
    //when user should write a game to subscribe
    WRITE_GAME_TO_SUBSCRIBE,
    //when user should write a price for game to subscribe
    WRITE_PRICE_FOR_GAME_TO_SUBSCRIBE,
    //when user should choice if he wants to track another game or not
    WRITE_DO_YOU_WANT_TO_TRACK_GAME,
    //when user should write a game number from list
    WRITE_GAME_NUMBER_TO_SUBSCRIBE,

    /*
        User discounts
     */
    SEE_MY_SUBSCRIPTIONS,
    WRITE_GAME_TO_EDIT,
    WRITE_OPERATION_TO_DO,
    WRITE_NEW_PRICE_FOR_GAME,

    /*
        Show game
     */
    SEARCH_GAME,
    WRITE_GAME_NUMBER_TO_SEE,

    //when user need to write a game for search
    WRITE_GAME_TO_SEARCH,
    //
    DO_YOU_WANT_TO_SEARCH_ANOTHER_GAME,


    /*
        register user
     */
    NEW_USER_REGISTRATION,
    WRITE_LOCALIZATION_TO_USE,
    WRITE_CURRENCY_TO_USE,
    //status for cases when user didn't fill the currency during registration
    WRITE_CURRENCY_TO_USE_IF_DIDNOT_FILL,

    //exit
    EXIT
}
