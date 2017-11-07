package mainUI;

import design.*;
import info.*;
import java.awt.Frame;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author pungi
 */
public class Admin extends javax.swing.JFrame {

    private static volatile Admin ad;

    private javax.swing.JLabel admi, clickableLabel, labelGroup,
            message, labelUser;
    private javax.swing.JTree treeComp;
    private design.TreeView rt;
    private javax.swing.JButton groupButton, userButton,
            positiveTweetsBtn, totalGroupsBtn, totalTweetsBtn, totalUsersBtn;
    private javax.swing.JFrame jF;
    private javax.swing.JScrollPane jSP;

    private javax.swing.JTextField TweetTextfieldpos, totGroupTextfield,
            totTweetsField, totUsersField, userTextfield, groupTextfield;

    private Admin() {
        initComponents();
    }

    //singleton
    public static Admin getInstance() {
        Admin adm = Admin.ad;
        if (adm == null) {
            synchronized (Admin.class) {
                adm = Admin.ad;
                if (adm == null) {
                    Admin.ad = adm = new Admin();
                }
            }
        }
        return adm;
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jF = new javax.swing.JFrame();
        userButton = new javax.swing.JButton();
        groupButton = new javax.swing.JButton();
        admi = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();
        labelGroup = new javax.swing.JLabel();
        userTextfield = new javax.swing.JTextField();
        groupTextfield = new javax.swing.JTextField();
        jSP = new javax.swing.JScrollPane();
        rt = new design.TreeView();
        treeComp = new javax.swing.JTree();
        clickableLabel = new javax.swing.JLabel();
        totalUsersBtn = new javax.swing.JButton();
        totalTweetsBtn = new javax.swing.JButton();
        positiveTweetsBtn = new javax.swing.JButton();
        totUsersField = new javax.swing.JTextField();
        totGroupTextfield = new javax.swing.JTextField();
        totalGroupsBtn = new javax.swing.JButton();
        totTweetsField = new javax.swing.JTextField();
        TweetTextfieldpos = new javax.swing.JTextField();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jF.getContentPane());
        jF.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 700, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 500, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userButton.setText("ok");
        userButton.setToolTipText("");
        userButton.addActionListener(this::onClickCreatUser);

        groupButton.setText("ok");
        groupButton.addActionListener(this::onClickCreateGroup);

        admi.setFont(new java.awt.Font("Arial", 0, 20)); // font
        admi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admi.setText("Welcome to the Admin Control Panel"); //title

