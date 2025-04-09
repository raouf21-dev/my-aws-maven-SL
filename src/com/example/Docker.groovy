#!/usr/bin.env groovy

package com.example

class Docker implements Serializable {
    def script

    Docker(script){
        this.script = script
    }

    def buildDockerImage(String imageName){
        script.echo "building the docker image..."
        script.sh "docker build  --platform linux/amd64 -t $imageName ."
    }
buildDockerImage
    def dockerLogin(){
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"
        }
    }
    
    def dockerPush(String imageName){
        script.echo "pushing docker image..."
        script.sh "docker push $imageName"

    }
}
