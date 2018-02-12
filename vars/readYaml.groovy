def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
	
    def value
	
    node {
	stage('Read Yaml'){
		
		value=sh('value=`curl '+ config.url+'`')
		sh('echo $value')
	}
    }
}

