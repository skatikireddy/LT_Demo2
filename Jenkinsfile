pipeline{
	agent any
	parameters {
      choice choices: ['single.xml', 'mobile.xml', 'parllel.xml'], description: 'Please select the pattern of execustion!', name: 'PerformBuild'
    }
	stages {
  stage('Test') {
    steps {
    sh 'mvn test -D suite=${PerformBuild}
    }
  }

}
	
}