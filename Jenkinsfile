pipeline {
    /** Declarative pipleine **/
    agent any
    parameters {
        string(name: 'tomcat_dev', defaultValue: '18.188.215.198', description: 'Staging server')
        string(name: 'tomcat_prod', defaultValue: '3.19.28.143', description: 'Production server')
    }

    triggers {
        pollSCM('* * * * *')
    }

    stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }

        stage ('Deployments'){
            parallel{
                stage ('Deploy to Staging'){
                    steps {
                        sh "scp -i /home/vagrant/tomcat-demo.pem /var/www/public/jenkins_plugin/maven-project/webapp/target/webapp.war ec2-user@${params.tomcat_dev}:/var/lib/tomcat/webapps"
                    }
                }

                stage ("Deploy to Production"){
                    steps {
                        sh "scp -i /home/vagrant/tomcat-demo.pem /var/www/public/jenkins_plugin/maven-project/webapp/target/webapp.war ec2-user@${params.tomcat_prod}:/var/lib/tomcat/webapps"
                    }
                }
            }
        }
    }
}