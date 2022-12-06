package mini_twitter;

// Use of the Composite pattern, and accepts visitors of Visitor pattern.

public interface CompositeTree 
{
	public String getID();
	public String toString();
	public void accept(UserGroupVisitor visitor);
}
