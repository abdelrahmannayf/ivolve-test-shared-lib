def call(String imageName, String tag) {

    echo "Logging into Docker Hub & Pushing Image..."

    withCredentials([usernamePassword(
        credentialsId: 'dockerhub-cred',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {

        sh """
            echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
            docker push ${imageName}:${tag}
        """
    }
}
