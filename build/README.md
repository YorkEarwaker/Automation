# Build

Build systems, testing, packaging, deployment, installation, ...

## Notes

In regard to AWG project, languages that require native build systems, in no particular order of importance
* C/C++/ASM, embedded, some applications, 
* Java, appliations, 
* JS/TS, GUI, data?, scripting? 
* Python, data analytics/science, prototyping, some applications
* Rust, embedded, other tbd, see also [GH](https://github.com/YorkEarwaker/Automation/tree/main/repository-sample/rst_structure#notes)
* ...

## Status
TODO
* <todo: consider, PlatformIO, relation to Bosch Sensortec for embedded systems other than Raspberry Pi, focus on C/C++ to begin with, for ARM Cortex-R and ARM Cortex-M >
* <todo: consider, Hatch, relation to PyOpenSci, Python >
* <todo: consider, Ant?, relation to FOSS AGW project, Java >
* <todo: consider, ???, relation to ???, JS/TS, node.js, >
* <todo: consider, just as replacement to make?, coded in Rust, support by many package managers, investigate more, >
* <todo: consider, Make, realtion to electrical engineering, C/C++, GNU Make?,  >
* <todo: consider, GitHub, relation to FOSS AGW, Repo, Git SCM based, >
* <todo: consider, GitLab, relation to FOSS AGW, Repo, Git SCM based, >
* <todo: consider, Meson, relation of FOSS AGW, meta-build, CMake aligned, looks interesting, Apache, >
* <todo: consider, what to other FOSS Foundation projects use for meta-build, native-build, compile, repo, is there any alignment? is there any standardisation? are they working towards any? >
* <todo: consider, Cargo, relation to electrical engineering, Rust, build system for Rust, embedded systems, but looks like is warps the Rust language>
* <todo: consider, other build systems; Bazel, Buck2, ...grow list? >

DONE
* <done: consider, intent to commit>
* <done: consider, renaming to Build systems bsy /bsy, conclusion - not at this time. >
* <done: consider, CMake, relation to Bosch Sensortec for Raspberry Pi, focus on C/C++ to begin with, initial GNU ARM Toolchain? for ARM Cortex-A, >
* <done: consider, Ninja, relation to ???, C/C++? >
* <done: consider, Git, relation to GitHub/GitLab, package mangement, remote repository access, Bash shell, used to download Pico SDK,  >
* <done: consider, ARM tool chain, Windows 64 x86_64 hosted, all four ARM targets, compilers, >

## Libs

Software - build, C/C++/ASM & others, established, large installed base
* CMake, [WP](https://en.wikipedia.org/wiki/CMake), org [WS](https://cmake.org/), FOSS, meta build tool, 
* Make, [WP](https://en.wikipedia.org/wiki/Make_(software)), CLI, Unix centric, native build tool, C/C++
* Ninja, [GH](https://github.com/ninja-build/ninja), [WP](https://en.wikipedia.org/wiki/Ninja_(build_system)), org [WS](https://ninja-build.org/), manual [WS](https://ninja-build.org/manual.html)

Software - build, Rust, to assess, 
* Cargo, doc [WS](https://doc.rust-lang.org/cargo/index.html), Rust build system
* just, [GH](https://github.com/casey/just), manual [WS](https://just.systems/man/en/), cheatsheet [WS](https://cheatography.com/linux-china/cheat-sheets/justfile/) a Make replacement, used by: Ubuntu, Raspbian Testing, Debian, Arch Linux ARM aarch64, written in Rust, 

Software - compile, established, large installed base
* gcc, C/C++ source to machine code, chip specific, 
* javac, Java source to Java byte code, chip independent, write once execute anywhere in a java runtime environment JRE

## References 

Terms
* Build automation, [WP](https://en.wikipedia.org/wiki/Build_automation), system list [Wp](https://en.wikipedia.org/wiki/List_of_build_automation_software), 
* CI, [WP](https://en.wikipedia.org/wiki/Continuous_integration), comparision [WP](https://en.wikipedia.org/wiki/Comparison_of_continuous_integration_software), Jenkinks looks like leader, Jenkins good candidate for AGW project?
* CD, 
* compiler, per chip architecture; ARM gcc toolchain, Intel?, RISC?,  
* DevOps
* DevSecOps
* IDE, support for build, support for SCM, support for language, VSCode? VSCodium and/or Eclipse Theia ryo extensions sibling project (sw-dev, sys-eng, ci, cd, devops, devsecops, rpi, scm, ...) tool chain? might also be used for extenstions for some end user business vertical (business scenario/use case) capability; emrr, ewa, monitoring telmetry weather stations, nwp climate/weather modelling, and so on ...
* Meta build tool, Meson as candiate for AGW project? ponder more.
* Native build tool, per language?, if core AGW languages to be; C/C++/ASM, Java, JS/TS, Python, Rust, . 
* Source Code Management SCM, code repository, examples: Git, SVN, ..., see version control
* verson control [WP](https://en.wikipedia.org/wiki/Version_control), comparision [WP](https://en.wikipedia.org/wiki/Comparison_of_version-control_software), see source code management, (Fossil, Git, Mercurial, Subversion SVN) candidate for AGW project? what are other FOS project using?

Papers
* Build systems a la carte; theory and practice, [PDF](https://simon.peytonjones.org/assets/pdfs/build-systems-jfp.pdf), [WS](https://simon.peytonjones.org/build-systems-a-la-carte-theory-and-practice/), Andrey Mokhov, Neil Mitchell, Simon Peyton Jones, Journal of Functional Programming, Vol 30(E11)

Languages
* ...
* GitHub, shell, scripts to rule them all, [GH](https://github.com/github/scripts-to-rule-them-all), is this still relevant for GH
* just, <no wikipedia page as of 2025-08-21 > likely preferred option over Make, 
* Rust, org <link-to-rust-web-site>, Rust Foundation, [WS](https://rustfoundation.org/)
* ...

News Papers - repository, PR/MR, with CI/CD,  
* GitHub vs GitLab - Why should I choose GitLab?, [WS](https://forum.gitlab.com/t/github-vs-gitlab-why-should-i-choose-gitlab/93945), GitLab, Oct 2023, 
* Gitlab Trigger CI/CD Pipeline only when PR/MR is approved, [WS](https://stackoverflow.com/questions/76921635/gitlab-trigger-ci-cd-pipeline-only-when-pr-mr-is-approved), StackOverflow, 17 Aug 2023, 

News Papers - build
* What is the difference between using a Makefile and CMake to compile the code?, [WS](https://stackoverflow.com/questions/25789644/what-is-the-difference-between-using-a-makefile-and-cmake-to-compile-the-code), 11 Sep 2014, 
* Makefile Grammar, [WS](https://stackoverflow.com/questions/18488680/makefile-grammar), 28 Aug 2013, StackOverflow, 

News Papers - compiler, CPU
* Demystifying the CPU: what x86, x86_64, i386, i686 and AMD64 mean, [WS](https://www.reddit.com/r/linux4noobs/comments/12j9chi/demystifying_the_cpu_what_x86_x86_64_i386_i686/), reddit, linux4noobs, 
* ...
