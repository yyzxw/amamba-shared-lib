def call(Map config) {
    runArgs = "--entrypoint='' "

    String pluginID = config.pluginID
    Map args = config.args
    string volume = config.volume

    if (volume) {
        runArgs = runArgs + "-v ${volume}"
    }
    echo "Running plugin ${pluginID} with ${args}, volume: ${volume}"

    script {
        String envVars = args.collect { k, v ->
            "-e ${k}=${v}"
        }.join(' ')

        echo "envVars: ${envVars}"
        runArgs = runArgs + " ${envVars}"
        docker.image("$image").inside("$runArgs") {
            sh "$shell $script"
        }
    }
}

return this