        message.setForeground(new java.awt.Color(255, 0, 0));
        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); //warining message

        labelUser.setText("Username:");
        labelGroup.setText("Group name:");

        javax.swing.tree.TreeNode rootNode = rt.getRoot();
        treeComp.setModel(new javax.swing.tree.DefaultTreeModel(rootNode));
        jSP.setViewportView(treeComp);

        treeComp.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClickedActionPerformed(evt);
            }
        });

        totalUsersBtn.setText("Total number of users");
        totalUsersBtn.addActionListener(this::onClicktotalUser);

        totalTweetsBtn.setText("Tweets total");
        totalTweetsBtn.addActionListener(this::onClicktotalTweet);

        positiveTweetsBtn.setText("Positive tweets");
        positiveTweetsBtn.addActionListener(this::positiveTweetsButtonActionPerformed);

        totalGroupsBtn.setText("Group total");
        totalGroupsBtn.addActionListener(this::onClicktotalGroup);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(admi, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                                        .addGap(71, 71, 71))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(labelUser)
                                                                .addComponent(labelGroup))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(userTextfield)
                                                                .addComponent(groupTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(userButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(groupButton)))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(totalTweetsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE) 
                                                                .addComponent(totalUsersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(totTweetsField) 
                                                                .addComponent(totUsersField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(41, 41, 41)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(positiveTweetsBtn)
                                                                .addComponent(totalGroupsBtn))))
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(totGroupTextfield) 
                                                .addComponent(TweetTextfieldpos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(41, 41, 41)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(clickableLabel)
                                .addComponent(jSP, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 4, Short.MAX_VALUE)
                                        .addComponent(jSP, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(clickableLabel))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(admi)
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(userButton)
                                                .addComponent(labelUser)
                                                .addComponent(userTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(groupButton)
                                                .addComponent(labelGroup)
                                                .addComponent(groupTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(totalUsersBtn)
                                                .addComponent(totUsersField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(totalGroupsBtn) 
                                                .addComponent(totGroupTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) //switch to group textfield
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(totTweetsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) //switch total tweey
                                                .addComponent(totalTweetsBtn) 
                                                .addComponent(positiveTweetsBtn)
                                                .addComponent(TweetTextfieldpos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
        );

        pack();
    }

    private void mouseClickedActionPerformed(java.awt.event.MouseEvent event) {
        if (event.getClickCount() == 2) {
            Composite node = (Composite) treeComp.getLastSelectedPathComponent();
            if (node != null && node instanceof User) {

                Frame userFrame = new JFrameUser((User) node);
            }
        }
    }

    private void onClickCreatUser(java.awt.event.ActionEvent event) {
        message.setText("");
        DefaultTreeModel dm = (DefaultTreeModel) treeComp.getModel();
        Composite r = (Composite) dm.getRoot();
        Composite selectedNode = (Composite) treeComp.getLastSelectedPathComponent();
        String username = userTextfield.getText().trim();
        String u = "A new user has been created: ";

        if (username.equals("")) {
            message.setText("Please, enter username");
        } else {
            if (selectedNode != null) {
                if (selectedNode instanceof GroupComposite) {
                    Composite newUser = new User(username, (GroupComposite) selectedNode);

                    System.out.println(u + username);

                    message.setText("");
                    dm.insertNodeInto(newUser, selectedNode, selectedNode.getChildCount());
                    dm.reload(newUser);
                } else {
                    message.setText("Please, add user to group");
                }
            } else {
                Composite newUser = new User(username, (GroupComposite) r);
                System.out.println(u + username);
                r.add(newUser);
                dm.reload();
            }
        }
    }

    private void onClickCreateGroup(java.awt.event.ActionEvent event) {
        message.setText("");
        String g = "A new group has been created: ";

        DefaultTreeModel dm = (DefaultTreeModel) treeComp.getModel();
        Composite r = (Composite) dm.getRoot();
        Composite selectedNode = (Composite) treeComp.getLastSelectedPathComponent();
        String groupName = groupTextfield.getText();

        if (groupName.trim().equals("")) {
            message.setText("Please, enter a group name");
        } else {
            if (selectedNode != null) {
                if (selectedNode instanceof GroupComposite) {
                    Composite newGroup = new GroupComposite(groupName, (GroupComposite) selectedNode);
                    System.out.println(g + groupName);

                    message.setText("");
                    dm.insertNodeInto(newGroup, selectedNode, selectedNode.getChildCount());
                    dm.reload(newGroup);
                } else {
                    message.setText("Please, add group inside an existing group");
                }
            } else {
                Composite newGroup = new GroupComposite(groupName, (GroupComposite) r);
                System.out.println(g + groupName);
                r.add(newGroup);
                dm.reload();
            }
        }
    }

    private void positiveTweetsButtonActionPerformed(java.awt.event.ActionEvent event) {
        try {
            message.setText("");
            VisitorTweet tv = (VisitorTweet) treeTraversal(new VisitorTweet());
            TweetTextfieldpos.setText(String.valueOf(tv.getPositiveTwitter()));
        } catch (IllegalArgumentException e) {
            message.setText(e.getMessage());
        }
    }

    private void onClicktotalUser(java.awt.event.ActionEvent event) {
        //number of user
        VisitorComp cv = (VisitorComp) treeTraversal(new VisitorComp());
        totUsersField.setText(String.valueOf(cv.getTotalUsers()));
    }

    private void onClicktotalGroup(java.awt.event.ActionEvent event) {
        //number of group
        VisitorComp cV = (VisitorComp) treeTraversal(new VisitorComp());
        totGroupTextfield.setText(String.valueOf(cV.getTotalGroups()));
    }

    private void onClicktotalTweet(java.awt.event.ActionEvent event) {
        //number of tweet
        VisitorTweet tVisit = (VisitorTweet) treeTraversal(new VisitorTweet());
        totTweetsField.setText(String.valueOf(tVisit.getTotalTweets()));
    }

    private Visitor treeTraversal(Visitor v) {
        DefaultTreeModel dm = (DefaultTreeModel) treeComp.getModel();
        Composite r = (Composite) dm.getRoot();
        Composite.treeTraversal(r, v);
        return v;
    }

    /**
     * @param aInstance the ad to set
     */
    public static void set(Admin aInstance) {
        ad = aInstance;
    }

}
