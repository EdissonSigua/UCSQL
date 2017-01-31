/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import CapaPruebas.Prueba;
import static LogicaNegocios.ObtenerInformacion.NombresTablas;
import static LogicaNegocios.ObtenerInformacion.obtenerSeleccionar;
import static LogicaNegocios.ObtenerInformacion.obtenerUnir;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class EntornoMain extends javax.swing.JFrame {

    private String [] nombreTablas;
   // private List<JButton> botones;
    private static int indiceBoton;
    private String Mensaje;
    private String Consola;
    private Prueba pruebaMain ;
    
    public EntornoMain() {
        initComponents();
        this.nombreTablas=NombresTablas();
        //this.botones=new ArrayList<>();
        this.indiceBoton=0;
        pruebaMain = new Prueba();
    }

    public static int getIndiceBoton() {
        return indiceBoton;
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldEjecutar = new javax.swing.JTextField();
        jButtonEjecutar = new javax.swing.JButton();
        jScrollPaneDirectorios = new javax.swing.JScrollPane();
        jPanelDirectorios = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSalida = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaConsulta = new javax.swing.JTextArea();
        jButtonLimpiar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                mostrarTablaWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(153, 0, 2));
        jLabelTitulo.setText(" Sistema Gestor de Base de Datos");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 700, 40));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        getContentPane().add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 32)); // NOI18N
        jLabel1.setText("CONSULTAS:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, 220, 30));

        jTextFieldEjecutar.setFont(new java.awt.Font("Verdana", 0, 19)); // NOI18N
        jTextFieldEjecutar.setToolTipText("");
        jTextFieldEjecutar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 2)));
        jTextFieldEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEjecutarActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldEjecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 680, 50));

        jButtonEjecutar.setBackground(new java.awt.Color(153, 0, 2));
        jButtonEjecutar.setFont(new java.awt.Font("Verdana", 0, 19)); // NOI18N
        jButtonEjecutar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEjecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ejecutar2.png"))); // NOI18N
        jButtonEjecutar.setToolTipText("EJECUTAR");
        jButtonEjecutar.setBorder(null);
        jButtonEjecutar.setBorderPainted(false);
        jButtonEjecutar.setContentAreaFilled(false);
        jButtonEjecutar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEjecutar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEjecutar.setIconTextGap(-3);
        jButtonEjecutar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ejecutar3.png"))); // NOI18N
        jButtonEjecutar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ejecutar1.png"))); // NOI18N
        jButtonEjecutar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonEjecutar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEjecutarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEjecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 130, 80, 80));

        jScrollPaneDirectorios.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneDirectorios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 2), 2));
        jScrollPaneDirectorios.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPaneDirectorios.setToolTipText("");

        jPanelDirectorios.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDirectorios.setToolTipText("");
        jPanelDirectorios.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPaneDirectorios.setViewportView(jPanelDirectorios);

        getContentPane().add(jScrollPaneDirectorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 290, 390));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 32)); // NOI18N
        jLabel2.setText("TABLAS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 19)); // NOI18N
        jLabel3.setText("CONSOLA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 140, 30));

        jTextAreaSalida.setEditable(false);
        jTextAreaSalida.setColumns(20);
        jTextAreaSalida.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jTextAreaSalida.setRows(5);
        jTextAreaSalida.setAlignmentX(50.0F);
        jTextAreaSalida.setAlignmentY(50.0F);
        jTextAreaSalida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 2)));
        jScrollPane1.setViewportView(jTextAreaSalida);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 860, 160));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 32)); // NOI18N
        jLabel4.setText("SALIDA: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 260, 150, 30));

        jTextAreaConsulta.setEditable(false);
        jTextAreaConsulta.setColumns(20);
        jTextAreaConsulta.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jTextAreaConsulta.setRows(5);
        jTextAreaConsulta.setAlignmentX(50.0F);
        jTextAreaConsulta.setAlignmentY(50.0F);
        jTextAreaConsulta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 2)));
        jScrollPane2.setViewportView(jTextAreaConsulta);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 860, 160));

        jButtonLimpiar.setBackground(new java.awt.Color(153, 0, 2));
        jButtonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/limpiar2.png"))); // NOI18N
        jButtonLimpiar.setToolTipText("LIMPIAR");
        jButtonLimpiar.setBorder(null);
        jButtonLimpiar.setContentAreaFilled(false);
        jButtonLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLimpiar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/limpiar3.png"))); // NOI18N
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 130, 70, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EntornoMain.jpg"))); // NOI18N
        jLabelFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 2), 3));
        jLabelFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEjecutarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEjecutarActionPerformed

    private void mostrarTablaWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_mostrarTablaWindowOpened
        crearBotones();
    }//GEN-LAST:event_mostrarTablaWindowOpened

    private void jButtonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEjecutarActionPerformed
        if(!"".equals(jTextFieldEjecutar.getText().trim())){
            //pruebaMain.Ejecutar(jTextFieldEjecutar.getText().trim());
            if(pruebaMain.Ejecutar(jTextFieldEjecutar.getText().trim())){
                //System.out.println("CORRECTO");
                jTextAreaSalida.setText("Sentencia ejecutada correctamente!!");
                jTextAreaSalida.setForeground(Color.green);
                //Prueba.sentencia="";
                this.nombreTablas=NombresTablas();
                jPanelDirectorios.removeAll();
                crearBotones();
                if(obtenerSeleccionar()!=null){
                    if(!obtenerSeleccionar().equals(""))
                        jTextAreaConsulta.setText(obtenerSeleccionar());
                }
                if(obtenerUnir()!=null){
                    if(!obtenerUnir().equals(""))
                        jTextAreaConsulta.setText(obtenerUnir());
                }
            }else{
                //System.out.println(Prueba.errores);
                jTextAreaSalida.setText(Prueba.errores);
                jTextAreaSalida.setForeground(Color.red);
                //Prueba.sentencia="";
                
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Línea de comando vacía!","Error",JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_jButtonEjecutarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        jTextAreaConsulta.setText("");
        jTextAreaSalida.setText("");
        jTextFieldEjecutar.setText("");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(EntornoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntornoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntornoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntornoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntornoMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelDirectorios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneDirectorios;
    private javax.swing.JTextArea jTextAreaConsulta;
    private javax.swing.JTextArea jTextAreaSalida;
    private javax.swing.JTextField jTextFieldEjecutar;
    // End of variables declaration//GEN-END:variables
    
    private void crearBotones(){
        JButton botonBD=new JButton("MetaBD");
        botonBD.setBackground(java.awt.Color.darkGray);
        botonBD.setForeground(Color.white);
        botonBD.setFont(new Font("Verdana",3,19));
        jPanelDirectorios.add(botonBD);
        //this.botones.add(botonBD);
        botonBD.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    File objetofile = new File ("ArchivoMetaBD/MetaBD.CSV");
                    Desktop.getDesktop().open(objetofile);
                }catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        indiceBoton++;
        jPanelDirectorios.updateUI();
        if(this.nombreTablas!=null){
            for(int i=0;i<this.nombreTablas.length;i++){
               JButton boton=new JButton(this.nombreTablas[i]);
               boton.setBackground(java.awt.Color.darkGray);
               boton.setForeground(Color.white);
               boton.setFont(new Font("Verdana",2,19));
               jPanelDirectorios.add(boton);
               //this.botones.add(boton);
               boton.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e){
                       AbrirTabla(boton.getText());
                   }
               });
               indiceBoton++;
               jPanelDirectorios.updateUI();
           }
        }
    }
    private void AbrirTabla(String nombre){
        try {
            File objetofile = new File ("Tablas/"+nombre);
            Desktop.getDesktop().open(objetofile);
     }catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
     }
    }
}
