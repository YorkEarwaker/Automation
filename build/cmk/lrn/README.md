# Learning lrn

CMake tutorials and other learning resources.

## Notes

Specify the generator via the cli
* cmake -G "Ninja"
* cmake -G "MinGW Makefiles"

Specify generator for the project or environment, Stops ablity to use -G cli function?
* CMAKE_GENERATOR environment variable to set the generator
* Preload.cmake file in project directory, e.g. set(CMAKE_GENERATOR "Ninja" CACHE INTERNAL "" FORCE)
* As of CMake 3.19, CMakePresets.json files to set env varaibles and configure CMake, 

List generators that might be used on the platform - but not necessarly installed on the host machine
* cmake --help

## Status
TODO
* <todo: consider, reading first chapters of 'Professonal CMake, A Practical Guide' Part 1 Getting Started, free pdf download, >
* <todo: consider, compile with GCC g++ via Git Bash shell, >
* <todo: consider, install GNU make banaries for Windows, for GCC g++ compile via Git Bash shell, >

DONE
* <done: consider, intent to commit>
* <done: consider, installing Visual Studio 2022 Community, for Windows cl.exe compiler, MSVC for C/C++ >

## Output

### Step 1 - CMake online tutorial
After installing Visual Studio 2022 Community . Dev host now has cl.exe C/C++ compiler. Generates build directory and some binaries. But returns the following error.
* <todo: consider, how to run error free, is it that it cannot find link.exe? does CMake require link.exe locatons set on command line, search for Detecting C compiler ABI info - failed >
* <todo: consider, document changes, delta, from CMake Step 1 tutorial, >

```
C:\Users\yorke\Documents\dev\repo\automation\build\cmk\lrn>cmake -S ./cmk_trl_stp_01 -B ./cmk_trl_stp_01_bld -G "Ninja" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_COMPILER="C:/Program Files (x86)/Microsoft Visual Studio 14.0/VC/bin/cl.exe" -DCMAKE_C_COMPILER="C:/Program Files (x86)/Microsoft Visual Studio 14.0/VC/bin/cl.exe"
-- The C compiler identification is MSVC 19.0.24247.2
-- The CXX compiler identification is MSVC 19.0.24247.2
-- Detecting C compiler ABI info
-- Detecting C compiler ABI info - failed
-- Check for working C compiler: C:/Program Files (x86)/Microsoft Visual Studio 14.0/VC/bin/cl.exe
-- Check for working C compiler: C:/Program Files (x86)/Microsoft Visual Studio 14.0/VC/bin/cl.exe - broken
CMake Error at C:/Program Files/CMake/share/cmake-3.28/Modules/CMakeTestCCompiler.cmake:67 (message):
  The C compiler

    "C:/Program Files (x86)/Microsoft Visual Studio 14.0/VC/bin/cl.exe"

  is not able to compile a simple test program.

  It fails with the following output:

    Change Dir: 'C:/Users/yorke/Documents/dev/repo/automation/build/cmk/lrn/cmk_trl_stp_01_bld/CMakeFiles/CMakeScratch/TryCompile-csn5rf'

    Run Build Command(s): C:/Users/yorke/Documents/env/ninja-win/ninja.exe -v cmTC_95b51
    [1/2] C:\PROGRA~2\MICROS~1.0\VC\bin\cl.exe  /nologo   /DWIN32 /D_WINDOWS /W3  /MDd /Zi /Ob0 /Od /RTC1 /showIncludes /FoCMakeFiles\cmTC_95b51.dir\testCCompiler.c.obj /FdCMakeFiles\cmTC_95b51.dir\ /FS -c C:\Users\yorke\Documents\dev\repo\automation\build\cmk\lrn\cmk_trl_stp_01_bld\CMakeFiles\CMakeScratch\TryCompile-csn5rf\testCCompiler.c
    [2/2] C:\WINDOWS\system32\cmd.exe /C "cd . && "C:\Program Files\CMake\bin\cmake.exe" -E vs_link_exe --intdir=CMakeFiles\cmTC_95b51.dir --rc=rc --mt=CMAKE_MT-NOTFOUND --manifests  -- C:\PROGRA~2\MICROS~1.0\VC\bin\link.exe /nologo CMakeFiles\cmTC_95b51.dir\testCCompiler.c.obj  /out:cmTC_95b51.exe /implib:cmTC_95b51.lib /pdb:cmTC_95b51.pdb /version:0.0 /machine:X86  /debug /INCREMENTAL /subsystem:console  kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib && cd ."
    FAILED: [code=4294967295] cmTC_95b51.exe
    C:\WINDOWS\system32\cmd.exe /C "cd . && "C:\Program Files\CMake\bin\cmake.exe" -E vs_link_exe --intdir=CMakeFiles\cmTC_95b51.dir --rc=rc --mt=CMAKE_MT-NOTFOUND --manifests  -- C:\PROGRA~2\MICROS~1.0\VC\bin\link.exe /nologo CMakeFiles\cmTC_95b51.dir\testCCompiler.c.obj  /out:cmTC_95b51.exe /implib:cmTC_95b51.lib /pdb:cmTC_95b51.pdb /version:0.0 /machine:X86  /debug /INCREMENTAL /subsystem:console  kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib && cd ."
    RC Pass 1: command "rc /fo CMakeFiles\cmTC_95b51.dir/manifest.res CMakeFiles\cmTC_95b51.dir/manifest.rc" failed (exit code 0) with the following output:
    no such file or directory
    ninja: build stopped: subcommand failed.





  CMake will not be able to correctly generate this project.
Call Stack (most recent call first):
  CMakeLists.txt:8 (project)


-- Configuring incomplete, errors occurred!
```

