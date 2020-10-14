def call() {
  def sourceJob = currentBuild?.getBuildCauses()[0]?.event?.source?.buildInfo?.job?.toString()

  def allowListString = libraryResource 'allowed-jobs.txt'

  def allowList = allowListString.split('\n')

  return allowList.contains(sourceJob)
}