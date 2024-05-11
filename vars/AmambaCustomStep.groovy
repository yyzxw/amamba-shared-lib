def call(String pluginID,Map args){
    def envs = [:]
    args.each { k, v ->
        envs[k] = v
    }
    echo "Running plugin ${pluginID} with ${envs}"
    withEnv(envs) {
        def image = envs['image']
        def shell = envs['shell']
        def script = envs['script']
        docker.image("$image").inside("--entrypoint=''") {
            sh "$shell $script"
        }
    }
}

return this