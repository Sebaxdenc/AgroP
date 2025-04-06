# AgroP

**AgroP** es una aplicación diseñada para ayudar a los campesinos a ser más conscientes sobre el estado de su tierra y proporcionar consejos personalizados para mejorarla. Utiliza datos agrícolas como pH, temperatura, humedad y nutrientes para generar recomendaciones basadas en inteligencia artificial.

---

## **Cómo compilar el proyecto**

### **Requisitos previos**
1. **NetBeans 13**:
    - Descarga e instala NetBeans 13 desde [Apache NetBeans](https://netbeans.apache.org/download/).
2. **JDK 17**:
    - Descarga e instala JDK 17 desde [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) o [OpenJDK](https://openjdk.org/).
    - Asegúrate de configurar la variable de entorno `JAVA_HOME` apuntando al directorio de instalación del JDK 17.

3. **Dependencias externas**:
    - Asegúrate de que las bibliotecas necesarias, como `mysql-connector-java` y `jfreechart`, estén disponibles en el proyecto. Estas ya están incluidas en la carpeta `lib`.

4. **Base de datos local**:
    - La aplicación utiliza una base de datos local configurada en MySQL Workbench. El esquema de la base de datos y las tablas necesarias están incluidas en el proyecto. Asegúrate de importar el archivo SQL proporcionado para configurar la base de datos correctamente.
    - Asegúrate de que las credenciales de la base de datos coincidan con las configuraciones en el archivo config.properties.

5. **Arduino Nano con sensores**:
    - El proyecto incluye un Arduino Nano que recopila datos de un sensor DHT11 (temperatura y humedad) y un sensor HW-080 (humedad del suelo). El Arduino envía estos tres datos al sistema a través de comunicación serial.
    - El código fuente para el Arduino está incluido en la carpeta `arduino/` dentro del proyecto. Asegúrate de compilarlo y cargarlo en el Arduino Nano utilizando el IDE de Arduino.
    - Descarga el IDE de Arduino desde [Arduino](https://www.arduino.cc/en/software).

---

### **Pasos para compilar con NetBeans 13**
1. **Abrir el proyecto en NetBeans**:
   - Abre NetBeans 13.
   - Haz clic en `File > Open Project` y selecciona la carpeta raíz del proyecto `AgroP`.

2. **Configurar el JDK 17**:
   - Ve a `Tools > Java Platforms`.
   - Asegúrate de que JDK 17 esté configurado como la plataforma predeterminada.

3. **Configurar las dependencias**:
   - Asegúrate de que las bibliotecas externas (como `mysql-connector-java` y `jfreechart`) estén añadidas al proyecto:
     - Haz clic derecho en el proyecto `AgroP` en el panel de proyectos.
     - Selecciona `Properties > Libraries`.
     - Añade las bibliotecas necesarias desde la carpeta `lib`.

4. **Compilar el proyecto**:
   - Haz clic derecho en el proyecto `AgroP` en el panel de proyectos.
   - Selecciona `Clean and Build`.
   - Esto generará un archivo `.jar` en la carpeta `dist`.

5. **Ejecutar el proyecto**:
   - Haz clic derecho en el proyecto `AgroP` y selecciona `Run`.
   - Asegúrate de que el archivo `config.properties` esté correctamente configurado para conectarse a la base de datos y a la API de Hugging Face.

---

## **Configuración del archivo `config.properties`**

El archivo `config.properties` se encuentra en la carpeta `src/config`. Asegúrate de configurarlo correctamente antes de ejecutar el proyecto. Aquí tienes un ejemplo:

```properties
# --- Configuración de la base de datos ---
db.host=localhost
db.user=root
db.password=tu_contraseña

# --- Configuración de la API de Hugging Face ---
hf.api.url=https://api-inference.huggingface.co/models/mistralai/Mistral-7B-Instruct-v0.2
hf.api.token=Bearer tu_token_de_huggingface
```
## **Imágenes del proyecto**

### **Pantallas principales**

![Pantalla principal1](images/login.png)
![Pantalla principal2](images/register.png)
![Pantalla principal3](images/lotes.png)
![Pantalla principal4](images/ingreso_datos.png)


### **Consejos personalizados**

![Consejos personalizados](images/consejos_ia.png)

### **Gráficos de análisis**

![Graficos](images/grafica.png)
![Graficos](images/tiempo_real.png)


### **Base de datos MySQL Workbench**

![Base de datos](images/bd.png)

## **Funcionalidades principales**

### **Análisis del estado de la tierra**
- Permite ingresar datos como pH, temperatura, humedad y nutrientes para evaluar el estado de la tierra.

### **Generación de consejos personalizados**
- Utiliza inteligencia artificial para proporcionar recomendaciones específicas basadas en los datos ingresados.

### **Visualización de gráficos**
- Muestra gráficos interactivos para analizar tendencias y patrones en los datos agrícolas.

### **Conexión a bases de datos**
- Permite almacenar y recuperar datos históricos para un análisis más detallado.

### **Integración con sensores**
- Recopila datos directamente desde sensores conectados a un Arduino Nano.

---

## **Contribuciones**
Si deseas contribuir al proyecto, por favor crea un fork del repositorio, realiza tus cambios y envía un pull request. ¡Todas las contribuciones son bienvenidas!
