package com.uber.okbuck.config

final class DotBuckConfigLocalFile extends BuckConfigFile {

    private final Map<String, String> aliases
    private final String buildToolVersion
    private final String target
    private final List<String> ignore
    private final String groovyHome

    DotBuckConfigLocalFile(Map<String, String> aliases,
                           String buildToolVersion,
                           String target,
                           List<String> ignore,
                           String groovyHome) {
        this.aliases = aliases
        this.buildToolVersion = buildToolVersion
        this.target = target
        this.ignore = ignore
        this.groovyHome = groovyHome
    }

    @Override
    final void print(PrintStream printer) {
        printer.println("[alias]")
        aliases.each { alias, target ->
            printer.println("\t${alias} = ${target}")
        }
        printer.println()

        printer.println("[android]")
        printer.println("\tbuild_tools_version = ${buildToolVersion}")
        printer.println("\ttarget = ${target}")
        printer.println()

        printer.println("[project]")
        printer.print("\tignore = ${ignore.join(', ')}")
        printer.println()

        if (groovyHome) {
            printer.println("[groovy]")
            printer.print("\tgroovy_home = ${groovyHome}")
            printer.println()
        }
    }
}
