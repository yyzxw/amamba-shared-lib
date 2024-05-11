def call(String pluginID,Map args){
    echo "Running plugin ${pluginID} with ${args}"
    withEnv(args) {
        def image = args['image']
        def shell = args['shell']
        def script = args['script']
        docker.image("$image").inside("--entrypoint=''") {
            sh "$shell $script"
        }
    }
}

return this