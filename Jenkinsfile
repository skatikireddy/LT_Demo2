pipeline {
    agent any
    
    parameters {
        choice(name: 'ENVIRONMENT', choices: ['single.xml', 'mobile.xml', 'parllel.xml'], description: 'Select the environment for deployment')
    }
    
    stages {
        stage('Test') {
            steps {
                sh 'mvn test -D suite=${params.ENVIRONMENT}'
            }
        }
        stage('Deploy') {
            steps {
                // Your deployment steps here, using the ${params.ENVIRONMENT} variable
            }
        }
    }
}
