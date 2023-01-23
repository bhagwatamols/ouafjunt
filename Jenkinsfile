pipeline {

    agent any
    stages {

        stage('Checkout Codebase'){
            steps{
                cleanWs()
                checkout scm: [$class: 'GitSCM', branches: [[name: '*/main']],userRemoteConfigs:
                [[url: 'https://github.com/bhagwatamols/junitrepo.git']]]
            }
        }

        stage('Build'){
            steps{
                bat 'mkdir lib'
				dir("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\JUNIT_TEST\\lib\\") {
				bat 'copy D:\\zlib\\*'
				}
				dir("cd ..") {
				
				}        
  
				dir("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\JUNIT_TEST\\src\\") {
				 bat 'javac -cp ../lib/* CarTest.java Car.java App.java'
				 bat 'copy D:\\zlib\\*'
				}        

		    
				
       
               
            }
        }

        stage('Test'){
            steps{
			
				dir("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\JUNIT_TEST\\src\\") {
				
				bat 'java -jar junit-platform-console-standalone-1.7.0.jar  -cp "."; --select-class CarTest --reports-dir="reports"'
				
				
				} 
				
		    dir("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\JUNIT_TEST\\src\\reports") {
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
