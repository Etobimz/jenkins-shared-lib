#!/usr/bin/env groovy

def call(String imageName) {
    echo "Building the Docker image: ${imageName}"

    withCredentials([
        usernamePassword(
            credentialsId: 'docker-gub-maven-rep',
            usernameVariable: 'DOCKER_USERNAME',
            passwordVariable: 'DOCKER_PASSWORD'
        )
    ]) {
        sh """
            echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin
            docker build -t ${imageName} .
            docker tag ${imageName} \$DOCKER_USERNAME/${imageName}
            docker push \$DOCKER_USERNAME/${imageName}
        """
    }
}
