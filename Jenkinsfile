pipeline {

    agent {
        label 'slave3'
    }
    tools {
        maven 'Maven'
    }

    stages {
        stage('Build Maven') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/tejaswini-vekaria/jenkin1']]])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    sh 'docker login -u=tejaswinivekaria -p=Dm@9909929391'
                    sh 'docker build -t tejaswinivekaria/tejaswini-jenkin-assignment -f Dockerfile .'
                }
            }
        }
        stage('push image to Hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'tejaswinivekaria', variable: 'dockerhub_pwd')]) {
                         sh 'docker login -u=tejaswinivekaria -p=${dockerhub_pwd}'
                    }
                sh 'docker push tejaswinivekaria/tejaswini-jenkin-assignment'
                }
            }
        }
        stage('Deploy to Kubernetes'){
            steps{
                script{
//                     kubernetesDeploy configs: 'deploymentservice.yaml', kubeConfig: [path: ''], kubeconfigId: 'kubernetesid', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
                       kubernetesDeploy (configs: 'deploymentservice.yaml', kubeconfigId: 'kubernetesid')

                }
            }
        }
    }
}