# Build

Build systems, testing, packaging, deployment, installation, ... . The build system tools orchestrate source code as input to throughput in compilation toolchain to target output. The build system tools and the compilation toolchain are both part of the larger continous integration and deployment tools pipeline.

| Source; input                        | Toolchain; throughput                                 | Target; output                         |
| :----------------------------------- | :---------------------------------------------------: | -------------------------------------: |
| high level code                      | Compiler, linker, debugger, ...                       | low level code CPU/GPU/MCU             |
| Ada/C/C++/.../Haskel/Rust/...        | Assembly language                                     | Machine code                           |
| Prgramming language PL               | Front End for PL, - Middle End -, Back End for ISA    | Instruction set architectre ISA        |
| Logic, function, process, data       | FE Language independet intermediate representation IR | Instructions, data types, registers    |
| Application programming interface    | ME Target independent analyser and optimzer           | Application binary interface           |
| Software: Programme instruction set  | BE Code generator and registry allocation             | Hardware: Processor instruction set    |
| example below, correct?              | example below, correct?                               | example below, correct?                |
| C/C++                                | Clang LLVM IR --, ---- LLVM ----, LLVM x86/ARM/MIPS   | file; binary/library/executable        |
|                                      | lxcl/sntx/smtc -, --- analyse --, code generation -   |                                        |
|                                      | symbol table ---, -- optimize --, reg alocation ---   |                                        |

Software source code -> Compiler assembly, object code linking, ... -> Machine code instruction set, binary executable for Hardware computer chip

Some programming languages can be both compiled as binarycode and also interpreted as bytecode.

## Notes
	
