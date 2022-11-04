package mini_twitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class User extends UserManager implements Subject
{
	// Uses Composite pattern and subject/observer from Observer pattern.
	
	// Declare variables.
    private String userGroup;
    private static HashMap<String, User> users = new HashMap<String, User>();
    private ArrayList<Observer> userFollowers;
    private ArrayList<String> userFollowing;
    private ArrayList<String> userTweets;
    private NewsFeed newsFeed;
    
    public User(String id, String userGroup)
    {
        if(!users.containsKey(id))
        {
            this.id = id;
            userFollowers = new ArrayList<Observer>();
            userFollowing = new ArrayList<String>();
            userTweets = new ArrayList<String>();
            this.userGroup = userGroup;
            newsFeed = new NewsFeed();
            this.register(newsFeed);
            users.put(id, this);
        }
        else
        {
            System.out.println("ID already exists!");
        }
    }
    
    public String getUserGroup()
    {
        return userGroup;
    }
    
    public ArrayList<String> getUserTweets()
    {
        return userTweets;
    }
    
    public ArrayList<String> getUserFollowing()
    {
        return userFollowing;
    }
    
    public NewsFeed getFeed()
    {
        return newsFeed;
    }
    
    public static boolean exists(String uid)
    {
        return users.containsKey(uid);
    }
    
    public void follow(String id)
    {
        users.get(id).register(newsFeed);
        userFollowing.add(id);
        for(String s : users.get(id).getUserTweets())
        {
            newsFeed.update(s, users.get(id));
        }
    }
    
    public void joinUserGroup(String id)
    {
        userGroup = id;
    }
   
    public void tweet(String msg)
    {
        userTweets.add(msg);
        notifyObserver();
    }

    @Override
    public void register(Observer obj) 
    {
        if(obj == null)
        {
            System.out.println("Null observer");
        }
        if(!userFollowers.contains(obj))
        {
            userFollowers.add(obj);
        }
    }

    @Override
    public void notifyObserver()
    {
        for(Observer obs : userFollowers)
        {
            obs.update(userTweets.get(userTweets.size() - 1), this);
        }
    }
    public boolean isUserFollowing(String id)
    {
        return userFollowing.contains(id);
    }
    
    // For Assignment 3.
    @Override
    public Object getUpdate(Observer obj) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(UserManager um) 
    {
        System.out.println("Can't add to leaf.");
    }

    @Override
    public ArrayList<UserManager> getMembers() 
    {
        return null;
    }

    public Collection getUsers()
    {
        return users.values();
    }
    
    @Override
    public void accept(InfoVisitor v) 
    {
        v.visit(this);
    }
}
