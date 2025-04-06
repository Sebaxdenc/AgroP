package agrop;
import javax.swing.JFrame;
import java.awt.Color;
import java.sql.*;
import clases.ConexiónDB;
import java.awt.Image;
import java.awt.Toolkit;
public class Agrologin extends javax.swing.JFrame {
    
    
    
    
    //Funcion para obtener IdUsuario
    public static int ObtenerIdUsuario(String user, String pass, Connection cn, ResultSet rs){
        try{
            cn = ConexiónDB.conectar();
            PreparedStatement pst = cn.prepareStatement("select id_usuario from usuario where nombre_usuario = '"
                + user + "' and contraseña = '" + pass +"'");
            rs = pst.executeQuery();
            if(rs.next()){
                return (rs.getInt("id_usuario"));
            }
        }
        catch(Exception e){
        }
        return -1;
    }
    //Este es el dato que despues se va para Agrosuelos para saber que en que Usuario estamos
    public static int id_usuario;
    //Estos son los datos para comprobar el usuario y contraseña
    public static String user = ""; 
    String pass = "";
    
    public Agrologin() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(getIconImage());
    }

    //Icono de JFrame
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("com/images/AGROP LOGO CENTRADO.png"));
        return retValue;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        cuadrose = new javax.swing.JLabel();
        panelRound1 = new agrop.PanelRound();
        pausu = new agrop.PanelRound();
        usuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pacontra = new agrop.PanelRound();
        contraseña = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        registrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        entrar = new agrop.PanelRound();
        entrarJLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        deco = new javax.swing.JLabel();
        bgcampe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(230, 230, 230));
        bg.setForeground(new java.awt.Color(230, 230, 230));
        bg.setMinimumSize(new java.awt.Dimension(570, 740));
        bg.setPreferredSize(new java.awt.Dimension(1000, 600));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cuadrose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadrose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/logoletra_1.png"))); // NOI18N
        cuadrose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bg.add(cuadrose, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, -10, 390, 230));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(40);
        panelRound1.setRoundBottomRight(40);
        panelRound1.setRoundTopLeft(40);
        panelRound1.setRoundTopRight(40);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pausu.setBackground(new java.awt.Color(230, 230, 230));
        pausu.setRoundBottomLeft(40);
        pausu.setRoundBottomRight(40);
        pausu.setRoundTopLeft(40);
        pausu.setRoundTopRight(40);

        usuario.setBackground(new java.awt.Color(230, 230, 230));
        usuario.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        usuario.setText("Usuario");
        usuario.setAutoscrolls(false);
        usuario.setBorder(null);
        usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuarioMousePressed(evt);
            }
        });
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/usuarioICON.png"))); // NOI18N

        javax.swing.GroupLayout pausuLayout = new javax.swing.GroupLayout(pausu);
        pausu.setLayout(pausuLayout);
        pausuLayout.setHorizontalGroup(
            pausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pausuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        pausuLayout.setVerticalGroup(
            pausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pausuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pausuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addComponent(usuario))
                .addContainerGap())
        );

        panelRound1.add(pausu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 310, 45));

        pacontra.setBackground(new java.awt.Color(230, 230, 230));
        pacontra.setRoundBottomLeft(40);
        pacontra.setRoundBottomRight(40);
        pacontra.setRoundTopLeft(40);
        pacontra.setRoundTopRight(40);

        contraseña.setBackground(new java.awt.Color(230, 230, 230));
        contraseña.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        contraseña.setText("Contraseña");
        contraseña.setAutoscrolls(false);
        contraseña.setBorder(null);
        contraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                contraseñaMousePressed(evt);
            }
        });
        contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/candadoICON.png"))); // NOI18N

        javax.swing.GroupLayout pacontraLayout = new javax.swing.GroupLayout(pacontra);
        pacontra.setLayout(pacontraLayout);
        pacontraLayout.setHorizontalGroup(
            pacontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pacontraLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        pacontraLayout.setVerticalGroup(
            pacontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pacontraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pacontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelRound1.add(pacontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 310, 45));

        registrar.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        registrar.setForeground(new java.awt.Color(0, 102, 51));
        registrar.setText("¿Sin cuenta aún? Registrate");
        registrar.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        registrar.setBorderPainted(false);
        registrar.setContentAreaFilled(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        panelRound1.add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 220, 30));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelRound1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 290, 10));

        entrar.setBackground(new java.awt.Color(108, 89, 49));
        entrar.setRoundBottomLeft(30);
        entrar.setRoundBottomRight(30);
        entrar.setRoundTopLeft(30);
        entrar.setRoundTopRight(30);

        entrarJLabel.setFont(new java.awt.Font("Gotham", 1, 18)); // NOI18N
        entrarJLabel.setForeground(new java.awt.Color(255, 255, 255));
        entrarJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entrarJLabel.setText("ENTRAR");
        entrarJLabel.setAlignmentY(0.0F);
        entrarJLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        entrarJLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        entrarJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entrarJLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                entrarJLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                entrarJLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout entrarLayout = new javax.swing.GroupLayout(entrar);
        entrar.setLayout(entrarLayout);
        entrarLayout.setHorizontalGroup(
            entrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entrarJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );
        entrarLayout.setVerticalGroup(
            entrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entrarJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRound1.add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 310, 40));

        jLabel6.setFont(new java.awt.Font("Gotham", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("INICIAR SESIÓN");
        panelRound1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 144, 390, 30));

        status.setFont(new java.awt.Font("Gotham", 2, 12)); // NOI18N
        status.setForeground(new java.awt.Color(0, 102, 51));
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 290, 10));

        bg.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 390, 480));

        deco.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        deco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/Decoracioninterfaz (1).png"))); // NOI18N
        deco.setText("jLabel4");
        bg.add(deco, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -70, -1, -1));

        bgcampe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgcampe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/campeGODdesenfocado.jpg"))); // NOI18N
        bg.add(bgcampe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void entrarJLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarJLabelMouseExited
        entrar.setBackground(new Color(108,89,49));
    }//GEN-LAST:event_entrarJLabelMouseExited

    private void entrarJLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarJLabelMouseEntered
        entrar.setBackground(new Color(61,53,37));
    }//GEN-LAST:event_entrarJLabelMouseEntered

    private void entrarJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarJLabelMouseClicked
        
        //A estos dos strings les doy sus respectivos valores
        user = usuario.getText().trim();
        pass = contraseña.getText().trim();
        //Compruebo que los campos de usuario y contraseña contengan algo
        if(!user.equals("") && !pass.equals("")){
            try{
                //Hago la conexion con la base de datos
                Connection cn = ConexiónDB.conectar();
                //Instrucciones a la base de datos
                PreparedStatement pst = cn.prepareStatement(
                    "select nombre_usuario, contraseña from usuario where nombre_usuario = '"+user
                        + "' and contraseña = '"+ pass + "'" );
                //Le digo que la ejecute
                ResultSet rs = pst.executeQuery();
                //Compruebo si se encontro la coincidencia
                if(rs.next()){
                    //Si el programa encontro coincidencias entonces miro que id tiene el usuario y lo mando a la siguiente pestaña
                    id_usuario = ObtenerIdUsuario(user, pass, cn, rs);
                    Agrosuelos.id_usuario = id_usuario;
                    Agrosuelos b = new Agrosuelos();
                    this.setVisible(false);
                    b.setVisible(true);
                    
                }
                else{
                   status.setText("Datos incorrectos");
                   usuario.setText("");
                   contraseña.setText("");
                }
            }
            catch(Exception e){
                status.setText("El usuario o la contraseña son incorrectos.");
            }
            
        }
        else{
            status.setText("Debes llenar todos los campos");
        }
        //-------
        
    }//GEN-LAST:event_entrarJLabelMouseClicked

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        Agroregister a = new Agroregister();
        this.setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_registrarActionPerformed

    private void contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñaActionPerformed

    private void contraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contraseñaMousePressed
        if(contraseña.getText().equals("Contraseña")){
            contraseña.setText("");
        }
        if(usuario.getText().isEmpty()){
            usuario.setText("Usuario");
        }
    }//GEN-LAST:event_contraseñaMousePressed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMousePressed
        if(usuario.getText().equals("Usuario")){
            usuario.setText("");
        }
        if(contraseña.getText().isEmpty()){
            contraseña.setText("Contraseña");
        }
    }//GEN-LAST:event_usuarioMousePressed

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
            java.util.logging.Logger.getLogger(Agrologin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agrologin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agrologin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agrologin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agrologin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel bgcampe;
    private javax.swing.JTextField contraseña;
    private javax.swing.JLabel cuadrose;
    private javax.swing.JLabel deco;
    private agrop.PanelRound entrar;
    private javax.swing.JLabel entrarJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private agrop.PanelRound pacontra;
    private agrop.PanelRound panelRound1;
    private agrop.PanelRound pausu;
    private javax.swing.JButton registrar;
    private javax.swing.JLabel status;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
