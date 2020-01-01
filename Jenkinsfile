pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
        jdk 'JDK 9.0.4'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn --version' 
            }
        }
    }
}