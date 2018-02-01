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
		print "Hello"
	}	
  }

}