## Libs

Docs
* CMake tutorial, [WS](https://cmake.org/cmake/help/latest/guide/tutorial/index.html)
* CMake, Help, guide, tutorial, [GL](https://gitlab.kitware.com/cmake/cmake/-/tree/master/Help/guide/tutorial?ref_type=heads), tutorial code artifacts, 
* CMake, generators, [WS](https://cmake.org/cmake/help/latest/manual/cmake-generators.7.html), command runner

Generators
* MSBuild, [WP](https://en.wikipedia.org/wiki/MSBuild), FOSS?, for MS Win native tool chain?
* nmake, only available with Visual Studio 2022 etc MS licnece required. default generator on Windows for CMake so awks. 
* Ninja, to use in place of nmake, Linux and MS Win, and MacOS?
* xmake ??? <todo: investigate further. Linux and MS Win, and MacOS? >

Compilers
* Linux, GCC
* Windows, clang-cl/MSVC

Rpi SDK
* Raspberry Pi, Microcontrollers, The C/C++ SDK, [GH](https://github.com/raspberrypi/pico-sdk) [WS](https://www.raspberrypi.com/documentation/microcontrollers/c_sdk.html)
* Getting started with Raspberry Pi Pico-series C/C++ development with Raspberry Pi Pico-series and other Raspberry Pi microcontroller-based boards. 2 0 2 4 - 1 0 - 1 5 : 2 b 6 0 1 8 e - c l e a  [PDF](https://datasheets.raspberrypi.com/pico/getting-started-with-pico.pdf)
* Raspberry Pi Pico-series C/C++ SDK Libraries and tools for C/C++ development on Raspberry Pi microcontrollers. [PDF](https://datasheets.raspberrypi.com/pico/raspberry-pi-pico-c-sdk.pdf)
* RP2350 Datasheet a microcontroller by Raspberry Pi [PDF](https://datasheets.raspberrypi.com/rp2350/rp2350-datasheet.pdf)
* 

Bosch SDK
* BMV080 SDK, particulate matter sensor, 
* ...

Windows - tool chain
* Portable C and C++ Development Kit for x64 (and x86) Windows, [GH](https://github.com/skeeto/w64devkit), appears to require Docker, 
* ...

## References

Terms
* Cross Compiler, runs on one platrom (the host) generates executable code for a second platform (the target)

Learning
* CMake Tutorial for Absolute Beginners - From GCC to CMake including Make and Ninja [YT](https://www.youtube.com/watch?v=NGPo7mz1oa4), Garry Explains, 
* How to Build a Universal Binary for the Raspberry Pi Pico 2 - Arm & RISC-V in the Same File, [YT](https://www.youtube.com/watch?v=GgYCBa4q4IE), 
* Raspberry Pi Pico PIO - 8 Little Processors You Can Program, 2040 only? [YT](https://www.youtube.com/watch?v=QlKtEA5XKc4)
* ...

News Papers - trouble shooting
* Building from source with CMake results in an error, [WS](Building from source with CMake results in an error), missing generator, nmake, ninja, etc
* Tutorial step1 Error with project(), [WS](https://discourse.cmake.org/t/tutorial-step1-error-with-project/11520), missing generator, nmake, ninja, etc
* CMake error at CMakeLists.txt, [WS](https://discourse.cmake.org/t/cmake-error-at-cmakelists-txt/10817), missing generator, nmake, ninja, etc
* Getting unwanted errors while running the project. [WS](https://discourse.cmake.org/t/getting-unwanted-errors-while-running-the-project/10238), missing generator, nmake, ninja, etc
* Error while configuring CMake project: Running 'nmake' '-?' failed, [WS](https://stackoverflow.com/questions/69338088/error-while-configuring-cmake-project-running-nmake-failed), missing generator, nmake, ninja, etc
* ...

News Papers - MS build tools - require Visual Studio licence
* Microsoft C++ Build Tools - Visual Studio free for commercial use, [WS](https://learn.microsoft.com/en-us/answers/questions/1683872/is-microsoft-c-build-tools-visual-studio-free-for), Microsoft, 
* How to install Visual C++ Build tools?, [WS](https://stackoverflow.com/questions/40504552/how-to-install-visual-c-build-tools), Overflow, 
* ...

News Papers - generators
* Check available generators, [WS](https://discourse.cmake.org/t/check-available-generators/9391), discorse, 
* Inspecting the host system for what generators will work [GL](https://gitlab.kitware.com/cmake/cmake/-/issues/25397), Issues, open, CMake
* CMake & MinGW Compilation on Windows, without needing the -G "MinGW Makefiles" flag, [WS](https://stackoverflow.com/questions/59095842/cmake-mingw-compilation-on-windows-without-needing-the-g-mingw-makefiles-f?noredirect=1&lq=1), StackOverflow, 
* Cmake on windows, [WS](https://www.reddit.com/r/cpp_questions/comments/1324tyc/cmake_on_windows/?rdt=47935), reddit, 
* ...

News Papers - compilers
* asiest way to set up C compiler on Windows 10 (if you use Visual Studio Code)? [WS](https://www.reddit.com/r/C_Programming/comments/11kzz2j/easiest_way_to_set_up_c_compiler_on_windows_10_if/?rdt=48115), reddit, c programming, 
* C++ developers on Windows, what compiler do you use to compile your C++ code on Windows, and how do you write your code to ensure it compiles and runs on Windows and Linux? [WS](https://www.reddit.com/r/cpp_questions/comments/1j8xc6c/c_developers_on_windows_what_compiler_do_you_use/?q=Best+C+compilers+for+Windows&tabId=related), reddit, cpp questions
* 
