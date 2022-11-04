
package mini_twitter;

// Use of Visitor pattern.

public interface InfoVisitor 
{
    public void visit(User u);
    public void visit(UserGroup ug);
}
