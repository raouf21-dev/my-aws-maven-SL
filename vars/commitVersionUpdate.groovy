#!/usr/bin.env groovy

def call(){
    withCredentials([usernamePassword(credentialsId: 'git-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "git remote set-url origin https://$USER:$PASS@github.com/raouf21-dev/maven-app.git"
        sh "git add ."
        sh 'git commit -m "ci: version bump"'
        sh "git push origin HEAD:jenkins-jobs" 
    }
} 