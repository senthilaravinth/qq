pipeline {
    agent any

    stages {
        stage('Clean & Compile') {
            steps {
                bat "mvn clean compile"
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo "Executing JUnit Tests..."
                // This command specifically runs the tests in src/test/java
                bat "mvn test"
            }
        }

        stage('Package JAR') {
            steps {
                // If tests pass, this creates the JAR
                bat "mvn package -DskipTests=false"
            }
        }

        stage('Run Application') {
            steps {
                echo "Running the final application..."
                bat "java -jar target/Primenumber-1.0-SNAPSHOT.jar"
            }
        }
    }

    post {
        failure {
            echo "The build failed! This likely means a Unit Test failed."
        }
    }
}