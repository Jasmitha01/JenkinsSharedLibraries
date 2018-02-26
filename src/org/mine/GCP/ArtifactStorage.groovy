class ArtifactStorage implements Serializable {
  
  def config
  def script

  ArtifactStorage(script,config) {
    this.config = config
    this.script = script
  }


 
def upload() {
    this.script.stage('Upload Artifcat') {
	if(this.config.storage=='Bucket')
	{
		this.script.echo "1"
		/* if(true){
			//curl -X POST --data-binary @image.png     -H "Authorization: Bearer ya29.GltoBUSTPauiAI2vzTAB5c2KaWKSKX460xES6y0FDStC8ETAEDYdb15l3Um3laRY1WqPrbWVD1nV-ZbEh9-hAOMhybcEIX-R0LRXI0w_kL7A72DWk2EmlQlGP55a"     -H "Content-Type: image/png"     "https://www.googleapis.com/upload/storage/v1/b/jas-1893/o?uploadType=media&name=output.png"

//def str=this.script.sh(script: 'curl -X POST --data-binary @/tmp/workspace/new/target/spring-boot-rest-example-0.5.0.war     -H "Authorization: Bearer ya29.GlxqBYhJRtEjqRjq8KRfHm5uKFSWB6YfDfeTjB4xDYk6s6BPgjiXlH76B4A2gYTgv16VSUQlOpFHNaIHMpRCbTcftHuvzoAGRYHtKQvu-ELY6QTVQ907iwJzoZxZnA"     -H "Content-Type: application/java-archive"     "https://www.googleapis.com/upload/storage/v1/b/jas-1893/o?uploadType=media&name=a.war"' , returnStdout: true)

			this.script.echo "2"
			def url = "https://www.googleapis.com"
			//def client = new RESTClient(url)
			def client = new HTTPBuilder(url)
			this.script.echo "3"
			this.script.echo "${this.script.env.WORKSPACE}"
			def file1 = new File("/tmp/workspace/new/target/spring-boot-rest-example-0.5.0.war")
        		def response = client.post(path: "/upload/storage/v1/b/"+this.config.bucket+"/o",
   		     		query: [uploadType: 'media', name: 'a.war'],
				body: [file: new File("@/tmp/workspace/new/target/spring-boot-rest-example-0.5.0.war")],
       				headers: [Authorization: 'Bearer '+ this.config.accesstoken, "Content-Type" : "application/java-archive"]
        			)
			this.script.echo "4"
			this.script.echo response.status 
			return reponse.data
			//return str
		} */

	 def baseUrl="https://www.googleapis.com"
   def imageType = 'application/java-archive'
   def imgFile = new File("/root/jenkins.war")
       // assert imgFile.exists()
	//def files = this.script.findFiles(glob: 'target/*.war')
	//this.script.echo "${files[0].name}+${files[0].path} "
       //this.script.sh('sleep 60s')
        def query = [uploadType: 'media', name: 'a.war']
        def cbFile = new FileBody(imgFile, imageType)
 
        def http = new HTTPBuilder(baseUrl)
         
         
        resp = http.request(POST) { req ->
            uri.path = 'upload/storage/v1/b/jas-1893/o'
            uri.query = query

            def mpEntity = new MultipartEntity()
            mpEntity.addPart("war", cbFile)
             
            req.entity = mpEntity
	
	} 
}
