package org.mine.first

class Hello implements Serializable {
  def config
  def script

  Hello(script,config) {
    this.config = config
    this.script = script
  }

  
  void wish()
  {
	this.script.stage('wish'){
		println "Hello" + this.config.name
	}	
  }

}
