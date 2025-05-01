pipeline{
    agent any
    environment {
        SONARQUBE_SERVER = 'SonarQubeServer'
    }
    stages{
        stage('Checkout'){
            steps{
                git 'https://github.com/manojbalineni/spring-boot-sonarqube-demo'
            }
        }

        stage('Build'){
            steps{
                bat 'mvn clean install'
            }

        }

        stage('SonarQube Analysis'){
        steps{
            withSonarQubeEnv("${SONARQUBE_SERVER}"){
                bat 'mvn sonar:sonar'
            }
        }
        }
    }
}