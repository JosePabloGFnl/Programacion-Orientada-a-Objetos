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
import java.lang.System;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
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
public class cierres extends javax.swing.JFrame implements Runnable{
    String hora,minuto,segundo;
    Thread hilo;
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

       public void HORA(){
           Calendar calendario=new GregorianCalendar();
           Date HORA =new Date();
           calendario.setTime(HORA);
           hora= calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
           minuto= calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
           segundo= calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);

           
       }
       public void run(){
           Thread current=Thread.currentThread();
           while(current==hilo)
           {
               HORA();
               ibhora.setText(hora+":"+minuto+":"+segundo);           
                       }
       }         



    /**
     * Creates new form cierres
     */
    public cierres() {
        initComponents();
        hilo= new Thread(this);
        hilo.start();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        
        cajas.caja(NumC);
  
        
           mostrardatos("");
        
        
    }
    
     private void Limpiar(){
    this.codc.setText("");
    this.NumC.setSelectedItem("");
        this.fechac.setCalendar(null);
        this.Fecha.setText("");
       
        this.FondoC.setText("");
        this.efectivoc.setText("");
       this.ganciaC.setText("");
     
    
}
     //*

     //
   
   final void mostrardatos(String valor){
        Connection conn=null;
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Id del Cierre");
        modelo.addColumn("Codigo de Cierre de caja");
        modelo.addColumn("Numero de Caja");
        modelo.addColumn("Fecha de Cierre de caja");
        modelo.addColumn("Hora de Cierre de caja");
        modelo.addColumn("Fondo al inicar en Caja");
        modelo.addColumn("Efectivo al Terminar en caja");
        modelo.addColumn("Ganancia del dia ");
          
        TabC.setModel(modelo);
        String sql="";
        if (valor.equals(""))
        {
            sql="SELECT * FROM cierre";
        }
        else{
            sql="SELECT * FROM cierre WHERE (id_Cierre='"+valor+"'  OR cod_Cierre='"+valor+"')";
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
            TabC.setModel(modelo);
        }catch(SQLException ex){
            Logger.getLogger(cierres.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
       
   
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
      DefaultTableModel cierre= new DefaultTableModel();
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        efectivoc = new javax.swing.JTextField();
        FondoC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabC = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Guardarp = new javax.swing.JButton();
        ganciaC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        codc = new javax.swing.JTextField();
        NumC = new javax.swing.JComboBox<>();
        buscarp = new javax.swing.JButton();
        ModificarP = new javax.swing.JButton();
        Fecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ibhora = new javax.swing.JLabel();
        fechac = new com.toedter.calendar.JDateChooser();

        jMenuItem1.setText("Modificar");
        jMenuItem1.setToolTipText("");
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(29, 58, 142));
        jPanel1.setAutoscrolls(true);

        jLabel1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CIERRE DE CAJA");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NUMERO DE CIERRE");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MODIFICAR FECHA");

        idc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        idc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idcActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("FONDO DE CAJA");

        efectivoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        efectivoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efectivocActionPerformed(evt);
            }
        });

        FondoC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        FondoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FondoCActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("GANANCIA");

        TabC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TabC.setComponentPopupMenu(jPopupMenu1);
        jScrollPane3.setViewportView(TabC);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logogrande.jpg"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NUMERO DE CAJA");

        Guardarp.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        Guardarp.setText("Guardar Inventario");
        Guardarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarpActionPerformed(evt);
            }
        });

        ganciaC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ganciaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ganciaCActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("EFECTIVO DE CAJA");

        codc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        codc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codcActionPerformed(evt);
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

        ModificarP.setBackground(new java.awt.Color(255, 255, 255));
        ModificarP.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        ModificarP.setText("Modificar Producto");
        ModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarPActionPerformed(evt);
            }
        });

        Fecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("FECHA DE CIERRE");

        ibhora.setBackground(new java.awt.Color(153, 255, 0));
        ibhora.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        ibhora.setForeground(new java.awt.Color(255, 255, 255));
        ibhora.setText("HORA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(idc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(107, 107, 107))
                                            .addComponent(codc, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(NumC, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fechac, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))
                                        .addGap(78, 78, 78)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Fecha))))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(FondoC, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(efectivoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ganciaC, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(ibhora, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)))
                        .addGap(117, 117, 117))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Guardarp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ModificarP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(idc, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(ibhora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(efectivoc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FondoC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NumC)
                                    .addComponent(codc)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(fechac, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ganciaC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(Guardarp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ModificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(214, 214, 214))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void inv_final(){
    double fondo,efectivo,ganancia;
   
   
    fondo=Double.parseDouble(this.FondoC.getText());
    efectivo=Double.parseDouble(this.efectivoc.getText());
    ganancia=((fondo)+(efectivo));
this.ganciaC.setText(String.valueOf(ganancia));
   
}
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
                int fila=TabC.getSelectedRow();
    if(fila>=0){
        idc.setText(TabC.getValueAt(fila,0).toString());
        codc.setText(TabC.getValueAt(fila,1).toString());
        NumC.setSelectedItem(TabC.getValueAt(fila,2).toString());
         Fecha.setText(TabC.getValueAt(fila,3).toString());
         ibhora.setText(TabC.getValueAt(fila,4).toString());
         FondoC.setText(TabC.getValueAt(fila,5).toString());
         efectivoc.setText(TabC.getValueAt(fila,6).toString());
         ganciaC.setText(TabC.getValueAt(fila,7).toString());
            String codigo = TabC.getValueAt(fila,0).toString();
     
           
    }
    else{
        JOptionPane.showMessageDialog(null,"No se encontro fila");
    } 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
             Connection conn=null;
             
                 int fila=TabC.getSelectedRow();
                String cod="";
                cod=TabC.getValueAt(fila,0).toString();
                try{
                    conn= getConnection();
                ps=conn.prepareStatement("DELETE  FROM cierre WHERE id_Cierre='"+cod+"'");
              
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

    private void FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaActionPerformed

    private void ModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarPActionPerformed
        // TODO add your handling code here:
        Connection conn=null;
        try {
            conn= getConnection();
            ps=conn.prepareStatement("UPDATE cierre SET cod_Cierre='"+codc.getText()+"',Caja_Cierre='"+NumC.getSelectedItem().toString()+"',fecha_Cierre='"+Fecha.getText()+"',hora_Cierre='"+ibhora.getText()+"',Fondo_Cierre='"+FondoC.getText()+"',efect_cierre='"+efectivoc.getText()+"',gananciaDia_Cierre='"+ganciaC.getText()+"' WHERE id_Cierre='"+idc.getText()+"'");
            String codigo = idc.getText();

            int res=ps.executeUpdate();
            mostrardatos("");
            if(res>0){
                JOptionPane.showMessageDialog(null,"Error Modificado");
                Limpiar();
            }  else{
                JOptionPane.showMessageDialog(null," Error al Modificar");
            }
            conn.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }//GEN-LAST:event_ModificarPActionPerformed

    private void buscarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarpActionPerformed
        // TODO add your handling code here:
        mostrardatos(codc.getText());
    }//GEN-LAST:event_buscarpActionPerformed

    private void codcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codcActionPerformed

    private void ganciaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ganciaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ganciaCActionPerformed

    private void GuardarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarpActionPerformed
        // TODO add your handling code here:

        inv_final();
        Connection conn=null;
        try {
            conn= getConnection();
            ps=conn.prepareStatement("INSERT INTO cierre(cod_Cierre,Caja_Cierre,fecha_Cierre,hora_Cierre,Fondo_Cierre,efect_cierre,gananciaDia_Cierre) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1,codc.getText());

            ps.setString(2,NumC.getSelectedItem().toString());

            ps.setString(3,((JTextField)fechac.getDateEditor().getUiComponent()).getText());
            ps.setString(4,ibhora.getText());
            ps.setString(5,FondoC.getText());
            ps.setString(6,efectivoc.getText());
            ps.setString(7,ganciaC.getText());

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

    private void FondoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FondoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FondoCActionPerformed

    private void efectivocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efectivocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_efectivocActionPerformed

    private void idcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idcActionPerformed

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
            java.util.logging.Logger.getLogger(cierres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cierres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cierres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cierres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cierres().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Fecha;
    private javax.swing.JTextField FondoC;
    private javax.swing.JButton Guardarp;
    private javax.swing.JButton ModificarP;
    private javax.swing.JComboBox<String> NumC;
    private javax.swing.JTable TabC;
    private javax.swing.JButton buscarp;
    private javax.swing.JTextField codc;
    private javax.swing.JTextField efectivoc;
    private com.toedter.calendar.JDateChooser fechac;
    private javax.swing.JTextField ganciaC;
    private javax.swing.JLabel ibhora;
    private javax.swing.JTextField idc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

}
