package me.grishka.houseclub.api.methods;

import java.util.ArrayList;
import java.util.List;

import me.grishka.houseclub.api.ClubhouseAPIRequest;
import me.grishka.houseclub.api.model.Channel;

public class CreateChannel extends ClubhouseAPIRequest<Channel> {

	public CreateChannel(Boolean is_social_mode, Boolean is_private, String topic) {
		super("POST", "create_channel", Channel.class);
		requestBody = new Body(is_social_mode, is_private, topic);
	}

	private static class Body {
		public Boolean is_social_mode;
		public Boolean is_private;
		public String club_id;
		public List<Integer> user_ids;
		public String event_id;
		public String topic;
		
		public Body(Boolean is_social_mode, Boolean is_private, String topic) {
			this.is_social_mode = is_social_mode;
			this.is_private = is_private;
			this.club_id = null;
			this.user_ids = new ArrayList<>();
			this.event_id = null;
			this.topic = topic;
		}
	}

}