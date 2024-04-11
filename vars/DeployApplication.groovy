def call(String credentialsId,String cluster, String namespace, String filepath){
    sh '''    
        withCredentials([file(credentialsId: ${credentialsId}, variable: 'KUBECONFIG')]) {
                echo "deploying ${filepath} to ${cluster} in ${namespace} namespace"
                kubectl apply - f ${filepath} -n ${namespace}
        }
        '''
}

return this