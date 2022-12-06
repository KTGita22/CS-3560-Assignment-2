package mini_twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositiveVisitor implements UserGroupVisitor 
{
	private double positiveCount = 0, totalMessages = 0, positivePercentage = 0;
	private List<String> positiveWords = new ArrayList<>(Arrays.asList("good", "great", "excellent", "amazing", "nice",
			"happy", "lit", "glad", "kind", "beautiful", "bright"));

	@Override
	public void visitUser(User user) 
	{
		// Get percentage of positive words based on number of words in user tweets.
		for (String message : user.getMyTweets()) 
		{
			totalMessages += 1;
			for (String positive : positiveWords) 
			{
				if (message.toLowerCase().contains(positive.toLowerCase())) 
				{
					positiveCount += 1;
				}
			}
		}
	}

	public double getPositivePercentage() 
	{
		if (totalMessages == 0) 
		{
			return positivePercentage;
		}
		
		setPositivePercentage((positiveCount / totalMessages) * 100.0);
		return positivePercentage;
	}

	public void setPositivePercentage(double positivePercentage) 
	{
		this.positivePercentage = positivePercentage;
	}
	
	@Override
	public void visitGroup(UserGroup group) 
	{
		
	}	
}
