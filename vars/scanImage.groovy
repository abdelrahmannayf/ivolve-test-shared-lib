def call(String imageName, String tag) {
    echo "Scanning Image with Trivy..."
    sh "trivy image ${imageName}:${tag}"
}
