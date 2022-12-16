pipeline {
    agent any
    stages{
        stage('test'){
            steps{
                echo 'Its alive'
            }
        }
    }

}

