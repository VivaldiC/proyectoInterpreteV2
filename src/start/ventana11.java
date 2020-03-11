/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */

public class ventana11 extends javax.swing.JFrame {
     
    JFileChooser seleccionar = new JFileChooser();
    File Archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    private String currentLexema;
    String Lexema;
    Token Token;
    private Token currentToken;
    ArrayList<Tokens> nl;
    String texto="";
    String Documento1;
    NumeroLinea numerolinea;
    /**
     * Creates new form ventana1
     */
    public ventana11() {
        initComponents();
        numerolinea = new NumeroLinea(txtArea1);
        jScrollPane1.setRowHeaderView(numerolinea);
    }
    
    public void empezar(){
        Lexer lexer = new Lexer(Archivo.getPath());
        Syntax ns;
        nl = new ArrayList<Tokens>();
        while (!lexer.isExausthed()) {
            System.out.printf("%-18s %s\n", lexer.currentToken(), lexer.currentLexema());
            Tokens nt = new Tokens();
            nt.setLexema(lexer.currentLexema());
            nt.setLinea(1);
            String aux3;
            aux3 = lexer.currentToken().toString();
            nt.setToken(aux3);
            nl.add(nt);
            lexer.moveAhead();
        }
        
        
        
        for (int i = 0; i < nl.size(); i++) {
            
            texto = texto + "----- Token: " +  nl.get(i).getToken() + " Lexema: " + nl.get(i).getLexema() + " Linea: " + i +"  -------" + "\n";
            System.out.println("-----------------------");
            System.out.println(nl.get(i).getToken());
            System.out.println(nl.get(i).getLexema());
            System.out.println(nl.get(i).getLinea());
            System.out.println("-----------------------");
            
            
        }
        
        
        ns = new Syntax(nl);
        System.out.println(ns.Imprimir());
        

        if (lexer.isSuccessful()) {
            System.out.println("Ok! :D");
        } else {
            System.out.println(lexer.errorMessage());
        }
    }
    public void sintactico(){
        Sintactico ns = new Sintactico();
        
        for (int i = 0; i < nl.size(); i++) {
            String token = nl.get(i).getToken();
            switch (token){
                case "MAIN_KEYWORD":
                    break;
                case "DENTERO_KEYWORD":
                    break;
                case "DCONDICION_KEYWORD":
                    break;
                case "DMIENTRAS_KEYWORD":
                    break;
                case "ELSE_KEYWORD":
                    break;
                case "DCADENA_KEYWORD":
                    break;
                case "DFLOTANTE_KEYWORD":
                    break;
                case "DIMPRIMIR_KEYWORD":
                    break;
                case "DPAQUETE_KEYWORD":
                    break;
                case "PUBLICO_KEYWORD":
                    break;
                case "PRIVADO_KEYWORD":
                    break;
                case "SEMICOLON":
                    break;
                case "COMMA":
                    break;
                case "OPEN_BRACKET":
                    break;
                case "CLOSE_BRACKET":
                    break;
                case "OPEN_PARENTHESIS":
                    break;
                case "CLOSE_PARENTHESIS":
                    break;
                case "EQUAL":
                    break;
                case "DIFFERENT":
                    break;
                case "GREATER_EQUAL":
                    break;
                case "LESSER_EQUAL":
                    break;
                case "ATTRIBUTION":
                    break;
                case "GREATER":
                    break;
                case "LESSER":
                    break;
                case "ADDITION":
                    break;
                case "SUBTRACTION":
                    break;
                case "MULTIPLICATION":
                    break;
                case "DIVISION":
                    break;
                case "STRING":
                    break;
                case "NUMBER":
                    break;
                case "IDENTIFIER":
                    break;
                default:
                    break;
            }
        }
    }
    public void imprimir(){
        
        for (int i = 0; i < nl.size(); i++) {
            System.out.println("-----------------------");
            System.out.println(nl.get(i).getToken());
            nl.set(i, nl.get(i));
            System.out.println(nl.get(i).getLexema());
            System.out.println(nl.get(i).getLinea());
            System.out.println("-----------------------");
        }
    }
    public String AbrirArchivo(File Archivo){
        String Documento="";
        try{
            entrada=new FileInputStream(Archivo);
            int assci;
            while ((assci = entrada.read())!=-1){
                char caracter=(char)assci;
                Documento+=caracter;
                Documento1+=caracter;
            }
        }catch (Exception e){
            
        }
      return Documento;  
    }
    
