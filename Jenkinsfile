pipeline {
    agent any
    
    stages {
        stage('Test1') {
            steps {
                sh "mvn test -D suite=single.xml
            }
        }
        stage('Test2') {
            steps {
                sh "mvn test -D suite=mobile.xml
            }
        }
    }
}
