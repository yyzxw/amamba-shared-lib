def call(String credentialsId,String cluster, String namespace, String kind, String name,String container, String image){
    echo "update ${kind}/${name} to ${image} in ${cluster} in ${namespace} namespace use ${credentialsId} credentials"
    withCredentials([file(credentialsId: credentialsId, variable: 'KUBECONFIG')]) {
        sh "kubectl set image ${kind}/${name} ${container}=${image} -n ${namespace}"
    }
}

return this