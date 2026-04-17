pipeline {
    agent any

    tools {
        // Must match the name in Manage Jenkins -> Tools
        maven 'Maven'
    }

    stages {
        stage('Initialize') {
            steps {
                bat "mvn -version"
            }
        }

        stage('Build & Test') {
            steps {
                // This will compile your App.java and run AppTest.java
                bat "mvn clean test"
            }
        }

        stage('Package') {
            steps {
                // This creates the .jar file in the target folder
                bat "mvn package -DskipTests"
            }
        }

        stage('Run Application') {
            steps {
                echo "Executing the Prime Number program..."
                // Ensure this filename matches your pom.xml artifactId and version
                bat "java -jar target/Primenumber-1.0-SNAPSHOT.jar"
            }
        }
    }

    post {
        failure {
            echo "Build failed. Verify your Maven3 tool path in Jenkins settings."
        }
    }
}