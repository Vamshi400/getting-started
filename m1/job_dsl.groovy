
def pipelines = [
    [name: 'm1/job1', scriptPath: 'm1/Jenkinsfile1'],
    [name: 'm1/job2', scriptPath: 'm1/Jenkinsfile2']
]

for(p in pipelines) {
    pipelineJob("${p.name}") {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            name('github')
                            url('https://github.com/Vamshi400/getting-started.git')
                        }
                        branch('master')
                        extensions {
                            cloneOptions {
                                shallow(true)
                                depth(1)
                                noTags(true)
                            }
                        }
                    }
                }
                scriptPath("${p.scriptPath}")
            }
        }
        }
    }
