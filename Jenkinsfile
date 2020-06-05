pipeline {
    agent any
    stages {
    	stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']],
    				userRemoteConfigs: [[url: 'https://github.com/kimgova/BPStoreAndForward.git']]])
				echo "Checkout ready."
            }
        }
        stage ('Artifactory configuration') {
            // Obtain an Artifactory server instance, defined in Jenkins --> Manage:
            server = Artifactory.server 'ArtifactoryProd'
            env.JAVA_HOME = "${tool 'IBM_java-x86_64-80'}"
            echo "${tool 'IBM_java-x86_64-80'}"
            rtMaven = Artifactory.newMavenBuild()
            rtMaven.tool = 'Maven_Local' // Tool name from Jenkins configuration
            rtMaven.deployer releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local', server: server
            rtMaven.resolver releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot', server: server
            rtMaven.deployer.deployArtifacts = false // Disable artifacts deployment during Maven run
            rtMaven.opts = '-Xmx3096m'
            buildInfo = Artifactory.newBuildInfo()
            echo "Artifactory ready."
        }
        stage('Build') {
            steps {
                echo "Build ready."
            }
        }
        stage('Compile') {
            rtMaven.run pom: '', goals: 'org.apache.maven.plugins:maven-dependency-plugin:3.0.0:purge-local-repository -DmanualInclude=com.baccredomatic:messaging:0.0.1-SNAPSHOT,com.baccredomatic:restbaclibrary:1.0-SNAPSHOT -Dmaven.repo.local=.mavenrepo'
            rtMaven.run pom: 'BPStoreAndForward/pom.xml', goals: 'clean install -Dmaven.test.skip=true -DargLine=-Xmx2048m'
            echo "Compile ready."
        }

    }
}