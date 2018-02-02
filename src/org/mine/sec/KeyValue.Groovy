package org.mine.sec
import org.mine.*

class KeyValue {
  def config
  def script

  KeyValue(script,config) {
    this.config = config
    this.script = script
  }

  
  void returnKey()
  {
	this.script.stage('keyValue'){
		def defaultconfigtxt = libraryResource+this.config.resource
		def defaultconfig = readProperties text: defaultconfigtxt
		return defaultconfig.name1
	}	
  }

}
