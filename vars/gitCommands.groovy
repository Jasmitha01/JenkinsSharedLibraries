def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node{
           stage('Checkout') {
              git(url: config.url1+config.url2, branch: config.branch, credentialsId: config.cid)
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
              sh('git push '+config.url1+config.git_user+':'+'$GIT'+config.url2+' '+config.branch)
           }
    }

}

