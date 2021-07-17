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

/**
 *
 * @author Monica Flores
 * 
 */


public class Productos extends javax.swing.JFrame {
    combo cajas=new combo();
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
    this.codigop.setText("");
        this.nomp.setText("");
        this.NumC.setSelectedItem("seleccione una opcion");
        this.descripp.setText("");
        this.preciop.setText("");
        this.totalp.setText("");
        this.vendidosp.setText("");
        this.sobrantesp.setText("");
    
}
    /**
     * Creates new form Productos
     */
    public Productos() {
        initComponents();
        mostrardatos("");
          mostrardatos1("");
           cajas.caji(NumC);
        
    
    }

 final void mostrardatos(String valor){
        Connection conn=null;
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Id del producto");
        modelo.addColumn("Codigo de producto");
        modelo.addColumn("Marca de producto");
        modelo.addColumn("Nombre de producto");
        modelo.addColumn("Descripcion de producto");
        modelo.addColumn("Precio de producto");
        modelo.addColumn("Total de productos");
        modelo.addColumn("Producto vendidos");
        modelo.addColumn("Producto sobrantes");
          
        Tabinvt.setModel(modelo);
        String sql="";
        if (valor.equals(""))
        {
            sql="SELECT * FROM productos";
        }
        else{
            sql="SELECT * FROM productos WHERE (id_Productos='"+valor+"'  OR codigo_Producto='"+valor+"')";
        }  
        
        String []datos=new String [9];
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
            datos[5]=rs.getString(6);
            datos[6]=rs.getString(7);
            datos[7]=rs.getString(8);
            datos[8]=rs.getString(9);
            modelo.addRow(datos);
            }
            Tabinvt.setModel(modelo);
        }catch(SQLException ex){
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
 final void mostrardatos1(String valor){
        Connection conn=null;
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Id del detalle de venta");
        modelo.addColumn("id de venta");
        modelo.addColumn("id del producto");
        modelo.addColumn("codigo del producto");
        modelo.addColumn("cantidad del producto vendido por venta");
        Tabv.setModel(modelo);
        String sql="";
        if (valor.equals(""))
        {
            sql="SELECT * FROM detalle_ventas";
        }
        else{
            sql="SELECT * FROM detalle_ventas WHERE (id_ventadetalle='"+valor+"'  OR cod_pro='"+valor+"')";
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
            Tabv.setModel(modelo);
        }catch(SQLException ex){
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE,null,ex);
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
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codigop = new javax.swing.JTextField();
        nomp = new javax.swing.JTextField();
        preciop = new javax.swing.JTextField();
        descripp = new javax.swing.JTextField();
        totalp = new javax.swing.JTextField();
        vendidosp = new javax.swing.JTextField();
        buscarp = new javax.swing.JButton();
        Guardarp = new javax.swing.JButton();
        sobrantesp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabinvt = new javax.swing.JTable();
        ModificarP = new javax.swing.JButton();
        idp = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabv = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        NumC = new javax.swing.JComboBox<>();

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

        jMenuItem3.setText("Eliminar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(29, 58, 142));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logogrande.jpg"))); // NOI18N

        codigop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigopActionPerformed(evt);
            }
        });

        totalp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalpActionPerformed(evt);
            }
        });

        buscarp.setBackground(new java.awt.Color(255, 255, 255));
        buscarp.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        buscarp.setText("Buscar Producto");
        buscarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarpActionPerformed(evt);
            }
        });

        Guardarp.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        Guardarp.setText("Guardar Inventario");
        Guardarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarpActionPerformed(evt);
            }
        });

        Tabinvt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabinvt.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(Tabinvt);

        ModificarP.setBackground(new java.awt.Color(255, 255, 255));
        ModificarP.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        ModificarP.setText("Modificar Producto");
        ModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarPActionPerformed(evt);
            }
        });

        Tabv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabv.setComponentPopupMenu(jPopupMenu2);
        jScrollPane3.setViewportView(Tabv);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CODIGO DE PRODUCTO");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("MARCA DE PRODUCTO");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("NOMBRE DE PRODUCTO");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DESCRIPCION");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("PRECIO DE PRODUCTO");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("VENTA DE PRODUCTO");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("TOTAL DE PRODUCTO");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("STOCK");

        jLabel18.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("INVENTARIO DE PRODUCTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(Guardarp, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ModificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarp, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigop, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(NumC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(nomp, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(descripp, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(preciop)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1107, 1107, 1107)
                                .addComponent(idp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(jLabel1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(totalp, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vendidosp, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sobrantesp))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel17))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(537, 537, 537))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(idp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(descripp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(preciop, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nomp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(vendidosp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sobrantesp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(codigop, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(NumC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardarp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ModificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigopActionPerformed

    private void GuardarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarpActionPerformed
        inv_final();
        
        Connection conn=null;
             try {
                 conn= getConnection();
                 ps=conn.prepareStatement("INSERT INTO productos(codigo_Producto,marca_producto,nombre_Productos,descripcion_producto,PrecioF_Productos,Total_Producto,vendidos_Productos,sobrantes_Productos) VALUES(?,?,?,?,?,?,?,?)");
                 ps.setString(1,codigop.getText());
                 ps.setString(2,NumC.getSelectedItem().toString());
                 ps.setString(3,nomp.getText());
                 ps.setString(4,descripp.getText());
                 ps.setString(5,preciop.getText());
                 ps.setString(6,totalp.getText()); 
                 ps.setString(7,vendidosp.getText());
                 ps.setString(8,sobrantesp.getText());
                 int res=ps.executeUpdate();
                 mostrardatos("");
                 if(res>0){
                     JOptionPane.showMessageDialog(null,"producto guardado");
                     Limpiar();
                 }  else{
                      JOptionPane.showMessageDialog(null," Error al guardar producto");
                 }  
                 conn.close();
             }catch(Exception e){
                     System.err.println(e);
                     }
        
    }//GEN-LAST:event_GuardarpActionPerformed

    private void buscarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarpActionPerformed
        // TODO add your handling code here:
        mostrardatos(codigop.getText());

    }//GEN-LAST:event_buscarpActionPerformed

    private void ModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarPActionPerformed
        // TODO add your handling code here:
        inv_final();
         Connection conn=null;
             try {
                 conn= getConnection();
                 ps=conn.prepareStatement("UPDATE productos SET codigo_Producto='"+codigop.getText()+"',marca_producto='"+NumC.getSelectedItem().toString()+"',nombre_Productos='"+nomp.getText()+"',descripcion_producto='"+descripp.getText()+"',PrecioF_Productos='"+preciop.getText()+"',Total_Producto='"+totalp.getText()+"',vendidos_Productos='"+vendidosp.getText()+"',sobrantes_Productos='"+sobrantesp.getText()+"' WHERE id_Productos='"+idp.getText()+"'");
             String codigo = idp.getText();
         
                 int res=ps.executeUpdate();
                 mostrardatos("");
                 if(res>0){
                     JOptionPane.showMessageDialog(null,"producto Modificado");
                     Limpiar();
                 }  else{
                      JOptionPane.showMessageDialog(null," Error al Modificar producto");
                 }  
                 conn.close();
             }catch(Exception e){
                     System.err.println(e);
                     }
        
        
    }//GEN-LAST:event_ModificarPActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int fila=Tabinvt.getSelectedRow();
    if(fila>=0){
        idp.setText(Tabinvt.getValueAt(fila,0).toString());
        codigop.setText(Tabinvt.getValueAt(fila,1).toString());
         NumC.setSelectedItem(Tabinvt.getValueAt(fila,2).toString());
         nomp.setText(Tabinvt.getValueAt(fila,3).toString());
         descripp.setText(Tabinvt.getValueAt(fila,4).toString());
         preciop.setText(Tabinvt.getValueAt(fila,5).toString());
         totalp.setText(Tabinvt.getValueAt(fila,6).toString());
         vendidosp.setText(Tabinvt.getValueAt(fila,7).toString());
         sobrantesp.setText(Tabinvt.getValueAt(fila,8).toString());
            String codigo = Tabinvt.getValueAt(fila,0).toString();
           
    }
    else{
        JOptionPane.showMessageDialog(null,"No se encontro fila");
    }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Connection conn=null;
             
                 int fila=Tabinvt.getSelectedRow();
                String cod="";
                cod=Tabinvt.getValueAt(fila,0).toString();
                try{
                    conn= getConnection();
                ps=conn.prepareStatement("DELETE  FROM productos WHERE id_Productos='"+cod+"'");
              
                 int res=ps.executeUpdate();
                 mostrardatos("");
                 if(res>0){
                     JOptionPane.showMessageDialog(null,"producto Eliminado");
               
                 }  else{
                      JOptionPane.showMessageDialog(null," Error al Eliminar Producto");
                 }  
                 conn.close();
             }catch(Exception e){
                     System.err.println(e);
                     
                
             }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void totalpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalpActionPerformed
        // TODO add your handling code here:
 
    }//GEN-LAST:event_totalpActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
               Connection conn=null;
             
                 int fila=Tabv.getSelectedRow();
                String cod="";
                cod=Tabv.getValueAt(fila,0).toString();
                try{
                    conn= getConnection();
                ps=conn.prepareStatement("DELETE  FROM detalle_ventas WHERE id_ventadetalle='"+cod+"'");
              
                 int res=ps.executeUpdate();
                      mostrardatos1("");
                 if(res>0){
                     JOptionPane.showMessageDialog(null,"Historal Eliminado");
               
                 }  else{
                      JOptionPane.showMessageDialog(null," Error al Eliminar Historial");
                 }  
                 conn.close();
             }catch(Exception e){
                     System.err.println(e);
                     
                
             }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed
DefaultTableModel inventa= new DefaultTableModel();
public void inv_final(){
    double codigop, ingresos,engresos,stock;
    String nombrepr;
    codigop=Double.parseDouble(this.codigop.getText());
    nombrepr=nomp.getText();
    ingresos=Double.parseDouble(this.totalp.getText());
    engresos=Double.parseDouble(this.vendidosp.getText());
    stock=((ingresos)-(engresos));
this.sobrantesp.setText(String.valueOf(stock));
   
}
 
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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardarp;
    private javax.swing.JButton ModificarP;
    private javax.swing.JComboBox<String> NumC;
    private javax.swing.JTable Tabinvt;
    private javax.swing.JTable Tabv;
    private javax.swing.JButton buscarp;
    private javax.swing.JTextField codigop;
    private javax.swing.JTextField descripp;
    private javax.swing.JTextField idp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nomp;
    private javax.swing.JTextField preciop;
    private javax.swing.JTextField sobrantesp;
    private javax.swing.JTextField totalp;
    private javax.swing.JTextField vendidosp;
    // End of variables declaration//GEN-END:variables
}
