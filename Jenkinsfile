pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                bat 'mvn clean install'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                echo 'Building finished'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                junit '**/target/*.xml'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}