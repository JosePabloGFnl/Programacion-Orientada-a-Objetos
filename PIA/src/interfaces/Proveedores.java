package interfaces;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package proveedores.pkgfinal;

/**
 *
 * @author jp_gl
 */
public class Proveedores extends javax.swing.JFrame {
     private static Connection conn;
         public static final String DRIVER="com.mysql.jdbc.Driver";
       
          public static final String USUARIO="root";
         public static final String PASSWORD="xboxONE.5";
         public static final String URL="jdbc:mysql://localhost:3306/basetienda";
         PreparedStatement ps;
         ResultSet rs;
         
       public static Connection getConnection(){
             conn=null;
             try {
                 Class.forName(DRIVER);
                 conn=(Connection) DriverManager.getConnection(URL, USUARIO, PASSWORD);
                 if(conn !=null){
                     System.out.print("conexcion establecida");
                 }
                 
                 
             }catch(ClassNotFoundException | SQLException e){
                 System.out.print("conexcion no establecida"+e);
                 
             }
    

    
    return conn;
       }
   
    
    private void Limpiar(){
        this.jTextFieldID_Proveedor.setText("");
        this.jTextFieldID_Producto.setText("");
        this.jTextFieldProducto_Proveedor.setText("");
        this.jTextFieldCantidad_Proveedor.setText("");
        this.jTextFieldPrecio_Proveedor.setText("");
}
    /**
     * Creates new form Proveedores
     */
    public Proveedores() {
        initComponents();
        mostrardatos("");
    }

    
    
    final void mostrardatos(String valor){
        Connection conn=null;
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Id del proveedor");
        modelo.addColumn("Codigo de proveedores");
        modelo.addColumn("Nombre de proveedores");
         modelo.addColumn("Telefono de proveedores");
          modelo.addColumn("Direccion de proveedores");
        
          
        Tap.setModel(modelo);
        String sql="";
        if (valor.equals(""))
        {
            sql="SELECT * FROM proveedores";
        }
        else{
            sql="SELECT * FROM proveedores WHERE (id_Proveedores='"+valor+"'  OR cod_proveedores='"+valor+"')";
        }  
        
        String []datos=new String [5];
        try{
            conn= getConnection();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            datos[4]=rs.getString(5);
                   
            modelo.addRow(datos);
            }
            Tap.setModel(modelo);
        }catch(SQLException ex){
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jFondo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldID_Producto = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCantidad_Proveedor = new javax.swing.JTextField();
        jTextFieldPrecio_Proveedor = new javax.swing.JTextField();
        jTextFieldProducto_Proveedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tap = new javax.swing.JTable();
        jTextFieldID_Proveedor = new javax.swing.JTextField();

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
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jFondo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jFondo.setText("C");
        getContentPane().add(jFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-400, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(29, 58, 142));
        jPanel1.setAutoscrolls(true);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CODIGO DE PROVEEDOR");

        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonModificar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PROVEEDORES");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOMBRE DE PROVEEDOR");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TELEFONO DE PROVEEDOR");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DIRRECION DE PROVEEDOR");

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logogrande.jpg"))); // NOI18N

        Tap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tap.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(Tap);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelLogo)
                .addGap(131, 131, 131))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jButtonAgregar)
                        .addGap(133, 133, 133)
                        .addComponent(jButtonBuscar)
                        .addGap(125, 125, 125)
                        .addComponent(jButtonModificar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jTextFieldID_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldProducto_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCantidad_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPrecio_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(407, 407, 407)
                        .addComponent(jLabel1)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldID_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCantidad_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrecio_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldProducto_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));
        getContentPane().add(jTextFieldID_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        // TODO add your handling code here:
                Connection conn=null;
             try {
                 conn= getConnection();
                 ps=conn.prepareStatement("INSERT INTO proveedores(cod_proveedores,nombre_Proveedores,telefono_proveedor,direccion_proveedor) VALUES(?,?,?,?)");
            
                 ps.setString(1,jTextFieldID_Producto.getText());
                 ps.setString(2,jTextFieldProducto_Proveedor.getText());
                 ps.setString(3,jTextFieldCantidad_Proveedor.getText());
                 ps.setString(4,jTextFieldPrecio_Proveedor.getText());
                 int res=ps.executeUpdate();
                 mostrardatos("");
                 if(res>0){
                     JOptionPane.showMessageDialog(null,"proveedor guardado");
                     Limpiar();
                 }  else{
                      JOptionPane.showMessageDialog(null," Error al guardar proveedor");
                 }  
                 conn.close();
             }catch(Exception e){
                     System.err.println(e);
                     }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        mostrardatos(jTextFieldID_Producto.getText());
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
                 Connection conn=null;
             try {
                 conn= getConnection();
                 ps=conn.prepareStatement("UPDATE proveedores SET cod_proveedores='"+jTextFieldID_Producto.getText()+"',nombre_Proveedores='"+jTextFieldProducto_Proveedor.getText()+"',telefono_proveedor='"+jTextFieldCantidad_Proveedor.getText()+"',direccion_proveedor='"+jTextFieldPrecio_Proveedor.getText()+"' WHERE id_Proveedores='"+jTextFieldID_Proveedor.getText()+"'");
             String codigo = jTextFieldID_Proveedor.getText();
         
                 int res=ps.executeUpdate();
                 mostrardatos("");
                 if(res>0){
                     JOptionPane.showMessageDialog(null,"proveedor Modificado");
                     Limpiar();
                 }  else{
                      JOptionPane.showMessageDialog(null," Error al Modificar proveedor");
                 }  
                 conn.close();
             }catch(Exception e){
                     System.err.println(e);
                     }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
            int fila=Tap.getSelectedRow();
    if(fila>=0){
        jTextFieldID_Proveedor.setText(Tap.getValueAt(fila,0).toString());
        jTextFieldID_Producto.setText(Tap.getValueAt(fila,1).toString());
        jTextFieldProducto_Proveedor.setText(Tap.getValueAt(fila,2).toString());
        jTextFieldCantidad_Proveedor.setText(Tap.getValueAt(fila,3).toString());
        jTextFieldPrecio_Proveedor.setText(Tap.getValueAt(fila,4).toString());
            String codigo = Tap.getValueAt(fila,0).toString();
           
    }
    else{
        JOptionPane.showMessageDialog(null,"No se encontro fila");
    }
      
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
          Connection conn=null;
             
                 int fila=Tap.getSelectedRow();
                String cod="";
                cod=Tap.getValueAt(fila,0).toString();
                try{
                    conn= getConnection();
                ps=conn.prepareStatement("DELETE  FROM proveedores WHERE id_Proveedores='"+cod+"'");
              
                 int res=ps.executeUpdate();
                 mostrardatos("");
                 if(res>0){
                     JOptionPane.showMessageDialog(null,"proveedor Eliminado");
               
                 }  else{
                      JOptionPane.showMessageDialog(null," Error al Eliminar Proveedor");
                 }  
                 conn.close();
             }catch(Exception e){
                     System.err.println(e);
                     
                
             
    }   
    }//GEN-LAST:event_jMenuItem2ActionPerformed
                                           
        // TODO add your handling code here:
                                           

                                        
        // TODO add your handling code here:
             
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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tap;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jFondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldCantidad_Proveedor;
    private javax.swing.JTextField jTextFieldID_Producto;
    private javax.swing.JTextField jTextFieldID_Proveedor;
    private javax.swing.JTextField jTextFieldPrecio_Proveedor;
    private javax.swing.JTextField jTextFieldProducto_Proveedor;
    // End of variables declaration//GEN-END:variables
}
