// var/generatePipeline.groovy
def call(String lang){
    if (lang == 'java') {
        echo java
    } else if (lang == 'node'){
        echo node
    }
     sh 'echo ${lang}'
}

return this
