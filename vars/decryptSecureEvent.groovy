def call(String privateKeyCredentialsId = "privateKey") {
  def encryptedText = currentBuild?.getBuildCauses()[0]?.event?.encryptedText?.toString()

  withCredentials([file(credentialsId: privateKeyCredentialsId, variable: "privateKey")]) {
    sh "echo ${encryptedText} | base64 -d | openssl rsautl -inkey ${privateKey} -decrypt"
  }  
}