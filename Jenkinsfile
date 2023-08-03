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
                sh "docker build -t accounts:${BUILD_NUMBER} ."
            }
        }
//         stage("Start Container"){
//             steps{
//                 CONTAINER_ID = sh "docker ps -q -f name=accounts"
//                 if(CONTAINER_ID){
//                     docker rm CONTAINER_ID
//                 }
//                 sh "docker run -d -p 8120:8080 accounts:${BUILD_NUMBER}"
//
//                 response = $(sh "docker run -d -p 8120:8080 accounts:${BUILD_NUMBER}")
//                 if(!${response}){
//                     echo "No violation"
//                 }else{
//                     echo "Violation"
//                 }
//             }
//         }
    }
}