pipeline {
    agent any

    tools {
        // Must match the name in Manage Jenkins -> Tools
        maven 'Maven3'
    }

    stages {
        stage('Build & Test') {
            steps {
                echo "Compiling and running Unit Tests..."
                bat "mvn clean test"
            }
        }

        stage('Package') {
            steps {
                echo "Creating Executable JAR..."
                bat "mvn package -DskipTests"
                // List files so you can see the JAR name in your Jenkins logs
                bat "dir target"
            }
        }

        stage('Execute') {
            steps {
                echo "Running the Prime Number Application..."
                /* This command finds the JAR in the target folder automatically 
                   and runs it. This fixes the 'Unable to access jarfile' error.
                */
                bat "for /R target %%i in (*.jar) do java -jar %%i"
            }
        }
    }

    post {
        success {
            echo "Pipeline Successful!"
        }
        failure {
            echo "Pipeline Failed. Please verify the Maven3 tool path in Jenkins."
        }
    }
}