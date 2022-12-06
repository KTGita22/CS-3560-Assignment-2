package mini_twitter;

import java.util.ArrayList;
import java.util.List;

public class UserGroup implements CompositeTree 
{
	private List<CompositeTree> groupUsers = new ArrayList<>();
	private String groupID;
	private Long createdGroup;

	// Set user group ID and the time of created group each time a new one is made.
	public UserGroup(String newID) 
	{
		this.groupID = newID;
		this.createdGroup = System.currentTimeMillis();
	}

	// Getter and setter methods.
	public String getID() 
	{
		return this.groupID;
	}

	public List<CompositeTree> getGroupUsers() 
	{
		return groupUsers;
	}

	@Override
	public String toString() 
	{
		return groupID;
	}

	public long getCreationTime() 
	{
		return createdGroup;
	}

	public void setCreationTime() 
	{
		createdGroup = System.currentTimeMillis();
	}

	// Accept visitor classes.
	public void accept(UserGroupVisitor visitor)
	{
		visitor.visitGroup(this);
		for (CompositeTree members : groupUsers) 
		{
			if (members instanceof User) 
			{
				members.accept(visitor);
			} 
			else if (members instanceof UserGroup) 
			{
				members.accept(visitor);
			}
		}
	}

	// Add new group to tree view.
	public void addGroupUsers(CompositeTree newGroup) 
	{
		this.groupUsers.add(newGroup);
	}

	// Verify if group contains a user ID.
	public Boolean containsUser(String UserID) 
	{
		for (CompositeTree members : groupUsers) 
		{
			if (members instanceof User) 
			{
				if (members.getID().equals(UserID)) 
				{
					return true;
				}
			} 
			else if (members instanceof UserGroup) 
			{
				if (((UserGroup) members).containsUser(UserID)) 
				{
					return true;
				}
			}
		}
		return false;
	}

	// Verify if group already contains a user or group ID.
	public Boolean containsGroup(String memberID) 
	{
		for (CompositeTree members : groupUsers) 
		{
			if (members instanceof User) 
			{
				continue;
			}
			// check for a group in this.groupMembers
			else if (members instanceof UserGroup) 
			{
				if (members.getID().equals(memberID)) 
				{
					return true;
				}
				// check ID of groups within groups
				else 
				{
					if (((UserGroup) members).containsGroup(memberID)) 
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	// Returns a user in a group of a group within a group.
	public User getUser(String userID) 
	{
		for (CompositeTree members : groupUsers) 
		{
			if (members instanceof User) 
			{
				if (members.getID().equals(userID)) 
				{
					return (User) members;
				}
			} 
			else if (members instanceof UserGroup) 
			{
				if (((UserGroup) members).containsUser(userID)) 
				{
					return ((UserGroup) members).getUser(userID);
				}
			}
		}
		return null;
	}
}
