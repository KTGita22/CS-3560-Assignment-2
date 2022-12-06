package mini_twitter;

public class LastUpdatedIDVisitor implements UserGroupVisitor 
{
	String lastUpdatedUser = "No user found.";
	long recentUpdatedTime = 0;

	@Override
	public void visitUser(User user) 
	{
		// Get ID of the user most recently updated (posted most recent tweet) and store in lastUpdatedUser.
		if (user.getLastUpdatedTime() > recentUpdatedTime) 
		{
			recentUpdatedTime = user.getLastUpdatedTime();
			lastUpdatedUser = user.getID();
		}
	}

	public String getLastUpdateUser() 
	{
		return lastUpdatedUser;
	}
	
	@Override
	public void visitGroup(UserGroup group) 
	{

	}
}
