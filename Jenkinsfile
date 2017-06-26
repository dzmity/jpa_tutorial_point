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
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
    post {
            always {
                junit '**/target/*.xml'
            }
            failure {
                mail (to: 'work.d.rafalovich@gmail.com', subject: 'The Pipeline failed :(' ,
                body: "Please go to ${env.BUILD_URL}.")
            }
    }

}