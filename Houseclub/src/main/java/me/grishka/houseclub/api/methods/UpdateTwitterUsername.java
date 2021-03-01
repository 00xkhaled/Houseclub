package me.grishka.houseclub.api.methods;

import me.grishka.houseclub.api.BaseResponse;
import me.grishka.houseclub.api.ClubhouseAPIRequest;

public class UpdateTwitterUsername extends ClubhouseAPIRequest<BaseResponse> {
    public UpdateTwitterUsername(String username, String twitter_token, String twitter_secret) {
        super("POST", "update_twitter_username", BaseResponse.class);
        requestBody = new Body(username, twitter_token, twitter_secret);
    }

    private static class Body{
        public String username;
        public String twitter_token;
        public String twitter_secret;
        Body(String username, String twitter_token, String twitter_secret){
            this.username = username;
            this.twitter_token = twitter_token;
            this.twitter_secret = twitter_secret;
        }
    }
}