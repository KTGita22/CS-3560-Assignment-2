package mini_twitter;

import java.util.ArrayList;
import java.util.List;

public class Subject 
{
	private List<Observer> followers = new ArrayList<>();

	// Attach observer to followers, who observe the news feed of the users they are following.
	public void attach(Observer observer) 
	{
		followers.add(observer);
	}

	// Update followers when a new message is posted to the news feed.
	public void updateFollowers(String message) 
	{
		for (Observer observer : this.followers) 
		{
			observer.update(this, message);
		}
	}
}
