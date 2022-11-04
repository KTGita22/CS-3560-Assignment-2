
package mini_twitter;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class UserView extends javax.swing.JPanel implements Observer 
{
	private User current;

	public UserView(User u) 
	{
		current = u;
		current.getFeed().register(this);
		initComponents();
	}

	// Declare Java Swing variables.
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextField tweetBox;
	private javax.swing.JTextField followID;
	private javax.swing.JList following;
	private javax.swing.JList newsFeed;
	private javax.swing.JButton followBtn;
	private javax.swing.JButton tweetBtn;

	@SuppressWarnings("unchecked")
	private void initComponents() 
	{
		// Create panels.
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane2 = new javax.swing.JScrollPane();

		// Create text fields.
		tweetBox = new javax.swing.JTextField();
		followID = new javax.swing.JTextField();

		// Create lists.
		following = new javax.swing.JList();
		newsFeed = new javax.swing.JList();

		// Create buttons.
		tweetBtn = new javax.swing.JButton();
		followBtn = new javax.swing.JButton();

		// Set options for buttons.

		// Follower User button.
		followBtn.setText("Follow User");
		followBtn.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				followBtnActionPerformed(evt);
			}
		});

		// Post Tweet button.
		tweetBtn.setText("Post Tweet");
		tweetBtn.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				tweetBtnActionPerformed(evt);
			}
		});

		// Group layout for follow features.
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap().addComponent(followID)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(followBtn,
								javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(followBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
								.addComponent(followID))
						.addContainerGap()));

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Following"));
		following.setModel(new javax.swing.DefaultListModel() {
		});
		updateFollowing();
		jScrollPane1.setViewportView(following);

		// Group layout for scroll pane.
		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout
						.createSequentialGroup().addContainerGap().addComponent(jScrollPane1).addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		// Group layout for tweet features.
		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(tweetBox, javax.swing.GroupLayout.PREFERRED_SIZE, 175,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(tweetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(tweetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
								.addComponent(tweetBox))
						.addContainerGap()));

		jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("News Feed"));
		newsFeed.setModel(new javax.swing.DefaultListModel() {
		});
		updateFeed();
		jScrollPane2.setViewportView(newsFeed);

		// Group layout for second scroll pane.
		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane2));

		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
	}

	// Follow a user when text field is filled out and Follower User button is clicked.
	private void followBtnActionPerformed(java.awt.event.ActionEvent evt) 
	{
		String id = followID.getText();
		if (User.exists(id) && !current.getID().equals(id) && !current.isUserFollowing(id)) 
		{
			current.follow(id);
			updateFollowing();
		} 
		else if (current.getID().equals(id)) 
		{
			JOptionPane.showMessageDialog(null, "Cannot follow self.");
		} 
		else if (current.isUserFollowing(id)) 
		{
			JOptionPane.showMessageDialog(null, "Already following " + id);
		} 
		else 
		{
			JOptionPane.showMessageDialog(null, "User with ID " + id + " does not exist!");
		}
	}

	// Post tweet to news feed when Post Tweet button is clicked.
	private void tweetBtnActionPerformed(java.awt.event.ActionEvent evt) 
	{
		current.tweet(tweetBox.getText());
	}

	// Update user list of followers when user follows someone new.
	private void updateFollowing() 
	{
		DefaultListModel model = new DefaultListModel();
		ArrayList<String> follow = current.getUserFollowing();
		for (String s : follow) 
		{
			model.addElement(s);
		}
		following.setModel(model);
		following.setSelectedIndex(0);
	}

	// Update news feed when new tweet is posted.
	private void updateFeed() 
	{
		DefaultListModel model = new DefaultListModel();
		ArrayList<String> feed = current.getFeed().getFeed();
		for (String s : feed) 
		{
			model.addElement(s);
		}
		newsFeed.setModel(model);
		newsFeed.setSelectedIndex(0);
	}

	// Observer.
	@Override
	public void update(String msg, Subject sub) 
	{
		updateFeed();
	}
}
