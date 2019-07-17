job('Seed All') {
  scm {
    git {
      remote {
        url('https://github.com/alusvedejs/jenkins-wip.git')
      }
      branch('master')
    }
  }
  steps {
    dsl {
      external('jobs/*.groovy')  
      // default behavior
      // removeAction('IGNORE')      
      removeAction('DELETE')
    }
  }
}



// git('https://github.com/demo/demo.git','development',{node -> node / 'extensions' << '' })



// pipelineJob('DSL_Pipeline') {

//   def repo = 'https://github.com/path/to/your/repo.git'

//   triggers {
//     scm('H/5 * * * *')
//   }
//   description("Pipeline for $repo")

//   definition {
//     cpsScm {
//       scm {
//         git {
//           remote { url(repo) }
//           branches('master', '**/feature*')
//           scriptPath('misc/Jenkinsfile.v2')
//           extensions { }
//         }

//       }
//     }
//   }
// }


// job('example') {
//   scm {
//     git {
//       remote {
//         url('https://github.com/jenkinsci/job-dsl-plugin.git')
//       }
//       branch('master')
//     }
//   }
// }


// scm {
//   git(buildRepoName, branchName) {
//     createTag(false)
//   }
// }