package mini_twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User extends Subject implements CompositeTree, Observer 
{
	// Declare variables.
	private String userID;
	private List<User> following = new ArrayList<>();
	private ObservableList<User> followingList = FXCollections.observableList(following);
	private List<String> myTweets = new ArrayList<>();
	private List<String> newsFeed = new ArrayList<>(Arrays.asList());

	private ObservableList<String> newsFeedList = FXCollections.observableList(newsFeed);
	private long createdUser;
	private long lastUpdatedTime = 0;

	public User(String newID) 
	{
		this.userID = newID;
		this.createdUser = System.currentTimeMillis();
	}

	// Setter and getter methods.
	@Override
	public String getID() 
	{
		return userID;
	}

	@Override
	public String toString() 
	{
		return userID;
	}

	public long getCreationTime() 
	{
		return createdUser;
	}

	public long getLastUpdatedTime() 
	{
		return lastUpdatedTime;
	}

	@Override
	public void accept(UserGroupVisitor visitor) 
	{
		visitor.visitUser(this);
	}

	@Override
	public void update(Subject subject, String tweet) 
	{
		if (subject instanceof User) 
		{
			this.newsFeedList.add("-" + ((User) subject).getID() + " : " + tweet);
			lastUpdatedTime = System.currentTimeMillis();
			this.newsFeedList.add("Last Updated: " + lastUpdatedTime);
		}
	}

	public ObservableList<User> getFollowingList() 
	{
		return followingList;
	}

	public void addFollowingList(User user) 
	{
		followingList.add(user);
	}

	public List<String> getMyTweets() 
	{
		return myTweets;
	}

	public ObservableList<String> getNewsFeedList() 
	{
		return newsFeedList;
	}

	public void tweetMessage(String tweet) 
	{
		// Add message to news feed with time updated. 
		myTweets.add(tweet);
		newsFeedList.add("-" + this.userID + " : " + tweet);
		lastUpdatedTime = System.currentTimeMillis();
		this.newsFeedList.add("Last Updated: " + lastUpdatedTime);
		
		updateFollowers(tweet);
	}
}
