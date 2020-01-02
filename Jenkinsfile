pipeline {
    agent none
    stages {
        stage('Build') { 
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2:z'
                }
            }
            steps {
                sh 'cat /root/.m2/settings.xml'
                sh 'mvn clean install'
                sh 'mvn deploy -Dmaven.wagon.http.pool=false'
            }
        }
    }
}