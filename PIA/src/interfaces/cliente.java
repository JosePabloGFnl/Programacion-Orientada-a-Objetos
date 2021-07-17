
package interfaces;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class cliente extends javax.swing.JFrame {

    public cliente() {
        initComponents();
 this.setLocationRelativeTo(null);
 mostrardatos("");
    }
    void mostrardatos(String valor) {
          conexion cc=new conexion();
            Connection cn = cc.conectar();
            DefaultTableModel modelo=new DefaultTableModel();
            modelo.addColumn("ID:");
             modelo.addColumn("NOMBRE");
              modelo.addColumn("DIRECCION");
                modelo.addColumn("EMAIL");
                 modelo.addColumn("RFC");
                
                tabla.setModel(modelo);
                String sql="";
                if (valor.equals(""))
                {
                    sql="SELECT * FROM clientes";
                    
                } 
                else {
                        sql="SELECT * from clientes WHERE(id_Clientes='"+valor+"' OR nombre_Clientes='"+valor+"')";
                        }
                String []datos=new String[5];
                try {
                    Statement st=cn.createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    while(rs.next()) {
                        datos [0]=rs.getString(1);
                        datos [1]=rs.getString(2);
                        datos [2]=rs.getString(3);
                        datos [3]=rs.getString(4);
                        datos [4]=rs.getString(5);
                     
                        
       
                        modelo.addRow(datos);
                    }
                    tabla.setModel(modelo);
                }catch(SQLException ex) {
                    Logger.getLogger(cliente.class.getName()).log(Level.SEVERE,null,ex);
                }
    }
    private void Limpiar(){
        this.t_nom.setText("");
        this.t_dire.setText("");
        this.t_email.setText("");
        this.t_nom.setText("");
        this.t_RFC.setText("");
        this.jTextField1.setText("");
}
 
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        t_dire = new javax.swing.JTextField();
        t_RFC = new javax.swing.JTextField();
        t_email = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        t_nom = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        idt = new javax.swing.JTextField();

        jMenuItem1.setText("Modificar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Eliminar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(29, 58, 142));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/CLIENTE.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DIRECCIÓN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("RFC");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        jPanel1.add(t_dire, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 186, -1));

        t_RFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_RFCActionPerformed(evt);
            }
        });
        jPanel1.add(t_RFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 110, -1));

        t_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_emailActionPerformed(evt);
            }
        });
        jPanel1.add(t_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 190, -1));

        tabla.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID :", "NOMBRE", "DIRECCIÓN", "RFC", "EMAIL"
            }
        ));
        tabla.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 550, 130));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logogrande.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 12, 720, 110));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CLIENTE");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 68, -1));

        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton2.setText("GUARDAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jButton4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton4.setText("BUSCAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NOMBRE");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        jPanel1.add(t_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 186, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("EMAIL");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 70, 20));

        jButton6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton6.setText("MODIFICAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 140, 30));
        jPanel1.add(idt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, -1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
            conexion cc=new conexion();
            Connection cn = cc.conectar();
            String nombre,direccion,rfc,email;
            String sql="";
          
           
            nombre=t_nom.getText();
            direccion= t_dire.getText();
                        email=t_email.getText();
            rfc=t_RFC.getText();

            sql="INSERT INTO clientes (nombre_Clientes,dirreccion_Clientes,email_Clienres,RFC_Clientes) VALUES (?,?,?,?) "; 
              try {
            PreparedStatement pst = cn.prepareStatement(sql);
        
           
            pst.setString(1,nombre);
            pst.setString(2,direccion);
            pst.setString(4,rfc);
            pst.setString(3,email);
          int n=pst.executeUpdate();
          
          if(n>0) {
              JOptionPane.showMessageDialog(null,"registro guardado");
                Limpiar();
              mostrardatos("");
          }
        } catch (SQLException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
              
              
              
              
              
              
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
mostrardatos(jTextField1.getText());

  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void t_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_emailActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
 conexion cc=new conexion();
 Connection cn = cc.conectar();
 try {
                PreparedStatement pst=cn.prepareStatement("UPDATE clientes SET nombre_Clientes='"+t_nom.getText()+"',dirreccion_Clientes='"+t_dire.getText()+"',email_Clienres='"+t_email.getText()+"' ,RFC_Clientes='"+t_RFC.getText()+"'WHERE id_Clientes='"+idt.getText()+"'");
      String id=idt.getText();
     pst.executeUpdate();
     
     mostrardatos("");
     Limpiar();
 } catch(SQLException e) {
     System.out.print(e.getMessage());
    
 }
           
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
int fila=tabla.getSelectedRow();
     if(fila>=0) {
         
       idt.setText(tabla.getValueAt(fila,0).toString());
          t_nom.setText(tabla.getValueAt(fila,1).toString());
            t_dire.setText(tabla.getValueAt(fila,2).toString());
              t_email.setText(tabla.getValueAt(fila,3).toString());
                t_RFC.setText(tabla.getValueAt(fila,4).toString());
            String id= tabla.getValueAt(fila,0).toString();
    }
     else {
         JOptionPane.showMessageDialog(null,"no se encontro la fila");
     }

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
conexion cc=new conexion();
 Connection cn = cc.conectar();
 int fila=tabla.getSelectedRow();
 String cod="";
 cod=tabla.getValueAt(fila,0).toString();
 try {
     PreparedStatement pst=cn.prepareStatement("DELETE FROM clientes WHERE id_Clientes='"+cod+"'");
     pst.executeUpdate();
     mostrardatos("");
 } catch(Exception e) {
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    }
    private void t_RFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_RFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_RFCActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idt;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField t_RFC;
    private javax.swing.JTextField t_dire;
    private javax.swing.JTextField t_email;
    private javax.swing.JTextField t_nom;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    private void mostardatos(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
