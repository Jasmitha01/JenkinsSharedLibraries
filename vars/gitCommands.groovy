def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    def git_creds = '1fda4faa-9816-4425-9260-c012a97b1d66'

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
          
        withCredentials([
      [$class: 'UsernamePasswordMultiBinding', credentialsId: git_creds, usernameVariable: 'GIT_USER', passwordVariable: 'GIT_PASS'],
        ]){
              stage('Push'){
                  sh('git push '+config.url1+'${GIT_USER}'+':'+'${GIT_PASS}'+'@'+config.url2+' '+config.branch)
               }
          }
    }

}