In regard to AGW project, languages that require native build systems, in no particular order of importance
* C/C++/ASM, embedded, some applications, compiled to machine code hardware specific
* Java, appliations, compiled to bytecode for runtime interpreter hardware agnostic, & JIT
* JS/TS, GUI, data?, scripting? compiled, interpreted & JIT? depending on usage, 
* Python, data analytics/science, rad prototyping, some applications, compiled to bytecode for runtime interpreter hardware agnostic, & JIT
* Rust, embedded, other tbd, see also [GH](https://github.com/YorkEarwaker/Automation/tree/main/repository-sample/rst_structure#notes), compiled to machine code hardware specific
* ...

In regard to AGW project, compilers libraries toolchains, <todo: more better disambiguation, >
* ARM compilers and libraries, com [WS](https://developer.arm.com/Tools%20and%20Software#f-navigationhierarchiesprocessortype=Compilers%20and%20Libraries&aq=%40navigationhierarchiescategories%3D%3D%22Tools%20and%20Software%20products%22%20AND%20%40navigationhierarchiescontenttype%3D%3D%22Product%20Information%22&numberOfResults=48) armcc/armclang, uses GCC and Clang but different coverage?, ARM targets? Raspberry Pi SBC and MCU? proprietry, multiple toolchains for ARM, which to use?
* Clang LLVM, org [WS](https://clang.llvm.org/), C/C++, front end for LLVM, cross compiler? does it work for ARM targets? probs? 
* LLVM, org [WS](https://llvm.org/), 
* GCC gcc/g++, org [WS](https://gcc.gnu.org/), linux only? must have for ARM and Raspberry Pi? Linux first?
* Visual C++ cl, C++, win, must have for windows applications? proprietry, but free for open source?
* Visual C++ MSVC, C, win, must have for windows applications? proprietry, but free for open source?

In regard to AGW project, build tools, native build and meta build, 
* CMake, C/C++, others, default industry standard for C/C++, likely yes confirm, Bosch use it for RPi SCB code, <todo: consider, confirm with Raspberry Pi if they use this as main build tool inhouse, >
* CMake, Jenkins plugin, [GH](https://plugins.jenkins.io/cmakebuilder/), the linux foundation, <todo: consdier, seperate CI/CD project for Jenkins, and other such tools, >
* Ninja, command runner/generator?

Order of compliation? <todo: validate this, probs not, move elsewhere learning? specific toolchian project? >
* MinGW GCC first, test on Linux
* Window MSVC second, 
* no compiler extensions? to enble binary execution in both Linux and Windows, 

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
* <todo: consider, what is QtCreator? how to use, what for; debugging? testing? >

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

Software - compiler, established, <todo: consider, only large installed base, that work in Windows, Linux, nice Mac
* List of compilers, [WP](https://en.wikipedia.org/wiki/List_of_compilers), 
* Clang, [WP](https://en.wikipedia.org/wiki/Clang), Linux, front end to LLVM
* Clang-cl, Windows <todo: consider, determine, same thing as Clang or differnt? >
* GCC, GNU Compiler Collection, C/C++ source to machine code, chip specific, other languages too, 
* javac, Java source to Java byte code, chip independent, write once execute anywhere in a java runtime environment JRE
* MSVC, Microsoft
* LLVM, Intell, [WP](https://en.wikipedia.org/wiki/LLVM), org [WS](https://releases.llvm.org/), binaries [WS](https://github.com/llvm/llvm-project/releases/tag/llvmorg-18.1.8)
* Open64, Itanium x86_64, microprocessor MCU's
* xlclang++, AIX, IBM, 

Windows - c runtime library to target, has toolchain dependency
* msvcrt, old legacy?
* ucrt, new

Linux - ? <todo: investigate more, linux glibc and musl binaries>
* glibc, GNU C library 
* musl

Compiler - specific C++ library, Clang/MSVC binaries cannot be combined with GCC binaries, can't use DLL's from one compiler with DLL's another compiler
* Clang, default on windows - MSVC C++ standard library, configure to use - LLVM libc++, generates only binary code compatible with MSVC
* MinGW-GCC, GNU libstdc++, generates only binary code compatible with GCC, 
* MSVC, only supports - MSVC C++ standard library, generates only binary code compatible with MSVC

Debugger - compiler specific, different debuggers for application compiled by different compilers
* Clang, lldb
* GCC, gdb
* MSVC, Visual Studio debugger

Profiler? - 
* ...?

File name encoding? - to avoid; cross platform issues, cross compiler issues
* glib, UTF8 

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

Products - 
* DLL, dynamically linked library, MS only? 
* Library file, 
* Executable file, 

Toolchain - tools that create code products 
* Analyser, 
* Compiler, [WP](https://en.wikipedia.org/wiki/Compiler), converts source code to machine code, as an executable, for a specific hardware chip instruction set architecture
* Debugger, 
* Interpreter, executes bytecode, and sometimes source code, in a runtime environment which is hardware chip ISA independent/agnostic
* Generator, generate code for execution on machine, hardware chip, specific ISA 
* Linker, 
* Optimizer, 
* Profiler, 
* Toolchain, [WP](https://en.wikipedia.org/wiki/Toolchain),
* Toolchain, GNU, [WP](https://en.wikipedia.org/wiki/GNU_toolchain), ported in part to Windows via Cygwin and MinGW/MSYS/WSL2, 
* ...

Code - application, to a end capability objective, of high and low level programming languages, HLPL and LLPL 
* Assembly, LLPL
* Code, HLPL to LLPL, set of instructions, often digital, semantics, 
* Object code, [WP](https://en.wikipedia.org/wiki/Object_code), LLPL, binary object
* Macihne code, LLPL, for a specific ISA, to create a library file/executable file, linked binary objects, for a specific harware chip architecture
* Programming Language, lexacon, syntax
* Source code, HLPL

Hardware
* Instruction set architecture [WP](https://en.wikipedia.org/wiki/Instruction_set_architecture)
* Machine code 
* ...

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
* Comparative Analysis of GNU Make, CMake, Ninja, and Meson, [WS](https://www.linkedin.com/pulse/modern-build-systems-comparative-analysis-gnu-make-cmake-ninja), Sep 15, 2023, VOLANSYS (An ACL Digital Company), LinkedIn, 

News Papers - compiler, CPU
* Demystifying the CPU: what x86, x86_64, i386, i686 and AMD64 mean, [WS](https://www.reddit.com/r/linux4noobs/comments/12j9chi/demystifying_the_cpu_what_x86_x86_64_i386_i686/), reddit, linux4noobs, 
* ...

News Papers - compiler, msvc cl.exe link.exe tools
* Where is MSVC installed? - Detecting location of `cl.exe` and `link.exe`, [WS](https://stackoverflow.com/questions/61554532/where-is-msvc-installed-detecting-location-of-cl-exe-and-link-exe), StackOverflow, 
* [WS](https://www.jetbrains.com/help/clion/quick-tutorial-on-configuring-clion-on-windows.html#MSVC)
