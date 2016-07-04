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

        project.configurations {
            ajc
            ajtools
            aspects
            ajInpath
            aspectpath
            compile {
                extendsFrom aspects
            }
        }

        project.dependencies {
            ajc "org.aspectj:aspectjtools:1.8.9"
            compile "org.aspectj:aspectjweaver:1.8.9"
            ajtools "org.aspectj:aspectjtools:1.8.9"
            compile "org.aspectj:aspectjrt:1.8.9"
        }

        def aspectj = { destDir, aspectPath, inpath, classpath ->
            project.ant.taskdef(resource: "org/aspectj/tools/ant/taskdefs/aspectjTaskdefs.properties",
                    classpath: project.configurations.ajc.asPath)

            project.ant.iajc(
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
                    if (!enabled) {
                        System.out.println("===> no aspectj")
                        return
                    }
//                    aspectj project.sourceSets.main.output.classesDir.absolutePath,
//                            project.configurations.aspects.asPath,
//                            project.sourceSets.main.output.classesDir.absolutePath,
//                            project.sourceSets.main.runtimeClasspath.asPath
                    aspectj project.sourceSets.main.output.classesDir.absolutePath,
                            compileJava.classpath.asPath,
                            compileJava.destinationDir.toString(),
                            compileJava.classpath.asPath
                }
            }

            project.logtrace.compileTestJavas.each { compileJava ->
                println compileJava
                compileJava.doLast {
                    if (!enabled) {
                        System.out.println("===> no aspectj")
                        return
                    }
//                    aspectj project.sourceSets.test.output.classesDir.absolutePath,
//                            project.configurations.aspects.asPath + project.jar.archivePath,
//                            project.sourceSets.test.output.classesDir.absolutePath,
//                            project.sourceSets.test.runtimeClasspath.asPath
                    aspectj project.sourceSets.test.output.classesDir.absolutePath,
                            compileJava.classpath.asPath,
                            compileJava.destinationDir.toString(),
                            compileJava.classpath.asPath
                }
            }
        }
    }
}
