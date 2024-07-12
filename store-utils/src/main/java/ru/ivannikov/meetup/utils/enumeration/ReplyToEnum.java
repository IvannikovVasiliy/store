package ru.ivannikov.meetup.utils.enumeration;

public enum ReplyToEnum {
    ORDER_REPLY("order-reply-to-topic");

    String replyTo;

    ReplyToEnum(String replyTo) {
        this.replyTo = replyTo;
    }
}
