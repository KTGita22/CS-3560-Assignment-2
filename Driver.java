package mini_twitter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Driver extends Application 
{
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage windowStage) 
	{
		// Get AdminControlPanel object and call it to display in scene.
		AdminControlPanel adminControlPanel = AdminControlPanel.getInstance();
		HBox adminView = adminControlPanel.getAdminPanel();

		Scene scene = new Scene(adminView, 600, 425);
		windowStage.setScene(scene);
		windowStage.getIcons().add(new Image("C:\\Users\\Manny\\eclipse-workspace\\MiniTwitter2.0\\src\\mini_twitter\\twitter_icon.png"));
		windowStage.setTitle("Admin Control Panel");
		windowStage.show();
	}
}
