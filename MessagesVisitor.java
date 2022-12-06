package mini_twitter;

public class MessagesVisitor implements UserGroupVisitor 
{
	private int TotalMessage = 0;

	@Override
	public void visitUser(User user) 
	{
		// Add number of messages user has posted to total messages.
		setMessageTotal(getMessageTotal() + user.getMyTweets().size());
	}

	// Return total number of messages.
	public int getMessageTotal() 
	{
		return TotalMessage;
	}

	public void setMessageTotal(int totalMessage) 
	{
		TotalMessage = totalMessage;
	}
	
	@Override
	public void visitGroup(UserGroup group) 
	{

	}
}
