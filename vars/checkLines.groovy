@NonCPS
def call(String inputString, String pattern) {
  inputString.eachLine {
    if (it == pattern) {
      echo "${pattern} in list of allowed jobs."
      return true
    } else {
      echo "${pattern} NOT in list of allowed jobs."
      return false
    }
  }
}
