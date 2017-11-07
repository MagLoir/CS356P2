package mainUI;

import design.User;
import design.userTweets;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

/**
 *
 * @author pungi
 */
public class JFrameUser extends javax.swing.JFrame {

    private javax.swing.JButton followBtn, postBtn;
    private javax.swing.JLabel followingLabel, lMessage, tweetLabel, userLabel;
    private javax.swing.JList<String> listFollowing, tweetsList;
    private DefaultListModel model, tweetModel;
    private javax.swing.JScrollPane jScrollPane1, jScrollPane2, msgTextfield;
    private javax.swing.JTextArea tweetTextfield;
    private javax.swing.JTextField usernameTextField;

    private User user;

    public JFrameUser(User user) {
        this.user = user;

        initComponents();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userLabel.setText(user.getName());
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        model = new DefaultListModel();
        listFollowing = new javax.swing.JList<>();
        userLabel = new javax.swing.JLabel();
        followBtn = new javax.swing.JButton();
        postBtn = new javax.swing.JButton();
        followingLabel = new javax.swing.JLabel();
        msgTextfield = new javax.swing.JScrollPane();
        tweetTextfield = new javax.swing.JTextArea();
        usernameTextField = new javax.swing.JTextField();
        lMessage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tweetModel = new DefaultListModel();
        tweetsList = new javax.swing.JList<>();
        tweetLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listFollowing.setModel(model);
        user.getFollowing().forEach((u) -> {
            model.addElement(u.getName());
        });
        jScrollPane2.setViewportView(listFollowing);

        userLabel.setFont(new java.awt.Font("Arial", 0, 24));
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userLabel.setText("User");

        followBtn.setText("Follow");
        followBtn.addActionListener(this::onClickfollowBtn);

        postBtn.setText("Post Message");
        postBtn.addActionListener(this::onClickpostBtn);

        followingLabel.setText("Following");

        tweetTextfield.setColumns(20);
        tweetTextfield.setRows(5);
        msgTextfield.setViewportView(tweetTextfield);

        lMessage.setForeground(new java.awt.Color(255, 0, 51));

        tweetsList.setModel(tweetModel);
        user.getTweets().forEach((t) -> {
            tweetModel.addElement(t.getMessage());
        });
        jScrollPane1.setViewportView(tweetsList);

        tweetLabel.setText("Tweets");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addGap(22, 22, 22)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(18, 18, 18)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                .addComponent(usernameTextField)
                                                                                                .addComponent(followBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                                                                                .addComponent(followingLabel)
                                                                                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addComponent(msgTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(tweetLabel)
                                                                                        .addGap(239, 239, 239))
                                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(postBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 9, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(lMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(userLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(followingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(followBtn)))
                                .addGap(18, 18, 18)
                                .addComponent(msgTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(postBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tweetLabel)
                                .addGap(9, 9, 9)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }

    private void onClickfollowBtn(java.awt.event.ActionEvent evt) {
        DefaultListModel dm = (DefaultListModel) listFollowing.getModel();
        String username = usernameTextField.getText().trim();
        try {
            lMessage.setText("");
            if (!username.equals("")) {
                user.addFollowing(username);
                dm.addElement(username);
            }
        } catch (Exception e) {
            lMessage.setText(e.getMessage());
        }
    }

    private void onClickpostBtn(java.awt.event.ActionEvent evt) {
        DefaultListModel dm = (DefaultListModel) tweetsList.getModel();
        String message = tweetTextfield.getText().trim();
        if (!message.equals("")) {
            userTweets tweet = user.postTweet(message);

            dm.addElement(tweet.getMessage());
        }
    }

}
