pipeline {
    agent any
    
    parameters {
        choice( choices: ['demo', 'prod'], description: '', name: 'env')
    }

    stages{
        stage('Stage A'){
            steps{
                echo 'Pip boop'
                exit()
            }
        }
     
    }

    post{
        failure {
            
                    build job: 'pipeline-B-MK', parameters: [string(name: 'env', value: params.env)]
            
                }
            
        }
    }   
}

