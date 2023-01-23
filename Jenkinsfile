pipeline {

    agent any
    stages {

        stage('Checkout Codebase'){
            steps{
                cleanWs()
                checkout scm: [$class: 'GitSCM', branches: [[name: '*/main']],userRemoteConfigs:
                [[url: 'https://github.com/bhagwatamols/ouafjunt.git']]]
            }
        }

        stage('Build'){
            steps{
                bat 'mkdir lib'
				dir("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\OUAF_TEST\\lib\\") {
				bat 'copy D:\\lib\\*'
				}
				dir("cd ..") {
				
				}        
  
				dir("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\OUAF_TEST\\src\\") {
				bat 'xcopy C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\OUAF_TEST\\bin /E /H /C /I /Y'
				 bat 'javac -cp ../lib/* com/splwg/CallTEstCases.java'
				 bat 'copy D:\\zlib\\*'
				}        

		    
				
       
               
            }
        }

        stage('Test'){
            steps{
			
				dir("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\OUAF_TEST\\src\\") {
				
				bat 'java -cp ".";D:/lib/* com.splwg.CallTEstCases --select-class com.splwg.AllTests --reports-dir="reports"'
				  
				} 
				
		     dir("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\OUAF_TEST\\src\\reports") {
			    junit 'TEST-junit-jupiter.xml'
		    }
		 
               
            }
        }

        stage('Deploy'){
            steps{
                bat 'chdir src/'
              
            }
        }
    }

}
