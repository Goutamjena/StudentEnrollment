pipeline {
    agent any

   tools{
       maven 'MAVEN_HOME'
   }
    environment {
        DOCKER_CRED = credentials('DockerCred')
    }
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'GoutamGITCRED', url: 'https://github.com/Goutamjena/StudentEnrollment.git']]])
            }
            
        }
        
        stage('Package Build'){
            
            steps{
                echo '####################Package Buuild started###################'
                bat 'mvn package'
                
                echo '##################package Build completed############################'
            }
            
        }
       
        stage('Building docker Images'){
            steps{
                 echo '##########Image Building Started #######################'
                 bat 'echo %CD%'
                 bat 'docker build -t goutam14339919/student_enrollment:6.0 .'
                 echo '########## Docker Image Build completed #############'
            }
        }
        stage('Push Image to docker hub'){
            steps{
                script {
                    withCredentials([string(credentialsId: 'DockerCred', variable: 'DOCKER_CRED')]) {
                        bat "docker login -u goutam14339919 -p ${DOCKER_CRED}"
                        echo 'Docker login succeeded'
                        bat 'docker push goutam14339919/student_enrollment:6.0'
                    }
                }
            }
        }
    }
    
}
