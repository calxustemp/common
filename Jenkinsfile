pipeline {
    agent none
    stages {
        stage('Build') { 
            agent {
                docker {
                    image 'maven:3-alpine'
                }
            }
            environment {
                GH_TOKEN = credentials('GH_TOKEN')
            }
            steps {
                sh 'mvn clean install'
                sh 'mvn deploy -Dregistry=https://maven.pkg.github.com/calxus -Dtoken=$GH_TOKEN'
            }
        }
    }
}