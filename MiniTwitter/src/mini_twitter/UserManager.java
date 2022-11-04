
package mini_twitter;

import java.util.ArrayList;
import javax.swing.tree.TreeModel;

public abstract class UserManager
{
    protected String id;
    
    public abstract void add(UserManager um);
    
    public String getID()
    {
        return id;
    }
    
    @Override
    public String toString() 
    {
        return id;
    }
    
    public abstract ArrayList<UserManager> getMembers();
    public abstract void accept(InfoVisitor v);
}
