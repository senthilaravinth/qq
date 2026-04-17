pipeline {
    agent any

    tools {
        // This name must match the name you defined in Manage Jenkins -> Tools
        maven 'Maven'
    }

    stages {
        stage('Environment Check') {
            steps {
                echo "Checking Java and Maven versions on the host machine..."
                bat "java -version"
                bat "mvn -version"
            }
        }

        stage('Clean & Compile') {
            steps {
                echo "Cleaning previous builds and compiling source code..."
                bat "mvn clean compile"
            }
        }

        stage('Unit Testing') {
            steps {
                echo "Running JUnit tests..."
                // This executes classes in src/test/java
                bat "mvn test"
            }
        }

        stage('Package') {
            steps {
                echo "Creating the JAR file..."
                // We skip tests here because they were verified in the previous stage
                bat "mvn package -DskipTests"
            }
        }

        stage('Execute Native') {
            steps {
                echo "Running the application natively (No Docker/K8s)..."
                // Ensure the filename matches your pom.xml artifactId and version
                bat "java -jar target/Primenumber-1.0-SNAPSHOT.jar"
            }
        }
    }

    post {
        success {
            echo "Pipeline finished successfully!"
        }
        failure {
            echo "Pipeline failed. Check the 'Unit Testing' stage or Maven paths."
        }
    }
}