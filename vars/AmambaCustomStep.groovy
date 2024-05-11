def call(Map config) {
    runArgs = "--entrypoint=''"

    String pluginID = config.pluginID
    Map args = config.args
    string volume = config.volume

    echo "Running plugin ${pluginID} with ${args}, volume: ${volume}"

    script {
        Map envVars = args.collectEntries { k, v ->
            [k, v]
        }
        echo "envVars: ${envVars}"

        withEnv(envVars) {
            if (volume) {
                runArgs = runArgs + " -v ${volume}"
            }
            docker.image("$image").inside("$runArgs") {
                sh "$shell $script"
            }
        }
    }
}

return this
