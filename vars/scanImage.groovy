def call(String imageName, String tag) {

    echo "Scanning Image with Trivy..."

    sh """
        trivy image \
        --scanners vuln \
        --timeout 10m \
        --severity HIGH,CRITICAL \
        ${imageName}:${tag}
    """
}
