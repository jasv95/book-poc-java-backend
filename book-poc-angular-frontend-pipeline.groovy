pipeline {
    agent any 
    stages {
        stage('Clone sources') {
            git branch: 'master' 
                url: 'https://github.com/jasv95/book-poc-angular-frontend.git'
        }
        stage('Build') { 
            steps {
                sh "Docker -f Dockerfile -t 'book-poc-angular-frontend:'"
            }
        }
        stage('Test') { 
            steps {
                // 
            }
        }
        stage('Deploy') { 
            steps {
                // 
            }
        }
    }
}