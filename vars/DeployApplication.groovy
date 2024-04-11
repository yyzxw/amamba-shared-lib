def call(String credentialsId,String cluster, String namespace, String filepath){
    echo "deploying ${filepath} to ${cluster} in ${namespace} namespace use ${credentialsId} credentials"
    withCredentials([file(credentialsId: credentialsId, variable: 'KUBECONFIG')]) {
        echo "credentials file is ${KUBECONFIG}"
        sh "kubectl --kubeconfig=${KUBECONFIG} apply -f ${filepath} --namespace=${namespace}"
    }
}

return this