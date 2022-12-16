pipeline {
    agent any
    
    parameters {
        choice( choices: ['demo', 'prod'], description: '', name: 'env')
    }

    stages{
        stage('Stage 1'){
            when{
                return params.env == "demo"

            }
            steps{
                echo "Deployment 1 on $params.env"
            }
        }

        stage('Stage 2'){
            steps{
                script{
                     if ( params.environment == "demo")
                     {
                         echo "Deployment 2 on $params.env"
                     } 
                }
               
            }
        }
        
    }

}

