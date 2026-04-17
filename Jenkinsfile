pipeline {
    agent any

    environment {
        // UPDATE THIS PATH: Point it to the 'bin' folder of your local Maven installation
        MAVEN_HOME = "C:\\apache-maven-3.9.6\\bin" 
        // This ensures 'mvn' is available for the 'bat' commands below
        PATH = "${MAVEN_HOME};${env.PATH}"
    }

    stages {
        stage('Debug & Environment') {
            steps {
                echo "Checking Java and Maven versions..."
                bat "java -version"
                bat "mvn -version"
                echo "Listing workspace files:"
                bat "dir /s /b" // Lists all files in subfolders to verify src structure
            }
        }

        stage('Clean & Compile') {
            steps {
                echo "Compiling the Prime Number application..."
                bat "mvn clean compile"
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo "Executing JUnit Tests in src/test/java..."
                // This will run the logic in AppTest.java
                bat "mvn test"
            }
        }

        stage('Package JAR') {
            steps {
                echo "Packaging application into a JAR file..."
                bat "mvn package -DskipTests" 
            }
        }

        stage('Run Native Application') {
            steps {
                echo "Running the final program directly on Windows..."
                // Path matches: target/artifactId-version.jar
                bat "java -jar target/Primenumber-1.0-SNAPSHOT.jar"
            }
        }
    }

    post {
        success {
            echo "Successfully built, tested, and executed the Prime Number app!"
        }
        failure {
            echo "Build Failed. Check if Maven path is correct or if a Unit Test failed."
        }
    }
}