def call(Map config) {
    validate(config)
    runArgs = "--entrypoint='' "

    String pluginID = config.pluginID
    Map args = config.args
    echo "============================================================"
    echo "run amamba custom plugin [${pluginID}] with args: ${args}"

    script {
        String envVars = args.collect { k, v ->
            "-e ${k}=${v}"
        }.join(' ')
        runArgs = runArgs + " ${envVars}"
        //TODO add -v for each volume
        docker.image(args.image).inside("$runArgs") {
            if (args.shell) {
                sh "$args.shell $args.script"
            } else {
                sh "$args.script"
            }
        }
    }
    echo "============================================================"
}

def validate(Map config) {
    if (!config.pluginID) {
        error "pluginID is required"
    }
    if (!config.args) {
        error "args is required"
    }
    if (!config.args.image) {
        error "args.image is required"
    }
    if (!config.args.script) {
        error "args.script is required"
    }
    return this
}

return this
