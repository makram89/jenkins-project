pipeline{
    agent 
    {
        node 'slave01'
    }
    steges{
        stage("Pull image 1")
        {
            steps{
                script{
                    def image = docker.image("python:3.6.12-alpine")
                    image.pull()
                }

            }
        }

         stage("Pull image 2")
        {
            steps{
                script{
                    try{
                        def image = docker.image("python:3.6.1111-alpine")
                        image.pull()
                    }
                    catch(e)
                    {
                        echo "Caught: ${e}"
                        currentBuild.result = 'UNSTABLE' 
                    }
                }
            }
            
        }

    }

}