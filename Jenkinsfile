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

	environment {
        ENV = "dev"
        REGISTRY_URL = "artifactory.onelum.host"

    }

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
                        docker build -t http://artifactory.onelum.host/artifactory/docker-sample-local/mycontainer:0.1  .
                        '''
                    }
                }
            }

        stage('build') {
            steps {
                container('docker') {
                    build_container("mycontainer",'build')
                    }
                }
            }

        stage('push') {
            steps {
                container('docker') {
                    push_container("mycontainer","0.0.1")
                    }
                }
            }


// docker login artifactory.onelum.host

// S00085@luminorgroup.com
// S00085%40luminorgroup.com
// s00085%40luminorgroup.com

// nMUuvpi2N7KdDGrlldB3

// docker push artifactory.onelum.host/artifactory/docker-sample-local/mycontainer:0.1


    }
}




// 		stage('BUILD CONTAINER') {
//       when {
//         expression {
//           CODE_IS_BUILT == "YES"
//         }
//       }
// 			parallel {
// 				stage('web') {
// 					steps {
//             container('docker'){
//               build_container("${THIS_STACK}-web",'k8sbuild')
//               }
//      				}
// 				  }

// 				stage('jobs') {
// 					steps {
//             container('docker'){
//               build_container("${THIS_STACK}-jobs",'k8sbuild')
//               }
//     				}
// 		  		}

//   			}
// 	  	}

// 		stage('PUSH') {
//       when {
//         expression {
//           CODE_IS_BUILT == "YES"
//         }
//       }
// 			parallel {
// 				stage('web') {
// 					steps {
//               container('docker'){
//                 push_container("${THIS_STACK}-web","b-k8s${THIS_BUILD_NUMBER}-${LAST_COMMIT}")
//                 }
// 					  }
// 				  }

// 				stage('jobs') {
// 					steps {
//               container('docker'){
//                 push_container("${THIS_STACK}-jobs","b-k8s${THIS_BUILD_NUMBER}-${LAST_COMMIT}")
//                 }
//   					}
// 	  			}

//   			}
// 		  }



def build_container(name, ver) {
    withDockerRegistry([credentialsId: 'eae7cd76-43f6-4cc1-8c16-7a44fd489090', url: "https://${REGISTRY_URL}" ]) {
	def cImage = docker.build("${REGISTRY_URL}/artifactory/docker-sample-local/${name}", "-f Dockerfile .")
	cImage.push("${ver}")
    }
}

def push_container(name, ver) {
    withDockerRegistry([credentialsId: 'eae7cd76-43f6-4cc1-8c16-7a44fd489090', url: "https://${REGISTRY_URL}" ]) {
    def cImage = docker.image("${REGISTRY_URL}/artifactory/docker-sample-local/${name}:build")
    cImage.push("latest")
    cImage.push("${ver}")
    }
}
