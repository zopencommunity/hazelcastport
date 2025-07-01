node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/hazelcastport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/hazelcastport.git'), string(name: 'PORT_DESCRIPTION', value: 'Hazelcast is a unified real-time data platform combining stream processing with a fast data store, allowing customers to act instantly on data-in-motion for real-time insights.' ), string(name: 'BUILD_LINE', value: 'DEV') ]
  }
}
