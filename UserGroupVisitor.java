package mini_twitter;

public interface UserGroupVisitor 
{
	public void visitUser(User user);
    public void visitGroup(UserGroup group);
}
