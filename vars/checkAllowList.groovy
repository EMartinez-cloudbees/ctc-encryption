def call() {
  def allowList = libraryResource 'allowed-jobs.txt'

  def sourceJob = currentBuild?.getBuildCauses()[0]?.event?.source?.buildInfo?.job?.toString()

  @NonCPS
  def checkLines() {
    allowList.eachLine {
      if (it == "${sourceJob}") {
        echo "${sourceJob} in list of allowed jobs."
        return true
      } else {
        echo "${sourceJob} NOT in list of allowed jobs."
        return false
      }
    }
  }

  return checkLines()
}