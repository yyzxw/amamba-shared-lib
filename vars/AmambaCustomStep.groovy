def call(Map args){
    def envs = [:]
    args.each { k, v ->
        envs[k] = v
    }

    def image = envs['image']
    def shell = envs['shell']
    def script = envs['script']
    def pluginID = envs['pluginID']
    if (image == null || shell == null || script == null || pluginID == null) {
        error("Missing required parameters")
    }
    echo "Running plugin ${pluginID} with ${envs}"
    withEnv(envs) {
        docker.image("$image").inside("--entrypoint=''") {
            sh "$shell $script"
        }
    }
}

return this