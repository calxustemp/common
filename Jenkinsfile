pipeline {
    agent none
    stages {
        stage('Build') { 
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/var/maven/.m2 -ti --rm -u 1000 -e MAVEN_CONFIG=/var/maven/.m2 maven mvn -Duser.home=/var/maven'
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