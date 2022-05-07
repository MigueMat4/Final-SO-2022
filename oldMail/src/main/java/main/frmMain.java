/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mfmatul
 */
public class frmMain extends javax.swing.JFrame {
    
    static final int N = 5; // Tamaño del buzón
    String buzon[] = new String[N]; // Buzón para mensajes
    private int contadorEmisores = 1;
    private int contadorMensajeros = 1;
    String[] mensajes = {"El Real Madrid es el mejor equipo del mundo", 
        "DC es mejor que Marvel", 
        "Sistemas Operativos fue el curso favorito de los estudiantes", 
        "Ella no te ama :'c",
        "La pizza con piña sí es buena",
        "La paciencia es una virtud",
        "En clases no hay dudas, pero en los exámenes sí ¬¬",
        "Todos saben que Batman es mejor que Superman",
        "Esperamos algún día volver a la normalidad",
        "Puro manco estaba en el Team Iron Man",
        "Todos sabemos que Capitán América tenía la razón en Civil War",
        "Los tqm mis queridos estudiantes",
        "¿Cuándo jugamos una partida de among us?",
        "A los introvertidos no les afectó la pandemia",
        "XV Simposio - Ingeniería que transforma al mundo",
        "Todos saben que el frío es mejor que el calor",
        "Todos saben que Cristiano Ronaldo es mejor que Messi",
        "Hola, cómo están? Todo bien? Todo correcto?",
        "Ya no sé que más escribir xd",
        "Todos saben que la mayoría de estudiantes copia en la modalida virtual"};
    private final Emisor emisor = new Emisor();
    private final Mensajero mensajero = new Mensajero();
    ArrayList<String> buzonMensaje = new ArrayList();
    Monitor monitor = new Monitor();
    int contadorAux = 0;
    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        btnMenosEmisores.setEnabled(false);
        btnMenosMensajeros.setEnabled(false);
        txtBuzon.setEnabled(false);
        for (int i=0; i<N; i++)
            buzon[i] = "";
    }
    
    public class Emisor extends Thread {
        public String mensaje = "";
        @Override
        public void run(){
            while(true){
                while(buzonMensaje.size()<5){
                    try {
                        Thread.sleep((Integer.parseInt(lblEmisores.getText())) * 1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        monitor.enviarMensaje();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        // Debe buscar un mensaje aleatorio (0-19)
        // Si hay espacio en el buzón, debe colocar el mensaje en el text area
        // Ojo que el text area debe indicar el orden de prioridad en base a las líneas
        // El orden de ingreso es FIFO
    }
    
    public class Mensajero extends Thread {
        public String mensajeAEnviar = "";
        public void run(){
            jLabel1.setText(jLabel1.getText());
            while (true) {
                jLabel1.setText(jLabel1.getText());
                while(!buzonMensaje.isEmpty()){
                    try {
                        Thread.sleep((Integer.parseInt(lblMensajeros.getText())) * 1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        monitor.recibirMensaje();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        // Debe buscar el mensaje con la prioridad más alta
        // Envía el mensaje del buzón y lo debe mostrar en consola
        // Ojo que el text area debe indicar que línea de mensaje ya fue entregado
        // La línea que acaba de enviar debe mostrar al final un mensaje tipo: "Mensaje envíado"
        //int velocidad = Integer.parseInt(lblMensajeros.getText()) * 1000;
    }
    public class Monitor{
        public synchronized void enviarMensaje() throws InterruptedException{
            while (buzonMensaje.size()==5) {
                wait();
            }
            int numero = (int) (Math.random()*(19-0)) + 0;
            emisor.mensaje=mensajes[numero];
            txtBuzon.append(emisor.mensaje+"\n");
            buzonMensaje.add(emisor.mensaje);
            notify();
        }
        public synchronized void recibirMensaje() throws InterruptedException{
            while(buzonMensaje.isEmpty()){
                wait();
            }
            if(contadorAux!=buzonMensaje.size()){
                mensajero.mensajeAEnviar=buzonMensaje.get(contadorAux);
                buzonMensaje.set(contadorAux, mensajero.mensajeAEnviar + "  -  Enviado");
                System.out.println("Mensaje Enviado: " + mensajero.mensajeAEnviar);
                txtBuzon.setText("");
                for (int i = 0; i < buzonMensaje.size(); i++) {
                    txtBuzon.append(buzonMensaje.get(i)+"\n");
                }
                contadorAux++;
            }
            notify();
        }
    }
    
    public void actualizarBuzon() {
        txtBuzon.setText(buzon[0] + "\n" + buzon[1] + "\n" + buzon[2] + "\n" + buzon[3] + "\n" + buzon[4]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnMenosEmisores = new javax.swing.JButton();
        lblEmisores = new javax.swing.JLabel();
        btnMasEmisores = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnMenosMensajeros = new javax.swing.JButton();
        lblMensajeros = new javax.swing.JLabel();
        btnMasMensajeros = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblAcceso = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBuzon = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Evaluación Final - Sistemas Operativos");

        jLabel2.setText("1a convocatoria");
        jLabel2.setToolTipText("");

        jLabel3.setText("Velocidad Emisores:");

        btnMenosEmisores.setText("-");
        btnMenosEmisores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosEmisoresActionPerformed(evt);
            }
        });

        lblEmisores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmisores.setText("1");

        btnMasEmisores.setText("+");
        btnMasEmisores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasEmisoresActionPerformed(evt);
            }
        });

        jLabel4.setText("Velocidad Mensajeros:");

        btnMenosMensajeros.setText("-");
        btnMenosMensajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosMensajerosActionPerformed(evt);
            }
        });

        lblMensajeros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMensajeros.setText("1");

        btnMasMensajeros.setText("+");
        btnMasMensajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasMensajerosActionPerformed(evt);
            }
        });

        jLabel5.setText("Central de correo:");

        jLabel6.setText("En el buzón:");

        lblAcceso.setText("N/A");

        btnIniciar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnIniciar.setText("Iniciar programa");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        txtBuzon.setColumns(20);
        txtBuzon.setRows(5);
        jScrollPane1.setViewportView(txtBuzon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMenosEmisores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmisores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMasEmisores)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMenosMensajeros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMensajeros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMasMensajeros)))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAcceso))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(btnIniciar)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMenosEmisores)
                            .addComponent(lblEmisores)
                            .addComponent(btnMasEmisores)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMenosMensajeros)
                            .addComponent(lblMensajeros)
                            .addComponent(btnMasMensajeros))))
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblAcceso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnIniciar)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasEmisoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasEmisoresActionPerformed
        contadorEmisores++;
        lblEmisores.setText(String.valueOf(contadorEmisores));
        if (contadorEmisores == 2)
            btnMenosEmisores.setEnabled(true);
        if (contadorEmisores == 5)
            btnMasEmisores.setEnabled(false);
    }//GEN-LAST:event_btnMasEmisoresActionPerformed

    private void btnMenosEmisoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosEmisoresActionPerformed
        contadorEmisores--;
        lblEmisores.setText(String.valueOf(contadorEmisores));
        if (contadorEmisores == 4)
            btnMasEmisores.setEnabled(true);
        if (contadorEmisores == 1)
            btnMenosEmisores.setEnabled(false);
    }//GEN-LAST:event_btnMenosEmisoresActionPerformed

    private void btnMenosMensajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosMensajerosActionPerformed
        contadorMensajeros--;
        lblMensajeros.setText(String.valueOf(contadorMensajeros));
        if (contadorMensajeros == 4)
            btnMasMensajeros.setEnabled(true);
        if (contadorMensajeros == 1)
            btnMenosMensajeros.setEnabled(false);
    }//GEN-LAST:event_btnMenosMensajerosActionPerformed

    private void btnMasMensajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasMensajerosActionPerformed
        contadorMensajeros++;
        lblMensajeros.setText(String.valueOf(contadorMensajeros));
        if (contadorMensajeros == 2)
            btnMenosMensajeros.setEnabled(true);
        if (contadorMensajeros == 5)
            btnMasMensajeros.setEnabled(false);
    }//GEN-LAST:event_btnMasMensajerosActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        btnMenosEmisores.setEnabled(false);
        btnMasEmisores.setEnabled(false);
        btnMenosMensajeros.setEnabled(false);
        btnMasMensajeros.setEnabled(false);
        btnIniciar.setEnabled(false);
        emisor.start();
        mensajero.start();
    }//GEN-LAST:event_btnIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnMasEmisores;
    private javax.swing.JButton btnMasMensajeros;
    private javax.swing.JButton btnMenosEmisores;
    private javax.swing.JButton btnMenosMensajeros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAcceso;
    private javax.swing.JLabel lblEmisores;
    private javax.swing.JLabel lblMensajeros;
    private javax.swing.JTextArea txtBuzon;
    // End of variables declaration//GEN-END:variables
}