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
				bat 'copyC:\\ProgramData\\Jenkins\\.jenkins\\workspace\\OUAF_TEST\\bin\\*'
				 bat 'javac -cp ../lib/* com/splwg/AllTests.java'
				 bat 'copy D:\\zlib\\*'
				}        

		    
				
       
               
            }
        }

        stage('Test'){
            steps{
			
				dir("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\OUAF_TEST\\src\\") {
				
				bat 'java -jar junit-platform-console-standalone-1.7.0.jar  -cp "."; --select-class AllTests --reports-dir="reports"'
				bat 'java -cp ".";D:/lib/* junit.textui.TestRunner com.splwg.AllTests'
				
				
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
