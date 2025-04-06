package agrop;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import clases.ConexiónDB;
import java.sql.*;
public class Agrosuelos extends javax.swing.JFrame {
    
    private agrop.PanelRound panelSeleccionado = null;
    private int contadorAlejo = 1;
    private Component espacioSeleccionado = null;
    private JLabel obtenerLabel = null;
    private int infinito = 1;
    
    //Este contador es para poder hacer funcionar el for siendo contador el maximo indice de id_lote
    //Va a obtener adentro el valor maximo de id_lote en la tabla carpeta_suelo
    public static int contadorSebas;    
    //Esta es la variable que tomo el dato de la pestaña anterior (agrologin)
    public static int id_usuario;
    //Para obtener el valor de contador
    public static int ObtenerMaxIdLote(){
        try{
            Connection cn = ConexiónDB.conectar();
            
            PreparedStatement pst = cn.prepareStatement("select MAX(id_lote) max_id_lote from carpeta_lote");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return (rs.getInt("max_id_lote"));
            }
        }
        catch(Exception e){
            System.err.println("Error en base de datos" + e);
            JOptionPane.showMessageDialog(null, "Error al conectar con base de datos, contacte al programador tqm");
        }
        return -1;
    }
    
    

    public Agrosuelos() {
        initComponents();
        paneles();
        showPanelLotes();
        setIconImage(getIconImage());
    }
    
    //Icono de JFrame
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("com/images/AGROP LOGO CENTRADO.png"));
        return retValue;
    }
    
    private void showPanelLotes(){
        contadorSebas = ObtenerMaxIdLote();
        //Sebas
        String nombre_lote = "";
        //Este for es para que valla incrementando el id del lote para poder obtener el nombre de cada uno
        //No es infinito porque se va a romper cuando llegue al indice maximo de lotes
        for(int i=1; i<=contadorSebas; i++){
            try{
                //Hago la conexion con la base de datos
                Connection cn = ConexiónDB.conectar();
                //Instrucciones a la base de datos
                PreparedStatement pst = cn.prepareStatement(
                    "select nombre_lote from carpeta_lote where id_usuario = "+id_usuario
                        + " and id_lote = " +i);
                //Le digo que la ejecute
                ResultSet rs = pst.executeQuery();
                //Compruebo si se encontro la coincidencia
                if(rs.next()){
                   nombre_lote = rs.getString("nombre_lote");
                   agregarNuevoPanel (nombre_lote);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al agregar lotes, contacte al programador tqm");
            }
        }
    }
    
    
    
    private void paneles() {
        panelalbergar.setLayout(new BoxLayout(panelalbergar, BoxLayout.Y_AXIS));
    }
    
    private void agregarNuevoPanel(String nombre_lote) {
        if(contadorAlejo<=7){
            Component espacioNuevo = Box.createRigidArea(new Dimension(0, 10));
            agrop.PanelRound nuevoPanel = new agrop.PanelRound();

            nuevoPanel.setBackground(new Color(230, 230, 230));
            nuevoPanel.setPreferredSize(new Dimension(418, 35)); //418
            nuevoPanel.setLayout(null);
            nuevoPanel.setRoundBottomLeft(10);
            nuevoPanel.setRoundBottomRight(10);
            nuevoPanel.setRoundTopLeft(10);
            nuevoPanel.setRoundTopRight(10);


            JLabel label = new JLabel(nombre_lote);
            label.setBounds(0,0,418,35);
            label.setFont(new java.awt.Font("Gotham", 0, 15));
            label.setForeground(new java.awt.Color(60, 60, 60));
            label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            nuevoPanel.add(label);
            contadorAlejo++;
            infinito ++;

            panelalbergar.add(nuevoPanel);
            panelalbergar.add(espacioNuevo);
            panelalbergar.revalidate();
            panelalbergar.repaint();


            nuevoPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    seleccionarPanel(nuevoPanel, espacioNuevo, label);
                }
            });
        }
        else{
            status.setText("No se pueden exceder los 8 lotes :(");
        }
    }
    
    //Esta variable es para ingresar al lote correspondiendete en la siguiente pestaña
    public String nombre_lote;
    
    private void cambiarNombre(){
        obtenerLabel.setText(cambiarnombrejtextfield.getText());
    }
    
    private void seleccionarPanel(agrop.PanelRound panel, Component madafaka, JLabel sisisi) {
        if (panelSeleccionado != null) {
            panelSeleccionado.setBackground(new Color(230, 230, 230));
        }
        panelSeleccionado = panel;
        espacioSeleccionado = madafaka;
        obtenerLabel = sisisi;
        
        //Este dato lo utilizare más adelante para saber el nombre del panel que tengo seleccionado
        nombre_lote = sisisi.getText();
        
        panelSeleccionado.setBackground(new Color(200, 200, 200));
    }
    
    private void borrarPanelSeleccionado() {
        if (panelSeleccionado != null) {
            panelalbergar.remove(panelSeleccionado);
            panelalbergar.remove(espacioSeleccionado);
            panelalbergar.revalidate();
            panelalbergar.repaint();
            jPanel1.revalidate();
            jPanel1.repaint();
            panelSeleccionado = null;
            contadorAlejo--;
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        agregarpanel = new agrop.PanelRound();
        agregarjlabel = new javax.swing.JLabel();
        borrarpanel = new agrop.PanelRound();
        borrarjlabel = new javax.swing.JLabel();
        panelmenus = new agrop.PanelRound();
        panelalbergar = new javax.swing.JPanel();
        ingresarpanel = new agrop.PanelRound();
        ingresarjlabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        checkjpanel = new agrop.PanelRound();
        checkjlabel = new javax.swing.JLabel();
        cambionombrejpanel = new agrop.PanelRound();
        cambiarnombrejtextfield = new javax.swing.JTextField();
        status = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CerrarSesionPanel = new agrop.PanelRound();
        cerrarSesionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(230, 230, 230));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarpanel.setBackground(new java.awt.Color(108, 89, 49));
        agregarpanel.setRoundBottomLeft(10);
        agregarpanel.setRoundBottomRight(10);
        agregarpanel.setRoundTopLeft(10);
        agregarpanel.setRoundTopRight(10);

        agregarjlabel.setFont(new java.awt.Font("Gotham", 1, 22)); // NOI18N
        agregarjlabel.setForeground(new java.awt.Color(255, 255, 255));
        agregarjlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        agregarjlabel.setText("AGREGAR");
        agregarjlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarjlabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        agregarjlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarjlabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agregarjlabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                agregarjlabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout agregarpanelLayout = new javax.swing.GroupLayout(agregarpanel);
        agregarpanel.setLayout(agregarpanelLayout);
        agregarpanelLayout.setHorizontalGroup(
            agregarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(agregarjlabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        agregarpanelLayout.setVerticalGroup(
            agregarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(agregarjlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(agregarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 210, 40));

        borrarpanel.setBackground(new java.awt.Color(108, 89, 49));
        borrarpanel.setRoundBottomLeft(10);
        borrarpanel.setRoundBottomRight(10);
        borrarpanel.setRoundTopLeft(10);
        borrarpanel.setRoundTopRight(10);

        borrarjlabel.setFont(new java.awt.Font("Gotham", 1, 22)); // NOI18N
        borrarjlabel.setForeground(new java.awt.Color(255, 255, 255));
        borrarjlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        borrarjlabel.setText("BORRAR");
        borrarjlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        borrarjlabel.setRequestFocusEnabled(false);
        borrarjlabel.setVerifyInputWhenFocusTarget(false);
        borrarjlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarjlabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                borrarjlabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                borrarjlabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout borrarpanelLayout = new javax.swing.GroupLayout(borrarpanel);
        borrarpanel.setLayout(borrarpanelLayout);
        borrarpanelLayout.setHorizontalGroup(
            borrarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borrarpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(borrarjlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        borrarpanelLayout.setVerticalGroup(
            borrarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borrarpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(borrarjlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(borrarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 210, 40));

        panelmenus.setBackground(new java.awt.Color(255, 255, 255));
        panelmenus.setRoundBottomLeft(10);
        panelmenus.setRoundBottomRight(10);
        panelmenus.setRoundTopLeft(10);
        panelmenus.setRoundTopRight(10);

        panelalbergar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelalbergarLayout = new javax.swing.GroupLayout(panelalbergar);
        panelalbergar.setLayout(panelalbergarLayout);
        panelalbergarLayout.setHorizontalGroup(
            panelalbergarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );
        panelalbergarLayout.setVerticalGroup(
            panelalbergarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelmenusLayout = new javax.swing.GroupLayout(panelmenus);
        panelmenus.setLayout(panelmenusLayout);
        panelmenusLayout.setHorizontalGroup(
            panelmenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelmenusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelalbergar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelmenusLayout.setVerticalGroup(
            panelmenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelalbergar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.add(panelmenus, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 430, 320));

        ingresarpanel.setBackground(new java.awt.Color(108, 89, 49));
        ingresarpanel.setRoundBottomLeft(10);
        ingresarpanel.setRoundBottomRight(10);
        ingresarpanel.setRoundTopLeft(10);
        ingresarpanel.setRoundTopRight(10);

        ingresarjlabel.setFont(new java.awt.Font("Gotham", 1, 22)); // NOI18N
        ingresarjlabel.setForeground(new java.awt.Color(255, 255, 255));
        ingresarjlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingresarjlabel.setText("INGRESAR");
        ingresarjlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ingresarjlabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ingresarjlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresarjlabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ingresarjlabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ingresarjlabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ingresarpanelLayout = new javax.swing.GroupLayout(ingresarpanel);
        ingresarpanel.setLayout(ingresarpanelLayout);
        ingresarpanelLayout.setHorizontalGroup(
            ingresarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ingresarjlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        ingresarpanelLayout.setVerticalGroup(
            ingresarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ingresarjlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(ingresarpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 430, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/circulo 130130.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -30, 210, 150));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/circulo 5050.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/circulo 5050.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        checkjpanel.setBackground(new java.awt.Color(33, 131, 128));
        checkjpanel.setRoundBottomLeft(10);
        checkjpanel.setRoundBottomRight(10);
        checkjpanel.setRoundTopLeft(10);
        checkjpanel.setRoundTopRight(10);

        checkjlabel.setBackground(new java.awt.Color(33, 131, 128));
        checkjlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        checkjlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/check.png"))); // NOI18N
        checkjlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkjlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkjlabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                checkjlabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                checkjlabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout checkjpanelLayout = new javax.swing.GroupLayout(checkjpanel);
        checkjpanel.setLayout(checkjpanelLayout);
        checkjpanelLayout.setHorizontalGroup(
            checkjpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(checkjlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        checkjpanelLayout.setVerticalGroup(
            checkjpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(checkjlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jPanel1.add(checkjpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 40, -1));

        cambionombrejpanel.setBackground(new java.awt.Color(33, 131, 128));
        cambionombrejpanel.setRoundBottomLeft(10);
        cambionombrejpanel.setRoundBottomRight(10);
        cambionombrejpanel.setRoundTopLeft(10);
        cambionombrejpanel.setRoundTopRight(10);

        cambiarnombrejtextfield.setBackground(new java.awt.Color(33, 131, 128));
        cambiarnombrejtextfield.setFont(new java.awt.Font("Gotham", 1, 22)); // NOI18N
        cambiarnombrejtextfield.setForeground(new java.awt.Color(255, 255, 255));
        cambiarnombrejtextfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cambiarnombrejtextfield.setText("CAMBIAR NOMBRE");
        cambiarnombrejtextfield.setBorder(null);
        cambiarnombrejtextfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarnombrejtextfieldMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout cambionombrejpanelLayout = new javax.swing.GroupLayout(cambionombrejpanel);
        cambionombrejpanel.setLayout(cambionombrejpanelLayout);
        cambionombrejpanelLayout.setHorizontalGroup(
            cambionombrejpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cambionombrejpanelLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(cambiarnombrejtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        cambionombrejpanelLayout.setVerticalGroup(
            cambionombrejpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cambiarnombrejtextfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(cambionombrejpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 380, 40));

        status.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        status.setForeground(new java.awt.Color(102, 51, 0));
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 20));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/circulo 5050.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, -1, -1));

        CerrarSesionPanel.setBackground(new java.awt.Color(255, 255, 255));
        CerrarSesionPanel.setRoundBottomLeft(10);
        CerrarSesionPanel.setRoundBottomRight(10);
        CerrarSesionPanel.setRoundTopLeft(10);
        CerrarSesionPanel.setRoundTopRight(10);

        cerrarSesionLabel.setBackground(new java.awt.Color(0, 0, 0));
        cerrarSesionLabel.setFont(new java.awt.Font("Gotham", 1, 10)); // NOI18N
        cerrarSesionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrarSesionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/cerrarSesionIco.png"))); // NOI18N
        cerrarSesionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarSesionLabel.setRequestFocusEnabled(false);
        cerrarSesionLabel.setVerifyInputWhenFocusTarget(false);
        cerrarSesionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarSesionLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrarSesionLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrarSesionLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout CerrarSesionPanelLayout = new javax.swing.GroupLayout(CerrarSesionPanel);
        CerrarSesionPanel.setLayout(CerrarSesionPanelLayout);
        CerrarSesionPanelLayout.setHorizontalGroup(
            CerrarSesionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CerrarSesionPanelLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(cerrarSesionLabel)
                .addContainerGap())
        );
        CerrarSesionPanelLayout.setVerticalGroup(
            CerrarSesionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CerrarSesionPanelLayout.createSequentialGroup()
                .addComponent(cerrarSesionLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(CerrarSesionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 50, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarjlabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarjlabelMouseEntered
        agregarpanel.setBackground(new Color(61,53,37));
    }//GEN-LAST:event_agregarjlabelMouseEntered

    private void agregarjlabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarjlabelMouseExited
        agregarpanel.setBackground(new Color(108,89,49));
    }//GEN-LAST:event_agregarjlabelMouseExited

    private void borrarjlabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarjlabelMouseEntered
        borrarpanel.setBackground(new Color(61,53,37));
    }//GEN-LAST:event_borrarjlabelMouseEntered

    private void borrarjlabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarjlabelMouseExited
        borrarpanel.setBackground(new Color(108,89,49));
    }//GEN-LAST:event_borrarjlabelMouseExited

    private void ingresarjlabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarjlabelMouseEntered
        ingresarpanel.setBackground(new Color(61,53,37));
    }//GEN-LAST:event_ingresarjlabelMouseEntered

    private void ingresarjlabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarjlabelMouseExited
        ingresarpanel.setBackground(new Color(108,89,49));
    }//GEN-LAST:event_ingresarjlabelMouseExited

    private void ingresarjlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarjlabelMouseClicked
        
        //Este dato es para la siguiente pestaña
        Agrodatos.nombre_lote = nombre_lote;
        Agrográfica.nombre_lote = nombre_lote;
        Agroconsejos.nombre_lote = nombre_lote;
        //Este codigo va a servir para obtener el valor id_lote para la siguiente pantalla
        if (panelSeleccionado != null) {
            
            try{
                //Hago la conexion con la base de datos
                
                Connection cn = ConexiónDB.conectar();
                //Instrucciones a la base de datos
                
                PreparedStatement pst = cn.prepareStatement(
                    "select id_lote from carpeta_lote where nombre_lote = '"+nombre_lote
                        + "' and id_usuario = "+id_usuario);
                //Le digo que la ejecute
                ResultSet rs = pst.executeQuery();
                //Compruebo si se encontro la coincidencia
                
                if(rs.next()){
                   //Este dato es para la siguiente pestaña
                   Agrodatos.id_lote = rs.getString("id_lote");
                   Agrográfica.id_lote = rs.getString("id_lote");
                   Agroconsejos.id_lote = rs.getString("id_lote");
                   Agrodatos a = new Agrodatos();
                   this.setVisible(false);
                   a.setVisible(true);
                }
            }
            catch(Exception e){
                System.err.println("Error en el boton agregar" + e);
                JOptionPane.showMessageDialog(null, "Error al ingresar, contacte al programador tqm");
            }
        }

    }//GEN-LAST:event_ingresarjlabelMouseClicked

    private void agregarjlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarjlabelMouseClicked
        
        String nombre_lote = "Lote" + infinito;
        agregarNuevoPanel(nombre_lote);
        
        //Sebas
        try {
            //Hago la conexion con la base de datos
            Connection cn = ConexiónDB.conectar();
            //Instrucciones a la base de datos
            PreparedStatement pst = cn.prepareStatement("insert into carpeta_lote values (?, ?, ?)");
            
            //aqui le digo a que columnas van dichos valores
            pst.setString(1, "0");
            //txt_usuario es como se llama el jtextfield de donde vamos a sacar este dato
            pst.setInt(2, id_usuario);
            pst.setString(3, nombre_lote);

            //le digo a java y a la base de datos que ejecute lo anterior
            pst.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar lotes, contacte al programador");
        }        
    }//GEN-LAST:event_agregarjlabelMouseClicked

    private void borrarjlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarjlabelMouseClicked
        
        //Sebas
        if (panelSeleccionado != null) {
            contadorSebas = ObtenerMaxIdLote();
            String id_lote = "";
            
            //Consigo el id_lote al cual eliminaremos todos los datos añadidos
            try {
                    //Hago la conexion con la base de datos
                    Connection cn = ConexiónDB.conectar();
                    //Instrucciones a la base de datos
                    PreparedStatement pst = cn.prepareStatement(
                            "select id_lote from carpeta_lote where id_usuario = " + id_usuario
                            + " and nombre_lote = '" + nombre_lote + "'");
                    //Le digo que la ejecute
                    ResultSet rs = pst.executeQuery();
                    //Compruebo si se encontro la coincidencia
                    if (rs.next()) {
                        id_lote = rs.getString("id_lote");
                        System.out.println(id_lote);
                    }
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al borrar lotes, contacte al programador");
                }

            //Este for es para eliminar los datos de la base de datos en el orden requerido
            try {
                //Hago la conexion con la base de datos
                Connection cn = ConexiónDB.conectar();
                //Instrucciones a la base de datos
                PreparedStatement pst = cn.prepareStatement("delete from detalle_suelo where id_lote = " + id_lote);
                //Le digo que la ejecute
                pst.executeUpdate();
                
                pst = cn.prepareStatement("delete from carpeta_lote where nombre_lote = '"+nombre_lote+"'" );
                //Le digo que la ejecute
                pst.executeUpdate();
                

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar lotes, contacte al programador");
            }
            
        }
              
        borrarPanelSeleccionado();
    }//GEN-LAST:event_borrarjlabelMouseClicked

    private void checkjlabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkjlabelMouseEntered
        checkjpanel.setBackground(new Color(0,60,60));
    }//GEN-LAST:event_checkjlabelMouseEntered

    private void checkjlabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkjlabelMouseExited
        checkjpanel.setBackground(new Color(33,131,128));
    }//GEN-LAST:event_checkjlabelMouseExited

    private void cambiarnombrejtextfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarnombrejtextfieldMouseClicked
        if(cambiarnombrejtextfield.getText().equals("CAMBIAR NOMBRE")){
            cambiarnombrejtextfield.setText("");
        }
    }//GEN-LAST:event_cambiarnombrejtextfieldMouseClicked

    private void checkjlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkjlabelMouseClicked
        if(!cambiarnombrejtextfield.getText().equals("CAMBIAR NOMBRE")){
            cambiarNombre();
        }
        
        //Sebas
        try {
            //Hago la conexion con la base de datos
            Connection cn = ConexiónDB.conectar();
            //Instrucciones a la base de datos
            PreparedStatement pst = cn.prepareStatement("update carpeta_lote set nombre_lote = '"
                    +cambiarnombrejtextfield.getText().trim()+ "' where nombre_lote = '"+nombre_lote+"'");

            //le digo a java y a la base de datos que ejecute lo anterior
            pst.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar lotes, contacte al programador tqm");
        }
        
        cambiarnombrejtextfield.setText("CAMBIAR NOMBRE");
    }//GEN-LAST:event_checkjlabelMouseClicked

    private void cerrarSesionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionLabelMouseClicked
        Agrologin a = new Agrologin();
        this.setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_cerrarSesionLabelMouseClicked

    private void cerrarSesionLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionLabelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarSesionLabelMouseEntered

    private void cerrarSesionLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionLabelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarSesionLabelMouseExited

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
            java.util.logging.Logger.getLogger(Agrosuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agrosuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agrosuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agrosuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agrosuelos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private agrop.PanelRound CerrarSesionPanel;
    private javax.swing.JLabel agregarjlabel;
    private agrop.PanelRound agregarpanel;
    private javax.swing.JLabel borrarjlabel;
    private agrop.PanelRound borrarpanel;
    private javax.swing.JTextField cambiarnombrejtextfield;
    private agrop.PanelRound cambionombrejpanel;
    private javax.swing.JLabel cerrarSesionLabel;
    private javax.swing.JLabel checkjlabel;
    private agrop.PanelRound checkjpanel;
    private javax.swing.JLabel ingresarjlabel;
    private agrop.PanelRound ingresarpanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelalbergar;
    private agrop.PanelRound panelmenus;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}