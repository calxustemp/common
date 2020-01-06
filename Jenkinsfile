pipeline {
    agent none
    environment {
        APPLICATION = 'common'
    }
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Version') {
            agent any
            steps {
                sh 'git tag 0.${BUILD_ID}.0'
                sh 'git remote set-url origin git@github.com:calxus/${APPLICATION}.git'
                sh 'git push origin --tags'
            }
        }
        stage('Test') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/var/maven/.m2 -e MAVEN_CONFIG=/var/maven/.m2'
                }
            }
            steps {
                sh 'mvn test'
            }
        }
        stage('Maven Build') { 
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/var/maven/.m2 -e MAVEN_CONFIG=/var/maven/.m2'
                }
            }
            steps {
                sh 'mvn versions:set -DnewVersion=0.${BUILD_ID}.0'
                sh 'mvn clean install -Duser.home=/var/maven'
            }
        }
    }
}