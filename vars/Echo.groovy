// var/generatePipeline.groovy
def call(String lang){
    if (lang == 'java') {
        sh 'echo java'
    } else if (lang == 'node'){
        sh 'echo node'
    }
     sh 'echo ${lang}'
}

return this
