FROM openjdk:17-oracle

# Create app directory
WORKDIR /spring-reddit-clone

# Install app dependencies
# A wildcard is used to ensure both package.json AND package-lock.json are copied
# where available (npm@5+)
COPY . .

EXPOSE 8080
CMD [ "java", "-noverify","-jar","target/spring-reddit-clone-0.0.1-SNAPSHOT.jar"]