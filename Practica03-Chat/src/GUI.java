
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Reina
 */
public class GUI extends javax.swing.JFrame {
String path,tmp_u="",tmp_m="";
int bandera;
String mensaje_inicio="",mensaje_medio="",mensaje_final="";
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        bandera=0;
        File f = new File("");
        String ruta = f.getAbsolutePath();
        path=ruta;
        mensaje_inicio= "<head><base href=\"file:"+ruta+"\\\">"+
                "<style>#usuarios {"+
                  "font-family: Arial, Helvetica, sans-serif;"+
                  "border-collapse: collapse;"+
                  "width: 100%;"+
                "} #usuarios td, #usuarios th {"+
                  "border: 0px solid #ddd;"+
                 " padding: 8px;"+
                "}#usuarios tr:nth-child(even){background-color: #f2f2f2;}"+
                "#usuarios tr:hover {background-color: #ddd;}"+
                "#usuarios th {"+
                 " padding-top: 12px;"+
                  "padding-bottom: 12px;"+
                  "text-align: left;"+
                  "background-color: #04AA6D;"+
                  "color: white;}"+
                "</style>"+
                "</head>"+ 
                "<table id=\"usuarios\">\n";
         /*   "  <tr>\n" +
            "    <th>Usuario</th>\n" +
            "    <th>Mensaje</th>\n" +
            "  </tr>";*/
       
       mensaje_final="</table>"; 
        
        ImageIcon foto_cara = new ImageIcon(ruta+"\\risa.gif");
        ImageIcon foto_wow = new ImageIcon(ruta+"\\wow.gif");
        //ImageIcon foto = new ImageIcon("C:\\Users\\52552\\Documents\\NetBeansProjects\\tttttttttt\\cara.gif");
        Icon icono_cara = new ImageIcon(foto_cara.getImage().getScaledInstance(jLabel4.getWidth(),jLabel4.getHeight(),Image.SCALE_DEFAULT));
        jLabel4.setIcon(icono_cara);
        Icon icono_wow = new ImageIcon(foto_wow.getImage().getScaledInstance(jLabel2.getWidth(),jLabel2.getHeight(),Image.SCALE_DEFAULT));
        jLabel2.setIcon(icono_wow);
        //jEditorPane1.setText(mensaje_inicio);
        //bandera=1;
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jEditorPane1.setEditable(false);
        jEditorPane1.setContentType("text/html");
        jScrollPane1.setViewportView(jEditorPane1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(21, 24, 275, 148);

        jLabel1.setText("Escribe aquí:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 280, 90, 14);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(130, 270, 170, 30);

        jButton1.setText("Enviar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 270, 63, 23);

        jLabel2.setText("jLabel2");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 330, 60, 42);

        jLabel4.setText("jLabel4");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 330, 60, 42);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(20, 380, 330, 10);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(20, 310, 330, 2);

        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 230, 60, 14);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(130, 220, 170, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        tmp_u =  jTextField2.getText();
        tmp_m =  jTextField1.getText();
        mensaje_medio= mensaje_medio+"  <tr>\n" +
        "    <td>"+jTextField2.getText()+" dice: </td>\n" +
        "    <td>"+jTextField1.getText()+"</td>\n" +
        "  </tr>";
        jEditorPane1.setText(mensaje_inicio+mensaje_medio+mensaje_final);

        this.repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.out.println("<img src=\"wow.gif\"width=\"40\" height=\"40\"></img>");
        mensaje_medio= mensaje_medio+"  <tr>\n" +
        "    <td>"+jTextField2.getText()+" dice: </td>\n" +
        "    <td>"+"<img src=\"wow.gif\"width=\"40\" height=\"40\"></img>"+"</td>\n" +
        "  </tr>";
        jEditorPane1.setText(mensaje_inicio+mensaje_medio+mensaje_final);
        this.repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.out.println("<img src=\"risa.gif\"width=\"50\" height=\"50\"></img>");
        mensaje_medio= mensaje_medio+"  <tr>\n" +
        "    <td>"+jTextField2.getText()+" dice: </td>\n" +
        "    <td>"+"<img src=\"risa.gif\"width=\"50\" height=\"50\"></img>"+"</td>\n" +
        "  </tr>";
        jEditorPane1.setText(mensaje_inicio+mensaje_medio+mensaje_final);
        this.repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
