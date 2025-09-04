# Step 1 of the CMake online tuturial


## Status
TODO
* <todo: consider, include link to tutorial page.>
* <todo: consider, windows toolchain build, on windows host >
* <todo: consider, gcc toolchain build, on windows host >
* <todo: consider, arm toolchain build, on windows host >
* <todo: consider, windows toolchain, how to run error free, is it that it cannot find link.exe? does CMake require link.exe locatons set on command line, search for Detecting C compiler ABI info - failed >
* <todo: consider, document changes, delta, from CMake Step 1 tutorial, >
* <todo: consider, windows toolchain, rerun as is with errors to reflect new directory structure /src /bld source directory and build directory respectively>

DONE
* <done: consider, intent to commit>

## Output

### Step 1 - Windows toolchain
After installing Visual Studio 2022 Community . Dev host now has cl.exe C/C++ compiler. Generates build directory and some binaries. But returns the following error.

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

### Step 1 - GCC toolchain


### Step 1 - ARM toolchain

