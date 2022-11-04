
package mini_twitter;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class AdminControlPanel extends javax.swing.JFrame implements TreeSelectionListener 
{
	// Use of the Singleton pattern.
	private static AdminControlPanel instance = new AdminControlPanel();
	private UserGroup root;
	private User current;
	private UserGroup currentGroup;

	private AdminControlPanel() 
	{
		root = new UserGroup("Root");
		initComponents();
		current = null;
	}
	
	public static AdminControlPanel getInstance() 
	{
		return instance;
	}
	
	// Declare Java Swing variables.
	private javax.swing.JTree tree;
	private javax.swing.JPanel treeView;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane sp;
	private javax.swing.JTextField groupIDField;
	private javax.swing.JTextField userIDField;
	private javax.swing.JButton addGroupBtn;
	private javax.swing.JButton addUserBtn;
	private javax.swing.JButton groupTotalBtn;
	private javax.swing.JButton userViewBtn;
	private javax.swing.JButton msgTotalBtn;
	private javax.swing.JButton posPercentageBtn;
	private javax.swing.JButton userTotalBtn;

	private void initComponents() 
	{
		// Create tree.
		tree = new javax.swing.JTree();
		treeView = new javax.swing.JPanel();

		// Create panels.
		sp = new javax.swing.JScrollPane();
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();

		// Create text fields.
		userIDField = new javax.swing.JTextField();
		groupIDField = new javax.swing.JTextField();

		// Create new buttons.
		addUserBtn = new javax.swing.JButton();
		addGroupBtn = new javax.swing.JButton();
		userViewBtn = new javax.swing.JButton();
		userTotalBtn = new javax.swing.JButton();
		groupTotalBtn = new javax.swing.JButton();
		msgTotalBtn = new javax.swing.JButton();
		posPercentageBtn = new javax.swing.JButton();

		// Program closes when window is closed.
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// Create base node in tree view for users and user groups.
		javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
		tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
		treeNode1 = new DefaultMutableTreeNode(root);
		tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
		tree.addTreeSelectionListener(this);
		sp.setViewportView(tree);

		// Create tree view.
		javax.swing.GroupLayout treeViewLayout = new javax.swing.GroupLayout(treeView);
		treeView.setLayout(treeViewLayout);
		treeViewLayout.setHorizontalGroup(treeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(treeViewLayout.createSequentialGroup().addContainerGap()
						.addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addContainerGap()));
		treeViewLayout.setVerticalGroup(treeViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(treeViewLayout.createSequentialGroup().addContainerGap().addComponent(sp,
						javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)));

		// Add User button.
		addUserBtn.setText("Add User");
		addUserBtn.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				addUserActionPerformed(evt);
			}
		});
		
		// Add Group button.
		addGroupBtn.setText("Add Group");
		addGroupBtn.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				addGroupActionPerformed(evt);
			}
		});
		
		// User View button.
		userViewBtn.setText("Open User View");
		userViewBtn.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				userViewBtnActionPerformed(evt);
			}
		});
				
		// Show User Total button.
		userTotalBtn.setText("Show User Total");
		userTotalBtn.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				userTotalActionPerformed(evt);
			}
		});

		// Show Group Total button.
		groupTotalBtn.setText("Show Group Total");
		groupTotalBtn.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				groupTotalBtnActionPerformed(evt);
			}
		});

		// Show Message Total button.
		msgTotalBtn.setText("Show Messages Total");
		msgTotalBtn.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				msgTotalActionPerformed(evt);
			}
		});

		// Show Positive Percentage button.
		posPercentageBtn.setText("Show Positive Percentage");
		posPercentageBtn.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				posPercentageActionPerformed(evt);
			}
		});

		// Group layout of top half of screen.
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
										.addComponent(userIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(addUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(userIDField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addUserBtn))
						.addContainerGap(14, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(
						jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
										.addComponent(groupIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(addGroupBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(groupIDField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addGroupBtn))
						.addContainerGap(14, Short.MAX_VALUE)));
		
		// Group layout of bottom half of screen with four buttons.
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(treeView, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(userViewBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(userTotalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(groupTotalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addComponent(msgTotalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(posPercentageBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
														187, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup().addGap(23, 23, 23)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(userTotalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(groupTotalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(1, 1, 1)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(msgTotalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(posPercentageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(treeView,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)))
						.addContainerGap()));
		pack();
	}

	// Create a new user (if the one inputed does not exist) and give them a unique ID.
	private void addUserActionPerformed(java.awt.event.ActionEvent evt) 
	{
		String id = this.userIDField.getText();
		if (currentGroup == null) 
		{
			currentGroup = UserGroup.findGroup("Root");
		}

		if (id.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter at least one character.");
		}

		else if (!User.exists(id)) 
		{
			User temp = new User(id, currentGroup.getID());
			if (current == null) 
			{
				current = temp;
			}
			currentGroup.add(temp);
			DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
			model.insertNodeInto(new DefaultMutableTreeNode(temp), this.getCurrentGroup(),
					this.getCurrentGroup().getChildCount());
		}
		
		else 
		{
			JOptionPane.showMessageDialog(null, "User with ID " + id + " already exists!");
		}
	}

	// Create a new group (if the one inputed does not exist).
	private void addGroupActionPerformed(java.awt.event.ActionEvent evt) 
	{
		String id = this.groupIDField.getText();
		if (currentGroup == null) 
		{
			currentGroup = UserGroup.findGroup("Root");
		}

		if (id.equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Please enter at least one character.");
		}

		else if (!UserGroup.exists(id)) 
		{
			UserGroup temp = new UserGroup(id);
			currentGroup.add(temp);
			DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
			model.insertNodeInto(new DefaultMutableTreeNode(temp), this.getCurrentGroup(),
					this.getCurrentGroup().getChildCount());
		}

		else 
		{
			JOptionPane.showMessageDialog(null, "Group with ID " + id + " already exists!");
		}
	}

	// Create new user window of selected user when Open User View button is clicked.
	private void userViewBtnActionPerformed(java.awt.event.ActionEvent evt) 
	{
		if (current != null) 
		{
			JFrame userWindow = new JFrame();
			final ImageIcon img = new ImageIcon(
					"C:\\Users\\Manny\\eclipse-workspace\\MiniTwitter\\src\\mini_twitter\\twitter_icon.png");
			userWindow.setIconImage(img.getImage());
			userWindow.setSize(new Dimension(400, 400));
			userWindow.setTitle(current.getID());
			userWindow.setLayout(new BorderLayout());
			userWindow.add(new UserView(current), BorderLayout.CENTER);
			userWindow.setVisible(true);
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Please select a valid user.");
		}
	}
	
	// Show total number of groups.
	private void groupTotalBtnActionPerformed(java.awt.event.ActionEvent evt) 
	{
		JOptionPane.showMessageDialog(null, "Total groups: " + UserGroup.groups.size());
	}

	// Connect UserVisitor functionality to current user.
	private void userTotalActionPerformed(java.awt.event.ActionEvent evt) 
	{
		UserVisitor uv = new UserVisitor();
		if (current != null) 
		{
			current.accept(uv);
		}
	}

	// Connect MessagesVisitor functionality to current user.
	private void msgTotalActionPerformed(java.awt.event.ActionEvent evt) 
	{
		MessagesVisitor mv = new MessagesVisitor();
		if (current != null) 
		{
			current.accept(mv);
		}
	}

	// Connect PositiveVisitor functionality to current user.
	private void posPercentageActionPerformed(java.awt.event.ActionEvent evt) 
	{
		PositiveVisitor pv = new PositiveVisitor();
		if (current != null) 
		{
			current.accept(pv);
		}
	}

	// Get group of selected user.
	public DefaultMutableTreeNode getCurrentGroup() 
	{
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if (node == null) 
		{
			node = (DefaultMutableTreeNode) tree.getModel().getRoot();
		}

		if (node.getUserObject().getClass().equals(User.class)) 
		{
			node = (DefaultMutableTreeNode) node.getParent();
		}

		return node;
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) 
	{
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

		Object info = node.getUserObject();

		if (node.getUserObject().getClass().equals(User.class))
		{
			current = (User) info;
			currentGroup = UserGroup.findGroup(current.getUserGroup());
		} 
		else 
		{
			current = null;
			currentGroup = (UserGroup) info;
		}
	}
}
