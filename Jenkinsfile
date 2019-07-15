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
                        docker build mycontainer  .
                        '''
                    }
                }
            }






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



// def build_container(name, ver) {
//     withDockerRegistry([credentialsId: 'eae7cd76-43f6-4cc1-8c16-7a44fd489090', url: "https://${REGISTRY_URL}" ]) {
// 	def cImage = docker.build("${env.REGISTRY_URL}/liflandgaming/sites/${env.THIS_STACK}/${name}", "-f infrastructure/${name}/Dockerfile .")
// 	cImage.push("${ver}")
//     }
// }

// def push_container(name, ver) {
//     withDockerRegistry([credentialsId: 'eae7cd76-43f6-4cc1-8c16-7a44fd489090', url: "https://${REGISTRY_URL}" ]) {
//     def cImage = docker.image("${env.REGISTRY_URL}/liflandgaming/sites/${env.THIS_STACK}/${name}:k8sbuild")
//     cImage.push("latest")
//     cImage.push("${ver}")
//     }
// }
