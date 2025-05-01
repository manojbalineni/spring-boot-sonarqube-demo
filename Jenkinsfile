pipeline {
    agent any

    environment {
        SONARQUBE_SERVER = 'SonarQubeServer'  // Name as configured in Jenkins
    }

    tools {
        maven 'Maven'
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from GitHub
                git 'https://github.com/manojbalineni/spring-boot-sonarqube-demo.git'  // Replace with your repo URL
            }
        }

        stage('Build') {
            steps {
                // Compile and package the project with Maven
                script {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${SONARQUBE_SERVER}") {
                    // Run SonarQube analysis
                    bat 'mvn sonar:sonar'
                }
            }
        }

        stage('Test') {
            steps {
                // Run unit tests and generate test reports
                script {
                    bat 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                // Optional: Deploy the application (can be Docker build/push, etc.)
                echo 'Deploying to the environment'
            }
        }

        stage('Archive Artifacts') {
            steps {
                // Archive Maven build artifacts for future use
                archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            }
        }

        stage('Clean') {
            steps {
                // Clean up after build
                cleanWs()
            }
        }
    }

    post {
        always {
            // This will always run, regardless of build result
            echo 'Pipeline completed.'
        }
        success {
            // Actions on successful pipeline execution
            echo 'Build and analysis successful!'
        }
        failure {
            // Actions on failed pipeline execution
            echo 'Build failed. Check the logs.'
        }
    }
}
