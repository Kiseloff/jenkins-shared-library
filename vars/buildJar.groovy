#!/usr/bin/env groovy

def call(PROJECT_PATH) {
    echo "building the app..."
    sh "mvn package -f ${PROJECT_PATH}"
}