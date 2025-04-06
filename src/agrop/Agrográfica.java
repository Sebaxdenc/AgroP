package agrop;
import clases.ConexiónDB;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.Image;
import java.awt.Toolkit;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Agrográfica extends javax.swing.JFrame {
    
    //Datos de pantallas anteriores
    public static String nombre_lote;
    public static String id_lote;
    
    public static int cuantoTiempo = 11;//Este sera el que cambie el lapso en la grafica
    //El 11 es por dias (ya esta determinado)
    
    
    //Este contador es para poder hacer funcionar el for siendo contador el maximo indice de id_detalle_suelo
    //Va a obtener adentro el valor maximo de id_detalle_suelo en la tabla detalle_suelo
    private static int[] ContadorSebas = new int[2]; 
    
    public static int ObtenerMaxMinIdDetalleSuelo(String maxmin){
        try{
            Connection cn = ConexiónDB.conectar();
            
            PreparedStatement pst = cn.prepareStatement("select "+maxmin+"(id_detalle_suelo) max_id_detalle_suelo from detalle_suelo"
                    + " where id_lote = "+id_lote);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return (rs.getInt("max_id_detalle_suelo"));
            }
        }
        catch(Exception e){
            System.err.println("Error en base de datos" + e);
            JOptionPane.showMessageDialog(null, "Error al conectar con base de datos, contacte al programador tqm");
        }
        return -1;
    }
    
    
    JFreeChart grafica;//Esta sera la grafica estatica 
    JFreeChart graficaTiempo;//Esta sera la grafica en tiempo real
    DefaultCategoryDataset datos = new DefaultCategoryDataset();//Aqui estaran los datos extraidos de SQL
    JPanel panelGrafica = new JPanel(new GridLayout());//Creo el panel donde despues estara la grafica
    JLabel advertencia = new JLabel();
    
    final XYSeries Serie = new XYSeries("Temperatura A");//Esta serie tomara los valores de temperaturaAmbiente obtenidos de arduino
    final XYSeries Serie1 = new XYSeries("Humedad A");// ... humedadAmbiente...
    final XYSeries Serie2 = new XYSeries("Humedad S");// ... humedadSuelo...
    final XYSeriesCollection Coleccion = new XYSeriesCollection(); //Este sera el que contendra todos los valores de las series
    
    int i = 0;//Este 'i' sera para tomar los segundos a la hora de hacer la grafica en tiempo real
    
    float [] IngresoDatosGrafica = new float[3]; /*Este arreglo es para mostrar los ultimos 3 ingresos reflejados 
    en la grafica*/
    float [] IngresoDatosGrafica2 = new float[3]; /*Este es por si la grafica muestra 2 datos*/
    String [] Fecha = new String[3]; //Este es para la fecha
    
    boolean EjecucionTiempoReal = true; /*Este booleano es para evitar posibles errores del tipo iniciar 2 veces
    la conexion arduino*/
    
            
    public Agrográfica() {
        initComponents(); 
        ContadorSebas[0] = ObtenerMaxMinIdDetalleSuelo("MAX");
        Agroconsejos.MaxIdLote = ContadorSebas[0];
        ContadorSebas[1] = ObtenerMaxMinIdDetalleSuelo("MIN");

        
        //Le doy los valores correspondientes al panel que contendra la grafica
        panelGrafica.setBounds(10, 5, 680, 430);//Posicion y tamaño dentro de la interfaz
        panelGrafica.setBackground(Color.white);
        panelG.add(panelGrafica);
        panelG.revalidate();
        panelG.repaint();
        
        advertencia.setBounds(10,5,680,430);
        
        nombreLote.setText("Lote: "+nombre_lote);
        setIconImage(getIconImage());
    } 

    //Icono de JFrame
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("com/images/AGROP LOGO CENTRADO.png"));
        return retValue;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phjlabel2 = new javax.swing.JLabel();
        phjpanel2 = new agrop.PanelRound();
        phjtextfield2 = new javax.swing.JTextField();
        MenuLapsoTiempo = new javax.swing.JPopupMenu();
        Dias = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Meses = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        Años = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        verIngresoJPanel = new agrop.PanelRound();
        verIngresoJLabel = new javax.swing.JLabel();
        panelG = new agrop.PanelRound();
        backjpanel = new javax.swing.JPanel();
        backjlabel = new javax.swing.JLabel();
        panelRound1 = new agrop.PanelRound();
        fosforo = new javax.swing.JLabel();
        nitrogejLabel = new javax.swing.JLabel();
        pHjLabel = new javax.swing.JLabel();
        humedadAjLabel = new javax.swing.JLabel();
        humedadSUelo = new javax.swing.JLabel();
        temperaturaS = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        temperaturaAjlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nombreLote = new javax.swing.JLabel();
        bgcafe = new javax.swing.JPanel();
        decobola1 = new javax.swing.JLabel();
        ConsejosJPanel = new agrop.PanelRound();
        ConsejosJLabel = new javax.swing.JLabel();
        decobola2 = new javax.swing.JLabel();
        TiempoJPanel = new agrop.PanelRound();
        TiempoReal = new javax.swing.JLabel();
        arduinonoencontrado = new javax.swing.JLabel();
        decobola4 = new javax.swing.JLabel();
        decobola3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cerrarSesionLabel = new javax.swing.JLabel();
        CerrarSesionPanel = new agrop.PanelRound();
        cambioLapso = new javax.swing.JLabel();

        phjlabel2.setBackground(new java.awt.Color(0, 102, 51));
        phjlabel2.setFont(new java.awt.Font("Gotham", 1, 20)); // NOI18N
        phjlabel2.setForeground(new java.awt.Color(0, 102, 51));
        phjlabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phjlabel2.setText("PH");

        phjpanel2.setBackground(new java.awt.Color(255, 255, 255));
        phjpanel2.setRoundBottomLeft(20);
        phjpanel2.setRoundBottomRight(20);
        phjpanel2.setRoundTopLeft(20);
        phjpanel2.setRoundTopRight(20);

        phjtextfield2.setFont(new java.awt.Font("Gotham", 0, 18)); // NOI18N
        phjtextfield2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        phjtextfield2.setText("0");
        phjtextfield2.setBorder(null);
        phjtextfield2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phjtextfield2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout phjpanel2Layout = new javax.swing.GroupLayout(phjpanel2);
        phjpanel2.setLayout(phjpanel2Layout);
        phjpanel2Layout.setHorizontalGroup(
            phjpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phjpanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(phjtextfield2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        phjpanel2Layout.setVerticalGroup(
            phjpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phjpanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phjtextfield2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Dias.setText("Grafica en dias");
        Dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiasActionPerformed(evt);
            }
        });
        MenuLapsoTiempo.add(Dias);
        MenuLapsoTiempo.add(jSeparator2);

        Meses.setText("Grafica en meses");
        Meses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MesesActionPerformed(evt);
            }
        });
        MenuLapsoTiempo.add(Meses);
        MenuLapsoTiempo.add(jSeparator4);

        Años.setText("Grafica en años");
        Años.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñosActionPerformed(evt);
            }
        });
        MenuLapsoTiempo.add(Años);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(230, 230, 230));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verIngresoJPanel.setBackground(new java.awt.Color(33, 131, 128));
        verIngresoJPanel.setRoundBottomLeft(30);
        verIngresoJPanel.setRoundBottomRight(30);
        verIngresoJPanel.setRoundTopLeft(30);
        verIngresoJPanel.setRoundTopRight(30);

        verIngresoJLabel.setFont(new java.awt.Font("Gotham", 1, 20)); // NOI18N
        verIngresoJLabel.setForeground(new java.awt.Color(255, 255, 255));
        verIngresoJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verIngresoJLabel.setText("VER INGRESO DE DATOS");
        verIngresoJLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verIngresoJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verIngresoJLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verIngresoJLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verIngresoJLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout verIngresoJPanelLayout = new javax.swing.GroupLayout(verIngresoJPanel);
        verIngresoJPanel.setLayout(verIngresoJPanelLayout);
        verIngresoJPanelLayout.setHorizontalGroup(
            verIngresoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(verIngresoJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );
        verIngresoJPanelLayout.setVerticalGroup(
            verIngresoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, verIngresoJPanelLayout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(verIngresoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(verIngresoJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, -20, 360, 60));

        panelG.setBackground(new java.awt.Color(255, 255, 255));
        panelG.setForeground(new java.awt.Color(0, 102, 51));
        panelG.setComponentPopupMenu(MenuLapsoTiempo);
        panelG.setRoundBottomLeft(30);
        panelG.setRoundBottomRight(30);
        panelG.setRoundTopLeft(30);
        panelG.setRoundTopRight(30);

        javax.swing.GroupLayout panelGLayout = new javax.swing.GroupLayout(panelG);
        panelG.setLayout(panelGLayout);
        panelGLayout.setHorizontalGroup(
            panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        panelGLayout.setVerticalGroup(
            panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel1.add(panelG, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 700, 450));
        panelG.getAccessibleContext().setAccessibleName("");
        panelG.getAccessibleContext().setAccessibleDescription("");

        backjpanel.setBackground(new java.awt.Color(108, 89, 49));

        backjlabel.setFont(new java.awt.Font("Gotham", 0, 18)); // NOI18N
        backjlabel.setForeground(new java.awt.Color(255, 255, 255));
        backjlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backjlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/backk.png"))); // NOI18N
        backjlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backjlabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backjlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backjlabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backjlabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backjlabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout backjpanelLayout = new javax.swing.GroupLayout(backjpanel);
        backjpanel.setLayout(backjpanelLayout);
        backjpanelLayout.setHorizontalGroup(
            backjpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backjpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backjlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        backjpanelLayout.setVerticalGroup(
            backjpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backjpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backjlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(backjpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        fosforo.setBackground(new java.awt.Color(0, 102, 51));
        fosforo.setFont(new java.awt.Font("Gotham", 1, 14)); // NOI18N
        fosforo.setForeground(new java.awt.Color(0, 102, 51));
        fosforo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fosforo.setText("FÓSFORO");
        fosforo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fosforo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fosforoMouseClicked(evt);
            }
        });

        nitrogejLabel.setBackground(new java.awt.Color(0, 102, 51));
        nitrogejLabel.setFont(new java.awt.Font("Gotham", 1, 14)); // NOI18N
        nitrogejLabel.setForeground(new java.awt.Color(0, 102, 51));
        nitrogejLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nitrogejLabel.setText("NITRÓGENO");
        nitrogejLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nitrogejLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nitrogejLabelMouseClicked(evt);
            }
        });

        pHjLabel.setBackground(new java.awt.Color(0, 102, 51));
        pHjLabel.setFont(new java.awt.Font("Gotham", 1, 14)); // NOI18N
        pHjLabel.setForeground(new java.awt.Color(0, 102, 51));
        pHjLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pHjLabel.setText("PH");
        pHjLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pHjLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pHjLabelMouseClicked(evt);
            }
        });

        humedadAjLabel.setBackground(new java.awt.Color(0, 102, 51));
        humedadAjLabel.setFont(new java.awt.Font("Gotham", 1, 14)); // NOI18N
        humedadAjLabel.setForeground(new java.awt.Color(0, 102, 51));
        humedadAjLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        humedadAjLabel.setText("HUMEDAD AMB.");
        humedadAjLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        humedadAjLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                humedadAjLabelMouseClicked(evt);
            }
        });

        humedadSUelo.setBackground(new java.awt.Color(0, 102, 51));
        humedadSUelo.setFont(new java.awt.Font("Gotham", 1, 14)); // NOI18N
        humedadSUelo.setForeground(new java.awt.Color(0, 102, 51));
        humedadSUelo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        humedadSUelo.setText("HUMEDAD SUELO");
        humedadSUelo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        humedadSUelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                humedadSUeloMouseClicked(evt);
            }
        });

        temperaturaS.setBackground(new java.awt.Color(0, 102, 51));
        temperaturaS.setFont(new java.awt.Font("Gotham", 1, 14)); // NOI18N
        temperaturaS.setForeground(new java.awt.Color(0, 102, 51));
        temperaturaS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        temperaturaS.setText("TEMPERATURA SUELO");
        temperaturaS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        temperaturaS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                temperaturaSMouseClicked(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        temperaturaAjlabel.setBackground(new java.awt.Color(0, 102, 51));
        temperaturaAjlabel.setFont(new java.awt.Font("Gotham", 1, 14)); // NOI18N
        temperaturaAjlabel.setForeground(new java.awt.Color(0, 102, 51));
        temperaturaAjlabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        temperaturaAjlabel.setText("TEMPERATURA AMB.");
        temperaturaAjlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        temperaturaAjlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                temperaturaAjlabelMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Rango ideal: 6.6 - 7.3");

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Rango ideal: 15 - 35  ppm");

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Rango ideal: 100 - 150 ppm");

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Rango ideal: 60 - 80 %");

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Rango ideal: 50 - 70 %");

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Rango ideal: 18 - 24  °C");

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Rango ideal: 15-25 °C");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(humedadSUelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(16, 16, 16))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(temperaturaAjlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(temperaturaS, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addContainerGap(10, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fosforo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pHjLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(nitrogejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(humedadAjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pHjLabel)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fosforo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nitrogejLabel)
                .addGap(4, 4, 4)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(humedadAjLabel)
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(humedadSUelo, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(temperaturaS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(temperaturaAjlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18))
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 200, 390));

        nombreLote.setBackground(new java.awt.Color(0, 102, 51));
        nombreLote.setFont(new java.awt.Font("Gotham Black", 2, 18)); // NOI18N
        nombreLote.setForeground(new java.awt.Color(92, 25, 22));
        nombreLote.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombreLote.setText("LOTE: ");
        jPanel1.add(nombreLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 190, 30));

        bgcafe.setBackground(new java.awt.Color(108, 89, 49));
        bgcafe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        decobola1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/circulo 130130.png"))); // NOI18N
        bgcafe.add(decobola1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 210, -1, -1));

        ConsejosJPanel.setBackground(new java.awt.Color(33, 131, 128));
        ConsejosJPanel.setRoundBottomLeft(20);
        ConsejosJPanel.setRoundBottomRight(20);
        ConsejosJPanel.setRoundTopLeft(20);
        ConsejosJPanel.setRoundTopRight(20);

        ConsejosJLabel.setFont(new java.awt.Font("Gotham", 1, 18)); // NOI18N
        ConsejosJLabel.setForeground(new java.awt.Color(255, 255, 255));
        ConsejosJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConsejosJLabel.setText("VER CONSEJOS");
        ConsejosJLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConsejosJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConsejosJLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ConsejosJLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ConsejosJLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ConsejosJPanelLayout = new javax.swing.GroupLayout(ConsejosJPanel);
        ConsejosJPanel.setLayout(ConsejosJPanelLayout);
        ConsejosJPanelLayout.setHorizontalGroup(
            ConsejosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsejosJPanelLayout.createSequentialGroup()
                .addComponent(ConsejosJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        ConsejosJPanelLayout.setVerticalGroup(
            ConsejosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsejosJPanelLayout.createSequentialGroup()
                .addComponent(ConsejosJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bgcafe.add(ConsejosJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 265, 190, 60));

        decobola2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/circulo 5050.png"))); // NOI18N
        bgcafe.add(decobola2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, -1, -1));

        TiempoJPanel.setBackground(new java.awt.Color(33, 131, 128));
        TiempoJPanel.setRoundBottomLeft(20);
        TiempoJPanel.setRoundBottomRight(20);

        TiempoReal.setFont(new java.awt.Font("Gotham", 1, 18)); // NOI18N
        TiempoReal.setForeground(new java.awt.Color(255, 255, 255));
        TiempoReal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TiempoReal.setText("TIEMPO REAL");
        TiempoReal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TiempoReal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TiempoRealMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TiempoRealMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TiempoRealMouseExited(evt);
            }
        });

        javax.swing.GroupLayout TiempoJPanelLayout = new javax.swing.GroupLayout(TiempoJPanel);
        TiempoJPanel.setLayout(TiempoJPanelLayout);
        TiempoJPanelLayout.setHorizontalGroup(
            TiempoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TiempoReal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        TiempoJPanelLayout.setVerticalGroup(
            TiempoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TiempoJPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TiempoReal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bgcafe.add(TiempoJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 180, 30));

        arduinonoencontrado.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        arduinonoencontrado.setForeground(new java.awt.Color(255, 255, 255));
        bgcafe.add(arduinonoencontrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, 230, 20));

        jPanel1.add(bgcafe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1000, 300));

        decobola4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/circulo 5050.png"))); // NOI18N
        jPanel1.add(decobola4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, -1, -1));

        decobola3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/circulo 5050.png"))); // NOI18N
        jPanel1.add(decobola3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/LOGOAGROP100X100.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

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
        jPanel1.add(cerrarSesionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, -1, -1));

        CerrarSesionPanel.setBackground(new java.awt.Color(255, 255, 255));
        CerrarSesionPanel.setRoundBottomLeft(10);
        CerrarSesionPanel.setRoundBottomRight(10);
        CerrarSesionPanel.setRoundTopLeft(10);
        CerrarSesionPanel.setRoundTopRight(10);

        javax.swing.GroupLayout CerrarSesionPanelLayout = new javax.swing.GroupLayout(CerrarSesionPanel);
        CerrarSesionPanel.setLayout(CerrarSesionPanelLayout);
        CerrarSesionPanelLayout.setHorizontalGroup(
            CerrarSesionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        CerrarSesionPanelLayout.setVerticalGroup(
            CerrarSesionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(CerrarSesionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, -1, -1));

        cambioLapso.setFont(new java.awt.Font("MS UI Gothic", 3, 18)); // NOI18N
        cambioLapso.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(cambioLapso, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 420, -1));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void phjtextfield2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phjtextfield2ActionPerformed
        
    }//GEN-LAST:event_phjtextfield2ActionPerformed

    private void TiempoRealMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TiempoRealMouseExited
        TiempoJPanel.setBackground(new Color(33,131,128));
    }//GEN-LAST:event_TiempoRealMouseExited

    private void TiempoRealMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TiempoRealMouseEntered
        TiempoJPanel.setBackground(new Color(0,60,60));
    }//GEN-LAST:event_TiempoRealMouseEntered

    private void TiempoRealMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TiempoRealMouseClicked
        i = 0; //Recordemos, 'i' es el tiempo

        // Obtener los puertos disponibles usando jSerialComm
        com.fazecast.jSerialComm.SerialPort[] puertosDisponibles = com.fazecast.jSerialComm.SerialPort.getCommPorts();

        if (puertosDisponibles.length > 0) {
            arduinonoencontrado.setText("");

            // Este if es para que si anteriormente presiono "Tiempo Real" no vuelva a crear otra conexion arduino
            if (EjecucionTiempoReal) {
                EjecucionTiempoReal = false;

                // Los limpio por si este boton fue presionado anteriormente, para no tener los datos anteriores
                Serie.clear();
                Serie1.clear();
                Serie2.clear();
                Coleccion.removeAllSeries();

                panelGrafica.removeAll();
                panelGrafica.updateUI(); // Actualizo el panel

                // Seleccionar el primer puerto disponible
                com.fazecast.jSerialComm.SerialPort puertoArduino = puertosDisponibles[0];

                // Configurar el puerto serie
                puertoArduino.setBaudRate(9600);
                puertoArduino.setNumDataBits(8);
                puertoArduino.setNumStopBits(com.fazecast.jSerialComm.SerialPort.ONE_STOP_BIT);
                puertoArduino.setParity(com.fazecast.jSerialComm.SerialPort.NO_PARITY);
                puertoArduino.setComPortTimeouts(com.fazecast.jSerialComm.SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);

                // Abrir el puerto
                if (puertoArduino.openPort()) {
                    System.out.println("Puerto abierto: " + puertoArduino.getSystemPortName());

                    // Crear un hilo para leer constantemente los datos del Arduino
                    Thread hiloLectura = new Thread(() -> {
                        // Buffer para leer los datos
                        byte[] buffer = new byte[1024];
                        StringBuilder mensajeCompleto = new StringBuilder();

                        try {
                            // Esperar un momento para que el Arduino se estabilice
                            Thread.sleep(2000);

                            while (puertoArduino.isOpen()) {
                                // Leer datos disponibles
                                if (puertoArduino.bytesAvailable() > 0) {
                                    int numBytes = puertoArduino.readBytes(buffer, buffer.length);

                                    // Convertir bytes a string
                                    String datoRecibido = new String(buffer, 0, numBytes);
                                    mensajeCompleto.append(datoRecibido);

                                    // Buscar líneas completas
                                    int posFinLinea;
                                    while ((posFinLinea = mensajeCompleto.indexOf("\n")) != -1) {
                                        String lineaCompleta = mensajeCompleto.substring(0, posFinLinea).trim();
                                        mensajeCompleto.delete(0, posFinLinea + 1);

                                        // Procesar la línea recibida
                                        if (!lineaCompleta.isEmpty()) {
                                            try {
                                                i++;
                                                System.out.println("Datos recibidos: " + lineaCompleta);

                                                String[] datos = lineaCompleta.split(",");
                                                if (datos.length >= 3) {
                                                    float temperaturaA = Float.parseFloat(datos[0]);
                                                    float humedadA = Float.parseFloat(datos[1]);
                                                    float humedadS = Float.parseFloat(datos[2]);

                                                    // Actualizar en el hilo de la interfaz
                                                    javax.swing.SwingUtilities.invokeLater(() -> {
                                                        Serie.add(i, temperaturaA);
                                                        Serie1.add(i, humedadA);
                                                        Serie2.add(i, humedadS);
                                                    });
                                                }
                                            } catch (NumberFormatException e) {
                                                System.out.println("Error al parsear datos: " + e.getMessage());
                                            }
                                        }
                                    }
                                }

                                // Pequeña pausa para no saturar la CPU
                                Thread.sleep(10);
                            }
                        } catch (InterruptedException e) {
                            System.out.println("Hilo de lectura interrumpido: " + e.getMessage());
                        } finally {
                            if (puertoArduino.isOpen()) {
                                puertoArduino.closePort();
                                System.out.println("Puerto cerrado.");
                            }
                        }
                    });

                    // Iniciar el hilo de lectura
                    hiloLectura.setDaemon(true);
                    hiloLectura.start();

                    // Inicializar las series para la gráfica
                    Serie.add(0, 0);
                    Serie1.add(0, 0);
                    Serie2.add(0, 0);
                    Coleccion.addSeries(Serie);
                    Coleccion.addSeries(Serie1);
                    Coleccion.addSeries(Serie2);
                    graficaTiempo = ChartFactory.createXYLineChart("Humedad y Temperatura VS Tiempo", "Segundos",
                            "Humedad S Humedad A Temperatura A", Coleccion,
                            PlotOrientation.VERTICAL, true, true, false);

                    ChartPanel panel = new ChartPanel(graficaTiempo);
                    panel.setPreferredSize(new Dimension(680, 430));

                    panelGrafica.add(panel);
                    panelGrafica.updateUI();

                } else {
                    System.out.println("No se pudo abrir el puerto " + puertoArduino.getSystemPortName());
                    arduinonoencontrado.setText("No se pudo conectar al arduino");
                }
            }
        } else {
            arduinonoencontrado.setText("No se encontró arduino");
        }

    }//GEN-LAST:event_TiempoRealMouseClicked

    private void ConsejosJLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsejosJLabelMouseExited
        ConsejosJPanel.setBackground(new Color(33,131,128));
    }//GEN-LAST:event_ConsejosJLabelMouseExited

    private void ConsejosJLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsejosJLabelMouseEntered
        ConsejosJPanel.setBackground(new Color(0,60,60));
    }//GEN-LAST:event_ConsejosJLabelMouseEntered

    private void ConsejosJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsejosJLabelMouseClicked
        Agroconsejos b = new Agroconsejos();
        b.setVisible(true);
    }//GEN-LAST:event_ConsejosJLabelMouseClicked

    private void backjlabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backjlabelMouseExited
        backjpanel.setBackground(new Color(108,89,49));
    }//GEN-LAST:event_backjlabelMouseExited

    private void backjlabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backjlabelMouseEntered
        backjpanel.setBackground(new Color(61,53,37));
    }//GEN-LAST:event_backjlabelMouseEntered

    private void backjlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backjlabelMouseClicked

        
        Agrosuelos a = new Agrosuelos();
        this.setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_backjlabelMouseClicked

    private void verIngresoJLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verIngresoJLabelMouseExited
        verIngresoJPanel.setBackground(new Color(33,131,128));
    }//GEN-LAST:event_verIngresoJLabelMouseExited

    private void verIngresoJLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verIngresoJLabelMouseEntered
        verIngresoJPanel.setBackground(new Color(0,60,60));
    }//GEN-LAST:event_verIngresoJLabelMouseEntered

    private void verIngresoJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verIngresoJLabelMouseClicked
   
        
        Agrodatos b = new Agrodatos();
        this.setVisible(false);
        b.setVisible(true);
    }//GEN-LAST:event_verIngresoJLabelMouseClicked

    private void temperaturaSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_temperaturaSMouseClicked

        arduinonoencontrado.setText(""); 
        cambioLapso.setText("");
        

        EjecucionTiempoReal = true;

        //Se limpia pq puede ser que tenga informacion adentro de otro tipo de dato
        datos.clear();

        int contador=0; //Este sera para añadir solo los primeros 3 datos ingresados
        float temperaturaS__=0;
        float temperaturaA=0;
        for(int j=ContadorSebas[1]; j<=ContadorSebas[0]; j++){
            if(contador<3){
                try{
                    //Hago la conexion con la base de datos
                    Connection cn = ConexiónDB.conectar();
                    //Instrucciones a la base de datos
                    PreparedStatement pst = cn.prepareStatement(
                        "select temperatura_suelo, temperatura_ambiente, tiempo from detalle_suelo where id_lote = "+id_lote+" and "
                        + "id_detalle_suelo = "+j);
                    //Le digo que la ejecute
                    ResultSet rs = pst.executeQuery();
                    //Compruebo si se encontro la coincidencia
                    if(rs.next()){
                        contador++;
                        temperaturaS__ = rs.getFloat("temperatura_suelo");
                        temperaturaA = rs.getFloat("temperatura_ambiente");
                        String fecha = rs.getString("tiempo").substring(0,cuantoTiempo);
                        /*El ".substring" lo use para que solo meta datos de dias diferentes, y para que el espacio
                        fuera suficiente para entender bien la fecha*/
                        datos.addValue(temperaturaS__, "Temp Suelo", fecha);
                        datos.addValue(temperaturaA, "Temp Ambiente", fecha);
                        
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error al extraer datos de la base de datos, contacte al programador tqm");
                }
            }else{
                break;
            }
        }
        int k=-1;
        for(int j=ContadorSebas[0]; j>ContadorSebas[1]; j--){
            if(contador<6){
                try{
                    //Hago la conexion con la base de datos
                    Connection cn = ConexiónDB.conectar();
                    //Instrucciones a la base de datos
                    PreparedStatement pst = cn.prepareStatement(
                        "select temperatura_suelo, temperatura_ambiente, tiempo from detalle_suelo where id_lote = "+id_lote+" and "
                        + "id_detalle_suelo = "+j);
                    //Le digo que la ejecute
                    ResultSet rs = pst.executeQuery();
                    //Compruebo si se encontro la coincidencia
                    if(rs.next()){
                        contador++;
                        k++;
                        
                        IngresoDatosGrafica[k] = rs.getFloat("temperatura_suelo");
                        IngresoDatosGrafica2[k] = rs.getFloat("temperatura_ambiente");
                        Fecha[k] = rs.getString("tiempo").substring(0,cuantoTiempo);
                        /*El ".substring" lo use para que solo meta datos de dias diferentes, y para que el espacio
                        fuera suficiente para entender bien la fecha*/
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error al extraer datos de la base de datos, contacte al programador tqm");
                }
            }else{
                break;
            }
        }
        boolean nosepudo = false;
        try{
            for (int z=2; z>=0; z--){
                datos.addValue(IngresoDatosGrafica[z], "Temp Suelo", Fecha[z]);
                datos.addValue(IngresoDatosGrafica2[z], "Temp Ambiente", Fecha[z]);
            }
        }catch (Exception e){
            nosepudo = true;
            advertencia.setText("<html>Lo lamento, tienes que tener mas de 6 dias con "
                        + "datos ingresados para poder ver graficas :(<html/>");
            panelGrafica.removeAll();
            panelGrafica.add(advertencia);
            panelGrafica.updateUI();
        }
        if(!nosepudo){
            grafica = ChartFactory.createLineChart("Cambios de temperatura", "Fecha", "Grados celsius", datos,
                PlotOrientation.VERTICAL, true, true, false);

            ChartPanel panel = new ChartPanel(grafica);
            panel.setPreferredSize(new Dimension(680, 430));
            panelGrafica.removeAll();
            panelGrafica.add(panel);
            panelGrafica.updateUI();
        }    
    }//GEN-LAST:event_temperaturaSMouseClicked

    private void humedadAjLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_humedadAjLabelMouseClicked

        arduinonoencontrado.setText("");
        cambioLapso.setText("");

        EjecucionTiempoReal = true;

        //Se limpia pq puede ser que tenga informacion adentro de otro tipo de dato
        datos.clear();

        int contador=0; //Este sera para añadir solo los primeros 3 datos ingresados
        float humedadS=0;
        float humedadA=0;
        for(int j=ContadorSebas[1]; j<=ContadorSebas[0]; j++){
            if(contador<3){
                try{
                    //Hago la conexion con la base de datos
                    Connection cn = ConexiónDB.conectar();
                    //Instrucciones a la base de datos
                    PreparedStatement pst = cn.prepareStatement(
                        "select humedad_suelo, humedad_ambiente, tiempo from detalle_suelo where id_lote = "+id_lote+" and "
                        + "id_detalle_suelo = "+j);
                    //Le digo que la ejecute
                    ResultSet rs = pst.executeQuery();
                    //Compruebo si se encontro la coincidencia
                    if(rs.next()){
                        contador++;
                        humedadS = rs.getFloat("humedad_suelo");
                        humedadA = rs.getFloat("humedad_ambiente");
                        String fecha = rs.getString("tiempo").substring(0,cuantoTiempo);
                        datos.addValue(humedadS, "Humedad Suelo", fecha);
                        datos.addValue(humedadA, "Humedad Ambiente", fecha);
                        /*El ".substring" lo use para que solo meta datos de dias diferentes, y para que el espacio
                        fuera suficiente para entender bien la fecha*/
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error al extraer datos de la base de datos, contacte al programador tqm");
                }
            }else{
                break;
            }
        }
        int k = -1;
        for(int j=ContadorSebas[0]; j>ContadorSebas[1]; j--){
            if(contador<6){
                try{
                    //Hago la conexion con la base de datos
                    Connection cn = ConexiónDB.conectar();
                    //Instrucciones a la base de datos
                    PreparedStatement pst = cn.prepareStatement(
                        "select humedad_suelo, humedad_ambiente, tiempo from detalle_suelo where id_lote = "+id_lote+" and "
                        + "id_detalle_suelo = "+j);
                    //Le digo que la ejecute
                    ResultSet rs = pst.executeQuery();
                    //Compruebo si se encontro la coincidencia
                    if(rs.next()){
                        contador++;
                        k++;
                        IngresoDatosGrafica[k] = rs.getFloat("humedad_suelo");
                        IngresoDatosGrafica2[k] = rs.getFloat("humedad_ambiente");
                        Fecha[k] = rs.getString("tiempo").substring(0,cuantoTiempo);
                        /*El ".substring" lo use para que solo meta datos de dias diferentes, y para que el espacio
                        fuera suficiente para entender bien la fecha*/ 
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error al extraer datos de la base de datos, contacte al programador tqm");
                }
            }else{
                break;
            }
        }
        boolean nosepudo = false;
        try{
            for (int z=2; z>=0; z--){
                datos.addValue(IngresoDatosGrafica[k], "Humedad Suelo", Fecha[k]);
                datos.addValue(IngresoDatosGrafica2[k], "Humedad Ambiente", Fecha[k]);
            }
        }catch (Exception e){
            nosepudo = true;
            advertencia.setText("<html>Lo lamento, tienes que tener mas de 6 dias con "
                        + "datos ingresados para poder ver graficas :(<html/>");
            panelGrafica.removeAll();
            panelGrafica.add(advertencia);
            panelGrafica.updateUI();
        }
        if(!nosepudo){
            grafica = ChartFactory.createLineChart("Cambios de humedad", "Fecha", "Porcentaje", datos,
                PlotOrientation.VERTICAL, true, true, false);

            ChartPanel panel = new ChartPanel(grafica);
            panel.setPreferredSize(new Dimension(680, 430));
            panelGrafica.removeAll();
            panelGrafica.add(panel);
            panelGrafica.updateUI();
        }    
    }//GEN-LAST:event_humedadAjLabelMouseClicked

    private void pHjLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pHjLabelMouseClicked

        arduinonoencontrado.setText("");
        cambioLapso.setText("");

    
        EjecucionTiempoReal = true;

        //Se limpia pq puede ser que tenga informacion adentro de otro tipo de dato
        datos.clear();

        int contador=0; //Este sera para añadir solo los primeros 3 datos ingresados
        float pH=0;
        for(int j=ContadorSebas[1]; j<=ContadorSebas[0]; j++){
            if(contador<3){
                try{
                    //Hago la conexion con la base de datos
                    Connection cn = ConexiónDB.conectar();
                    //Instrucciones a la base de datos
                    PreparedStatement pst = cn.prepareStatement(
                        "select pH, tiempo from detalle_suelo where id_lote = "+id_lote+" and "
                        + "id_detalle_suelo = "+j);
                    //Le digo que la ejecute
                    ResultSet rs = pst.executeQuery();
                    //Compruebo si se encontro la coincidencia
                    if(rs.next()){
                        contador++;
                        pH = rs.getFloat("pH");
                        String fecha = rs.getString("tiempo").substring(0,cuantoTiempo);
                        datos.addValue(pH, "pH", fecha);
                        /*El ".substring" lo use para que solo meta datos de dias diferentes, y para que el espacio
                        fuera suficiente para entender bien la fecha*/
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error al extraer datos de la base de datos, contacte al programador tqm");
                }
            }else{
                break;
            }
        }
        int k = -1;
        for(int j=ContadorSebas[0]; j>ContadorSebas[1]; j--){
            if(contador<6){
                try{
                    //Hago la conexion con la base de datos
                    Connection cn = ConexiónDB.conectar();
                    //Instrucciones a la base de datos
                    PreparedStatement pst = cn.prepareStatement(
                        "select pH, tiempo from detalle_suelo where id_lote = "+id_lote+" and "
                        + "id_detalle_suelo = "+j);
                    //Le digo que la ejecute
                    ResultSet rs = pst.executeQuery();
                    //Compruebo si se encontro la coincidencia
                    if(rs.next()){
                        contador++;
                        k++;
                        IngresoDatosGrafica[k] = rs.getFloat("pH");
                        Fecha[k] = rs.getString("tiempo").substring(0,cuantoTiempo);
                        /*El ".substring" lo use para que solo meta datos de dias diferentes, y para que el espacio
                        fuera suficiente para entender bien la fecha*/
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error al extraer datos de la base de datos, contacte al programador tqm");
                }
            }else{
                break;
            }
        }
        boolean nosepudo = false;
        try{
            for (int z=2; z>=0; z--){
                datos.addValue(IngresoDatosGrafica[z], "pH", Fecha[z]);
            }
        }catch (Exception e){
            nosepudo = true;
            advertencia.setText("<html>Lo lamento, tienes que tener mas de 6 dias con "
                        + "datos ingresados para poder ver graficas :(<html/>");
            panelGrafica.removeAll();
            panelGrafica.add(advertencia);
            panelGrafica.updateUI();
        }
        if(!nosepudo){
            grafica = ChartFactory.createLineChart("Cambios de pH", "Fecha", "Nivel pH", datos,
                PlotOrientation.VERTICAL, true, true, false);

            ChartPanel panel = new ChartPanel(grafica);
            panel.setPreferredSize(new Dimension(680, 430));
            panelGrafica.removeAll();
            panelGrafica.add(panel);
            panelGrafica.updateUI();
        }
    }//GEN-LAST:event_pHjLabelMouseClicked

    private void nitrogejLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nitrogejLabelMouseClicked

        arduinonoencontrado.setText("");
        cambioLapso.setText("");


        EjecucionTiempoReal = true;

        //Se limpia pq puede ser que tenga informacion adentro de otro tipo de dato
        datos.clear();

        int contador=0; //Este sera para añadir solo los primeros 3 datos ingresados
        float nitrogeno=0;
        float fosforo__=0;
        for(int j=ContadorSebas[1]; j<=ContadorSebas[0]; j++){
            if(contador<3){
                try{
                    //Hago la conexion con la base de datos
                    Connection cn = ConexiónDB.conectar();
                    //Instrucciones a la base de datos
                    PreparedStatement pst = cn.prepareStatement(
                        "select nitrogeno, fosforo, tiempo from detalle_suelo where id_lote = "+id_lote+" and "
                        + "id_detalle_suelo = "+j);
                    //Le digo que la ejecute
                    ResultSet rs = pst.executeQuery();
                    //Compruebo si se encontro la coincidencia
                    if(rs.next()){
                        contador++;
                        nitrogeno = rs.getFloat("nitrogeno");
                        fosforo__ = rs.getFloat("fosforo");
                        String fecha = rs.getString("tiempo").substring(0,cuantoTiempo);
                        datos.addValue(fosforo__, "Fósforo", fecha);
                        datos.addValue(nitrogeno, "Nitrogeno", fecha);
                        /*El ".substring" lo use para que solo meta datos de dias diferentes, y para que el espacio
                        fuera suficiente para entender bien la fecha*/
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error al extraer datos de la base de datos, contacte al programador tqm");
                }
            }else{
                break;
            }
        }
        int k=-1;
        for(int j=ContadorSebas[0]; j>ContadorSebas[1]; j--){
            if(contador<6){
                try{
                    //Hago la conexion con la base de datos
                    Connection cn = ConexiónDB.conectar();
                    //Instrucciones a la base de datos
                    PreparedStatement pst = cn.prepareStatement(
                        "select nitrogeno, fosforo, tiempo from detalle_suelo where id_lote = "+id_lote+" and "
                        + "id_detalle_suelo = "+j);
                    //Le digo que la ejecute
                    ResultSet rs = pst.executeQuery();
                    //Compruebo si se encontro la coincidencia
                    if(rs.next()){
                        contador++;
                        k++;
                        IngresoDatosGrafica[k] = rs.getFloat("nitrogeno");
                        IngresoDatosGrafica2[k] = rs.getFloat("fosforo");
                        Fecha[k] = rs.getString("tiempo").substring(0,cuantoTiempo);
                        /*El ".substring" lo use para que solo meta datos de dias diferentes, y para que el espacio
                        fuera suficiente para entender bien la fecha*/
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error al extraer datos de la base de datos, contacte al programador tqm");
                }
            }else{
                break;
            }
        }
        boolean nosepudo = false;
        try{
            for(int z=2; z>=0; z--){
                datos.addValue(IngresoDatosGrafica[z], "Nitrogeno", Fecha[z]);
                datos.addValue(IngresoDatosGrafica2[z], "Fósforo", Fecha[z]);
            }
        }catch (Exception e){
            nosepudo = true;
            advertencia.setText("<html>Lo lamento, tienes que tener mas de 6 dias con "
                        + "datos ingresados para poder ver graficas :(<html/>");
            panelGrafica.removeAll();
            panelGrafica.add(advertencia);
            panelGrafica.updateUI();
        }
        if(!nosepudo){
            grafica = ChartFactory.createLineChart("Cambios de nitrogeno y fósforo", "Fecha", "Nivel nitrogeno Nivel fósforo", datos,
                PlotOrientation.VERTICAL, true, true, false);

            ChartPanel panel = new ChartPanel(grafica);
            panel.setPreferredSize(new Dimension(680, 430));
            panelGrafica.removeAll();
            panelGrafica.add(panel);
            panelGrafica.updateUI();
        } 
    }//GEN-LAST:event_nitrogejLabelMouseClicked

    private void fosforoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fosforoMouseClicked
        nitrogejLabelMouseClicked(evt);
    }//GEN-LAST:event_fosforoMouseClicked

    private void temperaturaAjlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_temperaturaAjlabelMouseClicked
        temperaturaSMouseClicked(evt);
    }//GEN-LAST:event_temperaturaAjlabelMouseClicked

    private void humedadSUeloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_humedadSUeloMouseClicked
        humedadAjLabelMouseClicked(evt);
    }//GEN-LAST:event_humedadSUeloMouseClicked

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

    private void AñosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñosActionPerformed
        cuantoTiempo = 4;
        cambioLapso.setText("Vuelve a generar la grafica :)");
    }//GEN-LAST:event_AñosActionPerformed

    private void DiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiasActionPerformed
        cuantoTiempo = 11;
        cambioLapso.setText("Vuelve a generar la grafica :)");
    }//GEN-LAST:event_DiasActionPerformed

    private void MesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MesesActionPerformed
        cuantoTiempo = 7;
        cambioLapso.setText("Vuelve a generar la grafica :)");
    }//GEN-LAST:event_MesesActionPerformed

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
                new Agrográfica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Años;
    private agrop.PanelRound CerrarSesionPanel;
    private javax.swing.JLabel ConsejosJLabel;
    private agrop.PanelRound ConsejosJPanel;
    private javax.swing.JMenuItem Dias;
    private javax.swing.JPopupMenu MenuLapsoTiempo;
    private javax.swing.JMenuItem Meses;
    private agrop.PanelRound TiempoJPanel;
    private javax.swing.JLabel TiempoReal;
    private javax.swing.JLabel arduinonoencontrado;
    private javax.swing.JLabel backjlabel;
    private javax.swing.JPanel backjpanel;
    private javax.swing.JPanel bgcafe;
    private javax.swing.JLabel cambioLapso;
    private javax.swing.JLabel cerrarSesionLabel;
    private javax.swing.JLabel decobola1;
    private javax.swing.JLabel decobola2;
    private javax.swing.JLabel decobola3;
    private javax.swing.JLabel decobola4;
    private javax.swing.JLabel fosforo;
    private javax.swing.JLabel humedadAjLabel;
    private javax.swing.JLabel humedadSUelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel nitrogejLabel;
    private javax.swing.JLabel nombreLote;
    private javax.swing.JLabel pHjLabel;
    private agrop.PanelRound panelG;
    private agrop.PanelRound panelRound1;
    private javax.swing.JLabel phjlabel2;
    private agrop.PanelRound phjpanel2;
    private javax.swing.JTextField phjtextfield2;
    private javax.swing.JLabel temperaturaAjlabel;
    private javax.swing.JLabel temperaturaS;
    private javax.swing.JLabel verIngresoJLabel;
    private agrop.PanelRound verIngresoJPanel;
    // End of variables declaration//GEN-END:variables
}
