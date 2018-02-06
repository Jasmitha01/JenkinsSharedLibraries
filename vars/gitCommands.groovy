def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node{
           stage('checkout') {
              git(url: config.url, branch: config.branch, credentialsId: config.cid)
           }
            stage('checkout') {
              sh('echo $env.WORKSPACE')
           }
    }

}

