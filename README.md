# Calculator Project

Un proyecto de calculadora en Java con integración continua (CI/CD) usando GitHub Actions y Act.

# Descripción

Este proyecto implementa una calculadora básica con las operaciones fundamentales:
- Suma
- Resta
- Multiplicación
- División (con validación de división por cero)

# Tecnologías

- **Java 17** - Lenguaje de programación
- **Maven 3.9.11** - Gestión de dependencias y construcción
- **JUnit 5** - Framework de testing
- **GitHub Actions** - CI/CD pipeline
- **Docker** - Containerización
- **Act** - Ejecución local de GitHub Actions

# Estructura del Proyecto

```
Calculator/
├── .github/
│   └── workflows/
│       └── ci.yml          # Pipeline de CI/CD
├── src/
│   ├── main/java/
│   │   └── com/ejemplo/
│   │       ├── core/
│   │       │   └── CalculatorService.java
│   │       └── ui/
│   │           └── CalculatorFrame.java
│   └── test/java/
│       └── com/ejemplo/calculadora/
│           └── CalculatorTest.java
├── Dockerfile              # Imagen Docker para testing
├── pom.xml                # Configuración Maven
└── README.md              # Este archivo
```

# Configuración del Entorno

# Prerrequisitos

1. **Java 17** o superior
2. **Maven 3.9.11** o superior
3. **Docker** (para Act)
4. **Act** (para ejecución local de GitHub Actions)

# Instalación de Act

```bash
# Windows (usando Chocolatey)
choco install act-cli

# macOS (usando Homebrew)
brew install act

# Linux
curl https://raw.githubusercontent.com/nektos/act/master/install.sh | sudo bash
```

# Ejecución de Pruebas

# Localmente con Maven

```bash
# Ejecutar todas las pruebas
mvn clean test

# Compilar el proyecto
mvn clean compile

# Generar JAR
mvn clean package
```

# Con Docker

```bash
# Construir imagen Docker
docker build -t calculator-test .

# Ejecutar tests en contenedor
docker run --rm calculator-test
```

# Con Act (GitHub Actions local)

```bash
# Ejecutar el workflow completo
act

# Ejecutar solo el job de tests
act -j test

# Ejecutar con verbose para debugging
act -v
```

# Pipeline CI/CD

El pipeline se ejecuta automáticamente en:
- **Push** a ramas: `main`, `master`, `develop`
- **Pull Requests** hacia: `main`, `master`

# Etapas del Pipeline

1. **Test Job**:
   - Checkout del código
   - Configuración de JDK 17
   - Cache de dependencias Maven
   - Ejecución de pruebas
   - Generación de reportes
   - Compilación

2. **Build Job** (solo en main/master):
   - Construcción del JAR
   - Subida de artefactos

# Componentes Principales

# CalculatorService
Clase principal que implementa las operaciones matemáticas:

```java
public class CalculatorService {
    public double sumar(double a, double b)
    public double restar(double a, double b)
    public double multiplicar(double a, double b)
    public double dividir(double a, double b) // Con validación división por cero
}
```

# CalculatorTest
Suite de pruebas unitarias que valida:
-  Operaciones básicas
-  Casos límite
-  Manejo de errores (división por cero)

# Debugging y Troubleshooting

# Problemas Comunes

1. Error de versión Java:
   ```bash
   java -version  # Verificar versión instalada
   ```

2. Maven no encontrado:
   ```bash
   mvn -version   # Verificar instalación
   ```

3. Act no ejecuta:
   ```bash
   act --list     # Listar workflows disponibles
   act -n         # Dry run sin ejecutar
   ```

# Logs y Reportes

- **Reportes de pruebas**: `target/surefire-reports/`
- **JAR generado**: `target/Calculadora-1.0-SNAPSHOT.jar`
- **Logs de Act**: Se muestran en consola durante ejecución

# Métricas y Calidad

- **Cobertura de código**: Implementada via JUnit 5
- **Reportes automáticos**: Generados en cada ejecución del pipeline
- **Validación continua**: Cada push/PR ejecuta el pipeline completo

# Contribución

1. Fork del proyecto
2. Crear rama feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit cambios (`git commit -am 'Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Crear Pull Request

# Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo LICENSE para detalles.

---

**Nota**: Este proyecto está configurado para demostrar un pipeline CI/CD completo con GitHub Actions y Act para ejecución local.