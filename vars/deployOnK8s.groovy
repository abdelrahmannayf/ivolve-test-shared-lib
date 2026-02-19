def call(String imageName, String tag, String namespace) {

    echo "Deploying to Kubernetes Namespace: ${namespace}"

    sh """
        sed -i 's|IMAGE_PLACEHOLDER|${imageName}:${tag}|g' deployment.yaml
        kubectl apply -n ${namespace} -f deployment.yaml
    """
}
