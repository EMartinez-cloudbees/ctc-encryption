def call(String publicKeyCredentialId "publicKey", String secretString) {

  withCredentials([file(credentialsId: "${publicKeyCredentialId}", variable: "publicKey")]) {
    def encryptedText = sh(script: "echo ${secretString} | openssl rsautl -inkey ${publicKey} -pubin -encrypt | base64 -w 0",
                           returnStdout: true).trim()
    publishEvent event: jsonEvent("{'jobType':'encrypted', 'encryptedText': '${encryptedText}'}"), verbose: true
  }
}