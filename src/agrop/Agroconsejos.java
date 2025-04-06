package agrop;

import clases.ConexiónDB;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import config.ConfigLoader;


public class Agroconsejos extends javax.swing.JFrame {
    
    
    
    //conexion con la ia

public String obtenerConsejoDesdeHuggingFace(String tipoConsejo, float[] datos) {
    try {

        String url_model = ConfigLoader.get("hf.api.url");
        String token = ConfigLoader.get("hf.api.token");
        // Construir el prompt
        String prompt = "Dame un consejo sobre " + tipoConsejo + " basado en estos datos agrícolas:\n"
                + "- pH: " + datos[0] + "\n"
                + "- Temperatura del suelo: " + datos[1] + "°C\n"
                + "- Temperatura ambiente: " + datos[2] + "°C\n"
                + "- Humedad del suelo: " + datos[3] + "%\n"
                + "- Humedad ambiente: " + datos[4] + "%\n"
                + "- Nitrógeno: " + datos[5] + "mg/kg\n"
                + "- Fósforo: " + datos[6] + "mg/kg\n";

        // Limpiar caracteres no válidos
        prompt = prompt.replaceAll("[\\u0000-\\u001F]", "");

        // Crear el JSON de entrada
        String inputJson = "{ \"inputs\": \"" + prompt.replace("\"", "\\\"") + "\" }";

        // Configurar la conexión
        URL url = new URL(url_model);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", token);
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        // Enviar datos
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = inputJson.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Leer respuesta
        int status = con.getResponseCode();
        if (status == 200) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line.trim());
                }

                // Procesar el JSON recibido
                String rawResponse = response.toString();
                String consejo = rawResponse.replaceAll("\\{\"generated_text\":\"", "") // Eliminar inicio del JSON
                                            .replaceAll("\"}]", "") // Eliminar cierre del JSON
                                            .replaceAll("\\\\n", "<br>"); // Reemplazar saltos de línea por <br>

