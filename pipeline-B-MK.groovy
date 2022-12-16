pipeline {
    agent any
    
    parameters {
        string(name: "env")
    }

    stages{
        stage('Stage A'){
          
            steps{
                echo "Passed string: $params.env"
            }
        }

     
    }

}

