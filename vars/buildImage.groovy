#!/usr/bin/env groovy

def call(PROJECT_PATH) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'ls -la'
        sh "docker build -t 192.168.88.14:8083/java-maven-app:4.0 ${PROJECT_PATH}"
        sh "echo $PASS | docker login -u $USER --password-stdin 192.168.88.14:8083"
        sh 'docker push 192.168.88.14:8083/java-maven-app:4.0'
    }
}
