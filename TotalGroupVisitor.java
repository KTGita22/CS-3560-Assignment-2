package mini_twitter;

public class TotalGroupVisitor implements UserGroupVisitor 
{
	private int totalGroup = 0;

	@Override
	// Increment total by one with every addition of a user group.
	public void visitGroup(UserGroup group) 
	{
		setGroupTotal(getGroupTotal() + 1);
	}

	// Return total of user groups.
	public int getGroupTotal() 
	{
		return totalGroup;
	}

	public void setGroupTotal(int totalUser) 
	{
		this.totalGroup = totalUser;
	}
	
	public void visitUser(User user) 
	{
		
	}
}
