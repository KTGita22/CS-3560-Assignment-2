
package mini_twitter;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class PositiveVisitor implements InfoVisitor
{
    @Override
    public void visit(User u) 
    {
        double total = 0, positiveTotal = 0;
        ArrayList<String> words = new ArrayList<String>();
        String[] list = {"good", "great", "excellent", "amazing", "nice",
        					"happy", "lit", "glad", "kind", "beautiful", "bright"};
        
        words.addAll(Arrays.asList(list));
        
        // Get percentage of positive words based on number of words in user tweets and display.
        for(Object object : u.getUsers())
        {
            User user = (User) object;
            for(String userString : user.getUserTweets())
            {
                for(String word : words)
                {
                    if(userString.toLowerCase().contains(word))
                    {
                    	positiveTotal++;
                    }
                }
                total += userString.split(" ").length;
            }
        }
        
        // Result.
        String positivePercentage = String.format("%.2f", positiveTotal / total * 100);
        JOptionPane.showMessageDialog(null, "Total positive words: " + positivePercentage + "%");
    }

    @Override
    public void visit(UserGroup ug) 
    {
        
    }
    
}
