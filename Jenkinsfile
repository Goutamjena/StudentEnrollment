pipeline {
    agent any


    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'GoutamGITCRED', url: 'https://github.com/Goutamjena/StudentEnrollment.git']]])
             
            }
            
        }
        
        stage('Packae Build'){
            steps{
                echo "#######################Buildin Package##############################"
                sh 'mvn clean install'
                
                echo "#######################Packae Building Completed sucessfully###################"
            }
        }
        stage('Test Package'){
            steps{
                sh 'echo "Testing"'
            }
        }
        
    }
    
}
