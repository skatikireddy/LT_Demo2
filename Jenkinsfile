pipeline{
	agent any
	stages {
  stage('Test') {
    steps {
    sh 'mvn test -D suite=single.xml'
      // One or more steps need to be included within the steps block.
    }
  }

}
	
}