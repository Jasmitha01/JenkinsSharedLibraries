def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node{
           stage('checkout') {
               git url: 'https://github.com/JasmithaMeka/JenkinsSharedLibraries.git'
           }
    }

}

