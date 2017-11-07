
package minitwitterMain;

import mainUI.Admin;

/**
 *
 * @author pungi
 */
public class MainDriver {

    public static void main(String args[]) {
        /* 
         * Start the app by instantiating an instance of Admin.
         * This, in turn, uses RootTree to seed initial data to this app 
         */
        start();
    }

    public static void start() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Admin adminPanel = Admin.getInstance();
                adminPanel.setVisible(true);
            }
        });
    }

}
