# Usar la imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado al contenedor
COPY --from=myapp-build /app/target/myapp.jar app.jar

# Exponer el puerto que la aplicación usa
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
