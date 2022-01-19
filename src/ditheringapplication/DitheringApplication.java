package ditheringapplication;

/**
 *
 * @author rogerio
 */
public class DitheringApplication {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visualizador().setVisible(true);
            }
        });        
    }    
}