                return "<html>" + consejo + "</html>"; // Retornar texto formateado
            }
        } else {
            // Leer error
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"))) {
                StringBuilder errorResponse = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    errorResponse.append(line.trim());
                }
                return "Error al conectar con Hugging Face: " + errorResponse.toString();
            }
        }

    } catch (IOException e) {
        return "Error al conectar con Hugging Face: " + e.getMessage();
    }
}




    
    
    
    public static String nombre_lote;
    public static String id_lote;
    public static int MaxIdLote;
    
    private static float[] Datos = new float[7];
    
    public static float ObtenerDetalleSuelo(String dato){
        try{
            Connection cn = ConexiónDB.conectar();
            
            PreparedStatement pst = cn.prepareStatement("select "+dato+" from detalle_suelo"
                    + " where id_lote = "+id_lote+" and id_detalle_suelo = "+MaxIdLote);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return (rs.getFloat(dato));
            }
        }
        catch(Exception e){
            System.err.println("Error en base de datos" + e);
            JOptionPane.showMessageDialog(null, "Error al conectar con base de datos, contacte al programador tqm");
        }
        return -1;
    }
    
    public Agroconsejos() {
        initComponents();
        consejosName.setText("''"+nombre_lote+"''");
        Datos[0] = ObtenerDetalleSuelo("pH");
        Datos[1] = ObtenerDetalleSuelo("temperatura_suelo");
        Datos[2] = ObtenerDetalleSuelo("temperatura_ambiente");
        Datos[3] = ObtenerDetalleSuelo("humedad_suelo");
        Datos[4] = ObtenerDetalleSuelo("humedad_ambiente");
        Datos[5] = ObtenerDetalleSuelo("nitrogeno");
        Datos[6] = ObtenerDetalleSuelo("fosforo");
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

        jPanel1 = new javax.swing.JPanel();
        consejosName = new javax.swing.JLabel();
        cultivo = new javax.swing.JLabel();
        riego = new javax.swing.JLabel();
        mejoraTierra = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        descripcion = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        consejosName1 = new javax.swing.JLabel();
        backjpanel = new javax.swing.JPanel();
        backjlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scrollPane1 = new java.awt.ScrollPane();
        descripcion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setEnabled(false);
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consejosName.setFont(new java.awt.Font("Gotham", 1, 18)); // NOI18N
        consejosName.setForeground(new java.awt.Color(0, 102, 5));
        consejosName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        consejosName.setText("...");
        jPanel1.add(consejosName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 490, 40));

        cultivo.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        cultivo.setForeground(new java.awt.Color(0, 102, 5));
        cultivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cultivo.setText("CULTIVO");
        cultivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cultivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cultivoMouseClicked(evt);
            }
        });
        jPanel1.add(cultivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 100, -1));

        riego.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        riego.setForeground(new java.awt.Color(0, 102, 5));
        riego.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        riego.setText("RIEGO");
        riego.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        riego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                riegoMouseClicked(evt);
            }
        });
        jPanel1.add(riego, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 110, -1));

        mejoraTierra.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        mejoraTierra.setForeground(new java.awt.Color(0, 102, 5));
        mejoraTierra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mejoraTierra.setText("MEJORA TIERRA");
        mejoraTierra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mejoraTierra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mejoraTierraMouseClicked(evt);
            }
        });
        jPanel1.add(mejoraTierra, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 150, 40));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 10, 30));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 20, 30));

        descripcion.setBackground(new java.awt.Color(0, 0, 0));
        descripcion.setFont(new java.awt.Font("Gotham", 0, 13)); // NOI18N
        descripcion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        descripcion.setAutoscrolls(true);
        jPanel1.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 490, 380));

        titulo.setBackground(new java.awt.Color(0, 0, 0));
        titulo.setFont(new java.awt.Font("Gotham", 3, 14)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("...");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 450, 30));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 430, 10));

        consejosName1.setFont(new java.awt.Font("Gotham", 1, 18)); // NOI18N
        consejosName1.setForeground(new java.awt.Color(0, 102, 5));
        consejosName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        consejosName1.setText("CONSEJOS");
        jPanel1.add(consejosName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 190, -1));

        backjpanel.setBackground(new java.awt.Color(108, 89, 49));

        backjlabel.setFont(new java.awt.Font("Gotham", 0, 18)); // NOI18N
        backjlabel.setForeground(new java.awt.Color(255, 255, 255));
        backjlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backjlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/backk.png"))); // NOI18N
        backjlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        descripcion.setBackground(new java.awt.Color(0, 0, 0));
        descripcion.setFont(new java.awt.Font("Gotham", 0, 13)); // NOI18N
        descripcion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        descripcion.setAutoscrolls(true);
        jPanel1.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 490, 380));

        jPanel1.add(scrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void riegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_riegoMouseClicked
        
        titulo.setText("Riego");
        String consejo = obtenerConsejoDesdeHuggingFace("riego", Datos);
    
        if(consejo != null){ // para ver si hubo fallo con la ia o q
            descripcion.setText("<html>" + consejo.replaceAll("\n", "<br>") + "</html>");
        }else{
            //Persistencia humedad suelo
            if(Datos[3]<80 && Datos[3]>60){
                descripcion.setText("<html>Tu humedad del suelo es ideal. HUMEDAD SUELO: "+Datos[3]);
            }else{
                if(Datos[3]<=60){
                    descripcion.setText("<html>Tu humedad del suelo es baja, deberias empezar a regar "
                            + "más frecuentemente o aplicar un riego de profundidad teniendo cuidado "
                            + "de sobrepasarte. HUMEDAD SUELO: "+Datos[3]);
                }else{
                    descripcion.setText("<html>Tu humedad del suelo es alta, deberias "
                            + " reducir la frecuencia de tu riego o aplicar un riego más superficial;"
                            + " tambien puedes usar un sistema de drenaje para eliminar el exceso de "
                            + "agua en tu suelo. HUMEDAD SUELO: "+Datos[3]);
                }
            }
            descripcion.setText(descripcion.getText()+"<br><br>Aqui unos consejos generales: <br><br>Riega las raíces, "
                    + "no las hojas. <br><br>Riega profundamente para que el agua penetre en el suelo hasta las raíces. "
                    + "<br><br>Riega temprano en la mañana o tarde para en la noche para evitar la evaporación.");
        }
        
              
    }//GEN-LAST:event_riegoMouseClicked

    private void mejoraTierraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mejoraTierraMouseClicked

        titulo.setText("Mejora tierra");
        String consejo = obtenerConsejoDesdeHuggingFace("mejorar la tierra", Datos);

        if(consejo != null){ // para ver si hubo fallo con la ia o q
            descripcion.setText("<html>" + consejo.replaceAll("\n", "<br>") + "</html>");
        }else{
            //Persistencia ph
            if(Datos[0]<7.3 && Datos[0]>6.6){
                descripcion.setText("<html>Tu pH es ideal :D pH: "+Datos[0]);
            }else{
                if(Datos[0]<=6.6){
                    descripcion.setText("<html>Tu pH es bajo(acido), deberias de agregarle un poco de cal a tu"
                            + " suelo. ph: "+Datos[0]);
                }else{
                    descripcion.setText("<html>Tu pH es alto(basico), deberias de agregarle un poco de azufre a tu "
                            + "suelo. ph: "+Datos[0]);
                }
            }        
            //Persistencia temperatura suelo
            if(Datos[1]<24 && Datos[1]>18){
                descripcion.setText(descripcion.getText()+"<br><br>Tu temperatura de suelo es ideal :D Temp Suelo: "+Datos[1]);
            }else{
                if(Datos[1]<=18){
                    descripcion.setText(descripcion.getText()+"<br><br>Tu temperatura de suelo es baja(frio), deberias de "
                            + "cubrir tu suelo con mantillo o láminas de plastico negro para retener el calor del sol."
                            + " Temp Suelo: "+Datos[1]);
                }else{
                    descripcion.setText(descripcion.getText()+"<br><br>Tu temperatura de suelo es alta(calor), deberias de"
                            + "cubrir el suelo con paja o hojas para mantenerlo fresco; o regar el suelo por la noche"
                            + "para que el agua se evapore mas lentamente. Temp Suelo: "+Datos[1]);
                }
            }        
            //Persistencia temperatura ambiente
            if(Datos[2]<25 && Datos[2]>15){
                descripcion.setText(descripcion.getText()+"<br><br>Tu temperatura del ambiente es ideal :D Temp Ambiente: "+Datos[2]);
            }else{
                if(Datos[2]<=15){
                    descripcion.setText(descripcion.getText()+"<br><br>Tu temperatura del ambiente es baja(frio). Temp Ambiente: "+Datos[2]);
                }else{
                    descripcion.setText(descripcion.getText()+"<br><br>Tu temperatura del ambiente es alta(calor). Temp Ambiente: "+Datos[2]);
                }
            }        
            //Persistencia humedad suelo
            if(Datos[3]<80 && Datos[3]>60){
                descripcion.setText(descripcion.getText()+"<br><br>Tu humedad del suelo es ideal :D Humedad suelo: "+Datos[3]);
            }else{
                if(Datos[3]<=60){
                    descripcion.setText(descripcion.getText()+"<br><br>Tu humedad del suelo es baja, deberias de "
                            + "empezar a regar más frecuentemente, o aplicar un riego de profundidad teniendo cuidado "
                            + "de sobrepasarte. Humedad suelo: "+Datos[3]);
                }else{
                    descripcion.setText(descripcion.getText()+"<br><br>Tu humedad del suelo es alta, deberias de "
                            + "reducir la frecuencia de tu riego o aplicar un riego más superficial;"
                            + " tambien puedes usar un sistema de drenaje para eliminar el exceso de "
                            + "agua en tu suelo. Humedad suelo: "+Datos[3]);
                }
            }        
            //Persistencia humedad ambiente
            if(Datos[4]<70 && Datos[4]>50){
                descripcion.setText(descripcion.getText()+"<br><br>Tu humedad del ambiente es ideal :D Humedad ambiente: "+Datos[4]);
            }else{
                if(Datos[4]<=50){
                    descripcion.setText(descripcion.getText()+"<br><br>Tu humedad del ambiente es baja. Humedad ambiente: "+Datos[4]);
                }else{
                    descripcion.setText(descripcion.getText()+"<br><br>Tu humedad del ambiente es alta. Humedad ambiente: "+Datos[4]);
                }
            }        
            //Persistencia nitrogeno
            if(Datos[5]<150 && Datos[5]>100){
                descripcion.setText(descripcion.getText()+"<br><br>Tu nivel de nítrogeno es ideal :D Nítrogeno: "+Datos[5]);
            }else{
                if(Datos[5]<=100){
                    descripcion.setText(descripcion.getText()+"<br><br>Tu nivel de nítrogeno es bajo, deberias de "
                            + "aplicar fertilizante nitrogenado. Nítrogeno: "+Datos[5]);
                }else{
                    descripcion.setText(descripcion.getText()+"<br><br>Tu nivel de nítrogeno es alto, deberias de "
                            + "agregarle materia orgánica al suelo o cambiar el cultivo de tu suelo para"
                            + " reducir la acumulación de nítrogeno en el suelo. Nítrogeno: "+Datos[5]);
                }
            }      
            //Persistencia fósforo
            if(Datos[6]<35 && Datos[6]>15){
                descripcion.setText(descripcion.getText()+"<br><br>Tu nivel de fósforo es ideal :D Fósforo: "+Datos[6]+"</html>");
            }else{
                if(Datos[6]<=15){
                    descripcion.setText(descripcion.getText()+"<br><br>Tu nivel de fósforo es bajo, deberias de "
                            + "aplicar fertilizante fosfóricos y fosfatados. Fósforo: "+Datos[6]+"</html>");
                }else{
                    descripcion.setText(descripcion.getText()+"<br><br>Tu nivel de fósforo es alto, deberias de "
                            + "agregarle materia orgánica al suelo o regar el suelo con agua abundante hasta"
                            + " que el agua que sale del suelo esté clara. Fósforo: "+Datos[6]+"</html>");
                }
            }
        }
        
    }//GEN-LAST:event_mejoraTierraMouseClicked

    private void cultivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cultivoMouseClicked
        
        titulo.setText("Cultivo");
        String consejo = obtenerConsejoDesdeHuggingFace("cultivos", Datos);

        if(consejo != null){ // para ver si hubo fallo con la ia o q
            descripcion.setText("<html>" + consejo.replaceAll("\n", "<br>") + "</html>");
        }else{
            //Persistencia ph
            if(Datos[0]<7.3 && Datos[0]>6.6){
                descripcion.setText("<html>Tu pH es ideal(neutro), aqui puedes cultivar cereales, legumbres, verduras y"
                        + " frutas. pH: "+Datos[0]);
            }else{
                if(Datos[0]<=6.6){
                    descripcion.setText("<html>Tu pH es bajo(acido), aqui puedes cultivar plantas como arándanos, "
                            + "fresas, moras, arroz, menta; en general plantas resistentes a la acidez. ph: "+Datos[0]);
                }else{
                    descripcion.setText("<html>Tu pH es alto(basico), aqui puedes cultivar plantas como aguacates, mangos"
                            + ", zanahorias, orégano; en general plantas resistentes a la alcalinidad. ph: "+Datos[0]);
                }
            }        
            //Persistencia temperatura suelo
            if(Datos[1]<24 && Datos[1]>18){
                descripcion.setText(descripcion.getText()+"<br>Tu temperatura del suelo es ideal, aqui puedes cultivar "
                        + "cereales, legumbres, verduras y frutas. Temp Suelo: "+Datos[1]);
            }else{
                if(Datos[1]<=18){
                    descripcion.setText(descripcion.getText()+"<br>Tu temperatura del suelo es baja(frio),"
                            + " aqui puedes cultivar plantas como lechuga, brócoli, fresas; en general"
                            + " plantas resistentes al frio. Temp Suelo: "+Datos[1]);
                }else{
                    descripcion.setText(descripcion.getText()+"<br>Tu temperatura del suelo es alta(calor),"
                            + " aqui puedes cultivar plantas como tomates, pepinos, berenjenas, mangos;"
                            + " en general plantas resistentes al calor. Temp Suelo: "+Datos[1]);
                }
            }        
            //Persistencia temperatura ambiente
            if(Datos[2]<25 && Datos[2]>15){
                descripcion.setText(descripcion.getText()+"<br>Tu temperatura del ambiente es ideal, aqui puedes cultivar "
                        + "cereales, legumbres, verduras y frutas. Temp Ambiente: "+Datos[2]);
            }else{
                if(Datos[2]<=15){
                    descripcion.setText(descripcion.getText()+"<br>Tu temperatura del ambiente es baja(frio),"
                            + " aqui puedes cultivar plantas como manzanas, peras, uvas, lentejas, menta"
                            + "; en general plantas resistentes al frio. Temp Ambiente: "+Datos[2]);
                }else{
                    descripcion.setText(descripcion.getText()+"<br>Tu temperatura ambiente es alta(calor),"
                            + " aqui puedes cultivar plantas como aguacate, mango, papaya, berenjena, maíz; "
                            + "en general plantas resistentes al calor. Temp Ambiente: "+Datos[2]);
                }
            }        
            //Persistencia humedad suelo
            if(Datos[3]<80 && Datos[3]>60){
                descripcion.setText(descripcion.getText()+"<br>Tu humedad del suelo es ideal, aqui puedes cultivar"
                        + " cereales, legumbres, verduras y frutas. Humedad suelo: "+Datos[3]);
            }else{
                if(Datos[3]<=60){
                    descripcion.setText(descripcion.getText()+"<br>Tu humedad del suelo es baja, aqui puedes"
                            + " cultivar trigo, cebada, garbanzos, pepino, manzana, pera; en general"
                            + " plantas resistentes a la sequía. Humedad suelo: "+Datos[3]);
                }else{
                    descripcion.setText(descripcion.getText()+"<br>Tu humedad del suelo es alta, aqui puedes cultivar"
                            + " arroz, plátano, caña de azúcar, zanahora; en general plantas resistentes a la "
                            + "humedad. Humedad suelo: "+Datos[3]);
                }
            }        
            //Persistencia humedad ambiente
            if(Datos[4]<70 && Datos[4]>50){
                descripcion.setText(descripcion.getText()+"<br>Tu humedad del ambiente es ideal, aqui puedes cultivar "
                        + "cereales, legumbres, verduras y frutas. Humedad ambiente: "+Datos[4]);
            }else{
                if(Datos[4]<=50){
                    descripcion.setText(descripcion.getText()+"<br>Tu humedad del ambiente es baja, aqui puedes"
                            + " cultivar trigo, cebada, garbanzos, pepino, manzana, pera; en general"
                            + " plantas resistentes a la sequía. Humedad ambiente: "+Datos[4]);
                }else{
                    descripcion.setText(descripcion.getText()+"<br>Tu humedad del ambiente es alta, aqui puedes"
                            + " cultivar arroz, plátano, caña de azúcar, zanahora; en general plantas resistentes a la "
                            + "humedad. Humedad ambiente: "+Datos[4]);
                }
            }        
            //Persistencia nitrogeno
            if(Datos[5]<150 && Datos[5]>100){
                descripcion.setText(descripcion.getText()+"<br>Tu nítrogeno es ideal, aqui puedes cultivar "
                        + "cereales, legumbres, verduras y frutas. Nitrogeno: "+Datos[5]);
            }else{
                if(Datos[5]<=100){
                    descripcion.setText(descripcion.getText()+"<br>Tu nivel de nítrogeno es bajo, aqui puedes cultivar"
                            + " legumbres como las lentejas, los frijoles y los guisantes; tambien zanahoria, remolachas; "
                            + "en general plantas que son capaces de absorber el nitrógeno del suelo de manera eficiente "
                            + "y pueden crecer y producir incluso con niveles bajos de nitrógeno. Nitrogeno: "+Datos[5]);
                }else{
                    descripcion.setText(descripcion.getText()+"<br>Tu nivel de nítrogeno es alto, aqui puedes cultivar"
                            + " cultivos forrajeros como el maíz, el sorgo, la avena; tambien algodon, tabaco, azúcar; en"
                            + " general plantas que requieren una gran cantidad de nitrogeno para su crecimiento."
                            + " Nitrogeno: "+Datos[5]);
                }
            }      
            //Persistencia fósforo
            if(Datos[6]<35 && Datos[6]>15){
                descripcion.setText(descripcion.getText()+"<br>Tu nivel de fósforo es ideal, aqui puedes cultivar "
                        + "cereales, legumbres, verduras y frutas. Fósforo: "+Datos[6]+"</html>");
            }else{
                if(Datos[6]<=15){
                    descripcion.setText(descripcion.getText()+"<br>Tu nivel de fósforo es bajo aqui puedes cultivar"
                            + " cereales como el trigo, el arroz y el maiz; tambien espinacas, acelgas, zanahorias;"
                            + " en general plantas que requieren una cantidad relativamente baja de fósforo para su crecimiento."
                            + " Fósforo: "+Datos[6]+"</html>");
                }else{
                    descripcion.setText(descripcion.getText()+"<br>Tu nivel de fósforo es alto, aqui puedes cultivar"
                            + " papa, remolacha, guisantes, lentejas; en general plantas que son tolerantes "
                            + "a altos niveles de fósforo. Fósforo: "+Datos[6]+"</html>");
                }
            }
            
        }

        
    }//GEN-LAST:event_cultivoMouseClicked

    private void backjlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backjlabelMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_backjlabelMouseClicked

    private void backjlabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backjlabelMouseEntered
        backjpanel.setBackground(new Color(61,53,37));
    }//GEN-LAST:event_backjlabelMouseEntered

    private void backjlabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backjlabelMouseExited
        backjpanel.setBackground(new Color(108,89,49));
    }//GEN-LAST:event_backjlabelMouseExited

    /**
     * @param args the command line aVolverJPanelts
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
            java.util.logging.Logger.getLogger(Agroconsejos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agroconsejos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agroconsejos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agroconsejos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agroconsejos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backjlabel;
    private javax.swing.JPanel backjpanel;
    private javax.swing.JLabel consejosName;
    private javax.swing.JLabel consejosName1;
    private javax.swing.JLabel cultivo;
    private javax.swing.JLabel descripcion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel mejoraTierra;
    private javax.swing.JLabel riego;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