    public String GuardarArchivo(File Archivo, String Documento){
        String mensaje=null;
        try{
            salida = new FileOutputStream(Archivo);
            byte[] bytxt = Documento.getBytes();
            salida.write(bytxt);
            mensaje="Archivo Guardado";
        } catch (Exception e){
            
        }
        return mensaje;
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
        txtArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelRes = new javax.swing.JTextPane();
        AnLexico = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        btnAbrir = new javax.swing.JMenuItem();
        btnGuardar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1280, 720));
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setResizable(false);

        txtArea1.setColumns(20);
        txtArea1.setRows(5);
        txtArea1.setMaximumSize(new java.awt.Dimension(400, 500));
        txtArea1.setMinimumSize(new java.awt.Dimension(400, 500));
        txtArea1.setPreferredSize(new java.awt.Dimension(400, 500));
        jScrollPane1.setViewportView(txtArea1);

        jScrollPane2.setViewportView(PanelRes);

        AnLexico.setText("Analizador Lexico");
        AnLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnLexicoActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("New Project");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        btnAbrir.setText("Open Project");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(btnAbrir);

        btnGuardar.setText("Save Project");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(btnGuardar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AnLexico)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(AnLexico, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea descartar el archivo?") == 0){
            txtArea1.setText("");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        // TODO add your handling code here:
        if(seleccionar.showDialog(null,"Abrir")== JFileChooser.APPROVE_OPTION){
            Archivo = seleccionar.getSelectedFile();
            if(Archivo.canRead()){
                if(Archivo.getName().endsWith("txt")){
                    String Documento = AbrirArchivo(Archivo);
                    txtArea1.setText(Documento);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Archivo No Compatible");
                }
            }
        }
    }//GEN-LAST:event_btnAbrirActionPerformed
 
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(seleccionar.showDialog(null, "Guardar")== JFileChooser.APPROVE_OPTION){
            Archivo=seleccionar.getSelectedFile();
            if(Archivo.getName().endsWith("txt")){
                String Documento=txtArea1.getText();
                String mensaje=GuardarArchivo(Archivo,Documento);
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null, mensaje);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
                
            }
            else{
                        JOptionPane.showMessageDialog(null, "Guardar Documento de Texto");
                        }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void AnLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnLexicoActionPerformed
        PanelRes.setText("");
        PanelRes.setText(texto);
        if(seleccionar.showDialog(null, "Guardar")== JFileChooser.APPROVE_OPTION){
            Archivo=seleccionar.getSelectedFile();
            if(Archivo.getName().endsWith("txt")){
                String Documento=txtArea1.getText();
                String mensaje=GuardarArchivo(Archivo,Documento);
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null, mensaje);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
                
            }
            else{
                        JOptionPane.showMessageDialog(null, "Guardar Documento de Texto");
                        }
        }
        empezar();
    }//GEN-LAST:event_AnLexicoActionPerformed
    public void analizer(String currentLexema, Token currentToken){
        this.currentToken = currentToken;
        this.currentLexema = currentLexema;
        
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
            java.util.logging.Logger.getLogger(ventana11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana11().setVisible(true);
                Start em = new Start();
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnLexico;
    private javax.swing.JTextPane PanelRes;
    private javax.swing.JMenuItem btnAbrir;
    private javax.swing.JMenuItem btnGuardar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtArea1;
    // End of variables declaration//GEN-END:variables
}
