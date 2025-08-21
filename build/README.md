# Build

Build systems, testing, packaging, installation, ...

## Notes

In regard to AWG project, languages that require native build systems, in no particular order of importance
* C/C++/ASM, embedded, some applications, 
* Java, appliations, 
* JS/TS, GUI, data?, scripting? 
* Python, data analytics/science, prototyping, some applications
* Rust, embedded, other tbd, consider as first class before C/C++/ASM where there is an option to do so?, DARPA converting all C code to Rust, 
* ...

## Status
TODO
* <todo: consider, CMake, relation to Bosch Sensortec for Raspberry Pi, focus on C/C++ to begin with, initial GNU ARM Toolchain? for ARM Cortex-A, >
* <todo: consider, PlatformIO, relation to Bosch Sensortec for embedded systems other than Raspberry Pi, focus on C/C++ to begin with, for ARM Cortex-R and ARM Cortex-M >
* <todo: consider, Hatch, relation to PyOpenSci, Python >
* <todo: consider, Ant?, relation to FOSS AGW project, Java >
* <todo: consider, ???, relation to ???, JS/TS, node.js, >
* <todo: consider, Make, realtion to electrical engineering, C/C++, GNU Make?,  >
* <todo: consider, Ninja, relation to ???, C/C++? >
* <todo: consider, GitHub, relation to FOSS AGW, Repo, Git SCM based, >
* <todo: consider, GitLab, relation to FOSS AGW, Repo, Git SCM based, >
* <todo: consider, Meson, relation of FOSS AGW, meta-build, CMake aligned, looks interesting, Apache, >
* <todo: consider, what to other FOSS Foundation projects use for meta-build, native-build, compile, repo, is there any alignment? is there any standardisation? are they working towards any? >
* <todo: consider, just as replacement to make?, coded in Rust, support by many package managers, investigate more, >
* <todo: consider, Cargo, relation to electrical engineering, Rust, build system for Rust, embedded systems, >

DONE
* <done: consider, intent to commit>
* <done: consider, renaming to Build systems bsy /bsy, conclusion - not at this time. >

## Libs

Software - build
* CMake, [WP](https://en.wikipedia.org/wiki/CMake), org [WS](https://cmake.org/), FOSS, meta build tool, 
* Make, [WP](https://en.wikipedia.org/wiki/Make_(software)), CLI, Unix centric, native build tool, C/C++

Software - compile
* gcc, C/C++ source to machine code, chip specific, 
* javac, Java source to Java byte code, chip independent, write once execute anywhere in a java runtime environment JRE

## References 

Terms
* Build system, 
* CI/CD
* DevOps
* DevSecOps
* Meta build tool
* Native build tool
* Source Code Management SCM, code repository, examples: Git, SVN, ...

News Papers - repository, PR/MR, with CI/CD,  
* GitHub vs GitLab - Why should I choose GitLab?, [WS](https://forum.gitlab.com/t/github-vs-gitlab-why-should-i-choose-gitlab/93945), GitLab, Oct 2023, 
* Gitlab Trigger CI/CD Pipeline only when PR/MR is approved, [WS](https://stackoverflow.com/questions/76921635/gitlab-trigger-ci-cd-pipeline-only-when-pr-mr-is-approved), StackOverflow, 17 Aug 2023, 

News Papers - build
* What is the difference between using a Makefile and CMake to compile the code?, [WS](https://stackoverflow.com/questions/25789644/what-is-the-difference-between-using-a-makefile-and-cmake-to-compile-the-code), 11 Sep 2014, 
* Makefile Grammar, [WS](https://stackoverflow.com/questions/18488680/makefile-grammar), 28 Aug 2013, StackOverflow, 

News Papers - compile
* ...