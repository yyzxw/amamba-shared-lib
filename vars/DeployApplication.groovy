def call(String credentialsId,String cluster, String namespace, String filepath){
    sh "deploying ${filepath} to ${cluster} in ${namespace} namespace use ${credentialsId} credentials"
//        withCredentials([file(credentialsId: ${credentialsId}, variable: 'KUBECONFIG')]) {
//            sh '''
//                echo ""
//                kubectl apply - f ${filepath} -n ${namespace}
//                '''
//        }
}

return this