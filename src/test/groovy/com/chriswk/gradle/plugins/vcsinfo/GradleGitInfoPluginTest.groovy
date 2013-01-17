package com.chriswk.gradle.plugins.vcsinfo

class GradleGitInfoPluginTest {
    @Test
    public void greeterPluginAddsGreetingTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: 'greeting'

        assertTrue(project.tasks.hello instanceof GreetingTask)
    }
}
