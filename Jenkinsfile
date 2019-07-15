pipeline {
 	agent {
        kubernetes {
          label 'sidm'
           defaultContainer 'jnlp'
          yamlFile 'nodes.yml'
          }
    }
  
//   options { 
//         ansiColor('xterm')
//         parallelsAlwaysFailFast()
//     }

// 	environment {
//         ENV = "dev"

//     }

// 	post {
// 		always {
// 			cleanWs()

// 		  }
// 	  }
	

    stages {

        // stage ('Checkout') {
        //         steps {
        //             checkout([$class: 'GitSCM', branches: [[name: '*/master']], 
        //                 doGenerateSubmoduleConfigurations: false, 
        //                 extensions: [], 
        //                 submoduleCfg: [], 
        //                 userRemoteConfigs: [
        //                     // [credentialsId: 'bitbucket', 
        //                     url: 'https://github.com/alusvedejs/jenkins-wip.git']
        //                     // ]
        //                 ])
        //         }
        // }

        stage('Build') {
            steps {
                container('maven') {
                    sh '''
                        ls -latr
                        mvn --version
                        '''
                    }
                }
            }

                        // mvn package spring-boot:repackage -f pom.xml

        stage('docker') {
            steps {
                container('docker') {
                    sh '''
                        ls -latr
                        docker ps
                        '''
                    }
                }
            }

    }
}


