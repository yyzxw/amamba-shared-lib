#!/usr/bin/env groovy

def call(String imageName) {
    stage('Docker Push') {
        sh "echo "pushing ${imageName}""
        sh "docker push ${imageName}"
    }
}

return this