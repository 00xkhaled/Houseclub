package me.grishka.houseclub.api.model;

import java.util.Date;

public class Notification {
    public String notificationId;
    public boolean inUnread;
    public User userProfile;
    public String eventId;
    public int type;
    public Date timeCreated;
    public String message;
    public String channel;
//    public Channel channel;

    public static final int NOTIFICATION_TYPE_USER=1;
    public static final int NOTIFICATION_TYPE_EVENT=16;
}