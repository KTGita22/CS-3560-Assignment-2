package mini_twitter;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AdminControlPanel 
{
	private static AdminControlPanel adminInstance;
	private HBox menuBox;

	public static AdminControlPanel getInstance() 
	{
		if (adminInstance == null) 
		{
			adminInstance = new AdminControlPanel();
		}

		return adminInstance;
	}

	private AdminControlPanel() 
	{
		final Image rootFolderPic = new Image(
				"C:\\Users\\Manny\\eclipse-workspace\\MiniTwitter2.0\\src\\mini_twitter\\folder_icon.png", 20, 20,
				false, false);
		UserGroup rootGroup = new UserGroup("Root");

		Alert informationAlertWindow = new Alert(Alert.AlertType.INFORMATION);

		// Add Tree view for users and group, along with folder icon
		TreeItem<CompositeTree> root = new TreeItem<>(rootGroup, new ImageView(rootFolderPic));
		root.setExpanded(true);
		TreeView<CompositeTree> treeView = new TreeView<>(root);

		// Create text field and button to add new user.
		Button addUserBtn = new Button();
		addUserBtn.setText("Add User");
		addUserBtn.setPrefSize(95, 25);
		TextField UserIDText = new TextField();
		UserIDText.setPromptText("Enter User ID");
		
		
		// Create text field and button to add new user group.
		Button addGroupBtn = new Button();
		addGroupBtn.setText("Add Group");
		addGroupBtn.setPrefSize(95, 25);
		TextField GroupIDText = new TextField();
		GroupIDText.setPromptText("Enter Group ID");
		
		
		// Create button to validate user IDs.
		Button validateIDBtn = new Button();
		validateIDBtn.setText("Validate ID");
		validateIDBtn.setPrefSize(120, 50);
		
		// Create button to display ID of the last updated user.
		Button lastUpdatedUserBtn = new Button();
		lastUpdatedUserBtn.setText("Last Updated User's ID");
		lastUpdatedUserBtn.setPrefSize(150, 50);
		
		// Create button to open user view.
		Button userViewBtn = new Button();
		userViewBtn.setText("Open User View");
		userViewBtn.setPrefSize(120, 50);
		
		// Create button to show total users.
		Button userTotalBtn = new Button();
		userTotalBtn.setText("Show User Total");
		userTotalBtn.setPrefSize(140, 50);
		
		// Create button to show total user groups.
		Button userGroupTotalBtn = new Button();
		userGroupTotalBtn.setText("Show Group Total");
		userGroupTotalBtn.setPrefSize(140, 50);
		
		// Create button to show total number of messages.
		Button messageTotalBtn = new Button();
		messageTotalBtn.setText("Show Message Total");
		messageTotalBtn.setPrefSize(140, 50);
		
		// Create button to show percentage of positive words.
		Button positiveWordsPercentBtn = new Button();
		positiveWordsPercentBtn.setText("Show Positive Percentage");
		positiveWordsPercentBtn.setPrefSize(140, 50);
		positiveWordsPercentBtn.setWrapText(true);
		
		positiveWordsPercentBtn.setStyle("-fx-text-alignment: center;");

		// addUserBtn functions when clicked.
		addUserBtn.setOnAction((ActionEvent event) -> 
		{
			TreeItem<CompositeTree> selectedUser = treeView.getSelectionModel().getSelectedItem();
			String newUserInput = UserIDText.getText();
			
			if (rootGroup.containsUser(newUserInput)) 
			{
				informationAlertWindow.setContentText("This user already belongs to a group!");
				informationAlertWindow.showAndWait();
			} 
			else 
			{
				User temp = new User(newUserInput);
				((UserGroup) selectedUser.getValue()).addGroupUsers(temp);
				selectedUser.getChildren().add(new TreeItem<>(temp));
			}
			
			UserIDText.clear();
		});
		
		// addGroupBtn functions when clicked.
		addGroupBtn.setOnAction((ActionEvent event) -> 
		{
			String newGroup = GroupIDText.getText();
			UserGroup temp = new UserGroup(newGroup);
			TreeItem<CompositeTree> selectedGroup = treeView.getSelectionModel().getSelectedItem();

			if (rootGroup.containsGroup(newGroup)) 
			{
				informationAlertWindow.setContentText("This group already exists!");
				informationAlertWindow.showAndWait();
			} 
			else 
			{
				temp.setCreationTime();
				((UserGroup) selectedGroup.getValue()).addGroupUsers(temp);
				selectedGroup.getChildren().add(new TreeItem<>(temp, new ImageView(rootFolderPic)));
			}
			
			GroupIDText.clear();
		});
		
		// Conditions for invalid user ID when validateIDBtn is clicked.
		validateIDBtn.setOnAction((ActionEvent event) -> 
		{
			String newGroup = GroupIDText.getText();
			String newUser = UserIDText.getText();

			// ID is invalid if it already exists.
			if (rootGroup.containsGroup(newGroup) || rootGroup.containsUser(newUser)) 
			{
				informationAlertWindow.setContentText("Invalid ID. This ID already exists!");
				informationAlertWindow.showAndWait();
			}
			// ID is invalid if it contains spaces.
			else if (newGroup.contains(" ") || newUser.contains(" ")) 
			{
				informationAlertWindow.setContentText("Invalid ID. The ID cannot contain spaces!");
				informationAlertWindow.showAndWait();
			}
			// Otherwise the ID is valid.
			else 
			{
				informationAlertWindow.setContentText("Valid ID!");
				informationAlertWindow.showAndWait();
			}
		});
		
		// Show last update time of user when lastUpdatedUserBtn is clicked.
		lastUpdatedUserBtn.setOnAction((ActionEvent event) -> 
		{
			LastUpdatedIDVisitor updatedIDVisitor = new LastUpdatedIDVisitor();
			rootGroup.accept(updatedIDVisitor);
			informationAlertWindow.setContentText("Last Updated User: " + updatedIDVisitor.getLastUpdateUser());
			informationAlertWindow.showAndWait();
		});

		// Open user view window of selected user.
		userViewBtn.setOnAction((ActionEvent event) -> 
		{
			TreeItem<CompositeTree> selectedUser = treeView.getSelectionModel().getSelectedItem();
			if (selectedUser.getValue() instanceof User) 
			{
				User userViewUser = (User) selectedUser.getValue();
				UserView.openUserUI(userViewUser, rootGroup);
			}
		});

		// Show total users when userTotalBtn is clicked.
		userTotalBtn.setOnAction((ActionEvent event) -> 
		{
			UserVisitor userTotalVisitor = new UserVisitor();
			rootGroup.accept(userTotalVisitor);
			informationAlertWindow.setContentText("There are " + userTotalVisitor.getUserTotal() + " users total.");
			informationAlertWindow.showAndWait();
		});
		
		// Show total user groups when userGroupTotalBtn is clicked.
		userGroupTotalBtn.setOnAction((ActionEvent event) -> 
		{
			TotalGroupVisitor groupTotalVisitor = new TotalGroupVisitor();
			rootGroup.accept(groupTotalVisitor);
			informationAlertWindow.setContentText("There are " + groupTotalVisitor.getGroupTotal() + " user groups total.");
			informationAlertWindow.showAndWait();

		});

		// Show total messages when messageTotalBtn is clicked.
		messageTotalBtn.setOnAction((ActionEvent event) -> 
		{
			MessagesVisitor messageTotalVisitor = new MessagesVisitor();
			rootGroup.accept(messageTotalVisitor);
			informationAlertWindow.setContentText("There are " + messageTotalVisitor.getMessageTotal() + " messages total.");
			informationAlertWindow.showAndWait();
		});
		
		// Show percentage of positive words among all messages when positiveWordsPercentBtn is clicked.
		positiveWordsPercentBtn.setOnAction((ActionEvent event) -> 
		{
			PositiveVisitor positiveVisitor = new PositiveVisitor();
			rootGroup.accept(positiveVisitor);
			informationAlertWindow.setContentText(String.format("%.2f %%" + " of words in messages are positive.",
					positiveVisitor.getPositivePercentage()));
			informationAlertWindow.showAndWait();
		});
		
		// Organize all buttons and text boxes.
		VBox treeBox = new VBox(treeView);
		HBox userBox = new HBox(10, UserIDText, addUserBtn);
		HBox groupBox = new HBox(10, GroupIDText, addGroupBtn);
		HBox userGroupBox = new HBox(10, userTotalBtn, userGroupTotalBtn);
		HBox messageBox = new HBox(10, messageTotalBtn, positiveWordsPercentBtn);
		HBox newUserButtonsBox = new HBox(10, validateIDBtn, lastUpdatedUserBtn);
		HBox userViewButtonBox = new HBox(10, userViewBtn);
		
		userGroupBox.setAlignment(Pos.CENTER);
		userGroupBox.setPadding(new Insets(0, 0, 10, 0));
		messageBox.setAlignment(Pos.CENTER);
		
		newUserButtonsBox.setAlignment(Pos.CENTER);
		newUserButtonsBox.setPadding(new Insets(30, 12, 15, 12));
		userViewButtonBox.setAlignment(Pos.CENTER);

		VBox topButtonsBox = new VBox(10, userBox, groupBox, newUserButtonsBox, userViewButtonBox, userGroupBox, messageBox);
		VBox bottomButtonsBox = new VBox(10, userGroupBox, messageBox);
		VBox combinedButtonsBox = new VBox(10, topButtonsBox, bottomButtonsBox);

		combinedButtonsBox.setSpacing(70);
		menuBox = new HBox(10, treeBox, combinedButtonsBox);
		menuBox.setPadding(new Insets(10));
	}

	public HBox getAdminPanel() 
	{
		return menuBox;
	}
}
