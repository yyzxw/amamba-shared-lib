def call(String credentialsId,String cluster, String namespace, String filepath){
    echo "deploying ${filepath} to ${cluster} in ${namespace} namespace use ${credentialsId} credentials"
    withCredentials([file(credentialsId: credentialsId, variable: 'KUBECONFIG')]) {
        sh 'kubectl apply - f ${filepath} -n ${namespace}'
    }
}

return this