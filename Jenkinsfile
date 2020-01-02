pipeline {
    agent none
    stages {
        stage('Build') { 
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/var/maven/.m2 -e MAVEN_CONFIG=/var/maven/.m2'
                }
            }
            steps {
                sh 'cat /var/maven/.m2/settings.xml'
                sh 'mvn clean install -Duser.home=/var/maven'
                sh 'mvn deploy -Dmaven.wagon.http.pool=false -Duser.home=/var/maven'
            }
        }
    }
}