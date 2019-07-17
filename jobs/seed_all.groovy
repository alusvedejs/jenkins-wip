job('Seed All') {
  scm {
    git ('https://github.com/alusvedejs/jenkins-wip.git')
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
