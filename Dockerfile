# Dockerfile para Calculator con JDK 17 y Maven
FROM openjdk:17-jdk-slim

# Instalar Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Establecer directorio de trabajo
WORKDIR /app

# Copiar archivos del proyecto
COPY pom.xml .
COPY src ./src

# Descargar dependencias (para optimizar cache de Docker)
RUN mvn dependency:go-offline -B

# Compilar y ejecutar tests
RUN mvn clean compile test

# Construir el JAR
RUN mvn clean package -DskipTests

# Exponer puerto (si fuera necesario para una aplicación web)
EXPOSE 8080

# Comando por defecto: ejecutar tests
CMD ["mvn", "test"]