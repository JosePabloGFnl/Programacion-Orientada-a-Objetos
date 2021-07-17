/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author batis
 */
public class cita extends javax.swing.JFrame  {

           Calendar horas=new GregorianCalendar();
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
       
       
   
         
         
   
    /**
     * Creates new form cita
     */
    public cita() {
        initComponents();

      
           mostrardatos("");
           cajas.caji(NumC);
    }
    
     private void Limpiar(){
    this.nuc.setText("");
   
        this.fechac.setCalendar(null);
        this.NumC.setSelectedItem(null);
        this.coc.setText("");
    
        this.idc.setText("");
        this.mc.setText("");
         this.fecp.setText("");
         this.horai.setText("");
     
    
}
       final void mostrardatos(String valor){
        Connection conn=null;
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Id del Cita");
        modelo.addColumn("Id de Producto");
        modelo.addColumn("Numero de cita");
        modelo.addColumn("Codigo de Proveedor");
        modelo.addColumn("Nombre de proveedor");
        modelo.addColumn("Asunto");
        modelo.addColumn("Fecha de cita ");
        modelo.addColumn("Hora de cita");
       
          
        Tac.setModel(modelo);
        String sql="";
        if (valor.equals(""))
        {
            sql="SELECT * FROM cita";
        }
        else{
            sql="SELECT * FROM cita WHERE (id_Cita='"+valor+"'  OR cod_cita='"+valor+"')";
        }  
        
        String []datos=new String [8];
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
      
            modelo.addRow(datos);
            }
            Tac.setModel(modelo);
        }catch(SQLException ex){
            Logger.getLogger(cita.class.getName()).log(Level.SEVERE,null,ex);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        coc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nuc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tac = new javax.swing.JTable();
        mc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ModificarP = new javax.swing.JButton();
        buscarp = new javax.swing.JButton();
        Guardarp = new javax.swing.JButton();
        fecp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Validar = new javax.swing.JButton();
        horai = new javax.swing.JTextField();
        fechac = new com.toedter.calendar.JDateChooser();
        NumC = new javax.swing.JComboBox<>();
        idp = new javax.swing.JTextField();
        idc = new javax.swing.JTextField();

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

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FECHA DE CITA");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CODIGO PROVEEDOR");

        coc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cocActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NUMERO DE CITA");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("COMPAÑIA PROVEEDOR");

        nuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nucActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logogrande.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CITAS DE LOS PROVEEDORES");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MOTIVO DE CITA");

        Tac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tac.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(Tac);

        mc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("HORA CITA");

        ModificarP.setBackground(new java.awt.Color(255, 255, 255));
        ModificarP.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        ModificarP.setText("Modificar Producto");
        ModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarPActionPerformed(evt);
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

        fecp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecpActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("MODIFICAR FECHA");

        Validar.setBackground(new java.awt.Color(255, 255, 255));
        Validar.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        Validar.setText("VALIDAR");
        Validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValidarActionPerformed(evt);
            }
        });

        horai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaiActionPerformed(evt);
            }
        });

        fechac.setDateFormatString("yyyy/MM/d\n");

        NumC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel8))
                                .addGap(42, 42, 42))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Validar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(mc, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fecp)
                                .addComponent(fechac, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addComponent(horai, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(coc, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nuc, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NumC, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Guardarp, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ModificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarp, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(364, 364, 364))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Guardarp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Validar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(nuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(NumC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(mc, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(fechac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(horai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)))
                                    .addComponent(coc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(fecp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)))))
                .addContainerGap(712, Short.MAX_VALUE))
        );

        idp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpActionPerformed(evt);
            }
        });

        idc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1019, 1019, 1019))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idc, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(687, 687, 687)
                .addComponent(idp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idcActionPerformed

    private void cocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cocActionPerformed

    private void nucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nucActionPerformed

    private void mcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mcActionPerformed

    private void idpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idpActionPerformed

    private void ModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarPActionPerformed
        // TODO add your handling code here:
        
        Connection conn=null;
        try {
            conn= getConnection();
            ps=conn.prepareStatement("UPDATE cita SET id_proveedores='"+idp.getText()+"',cod_cita='"+nuc.getText()+"',cod_proveedores='"+coc.getText()+"',nombre_Proveedores='"+NumC.getSelectedItem().toString()+"',descripcion_Cita='"+mc.getText()+"',fecha_Cita='"+fecp.getText()+"',hora_Cita='"+horai.getText()+"' WHERE id_Cita='"+idp.getText()+"'");
            String codigo = idp.getText();

            int res=ps.executeUpdate();
            mostrardatos("");
            if(res>0){
                JOptionPane.showMessageDialog(null,"Cita Modificado");
                Limpiar();
            }  else{
                JOptionPane.showMessageDialog(null," Error al Modificar Cita");
            }
            conn.close();
        }catch(Exception e){
            System.err.println(e);
        }

    }//GEN-LAST:event_ModificarPActionPerformed

    private void buscarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarpActionPerformed
        // TODO add your handling code here:
        mostrardatos(nuc.getText());
    }//GEN-LAST:event_buscarpActionPerformed

    private void GuardarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarpActionPerformed
     
        Connection conn=null;
        try {
            conn= getConnection();
            ps=conn.prepareStatement("INSERT INTO cita(id_proveedores,cod_cita,cod_proveedores,nombre_Proveedores,descripcion_Cita,fecha_Cita,hora_Cita) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1,idp.getText());
         
            ps.setString(2,nuc.getText());
            ps.setString(3,coc.getText());
            ps.setString(4,NumC.getSelectedItem().toString());

            ps.setString(5,mc.getText());
             ps.setString(6,((JTextField)fechac.getDateEditor().getUiComponent()).getText());
            ps.setString(7,horai.getText());
    
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

    private void fecpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fecpActionPerformed

    private void ValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValidarActionPerformed
        // TODO add your handling code here:
        Connection conn=null;

        try{
            conn= getConnection();
            ps=conn.prepareStatement("SELECT * FROM proveedores WHERE nombre_Proveedores=?");
            ps.setString(1,NumC.getSelectedItem().toString());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                idp.setText(rs.getString("id_Proveedores"));
                coc.setText(rs.getString("cod_proveedores"));
           
            }  else{
                JOptionPane.showMessageDialog(null," Error al guardar produto");
            }
            conn.close();

        }catch(SQLException ex){
            Logger.getLogger(cita.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_ValidarActionPerformed

    private void horaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaiActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
                       int fila=Tac.getSelectedRow();
    if(fila>=0){
        idc.setText(Tac.getValueAt(fila,0).toString());
        idp.setText(Tac.getValueAt(fila,1).toString());
        nuc.setText(Tac.getValueAt(fila,2).toString());
     
         coc.setText(Tac.getValueAt(fila,3).toString());
         NumC.setSelectedItem(Tac.getValueAt(fila,4).toString());
            mc.setText(Tac.getValueAt(fila,5).toString());
       
         fecp.setText(Tac.getValueAt(fila,6).toString());
             horai.setText(Tac.getValueAt(fila,7).toString());
            String codigo = Tac.getValueAt(fila,0).toString();
    }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here
        Connection conn=null;
             
                 int fila=Tac.getSelectedRow();
                String cod="";
                cod=Tac.getValueAt(fila,0).toString();
                try{
                    conn= getConnection();
                ps=conn.prepareStatement("DELETE  FROM cita WHERE id_Cita='"+cod+"'");
              
                 int res=ps.executeUpdate();
                 mostrardatos("");
                 if(res>0){
                     JOptionPane.showMessageDialog(null,"Cita Eliminado");
               
                 }  else{
                      JOptionPane.showMessageDialog(null," Error al Eliminar Cita");
                 }  
                 conn.close();
             }catch(Exception e){
                     System.err.println(e);
             }
                     
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardarp;
    private javax.swing.JButton ModificarP;
    private javax.swing.JComboBox<String> NumC;
    private javax.swing.JTable Tac;
    private javax.swing.JButton Validar;
    private javax.swing.JButton buscarp;
    private javax.swing.JTextField coc;
    private com.toedter.calendar.JDateChooser fechac;
    private javax.swing.JTextField fecp;
    private javax.swing.JTextField horai;
    private javax.swing.JTextField idc;
    private javax.swing.JTextField idp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JTextField mc;
    private javax.swing.JTextField nuc;
    // End of variables declaration//GEN-END:variables

  
    }
