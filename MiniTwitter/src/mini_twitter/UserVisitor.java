
package mini_twitter;

import javax.swing.JOptionPane;

// Use of Visitor pattern to include "show total number of users" functionality. 
public class UserVisitor implements InfoVisitor
{
    @Override
    public void visit(User u) 
    {
        JOptionPane.showMessageDialog(null, "Total # of Users: " + u.getUsers().size());
    }

    @Override
    public void visit(UserGroup ug) 
    {
    	
    }
    
}
