def call(Map config){
    String pluginID = config.pluginID
    Map args = config.args

    echo "Running plugin ${pluginID} with ${args}"
    script {
        withEnv(args) {
            def image = args['image']
            def shell = args['shell']
            def script = args['script']
            docker.image("$image").inside("--entrypoint=''") {
                sh "$shell $script"
            }
        }
    }
}

return this