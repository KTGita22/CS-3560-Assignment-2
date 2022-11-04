
package mini_twitter;

import javax.swing.JOptionPane;

public class MessagesVisitor implements InfoVisitor
{
	// Get total number of tweets from all users.
    @Override
    public void visit(User user) 
    {
        int total = 0;
        for(Object object : user.getUsers())
        {
            User us = (User) object;
            total += us.getUserTweets().size();
        }
        JOptionPane.showMessageDialog(null, "Total # of messages: " + total);
    }

    @Override
    public void visit(UserGroup ug) 
    {

    }
    
}
