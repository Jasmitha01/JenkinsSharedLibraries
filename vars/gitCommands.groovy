def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node{
           stage('Checkout') {
              git(url: config.url, branch: config.branch, credentialsId: config.cid)
           }
        
           stage('Create temp file') {
              sh('cd $WORKSPACE/')
              sh('touch '+config.file)
           }
         
          stage('Commit'){
              sh('git add .')
              sh('git commit -m "adding the file "' + config.file)
           }
                 
          stage('Push'){
              sh('git push origin '+config.branch)
           }
    }

}

