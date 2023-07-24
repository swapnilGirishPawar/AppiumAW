FROM openjdk
WORKDIR /app
COPY . /app
RUN javac src/test/java/TestRunners/TestRunner.java
CMD ["mvn", "test"]