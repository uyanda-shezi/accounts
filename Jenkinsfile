pipeline{
    agent any
    stages {
        stage("Clean"){
            steps{
                deleteDir()
            }
        }
        stage("Checkout"){
            steps{
                sh "git clone https://github.com/uyanda-shezi/accounts.git"
                dir("accounts"){
                    sh "git checkout develop"
                }
            }
        }
        stage("Build"){
            steps{
                dir("accounts"){
                    sh "mvn clean install -Denforcer.skip=true"
                }
            }
        }
        stage("Test"){
            steps{
                dir("accounts"){
                    sh "mvn test -Denforcer.skip=true"
                }
            }
        }
        stage("Build Image"){
            steps{
                sh 'docker build -t accounts .'
            }
        }
        stage("Run Image"){
            steps{
                sh 'docker-compose up'
            }
        }
    }
}