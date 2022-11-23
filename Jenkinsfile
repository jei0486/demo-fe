pipeline {
agent any
    environment {
        SOURCECODE_JENKINS_CREDENTIAL_ID = 'jei0486'
        SOURCE_CODE_URL = 'https://github.com/jei0486/demo-fe'
        RELEASE_BRANCH = 'main'
        REGISTRY = 'jei0486/demo-fe'
    }

    stages {
        stage('init') {
            steps {
                echo 'init'
                echo "Current workspace : ${workspace}"
            }
        }

        stage('clone') {
            steps {
                echo 'clone'
                git url: "$SOURCE_CODE_URL",
                branch: "$RELEASE_BRANCH",
                credentialsId: "$SOURCECODE_JENKINS_CREDENTIAL_ID"
                sh "ls -al"
            }
        }

        stage('build') {
            steps {
                sh 'pwd'
                sh '''
                chmod +x gradlew
                ./gradlew clean build
                '''
            }
        }

        stage('dockerizing'){
            steps{
                sh '''
                pwd
                docker image build -f Dockerfile -t $REGISTRY:${TAG} .
                '''
            }
        }

        stage('Deploy docker image') {
            steps {
                withDockerRegistry([ credentialsId: 'dockerhub', url: '' ]) { sh 'docker push $REGISTRY:${TAG}'}
            }
        }

        stage('workspace clear'){
            steps {
                cleanWs()
            }
        }

        stage('Clean docker image') {
            steps{
                sh "docker rmi $REGISTRY:${TAG}"
            }
        }


    }
}