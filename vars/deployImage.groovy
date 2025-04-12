#!/usr/bin.env groovy

def call(){
    def shellCmd = "bash ./server-cmds.sh ${IMAGE_NAME}"
    def ec2Instance = "ec2-user@13.39.146.56"
    def pwd = "/home/ec2-user"
    sshagent(['ec2-server-key']) {
        sh "scp server-cmds.sh ${ec2Instance}:${pwd}"
        sh "scp docker-compose.yaml ${ec2Instance}:${pwd}"
        sh "ssh -o StrictHostKeyChecking=no ${ec2Instance} ${shellCmd}"                        
    }
}