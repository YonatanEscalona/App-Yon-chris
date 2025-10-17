# App-Yon-chris

Aplicación Android para la tarea de Intents. Hecha en Java con intents explícitos e implícitos.

## 📱 Información Técnica

- **Android mínimo**: API 31 (Android 12)
- **Android target**: API 36 (Android 14+)
- **AGP**: 8.x
- **Lenguaje**: Java

## 🗺️ LocationManager

Para la ubicación usé un intent implícito con Google Maps en vez de LocationManager directamente:
```java
String ubicacion = "geo:-33.4372,−70.6128?q=Santo+Tomás+Universidad";
Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ubicacion));
startActivity(mapIntent);
```

## 📚 Librería Interna

Actividades que hice como módulos reutilizables:
- **DetalleActivity**: Muestra los datos del producto
- **FormActivity y ConfirmActivity**: Formulario que devuelve si confirmaste o cancelaste
- **SwitchActivity**: Elige a dónde ir según lo que selecciones

---

## 📋 Intents que Implementé

### 🌐 Intents Implícitos (5)

#### 1. Abrir Configuración de Wi-Fi
**Archivo**: `HomeActivity.java` (línea 181)

**Código:**
```java
Intent intentConfig = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
startActivity(intentConfig);
```

**Cómo probarlo:**
1. Abre la app
2. Dale al botón "Configuración"
3. Se abre la config de Wi-Fi ✅

---

#### 2. Enviar SMS
**Archivo**: `HomeActivity.java` (línea 217)

**Código:**
```java
Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
smsIntent.setData(Uri.parse("smsto:+56912345678"));
smsIntent.putExtra("sms_body", "Hola, este es un mensaje de prueba");
startActivity(smsIntent);
```

**Cómo probarlo:**
1. Presiona "SMS"
2. Se abre la app de mensajes con el número y texto ya escritos ✅

---

#### 3. Abrir Contactos
**Archivo**: `HomeActivity.java` (línea 197)

**Código:**
```java
Intent contactIntent = new Intent(Intent.ACTION_PICK);
contactIntent.setData(android.provider.ContactsContract.Contacts.CONTENT_URI);
startActivity(contactIntent);
```

**Cómo probarlo:**
1. Dale a "Contactos"
2. Se abre tu lista de contactos del celular ✅

---

#### 4. Abrir Google Maps
**Archivo**: `HomeActivity.java` (línea 188)

**Código:**
```java
String ubicacion = "geo:-33.4372,−70.6128?q=Santo+Tomás+Universidad";
Uri locationUri = Uri.parse(ubicacion);
Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);
startActivity(mapIntent);
```

**Cómo probarlo:**
1. Presiona "Abrir Maps"
2. Google Maps se abre en la ubicación de Santo Tomás ✅

---

#### 5. Marcar Número de Teléfono
**Archivo**: `HomeActivity.java` (línea 206)

**Código:**
```java
String numeroTelefono = "+5695122222";
Intent dialIntent = new Intent(Intent.ACTION_DIAL);
dialIntent.setData(Uri.parse("tel:" + numeroTelefono));
startActivity(dialIntent);
```

**Cómo probarlo:**
1. Dale a "Llamar"
2. Se abre el teclado del teléfono con el número ya puesto ✅
3. No llama solo, solo abre el marcador

---

### 🎯 Intents Explícitos (3)

#### 1. Ir a DetalleActivity con datos
**Archivo**: `HomeActivity.java` (línea 239)

**Código:**
```java
Intent i = new Intent(HomeActivity.this, DetalleActivity.class);
i.putExtra("nombre", nombre);
i.putExtra("precio", precio);
startActivity(i);
```

**Qué hace:** Envía el nombre y precio del producto a otra pantalla

**Cómo probarlo:**
1. Escribe un nombre como "Laptop"
2. Escribe un precio como "500000"
3. Dale a "Ir a Detalle"
4. Se abre DetalleActivity y muestra lo que escribiste ✅

---

#### 2. FormActivity con resultado
**Archivo**: `FormActivity.java` (línea 38)

**Código:**
```java
Intent i = new Intent(FormActivity.this, ConfirmActivity.class);
i.putExtra("nombre", etNombreForm.getText().toString());
i.putExtra("correo", etCorreoForm.getText().toString());
confirmLauncher.launch(i);
```

**Qué hace:** Manda datos a ConfirmActivity y espera que te diga si confirmaste o cancelaste

**Cómo probarlo:**
1. Desde Home, dale a "Ir a Form"
2. Escribe tu nombre y correo
3. Dale "Enviar"
4. En la nueva pantalla dale "Confirmar" o "Cancelar"
5. Vuelve atrás y dice si confirmaste o cancelaste ✅

---

#### 3. SwitchActivity - Navegación Condicional
**Archivo**: `SwitchActivity.java` (línea 29)

**Código:**
```java
int checkedId = rgOpciones.getCheckedRadioButtonId();

if (checkedId == R.id.rbCamara) {
    startActivity(new Intent(SwitchActivity.this, CamaraActivity.class));
} else if (checkedId == R.id.rbPerfil) {
    startActivity(new Intent(SwitchActivity.this, PerfilActivity.class));
}
```

**Qué hace:** Dependiendo de lo que elijas, te lleva a Cámara o Perfil

**Cómo probarlo:**
1. Dale a "Ir a Switch"
2. Selecciona "Cámara"
3. Dale "Abrir"
4. Se abre la pantalla de la cámara ✅
5. Vuelve y prueba con "Perfil" ✅

---

## 🚀 Cómo Compilar

### Si quieres el APK ya hecho:
Está en: `app/build/outputs/apk/debug/app-debug.apk`

### Si quieres compilarlo tú:
```bash
# Clona el repo
git clone https://github.com/YonatanEscalona/App-Yon-chris.git
cd App-Yon-chris

# Cámbiate a la rama de intents
git checkout feature/intents

# Compila el APK
./gradlew assembleDebug

# El APK queda en: app/build/outputs/apk/debug/
```

---

## 📁 Estructura del Proyecto

```
app/src/main/java/com/devst/app/
├── MainActivity.java          # Login
├── HomeActivity.java          # Pantalla principal (todos los botones)
├── DetalleActivity.java       # Muestra producto
├── FormActivity.java          # Formulario
├── ConfirmActivity.java       # Confirmación
├── SwitchActivity.java        # Elegir dónde ir
├── PerfilActivity.java        # Perfil
└── CamaraActivity.java        # Tomar foto
```
