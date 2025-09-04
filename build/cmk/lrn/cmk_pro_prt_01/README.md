# Step 1 of the CMake online tutorial

CMake » Documentation » CMake Tutorial » Step 1: A Basic Starting Point [WS](https://cmake.org/cmake/help/latest/guide/tutorial/A%20Basic%20Starting%20Point.html)

See also
* Notes on introduction to CMake, [GH](https://github.com/YorkEarwaker/Automation/tree/main/build/cmk/lrn/cmk_pro_prt_01)

## Notes

Tutorial assumes host environment is setup for tutorial activities. 
* Part of the learning is troubleshooting how to setup the host environment to undertake the tutorial step activities

## Status
TODO
* <todo: consider, gcc toolchain build, on windows host >
* <todo: consider, arm toolchain build, on windows host >
* <todo: consider, windows toolchain, how to run error free, is it that it cannot find link.exe? does CMake require link.exe locatons set on command line, search for Detecting C compiler ABI info - failed >
* <todo: consider, document changes, delta, from CMake Step 1 tutorial, >

DONE
* <done: consider, intent to commit>
* <done: consider, windows toolchain build, on windows host, wip >
* <done: consider, windows toolchain, rerun as is with errors to reflect new directory structure /src /bld source directory and build directory respectively>
* <done: consider, include link to tutorial page.>

## Output

### Step 1 - Windows toolchain
After installing Visual Studio 2022 Community . Dev host now has cl.exe C/C++ compiler. Generates build directory and some binaries. But returns the following error.

```
C:\Users\yorke\Documents\dev\repo\automation\build\cmk\lrn\cmk_trl_stp_01>cmake -S ./src -B ./bld -G "Ninja" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_COMPILER="C:/Program Files (x86)/Microsoft Visual Studio 14.0/VC/bin/cl.exe" -DCMAKE_C_COMPILER="C:/Program Files (x86)/Microsoft Visual Studio 14.0/VC/bin/cl.exe"
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

    Change Dir: 'C:/Users/yorke/Documents/dev/repo/automation/build/cmk/lrn/cmk_trl_stp_01/bld/CMakeFiles/CMakeScratch/TryCompile-dh2x9x'

    Run Build Command(s): C:/Users/yorke/Documents/env/ninja-win/ninja.exe -v cmTC_a2236
    [1/2] C:\PROGRA~2\MICROS~1.0\VC\bin\cl.exe  /nologo   /DWIN32 /D_WINDOWS /W3  /MDd /Zi /Ob0 /Od /RTC1 /showIncludes /FoCMakeFiles\cmTC_a2236.dir\testCCompiler.c.obj /FdCMakeFiles\cmTC_a2236.dir\ /FS -c C:\Users\yorke\Documents\dev\repo\automation\build\cmk\lrn\cmk_trl_stp_01\bld\CMakeFiles\CMakeScratch\TryCompile-dh2x9x\testCCompiler.c
    [2/2] C:\WINDOWS\system32\cmd.exe /C "cd . && "C:\Program Files\CMake\bin\cmake.exe" -E vs_link_exe --intdir=CMakeFiles\cmTC_a2236.dir --rc=rc --mt=CMAKE_MT-NOTFOUND --manifests  -- C:\PROGRA~2\MICROS~1.0\VC\bin\link.exe /nologo CMakeFiles\cmTC_a2236.dir\testCCompiler.c.obj  /out:cmTC_a2236.exe /implib:cmTC_a2236.lib /pdb:cmTC_a2236.pdb /version:0.0 /machine:X86  /debug /INCREMENTAL /subsystem:console  kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib && cd ."
    FAILED: [code=4294967295] cmTC_a2236.exe
    C:\WINDOWS\system32\cmd.exe /C "cd . && "C:\Program Files\CMake\bin\cmake.exe" -E vs_link_exe --intdir=CMakeFiles\cmTC_a2236.dir --rc=rc --mt=CMAKE_MT-NOTFOUND --manifests  -- C:\PROGRA~2\MICROS~1.0\VC\bin\link.exe /nologo CMakeFiles\cmTC_a2236.dir\testCCompiler.c.obj  /out:cmTC_a2236.exe /implib:cmTC_a2236.lib /pdb:cmTC_a2236.pdb /version:0.0 /machine:X86  /debug /INCREMENTAL /subsystem:console  kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib && cd ."
    RC Pass 1: command "rc /fo CMakeFiles\cmTC_a2236.dir/manifest.res CMakeFiles\cmTC_a2236.dir/manifest.rc" failed (exit code 0) with the following output:
    no such file or directory
    ninja: build stopped: subcommand failed.





  CMake will not be able to correctly generate this project.
Call Stack (most recent call first):
  CMakeLists.txt:8 (project)


-- Configuring incomplete, errors occurred!
```

### Step 1 - GCC toolchain


### Step 1 - ARM toolchain

