package com.chriswk.gradle.plugins.vcsinfo

import org.eclipse.jgit.api.Git
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction

class GradleGitInfoPlugin implements Plugin<Project> {
    String VCS_HASH_NAME = "vcsinfo"
    String VCS_BRANCH = "branch"
    String VCS_REVISION = "revision"
    String VCS_FULLREVISION = "fullRevision"
    String VCS_DESCRIBE = "describe"
    @Override
    void apply(Project project) {
        GradleGitInfoPlugin p = new GradleGitInfoPlugin(project)
    }

    GradleGitInfoPlugin(Project project) {
        Git projectGit = Git.open project.rootDir
        vcsPropHolder = [:]

        vcsPropHolder[VCS_BRANCH] =  projectGit.repository.branch
        vcsPropHolder[VCS_FULLREVISION] = projectGit.repository.resolve("HEAD")
        vcsPropHolder[VCS_REVISION] = projectGit.repository.resolve("HEAD short-name")

    }

    @TaskAction
    def printVcsInfo() {
        println "Operating on branch: [${vcsinfo.branch}] with fullrevision [${vcsinfo.fullRevision}], shortrevision [${vcsinfo.revision}] and describe [${vcsinfo.describe}]"
    }
}
