pipeline {
	  agent any
    tools{
	    maven "M2_HOME"
	    
		
    }
	environment {
	        PATH = "$PATH:/usr/share/maven/bin"
	    }

    stages {
	     stage('Git clone ') {
            steps {
                git branch: 'main',
                credentialsId: 'Jenkins-GitHub',
                url: 'https://github.com/ImenMessaoudi/ClubProjectRepo.git'
               
            }
        }
	    
	    stage('Testing maven') {
		      steps {
		       sh """mvn -version"""
		      }
		    }
	    stage('Testing java') {
		      steps {
		       sh """java -version"""
		      }
		    }
	   stage('hello') {
		      steps {
		       echo "Hello Word"
		      }
		    }
	         
	    stage('Mvn Clean ') {
                        steps {
                           sh """mvn clean"""
                        }
                    }
	    stage('MVN compile') {
		      steps {
		       sh """mvn compile"""
		      }
		    }
	    
	    
	      stage('SonarQube analysis ') {
                        steps {
                           
                           sh """mvn sonar:sonar"""
                        }
                    
	      }  
	    
	    
           

	    
	  
    
      
      
	  }
	
