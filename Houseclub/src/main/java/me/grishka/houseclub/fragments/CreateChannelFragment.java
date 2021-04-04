package me.grishka.houseclub.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import me.grishka.appkit.api.Callback;
import me.grishka.appkit.api.ErrorResponse;
import me.grishka.houseclub.MainActivity;
import me.grishka.houseclub.R;
import me.grishka.houseclub.api.ClubhouseSession;
import me.grishka.houseclub.api.methods.CreateChannel;
import me.grishka.houseclub.api.model.Channel;

public class CreateChannelFragment extends BaseToolbarFragment {

	private Button createRoomBtn;
	private EditText topicName;

	private RadioButton openMode, socialMode, privateMode;

	private boolean self;

	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		self=getArguments().getInt("id")==Integer.parseInt(ClubhouseSession.userID);
	}

	@Override
	public View onCreateContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View v=inflater.inflate(R.layout.create_channel, container, false);

		topicName = v.findViewById(R.id.topic_input);

		openMode = v.findViewById(R.id.open_mode_radio);
		socialMode = v.findViewById(R.id.social_mode_radio);
		privateMode = v.findViewById(R.id.private_mode_radio);

		createRoomBtn = v.findViewById(R.id.create_room_button);
		createRoomBtn.setOnClickListener(this::onCreateRoomClick);

		return v;
	}

	private void onCreateRoomClick(View v) {
		final String topic = topicName.getText().toString();
		final Boolean is_social_mode = socialMode.isChecked();
		final Boolean is_private = privateMode.isChecked();


		new CreateChannel(is_social_mode, is_private, topic)
				.wrapProgress(getContext())
				.setCallback(new Callback<Channel>() {
					@Override
					public void onSuccess(Channel result) {
						Toast.makeText(getContext(),
								"Channel with topic: ("+result.topic+") created",
								Toast.LENGTH_SHORT).show();
						((MainActivity)getActivity()).joinChannel(result.channel);
					}

					@Override
					public void onError(ErrorResponse error) {
						Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();
					}
				})
				.exec();
	}

}