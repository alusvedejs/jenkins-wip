pipeline {
 	agent {
        kubernetes {
          label 'sidm'
           defaultContainer 'jnlp'
          yamlFile 'nodes.yml'
          }
    }
  
  options { 
        ansiColor('xterm')
        parallelsAlwaysFailFast()
    }

	environment {
        ENV = "dev"

    }

	post {
		always {
			cleanWs()

		  }
	  }
	

    stages {

        stage ('Checkout') {
                steps {
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], 
                        doGenerateSubmoduleConfigurations: false, 
                        extensions: [], 
                        submoduleCfg: [], 
                        userRemoteConfigs: [
                            // [credentialsId: 'bitbucket', 
                            url: 'https://github.com/alusvedejs/jenkins-wip.git']
                            // ]
                        ])
                }
        }

        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}


