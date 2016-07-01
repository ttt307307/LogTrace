package com.logtrace.plugin

import com.logtrace.extension.LogTraceExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
/**
 * Created by tandewei on 2016/6/30.
 */
public class LogTracePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create("logtrace", LogTraceExtension)

        def aspectj = { destDir, aspectPath, inpath, classpath ->
            ant.taskdef(resource: "org/aspectj/tools/ant/taskdefs/aspectjTaskdefs.properties",
                    classpath: configurations.ajc.asPath)

            ant.iajc(
                    encoding: 'UTF-8',
                    maxmem: "1024m", fork: "true", Xlint: "ignore",
                    destDir: destDir,
                    aspectPath: aspectPath,
                    inpath: inpath,
                    classpath: classpath,
                    source: project.sourceCompatibility,
                    target: project.targetCompatibility,
            )
        }

        project.afterEvaluate {
            def enabled = project.logtrace.enabled
            println("logtrace.enabled=" + enabled)

            project.logtrace.compileJavas.each { compileJava ->
                println(compileJava)
                compileJava.doLast {
                    System.out.println(compileJava.dump() + "===> no aspectj")
                }
//                compileJava {
//                    doLast {
//                        if (!enabled) {
//                            System.out.println(compileJava.dump() + "===> no aspectj")
//                            return
//                        }
//                        aspectj project.sourceSets.main.output.classesDir.absolutePath,
//                                configurations.aspects.asPath,
//                                project.sourceSets.main.output.classesDir.absolutePath,
//                                project.sourceSets.main.runtimeClasspath.asPath
//                    }
//                }
            }

            project.logtrace.compileTestJavas.each { compileTestJava ->
                println compileTestJava
//                compileTestJava {
//                    dependsOn jar
//
//                    doLast {
//                        if (!enabled) {
//                            System.out.println(compileTestJava.dump() + "===> no aspectj")
//                            return
//                        }
//                        aspectj project.sourceSets.test.output.classesDir.absolutePath,
//                                configurations.aspects.asPath + jar.archivePath,
//                                project.sourceSets.test.output.classesDir.absolutePath,
//                                project.sourceSets.test.runtimeClasspath.asPath
//                    }
//                }
            }
        }
    }
}
