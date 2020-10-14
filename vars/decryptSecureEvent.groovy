def call() {
  def sourceJob = currentBuild?.getBuildCauses()[0]?.event?.source?.buildInfo?.job?.toString().replaceAll('/','-')
  def encryptedText = currentBuild?.getBuildCauses()[0]?.event?.encryptedText?.toString()

  withCredentials([file(credentialsId: "${sourceJob}", variable: "privateKey")]) {
    sh "echo ${encryptedText} | base64 -d | openssl rsautl -inkey ${privateKey} -decrypt"
  }  
}