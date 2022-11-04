
/*
 *	Name: Kyle Tam
 *	CS 3560
 *	Professor Yu Sun
 *	Assignment 2 - Mini Twitter 
 */

package mini_twitter;

public class Driver 
{
    public static void main(String[] args)
    {
        AdminControlPanel panel = AdminControlPanel.getInstance();
        
        // Change UI to Nimbus look and feel.
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(AdminControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(AdminControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(AdminControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(AdminControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Display the form when ready.
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                panel.setVisible(true);
            }
        });
    }
    
}
