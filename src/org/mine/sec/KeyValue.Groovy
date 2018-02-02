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
		def defaultconfigtxt = libraryResource 'values.json'
		def defaultconfig = readProperties text: defaultconfigtxt
		echo defaultconfig.name
	}	
  }

}
