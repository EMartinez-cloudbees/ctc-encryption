def call() {
  def allowList = libraryResource 'allowed-jobs.txt'

  def sourceJob = currentBuild?.getBuildCauses()[0]?.event?.source?.buildInfo?.job?.toString()

  return allowList.contains(sourceJob)
}