call mvn clean package -DskipTests -T 8
call docker build -t europe-north1-docker.pkg.dev/root-augury-420915/microservice/microservice1 .
call docker push europe-north1-docker.pkg.dev/root-augury-420915/microservice/microservice1