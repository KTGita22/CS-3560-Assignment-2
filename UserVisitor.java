package mini_twitter;

public class UserVisitor implements UserGroupVisitor 
{
	private int totalUser = 0;

	@Override
	// Increment total by one with every addition of a user.
	public void visitUser(User user) 
	{
		setUserTotal(getUserTotal() + 1);
	}

	// Return total number of users.
	public int getUserTotal() 
	{
		return totalUser;
	}

	public void setUserTotal(int totalUser) 
	{
		this.totalUser = totalUser;
	}
	
	@Override
	public void visitGroup(UserGroup group) 
	{
		
	}
}
