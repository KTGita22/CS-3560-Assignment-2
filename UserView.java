package mini_twitter;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserView 
{
	private VBox menuBox;

	private UserView(User user, UserGroup rootGroup) 
	{
		Alert informationAlertWindow = new Alert(Alert.AlertType.INFORMATION);
		
		// Create text field and button to follow a user.
		TextField userIDText = new TextField();
		userIDText.setPromptText("Enter User ID");
		Button followBtn = new Button();
		followBtn.setText("Follow User");

		// Create list to display user followers.
		ListView followerList = new ListView(user.getFollowingList());
		followerList.setMaxWidth(575);
		followerList.setPrefHeight(75);

		// Create text field and button to write and post message.
		TextArea writeTweet = new TextArea();
		writeTweet.setWrapText(true);
		writeTweet.setPrefSize(300, 75);
		writeTweet.setPromptText("What's happening?");
		Button postTweetBtn = new Button();
		postTweetBtn.setText("Post Tweet");
		
		// Create list to display news feed of all user and followers' messages.
		ListView newsFeedList = new ListView(user.getNewsFeedList());
		newsFeedList.setMaxWidth(575);
		newsFeedList.setPrefHeight(115);

		// Create labels.
		Label newsFeedLbl = new Label("News Feed");
		Label currentlyFollowingLbl = new Label("Currently Following");
		Label userCreationTimeLbl = new Label("User's Creation Time: " + user.getCreationTime());
		
		newsFeedLbl.setStyle("-fx-font-weight: bold");
		currentlyFollowingLbl.setStyle("-fx-font-weight: bold");
		userCreationTimeLbl.setStyle("-fx-font-weight: bold");

		// Conditions for followBtn.
		followBtn.setOnAction((ActionEvent event) -> 
		{
			String newUserFollowerRequest = userIDText.getText();
			User checkFollow = rootGroup.getUser(newUserFollowerRequest);
			
			// Display alert that user cannot follow themselves.
			if (checkFollow == user) 
			{
				informationAlertWindow.setContentText("Unable to follow yourself.");
				informationAlertWindow.showAndWait();

			}
			
			// Display alert that given user cannot be found.
			else if (checkFollow == null) 
			{
				informationAlertWindow.setContentText("Unable to find user.");
				informationAlertWindow.showAndWait();
			}
			
			// Otherwise follow given user.
			else 
			{
				checkFollow.attach(user);
				user.addFollowingList(checkFollow);
			}
			userIDText.clear();
		});

		// Post message when postTweetBtn is clicked.
		postTweetBtn.setOnAction((ActionEvent event) -> 
		{
			String newTweet = writeTweet.getText();
			user.tweetMessage(newTweet);
			writeTweet.clear();
		});

		// Organize all text boxes, buttons, labels, and lists.
		HBox followUserBox = new HBox(10, userIDText, followBtn);
		followUserBox.setPadding(new Insets(0, 0, 0, 20));
		HBox tweetBox = new HBox(10, writeTweet, postTweetBtn);
		tweetBox.setAlignment(Pos.CENTER);

		menuBox = new VBox(10, userCreationTimeLbl, followUserBox, currentlyFollowingLbl, followerList, tweetBox, newsFeedLbl,
				newsFeedList);
		menuBox.setPadding(new Insets(10, 0, 0, 10));
	}

	public VBox getMenuBox() 
	{
		return menuBox;
	}

	// Display window.
	public static void openUserUI(User user, UserGroup rootGroup) 
	{
		UserView userViewUI = new UserView(user, rootGroup);
		VBox menuBox = userViewUI.getMenuBox();

		Scene userScene = new Scene(menuBox, 600, 425);

		Stage userStage = new Stage();
		userStage.setTitle(user.getID() + "'s Twitter Account");
		userStage.setScene(userScene);
		userStage.getIcons().add(new Image("C:\\Users\\Manny\\eclipse-workspace\\MiniTwitter2.0\\src\\mini_twitter\\twitter_icon.png"));
		userStage.show();
	}
}
