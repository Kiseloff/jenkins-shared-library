#!/usr/bin/env groovy

def call(String repName, String imgName, String projectPath) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t ${repName}/${imgName} ${projectPath}"
        sh "echo $PASS | docker login -u $USER --password-stdin ${repName}"
        sh "docker push ${repName}/${imgName}"
    }
}
