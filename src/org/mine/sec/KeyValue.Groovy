package org.mine.first
import org.mine.*

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
		def defaultconfigtxt = libraryResource+this.config.resource
		def defaultconfig = readProperties text: defaultconfigtxt
		return defaultconfig.name1
	}	
  }

}
