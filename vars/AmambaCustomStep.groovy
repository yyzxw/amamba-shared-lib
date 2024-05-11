def call(Map config) {
    runArgs = "--entrypoint='' "

    String pluginID = config.pluginID
    echo "run amamba custom step ${pluginID}"

    Map args = config.args
    echo "plugin args ${args}"

    script {
        String envVars = args.collect { k, v ->
            "-e ${k}=${v}"
        }.join(' ')

        echo "inject env vars ${envVars}"

        runArgs = runArgs + " ${envVars}"
        docker.image(args.image).inside("$runArgs") {
            sh "$args.shell $args.script"
        }
    }
}

return this
