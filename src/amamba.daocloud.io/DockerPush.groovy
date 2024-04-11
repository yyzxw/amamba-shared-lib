#!/usr/bin/env groovy

def call(String imageName) {
    stage('Docker Push') {
        sh "docker push ${imageName}"
    }
}

return this