package org.mine.sec

class KeyValue {
  def config
  def script

  KeyValue(script,config) {
    this.config = config
    this.script = script
  }

  
  void returnKey(){
	this.script.stage('KeyValue'){
		def defaultconfigtxt = libraryResource+this.config.resource
		def defaultconfig = readProperties text: defaultconfigtxt
		return defaultconfig.name1
   }	
  }
}
