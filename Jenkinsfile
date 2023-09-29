pipeline {
    agent any
    
    stages {
/**
        stage('Test1') {
            steps {
                sh 'mvn test -D suite=single.xml'
            }
        }
        stage('Test2') {
            steps {
                sh 'mvn test -D suite=mobile.xml'
            }
        }
*/
        stage('Email Notification'){
            steps {
                emailext (to: 'srinivas.k@ishafoundation.org', replyTo: 'srinivas.k@ishafoundation.org', subject: "Email Report from - '${env.JOB_NAME}' ", body: readFile("target/surefire-reports/emailable-report.html"), mimeType: 'text/html');         
            }

        }
     }
/**
post {
    always {
        mail bcc: '', body: """'Project: ${env.JOB_NAME} <br/> Build Number: ${env.BUILD_NUMBER} <br/> URL: ${env.BUILD_URL}'""", cc: '', from: '', replyTo: '', subject: "'${currentBuild.result}'", to: 'srinivas.k@ishafoundation.org'
    }
    
  }*/

}
