pipeline{
	agent any
	stages {
  stage('Test') {
    steps {
    sh 'mvn test -D suite=single.xml'
    }
  }

}
	
}