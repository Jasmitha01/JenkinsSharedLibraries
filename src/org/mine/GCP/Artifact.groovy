package org.mine.GCP

@Grab('io.github.http-builder-ng:http-builder-ng-core:1.0.3')

import groovyx.net.http.OkHttpBuilder
import groovyx.net.http.*
import static groovyx.net.http.MultipartContent.multipart


class Artifact implements Serializable {
  
  def config
  def script

  Artifact(script,config) {
    this.config = config
    this.script = script
  }

def upload() {
    this.script.stage('Upload Artifcat') {
        if(this.config.storage=='Bucket')
        {
            def req = OkHttpBuilder.configure {
                  request.uri = 'https://www.googleapis.com'
                  request.headers['Authorization'] = 'Bearer ya29.Glt3BScZb6AsWKOXDoXqoAegey4M-8_OFZP7ddMWyxNg-IIDlCIeWZBLUHnWvc--Rl3wL-xQNOXwmhSqobJ5bcX1P9GKEkH69fD6_OFKJoiiaR7dkABXlayMJP6m'
                  request.headers['Content-Typer'] = 'application/java-archive'
              }.post {
                  request.uri.path = '/upload/storage/v1/b/jas-1893/o'
                  request.uri.query = [uploadType: 'media',name:'final.war']
                  request.contentType = 'multipart/form-data'
                  request.body = multipart {

                      field 'name', 'This is my file'
                      part 'file', '/tmp/workspace/gcp/target/spring-boot-rest-example-0.5.0.war', 'application/java-archive'
                  }
                  request.encoder 'multipart/form-data', OkHttpEncoders.&multipart
              }
         }
    }
}
