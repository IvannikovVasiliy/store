package ru.ivannikov.meetup.utils.enumeration;

public enum CommandTypeEnum {
    CREATE_ORDER("createOrder"), CREATE_RESTAURANT("createRestaurant");

    String commandType;

    CommandTypeEnum(String commandType) {
        this.commandType = commandType;
    }
}
