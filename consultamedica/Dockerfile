#Dockerfile
FROM openjdk:21-ea-24-oracle

#directorio de trabajo
WORKDIR /app

#aqui debemos asegurarnos que el nombre de nuestro jar coincida
COPY target/consultamedica-0.0.1-SNAPSHOT.jar aplicacion.jar

#Ubicacion y nombre del Wallet descomprimido
COPY Wallet_S2EAZR8T9KFHQM3E /app/oracle_wallet/

#Puerto
EXPOSE 8080

# Comando para ejecutar tu aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "aplicacion.jar"]
