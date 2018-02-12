def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
	stage('Read Yaml'){
		sh('value=`curl '+ config.url`)
		sh('echo $value')
	}
    }
}

