# Step 1 of the CMake online tutorial

CMake » Documentation » CMake Tutorial » Step 1: A Basic Starting Point [WS](https://cmake.org/cmake/help/latest/guide/tutorial/A%20Basic%20Starting%20Point.html)

See also
* Notes on introduction to CMake, [GH](https://github.com/YorkEarwaker/Automation/tree/main/build/cmk/lrn/cmk_pro_prt_01)

## Notes

Tutorial assumes host environment is setup for tutorial activities. 
* Part of the learning is troubleshooting how to setup the host environment to undertake the tutorial step activities
* Simplest option for Windows, install Community edition of Visual Studio. Visual Studio 2022 Community in this instance. 
* Best option for any environment create build environment on developer box which is IDE independent and OS independent. Vendor neutral dev env and build env, to mitigate vendor lock in risk. 
* - work in progress for this effort
* - more difficult to iron out dependencies and create vendor neutral env, sourcing installing cross compilers and so on, seperate task to learning CMake
* - significantly more difficult if also new to CMake, learning CMake separate task to creation of vendor neutral dev/build env task
 
Consider
* -DCMAKE_C_COMPILER_LAUNCHER=../cc_args.py 
* -DCMAKE_CXX_COMPILER_LAUNCHER=../cc_args.py

PATH systems variable 
* echo PATH, in command window
```
echo %PATH%
C:\Program Files\Eclipse Adoptium\jdk-21.0.4.7-hotspot\bin;C:\Program Files\Common Files\Oracle\Java\javapath;C:\Program Files (x86)\Common Files\Oracle\Java\javapath;C:\ProgramData\Oracle\Java\javapath;C:\Windows\System32;C:\Windows;C:\Windows\System32\wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Windows\System32\OpenSSH\;C:\Program Files (x86)\Gpg4win\..\GnuPG\bin;C:\Program Files\PuTTY\;C:\Program Files\Git\cmd;C:\Program Files (x86)\Incredibuild;C:\Program Files\PowerShell\7\;C:\Program Files (x86)\Windows Kits\10\Windows Performance Toolkit\;C:\Users\yorke\AppData\Local\Programs\Python\Python37\Scripts\;C:\Users\yorke\AppData\Local\Programs\Python\Python37\;C:\Users\yorke\AppData\Local\Microsoft\WindowsApps;;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.3.2\bin;;C:\Users\yorke\AppData\Local\Programs\Microsoft VS Code\bin;C:\Users\yorke\AppData\Local\Programs\VSCodium\bin;C:\Program Files\CMake\bin
```

CMake location - still confused as to weather VS 2022 Community has caused issues with standalone CMake install
* From echo PATH, 
* C:\Program Files\CMake\bin
```
C:\Users\yorke\Documents\dev\cmake>where cmake
C:\Program Files\CMake\bin\cmake.exe
```
* From Visual Studio 2022 Community install
* C:\Program Files\Microsoft Visual Studio\2022\Community\Common7\IDE\CommonExtensions\Microsoft\CMake\CMake

SDK's location? - Windows Kits, seem so 
* From echo PATH, 
* Don't know what was here before installing; Visual Studio 2022 Community, Windows 11 SDK,  
```
C:\Program Files (x86)\Windows Kits\10\bin>dir
 Volume in drive C has no label.
 Volume Serial Number is 7EE5-8235

 Directory of C:\Program Files (x86)\Windows Kits\10\bin

15/09/2025  11:41    <DIR>          .
15/09/2025  11:41    <DIR>          ..
15/09/2025  11:41    <DIR>          10.0.14393.0
15/09/2025  11:41    <DIR>          10.0.15063.0
15/09/2025  11:41    <DIR>          10.0.16299.0
15/09/2025  11:41    <DIR>          10.0.17134.0
01/09/2025  12:30    <DIR>          10.0.19041.0
01/09/2025  12:30    <DIR>          10.0.22621.0
15/09/2025  11:43    <DIR>          10.0.26100.0
01/09/2025  12:32    <DIR>          arm
15/09/2025  11:41    <DIR>          arm64
15/09/2025  11:41    <DIR>          x64
15/09/2025  11:41    <DIR>          x86
               0 File(s)              0 bytes
              13 Dir(s)  755,972,177,920 bytes free
```

## Status
TODO
* <todo: consider, gcc toolchain build, on windows host deploy to Linux, Raspberry Pi Zero, crosscompile, >
* <todo: consider, arm toolchain build, on windows host deploy to Linux, Raspberry Pi Zero, crosscompile, >
* <todo: consider, windows toolchain, how to run error free, is it that it cannot find link.exe? does CMake require link.exe locatons set on command line, search for Detecting C compiler ABI info - failed >
* <todo: consider, document changes, delta, from CMake Step 1 tutorial, >
* <todo: consider, consider install earlier Windows 10 SDK, >
* <todo: consider, Ninja generator, which has failed till now, but with success of Visual Studio 17 2022 generator, getting Ninja generator working is next step, >
* <todo: consider, Visual Studio 17 2022 generator from deeper directory structure /dev/repo/.. >
* <todo: consider, installing Windows SDK 10.0.19045, can it be installed alongside Windows SDK 10.0.19045, >
* <todo: consider, try Ninja and clang, see heading below, Step 1 - Clang toolchain>

DONE
* <done: consider, intent to commit>
* <done: consider, windows toolchain build, on windows host, wip >
* <done: consider, windows toolchain, rerun as is with errors to reflect new directory structure /src /bld source directory and build directory respectively>
* <done: consider, include link to tutorial page.>
* <done: consider, reduced directory depth, move for evaulation, /dev/cmake >
* <done: consider, environment set up script, C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Auxiliary/Build/vcvarsall.bat, but with SDK errors with Ninja generator, not necessary for Visual Studio 17 2022 generator? >
* <done: consider, Visual Studio 17 2022 generator for MSVC, success! see Output below. cmake -S src -B bld -G "Visual Studio 17 2022">
* <done: consider, Visual Studio 17 2022 generator for Clang, success! see Output below. cmake -S ./src -B ./bld-clg-vsc -G "Visual Studio 17 2022" -T ClangCL -A x64>
* <done: as a consequence of 'Ninja does not support' statements copy Clang.VS2022C command line options test with Ninja failure to Ninja - generator heading and delete 'Ninja - generator 2' heading.>

## Output

### Step 1 - Windows MSVC toolchain

#### Visual Studio 17 2022 - generator
Success

Precursors
* Install, CMake, Necessary, <todo: is it in this context? does not Visual Studio install its own version of CMake? Likely VS CMake install dirupts stand alone CMake install? or are there two completely isolated instances? >
* Install, Visual Studio 2022 Community . Necessary as previous to installation default generator was reported as NMake by cmake --help
* Read, Professional CMake Part 1 [GH](https://github.com/YorkEarwaker/Automation/tree/main/build/cmk/lrn/cmk_pro_prt_01) see notes here. Necessary to better understand CMake.
* Install, Windows SDK 10.0.26100.4948 for Windows 11. Was this necessary? Don't know. Confused about MS SDK's .

<info: Windows SDK 10.0.26100.4948 installed, comments>
* Get The Windows SDK (10.0.26100) for Windows 11,  SDK installer, [WS](https://developer.microsoft.com/en-us/windows/downloads/windows-sdk/), retrieved/installed 15/09/2025
* winsdksetup.exe
* Last updated: August 2025
* Windows Software Development Kit, 10.0.26100.4948, reported installed
* Rebooted
* Still appears to be missing, when using Ninja
* consider, Ninja config issue? Ninja looking in wrong place? misdirected by Registry entry? 
* also causing compiltion issues for Ninja needs x64 for host architecture but Microsoft SDKs under Program Files (x86), where is x64 equivalent?
* might not have been necessary to install SDK for Visual Studio 17 2022 generator to succeed?
```
where? /Microsoft SDKs/Windows Kit, not /Microsoft SDKs/Windows
Can't see it in, 
C:\Program Files (x86)\Microsoft SDKs
```

<todo: try in new cmd shell window without these calls, calls suggested by online sources while attempting to troubleshoot Ninja generator issues, >
* After running 
* - "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Auxiliary/Build/vcvarsall.bat" x86 10.0.26100.4948 
* - likely errors here in arguments, should be x64? not required with this Visual Studio 17 2022 generator?
* After running
* - set VSCMD_DEBUG=1
* - vsdevcmd.bat 
* - 

Consider, test
* cmake -S src -B bld -G "Visual Studio 17 2022"
* Success
```
C:\Users\yorke\Documents\dev\cmake>cmake -S src -B bld -G "Visual Studio 17 2022"
-- Selecting Windows SDK version 10.0.26100.0 to target Windows 10.0.19045.
-- The C compiler identification is MSVC 19.44.35216.0
-- The CXX compiler identification is MSVC 19.44.35216.0
-- Detecting C compiler ABI info
-- Detecting C compiler ABI info - done
-- Check for working C compiler: C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx64/x64/cl.exe - skipped
-- Detecting C compile features
-- Detecting C compile features - done
-- Detecting CXX compiler ABI info
-- Detecting CXX compiler ABI info - done
-- Check for working CXX compiler: C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx64/x64/cl.exe - skipped
-- Detecting CXX compile features
-- Detecting CXX compile features - done
-- Configuring done (11.0s)
-- Generating done (0.0s)
-- Build files have been written to: C:/Users/yorke/Documents/dev/cmake/bld
```

Consider, test
* cmake --build ./bld
* Success
```
C:\Users\yorke\Documents\dev\cmake>cmake --build ./bld
MSBuild version 17.14.23+b0019275e for .NET Framework

  1>Checking Build System
  Building Custom Rule C:/Users/yorke/Documents/dev/cmake/src/CMakeLists.txt
  tutorial.cxx
  Tutorial.vcxproj -> C:\Users\yorke\Documents\dev\cmake\bld\Debug\Tutorial.exe
  Building Custom Rule C:/Users/yorke/Documents/dev/cmake/src/CMakeLists.txt

C:\Users\yorke\Documents\dev\cmake>
```

Consider, test
* call executable
* Success
```
C:\Users\yorke\Documents\dev\cmake>bld\Debug\Tutorial.exe 6
The square root of 6 is 2.44949

C:\Users\yorke\Documents\dev\cmake>
```

#### Ninja - generator
Revisit this after success with generator Visual Studio 17 2022 
* Ninja was initial test generator but kept failing. Resolve issues to use as default.

After installing Visual Studio 2022 Community . Dev host now has cl.exe C/C++ compiler. Generates build directory and some binaries. But returns the following error.
* did not run environment setup script "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Auxiliary/Build/vcvarsall.bat" as recomended in some commentary.
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

After reading Part 1 Professional CMake, 15/09/2025 
* Moved tutorial test to reduce directory depth /dev/cmake
* Run MS environment setup script "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Auxiliary/Build/vcvarsall.bat"
```
C:\Users\yorke\Documents\dev\cmake>"C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Auxiliary/Build/vcvarsall.bat"
[ERROR:vcvarsall.bat] Error in script usage. The correct usage is:
Syntax:
    vcvarsall.bat [arch] [platform_type] [winsdk_version] [-vcvars_ver=vc_version] [-vcvars_spectre_libs=spectre_mode]
where :
    [arch]: x86 | amd64 | x86_amd64 | x86_arm | x86_arm64 | amd64_x86 | amd64_arm | amd64_arm64
    [platform_type]: {empty} | store | uwp
    [winsdk_version] : full Windows 10 SDK number (e.g. 10.0.10240.0) or "8.1" to use the Windows 8.1 SDK.
    [vc_version] : {none} for latest installed VC++ compiler toolset |
                   "14.0" for VC++ 2015 Compiler Toolset |
                   "14.xx" for the latest 14.xx.yyyyy toolset installed (e.g. "14.11") |
                   "14.xx.yyyyy" for a specific full version number (e.g. "14.11.25503")
    [spectre_mode] : {none} for libraries without spectre mitigations |
                     "spectre" for libraries with spectre mitigations

The store parameter sets environment variables to support Universal Windows Platform application
development and is an alias for 'uwp'.

For example:
    vcvarsall.bat x86_amd64
    vcvarsall.bat x86_amd64 10.0.10240.0
    vcvarsall.bat x86_arm uwp 10.0.10240.0
    vcvarsall.bat x86_arm onecore 10.0.10240.0 -vcvars_ver=14.0
    vcvarsall.bat x64 8.1
    vcvarsall.bat x64 store 8.1

Please make sure either Visual Studio or C++ Build SKU is installed.
```

Call vshwere, to determine Visual Studio location, 
* was not available on the command line from /dev/cmake so likely not in the PATH variable
```
C:\Users\yorke\Documents\dev\cmake>"C:\Program Files (x86)\Microsoft Visual Studio\Installer\vswhere"
Visual Studio Locator version 3.1.7+f39851e70f [query version 3.12.2140.44225]
Copyright (C) Microsoft Corporation. All rights reserved.

instanceId: 9e8638bd
installDate: 29/08/2025 13:58:14
installationName: VisualStudio/17.14.13+36414.22.-august.2025-
installationPath: C:\Program Files\Microsoft Visual Studio\2022\Community
installationVersion: 17.14.36414.22
productId: Microsoft.VisualStudio.Product.Community
productPath: C:\Program Files\Microsoft Visual Studio\2022\Community\Common7\IDE\devenv.exe
state: 4294967295
isComplete: 1
isLaunchable: 1
isPrerelease: 0
isRebootRequired: 0
displayName: Visual Studio Community 2022
description: Powerful IDE, free for students, open-source contributors, and individuals
channelId: VisualStudio.17.Release
channelUri: https://aka.ms/vs/17/release/channel
enginePath: C:\Program Files (x86)\Microsoft Visual Studio\Installer\resources\app\ServiceHub\Services\Microsoft.VisualStudio.Setup.Service
installedChannelId: VisualStudio.17.Release
installedChannelUri: https://aka.ms/vs/17/release/channel
releaseNotes: https://docs.microsoft.com/en-us/visualstudio/releases/2022/release-notes-v17.14#17.14.13
resolvedInstallationPath: C:\Program Files\Microsoft Visual Studio\2022\Community
thirdPartyNotices: https://go.microsoft.com/fwlink/?LinkId=661288
updateDate: 2025-08-29T12:58:14.2570614Z
catalog_buildBranch: d17.14
catalog_buildVersion: 17.14.36414.22
catalog_id: VisualStudio/17.14.13+36414.22.-august.2025-
catalog_localBuild: build-lab
catalog_manifestName: VisualStudio
catalog_manifestType: installer
catalog_productDisplayVersion: 17.14.13 (August 2025)
catalog_productLine: Dev17
catalog_productLineVersion: 2022
catalog_productMilestone: RTW
catalog_productMilestoneIsPreRelease: False
catalog_productName: Visual Studio
catalog_productPatchVersion: 13
catalog_productPreReleaseMilestoneSuffix: 1.0
catalog_productReleaseNameSuffix: (August 2025)
catalog_productSemanticVersion: 17.14.13+36414.22.-august.2025-
catalog_requiredEngineVersion: 3.14.2084.208
properties_campaignId: 2030:afd6ace11e714d55bd7af5e60c81b378
properties_channelManifestId: VisualStudio.17.Release/17.14.13+36414.22.-august.2025-
properties_includeRecommended: 1
properties_nickname:
properties_setupEngineFilePath: C:\Program Files (x86)\Microsoft Visual Studio\Installer\setup.exe
```

Consider, test
* vcvarsall.bat x64 10.0.26100
* "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Auxiliary/Build/vcvarsall.bat" x64 10.0.26100
```
C:\Users\yorke\Documents\dev\cmake>"C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Auxiliary/Build/vcvarsall.bat" x64 10.0.26100
**********************************************************************
** Visual Studio 2022 Developer Command Prompt v17.14.13
** Copyright (c) 2025 Microsoft Corporation
**********************************************************************
[ERROR:winsdk.bat] Windows SDK 10.0.26100 : 'C:\Program Files (x86)\Windows Kits\10\include\10.0.26100\um' not found or was incomplete
[ERROR:VsDevCmd.bat] *** VsDevCmd.bat encountered errors. Environment may be incomplete and/or incorrect. ***
[ERROR:VsDevCmd.bat] In an uninitialized command prompt, please 'set VSCMD_DEBUG=[value]' and then re-run
[ERROR:VsDevCmd.bat] vsdevcmd.bat [args] for additional details.
[ERROR:VsDevCmd.bat] Where [value] is:
[ERROR:VsDevCmd.bat]    1 : basic debug logging
[ERROR:VsDevCmd.bat]    2 : detailed debug logging
[ERROR:VsDevCmd.bat]    3 : trace level logging. Redirection of output to a file when using this level is recommended.
[ERROR:VsDevCmd.bat] Example: set VSCMD_DEBUG=3
[ERROR:VsDevCmd.bat]          vsdevcmd.bat > vsdevcmd.trace.txt 2>&1
```

SDK location
* Registry, HKEY_LOCAL_MACHINE\SOFTWARE\WOW6432Node\Microsoft\Microsoft SDKs\Windows\v10.0
* Window SDK, Product version, 10.0.26100
* Location, C:\Program Files (x86)\Microsoft SDKs\Windows Kits\10

Windows SDK appears incomplete. see above. [ERROR:winsdk.bat] Windows SDK 10.0.26100 : 'C:\Program Files (x86)\Windows Kits\10\include\10.0.26100\um' not found or was incomplete

Consider, test
* set VSCMD_DEBUG=1
* vsdevcmd.bat 
```
C:\Users\yorke\Documents\dev\cmake>set VSCMD_DEBUG=1

C:\Users\yorke\Documents\dev\cmake>vsdevcmd.bat
[DEBUG:VsDevCmd] Writing pre-initialization environment to C:\Users\yorke\AppData\Local\Temp\dd_vsdevcmd17_preinit_env.log
[DEBUG:core\vsdevcmd_start] initializing with arguments ''
[DEBUG:core\parse_cmd.bat] initializaing with arguments ''
[DEBUG:VsDevCmd.bat] Found version "17.14.13"
**********************************************************************
** Visual Studio 2022 Developer Command Prompt v17.14.13
** Copyright (c) 2025 Microsoft Corporation
**********************************************************************
[DEBUG:VsDevCmd.bat] calling "core\dotnet.bat"
[DEBUG:core\dotnet.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "core\msbuild.bat"
[DEBUG:core\msbuild.bat] initializing...
[DEBUG:core\msbuild.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "core\winsdk.bat"
[DEBUG:winsdk.bat] initializing...
[DEBUG:core\winsdk.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\clang_cl.bat"
[DEBUG:ext\clang_cl.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\cmake.bat"
[DEBUG:ext\cmake.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\ConnectionManagerExe.bat"
[DEBUG:ext\ConnectionManagerExe.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\diaghub.bat"
[DEBUG:ext\diaghub.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\html_help.bat"
[DEBUG:ext\html_help.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\netfxsdk.bat"
[DEBUG:ext\netfxsdk.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\perf_tools.bat"
[DEBUG:ext\perf_tools.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\roslyn.bat"
[DEBUG:ext\roslyn.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\team_explorer.bat"
[DEBUG:ext\team_explorer.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\testwindow.bat"
[DEBUG:ext\testwindow.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\vcpkg.bat"
[DEBUG:ext\vcpkg.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\vcvars.bat"
[DEBUG:ext\vcvars.bat] VCToolsVersion = "14.44.35207"
[DEBUG:ext\vcvars.bat] IFCPATH was not modified. IFCPATH already set: "C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\ifc\x64".
[DEBUG:ext\vcvars.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] Sending telemetry
[DEBUG:core\vsdevcmd_end] initializing with arguments ''
[DEBUG:VsDevCmd] Writing post-execution environment to C:\Users\yorke\AppData\Local\Temp\dd_vsdevcmd17_env.log
```

Get Windows 10 SDK installer, retrieved/installed 15/09/2025
* https://developer.microsoft.com/en-us/windows/downloads/windows-sdk/
* winsdksetup.exe
* Last updated: August 2025
* Windows Software Development Kit, 10.0.26100.4948, reported installed
* Rebooted
* Still appears to be missing, see below.
```
where?
```

Consider, test
* set VSCMD_DEBUG=1
* vcvarsall.bat x64 110.0.26100.4948
* "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Auxiliary/Build/vcvarsall.bat" x64 10.0.26100.4948
```
C:\Users\yorke\Documents\dev\cmake>"C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Auxiliary/Build/vcvarsall.bat" x64 10.0.26100.4948
[DEBUG:vcvarsall.bat] init with arguments 'x64 10.0.26100.4948'
[DEBUG:vcvarsall.bat] Command line parse completed with values:
[DEBUG:vcvarsall.bat] __VCVARSALL_TARGET_ARCH='x64'
[DEBUG:vcvarsall.bat] __VCVARSALL_HOST_ARCH='x64'
[DEBUG:vcvarsall.bat] __VCVARSALL_WINSDK='10.0.26100.4948'
[DEBUG:vcvarsall.bat] __VCVARSALL_STORE=''
[DEBUG:vcvarsall.bat] __VCVARSALL_HELP=''
[DEBUG:vcvarsall.bat] __VCVARSALL_PARSE_ERROR='0'
[DEBUG:VsDevCmd] Writing pre-initialization environment to C:\Users\yorke\AppData\Local\Temp\dd_vsdevcmd17_preinit_env.log
[DEBUG:core\vsdevcmd_start] initializing with arguments ''
[DEBUG:core\parse_cmd.bat] initializaing with arguments ''
[DEBUG:VsDevCmd.bat] Found version "17.14.14"
**********************************************************************
** Visual Studio 2022 Developer Command Prompt v17.14.14
** Copyright (c) 2025 Microsoft Corporation
**********************************************************************
[DEBUG:VsDevCmd.bat] calling "core\dotnet.bat"
[DEBUG:core\dotnet.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "core\msbuild.bat"
[DEBUG:core\msbuild.bat] initializing...
[DEBUG:core\msbuild.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "core\winsdk.bat"
[DEBUG:winsdk.bat] initializing...
[ERROR:winsdk.bat] Windows SDK 10.0.26100.4948 : 'C:\Program Files (x86)\Windows Kits\10\include\10.0.26100.4948\um' not found or was incomplete
[ERROR:core\winsdk.bat] init:FAILED code:1
[DEBUG:VsDevCmd.bat] calling "ext\clang_cl.bat"
[DEBUG:ext\clang_cl.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\cmake.bat"
[DEBUG:ext\cmake.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\ConnectionManagerExe.bat"
[DEBUG:ext\ConnectionManagerExe.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\diaghub.bat"
[DEBUG:ext\diaghub.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\html_help.bat"
[DEBUG:ext\html_help.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\netfxsdk.bat"
[DEBUG:ext\netfxsdk.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\perf_tools.bat"
[DEBUG:ext\perf_tools.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\roslyn.bat"
[DEBUG:ext\roslyn.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\team_explorer.bat"
[DEBUG:ext\team_explorer.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\testwindow.bat"
[DEBUG:ext\testwindow.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\vcpkg.bat"
[DEBUG:ext\vcpkg.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\vcvars.bat"
[DEBUG:ext\vcvars.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] Sending telemetry
[DEBUG:core\vsdevcmd_end] initializing with arguments ''
[ERROR:VsDevCmd.bat] *** VsDevCmd.bat encountered errors. Environment may be incomplete and/or incorrect. ***
[ERROR:VsDevCmd.bat] In an uninitialized command prompt, please 'set VSCMD_DEBUG=[value]' and then re-run
[ERROR:VsDevCmd.bat] vsdevcmd.bat [args] for additional details.
[ERROR:VsDevCmd.bat] Where [value] is:
[ERROR:VsDevCmd.bat]    1 : basic debug logging
[ERROR:VsDevCmd.bat]    2 : detailed debug logging
[ERROR:VsDevCmd.bat]    3 : trace level logging. Redirection of output to a file when using this level is recommended.
[ERROR:VsDevCmd.bat] Example: set VSCMD_DEBUG=3
[ERROR:VsDevCmd.bat]          vsdevcmd.bat > vsdevcmd.trace.txt 2>&1
[DEBUG:VsDevCmd] Writing post-execution environment to C:\Users\yorke\AppData\Local\Temp\dd_vsdevcmd17_env.log
```

Consider, test
* as requested from call above
* vsdevcmd.bat
* winsdk.bat returns success! Huzza! But am not concinced the environment is fit for purpose.
```
C:\Users\yorke\Documents\dev\cmake>vsdevcmd.bat
[DEBUG:VsDevCmd] Writing pre-initialization environment to C:\Users\yorke\AppData\Local\Temp\dd_vsdevcmd17_preinit_env.log
[DEBUG:core\vsdevcmd_start] initializing with arguments ''
[DEBUG:core\parse_cmd.bat] initializaing with arguments ''
[DEBUG:VsDevCmd.bat] Found version "17.14.14"
**********************************************************************
** Visual Studio 2022 Developer Command Prompt v17.14.14
** Copyright (c) 2025 Microsoft Corporation
**********************************************************************
[DEBUG:VsDevCmd.bat] calling "core\dotnet.bat"
[DEBUG:core\dotnet.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "core\msbuild.bat"
[DEBUG:core\msbuild.bat] initializing...
[DEBUG:core\msbuild.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "core\winsdk.bat"
[DEBUG:winsdk.bat] initializing...
[DEBUG:core\winsdk.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\clang_cl.bat"
[DEBUG:ext\clang_cl.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\cmake.bat"
[DEBUG:ext\cmake.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\ConnectionManagerExe.bat"
[DEBUG:ext\ConnectionManagerExe.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\diaghub.bat"
[DEBUG:ext\diaghub.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\html_help.bat"
[DEBUG:ext\html_help.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\netfxsdk.bat"
[DEBUG:ext\netfxsdk.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\perf_tools.bat"
[DEBUG:ext\perf_tools.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\roslyn.bat"
[DEBUG:ext\roslyn.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\team_explorer.bat"
[DEBUG:ext\team_explorer.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\testwindow.bat"
[DEBUG:ext\testwindow.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\vcpkg.bat"
[DEBUG:ext\vcpkg.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\vcvars.bat"
[DEBUG:ext\vcvars.bat] VCToolsVersion = "14.44.35207"
[DEBUG:ext\vcvars.bat] IFCPATH was not modified. IFCPATH already set: "C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\ifc\x64".
[DEBUG:ext\vcvars.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] Sending telemetry
[DEBUG:core\vsdevcmd_end] initializing with arguments ''
[DEBUG:VsDevCmd] Writing post-execution environment to C:\Users\yorke\AppData\Local\Temp\dd_vsdevcmd17_env.log
```

Consider, test
* vswhere
```
C:\Users\yorke\Documents\dev\cmake>"C:\Program Files (x86)\Microsoft Visual Studio\Installer\vswhere"
Visual Studio Locator version 3.1.7+f39851e70f [query version 3.12.2140.44225]
Copyright (C) Microsoft Corporation. All rights reserved.

instanceId: 9e8638bd
installDate: 29/08/2025 13:58:14
installationName: VisualStudio/17.14.14+36429.23
installationPath: C:\Program Files\Microsoft Visual Studio\2022\Community
installationVersion: 17.14.36429.23
productId: Microsoft.VisualStudio.Product.Community
productPath: C:\Program Files\Microsoft Visual Studio\2022\Community\Common7\IDE\devenv.exe
state: 4294967295
isComplete: 1
isLaunchable: 1
isPrerelease: 0
isRebootRequired: 0
displayName: Visual Studio Community 2022
description: Powerful IDE, free for students, open-source contributors, and individuals
channelId: VisualStudio.17.Release
channelUri: https://aka.ms/vs/17/release/channel
enginePath: C:\Program Files (x86)\Microsoft Visual Studio\Installer\resources\app\ServiceHub\Services\Microsoft.VisualStudio.Setup.Service
installedChannelId: VisualStudio.17.Release
installedChannelUri: https://aka.ms/vs/17/release/channel
releaseNotes: https://docs.microsoft.com/en-us/visualstudio/releases/2022/release-notes-v17.14#17.14.14
resolvedInstallationPath: C:\Program Files\Microsoft Visual Studio\2022\Community
thirdPartyNotices: https://go.microsoft.com/fwlink/?LinkId=661288
updateDate: 2025-09-15T10:00:44.1323655Z
catalog_buildBranch: d17.14
catalog_buildVersion: 17.14.36429.23
catalog_id: VisualStudio/17.14.14+36429.23
catalog_localBuild: build-lab
catalog_manifestName: VisualStudio
catalog_manifestType: installer
catalog_productDisplayVersion: 17.14.14
catalog_productLine: Dev17
catalog_productLineVersion: 2022
catalog_productMilestone: RTW
catalog_productMilestoneIsPreRelease: False
catalog_productName: Visual Studio
catalog_productPatchVersion: 14
catalog_productPreReleaseMilestoneSuffix: 1.0
catalog_productSemanticVersion: 17.14.14+36429.23
catalog_requiredEngineVersion: 3.14.2086.54749
properties_campaignId: 2030:afd6ace11e714d55bd7af5e60c81b378
properties_channelManifestId: VisualStudio.17.Release/17.14.14+36429.23
properties_includeRecommended: 1
properties_nickname:
properties_setupEngineFilePath: C:\Program Files (x86)\Microsoft Visual Studio\Installer\setup.exe
```

Consider, test
* Try CMake again
* As,vsdevcmd.bat, winsdk.bat reports no errors above.
* Compilers, C CXX
* cmake -S src -B bld -G "Ninja" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_COMPILER="C:/Program Files (x86)/Microsoft Visual Studio 14.0/VC/bin/cl.exe" -DCMAKE_C_COMPILER="C:/Program Files (x86)/Microsoft Visual Studio 14.0/VC/bin/cl.exe"
```
C:\Users\yorke\Documents\dev\cmake>cmake -S src -B bld -G "Ninja" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_COMPILER="C:/Program Files (x86)/Microsoft Visual Studio 14.0/VC/bin/cl.exe" -DCMAKE_C_COMPILER="C:/Program Files (x86)/Microsoft Visual Studio 14.0/VC/bin/cl.exe"
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

    Change Dir: 'C:/Users/yorke/Documents/dev/cmake/bld/CMakeFiles/CMakeScratch/TryCompile-rx5ij2'

    Run Build Command(s): C:/Users/yorke/Documents/env/ninja-win/ninja.exe -v cmTC_f97d2
    [1/2] C:\PROGRA~2\MICROS~1.0\VC\bin\cl.exe  /nologo   /DWIN32 /D_WINDOWS /W3  /MDd /Zi /Ob0 /Od /RTC1 /showIncludes /FoCMakeFiles\cmTC_f97d2.dir\testCCompiler.c.obj /FdCMakeFiles\cmTC_f97d2.dir\ /FS -c C:\Users\yorke\Documents\dev\cmake\bld\CMakeFiles\CMakeScratch\TryCompile-rx5ij2\testCCompiler.c
    [2/2] C:\WINDOWS\system32\cmd.exe /C "cd . && "C:\Program Files\CMake\bin\cmake.exe" -E vs_link_exe --intdir=CMakeFiles\cmTC_f97d2.dir --rc=C:\PROGRA~2\WI3CF2~1\10\bin\100261~1.0\x86\rc.exe --mt=C:\PROGRA~2\WI3CF2~1\10\bin\100261~1.0\x86\mt.exe --manifests  -- C:\PROGRA~2\MICROS~1.0\VC\bin\link.exe /nologo CMakeFiles\cmTC_f97d2.dir\testCCompiler.c.obj  /out:cmTC_f97d2.exe /implib:cmTC_f97d2.lib /pdb:cmTC_f97d2.pdb /version:0.0 /machine:X86  /debug /INCREMENTAL /subsystem:console  kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib && cd ."
    FAILED: [code=4294967295] cmTC_f97d2.exe
    C:\WINDOWS\system32\cmd.exe /C "cd . && "C:\Program Files\CMake\bin\cmake.exe" -E vs_link_exe --intdir=CMakeFiles\cmTC_f97d2.dir --rc=C:\PROGRA~2\WI3CF2~1\10\bin\100261~1.0\x86\rc.exe --mt=C:\PROGRA~2\WI3CF2~1\10\bin\100261~1.0\x86\mt.exe --manifests  -- C:\PROGRA~2\MICROS~1.0\VC\bin\link.exe /nologo CMakeFiles\cmTC_f97d2.dir\testCCompiler.c.obj  /out:cmTC_f97d2.exe /implib:cmTC_f97d2.lib /pdb:cmTC_f97d2.pdb /version:0.0 /machine:X86  /debug /INCREMENTAL /subsystem:console  kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib && cd ."
    LINK Pass 1: command "C:\PROGRA~2\MICROS~1.0\VC\bin\link.exe /nologo CMakeFiles\cmTC_f97d2.dir\testCCompiler.c.obj /out:cmTC_f97d2.exe /implib:cmTC_f97d2.lib /pdb:cmTC_f97d2.pdb /version:0.0 /machine:X86 /debug /INCREMENTAL /subsystem:console kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib /MANIFEST /MANIFESTFILE:CMakeFiles\cmTC_f97d2.dir/intermediate.manifest CMakeFiles\cmTC_f97d2.dir/manifest.res" failed (exit code 1120) with the following output:
    MSVCRTD.lib(loadcfg.obj) : error LNK2001: unresolved external symbol ___enclave_config
    MSVCRTD.lib(loadcfg.obj) : error LNK2001: unresolved external symbol ___guard_eh_cont_table
    MSVCRTD.lib(loadcfg.obj) : error LNK2001: unresolved external symbol ___guard_eh_cont_count
    MSVCRTD.lib(loadcfg.obj) : error LNK2001: unresolved external symbol ___volatile_metadata
    cmTC_f97d2.exe : fatal error LNK1120: 4 unresolved externals
    ninja: build stopped: subcommand failed.

  CMake will not be able to correctly generate this project.
Call Stack (most recent call first):
  CMakeLists.txt:12 (project)


-- Configuring incomplete, errors occurred!

```

Consider, test
* different compiler instance, cl.exe
* add command option to reference, link.exe
* C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx64/x64
* cmake -S src -B bld -G "Ninja" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_COMPILER="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx64/x64/cl.exe" -DCMAKE_C_COMPILER="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx64/x64/cl.exe" -DCMAKE_LINKER="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx64/x64/link.exe"
```
C:\Users\yorke\Documents\dev\cmake>cmake -S src -B bld -G "Ninja" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_COMPILER="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx64/x64/cl.exe" -DCMAKE_C_COMPILER="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx64/x64/cl.exe" -DCMAKE_LINKER="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx64/x64/link.exe"
-- The C compiler identification is MSVC 19.44.35216.0
-- The CXX compiler identification is MSVC 19.44.35216.0
-- Detecting C compiler ABI info
-- Detecting C compiler ABI info - failed
-- Check for working C compiler: C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx64/x64/cl.exe
-- Check for working C compiler: C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx64/x64/cl.exe - broken
CMake Error at C:/Program Files/CMake/share/cmake-3.28/Modules/CMakeTestCCompiler.cmake:67 (message):
  The C compiler

    "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx64/x64/cl.exe"

  is not able to compile a simple test program.

  It fails with the following output:

    Change Dir: 'C:/Users/yorke/Documents/dev/cmake/bld/CMakeFiles/CMakeScratch/TryCompile-gxsvry'

    Run Build Command(s): C:/Users/yorke/Documents/env/ninja-win/ninja.exe -v cmTC_4c950
    [1/2] C:\PROGRA~1\MICROS~3\2022\COMMUN~1\VC\Tools\MSVC\1444~1.352\bin\Hostx64\x64\cl.exe  /nologo   /DWIN32 /D_WINDOWS /W3  /MDd /Zi /Ob0 /Od /RTC1 /showIncludes /FoCMakeFiles\cmTC_4c950.dir\testCCompiler.c.obj /FdCMakeFiles\cmTC_4c950.dir\ /FS -c C:\Users\yorke\Documents\dev\cmake\bld\CMakeFiles\CMakeScratch\TryCompile-gxsvry\testCCompiler.c
    [2/2] C:\WINDOWS\system32\cmd.exe /C "cd . && "C:\Program Files\CMake\bin\cmake.exe" -E vs_link_exe --intdir=CMakeFiles\cmTC_4c950.dir --rc=C:\PROGRA~2\WI3CF2~1\10\bin\100261~1.0\x86\rc.exe --mt=C:\PROGRA~2\WI3CF2~1\10\bin\100261~1.0\x86\mt.exe --manifests  -- C:\PROGRA~1\MICROS~3\2022\COMMUN~1\VC\Tools\MSVC\1444~1.352\bin\Hostx64\x64\link.exe /nologo CMakeFiles\cmTC_4c950.dir\testCCompiler.c.obj  /out:cmTC_4c950.exe /implib:cmTC_4c950.lib /pdb:cmTC_4c950.pdb /version:0.0 /machine:x64  /debug /INCREMENTAL /subsystem:console  kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib && cd ."
    FAILED: [code=4294967295] cmTC_4c950.exe
    C:\WINDOWS\system32\cmd.exe /C "cd . && "C:\Program Files\CMake\bin\cmake.exe" -E vs_link_exe --intdir=CMakeFiles\cmTC_4c950.dir --rc=C:\PROGRA~2\WI3CF2~1\10\bin\100261~1.0\x86\rc.exe --mt=C:\PROGRA~2\WI3CF2~1\10\bin\100261~1.0\x86\mt.exe --manifests  -- C:\PROGRA~1\MICROS~3\2022\COMMUN~1\VC\Tools\MSVC\1444~1.352\bin\Hostx64\x64\link.exe /nologo CMakeFiles\cmTC_4c950.dir\testCCompiler.c.obj  /out:cmTC_4c950.exe /implib:cmTC_4c950.lib /pdb:cmTC_4c950.pdb /version:0.0 /machine:x64  /debug /INCREMENTAL /subsystem:console  kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib && cd ."
    LINK Pass 1: command "C:\PROGRA~1\MICROS~3\2022\COMMUN~1\VC\Tools\MSVC\1444~1.352\bin\Hostx64\x64\link.exe /nologo CMakeFiles\cmTC_4c950.dir\testCCompiler.c.obj /out:cmTC_4c950.exe /implib:cmTC_4c950.lib /pdb:cmTC_4c950.pdb /version:0.0 /machine:x64 /debug /INCREMENTAL /subsystem:console kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib /MANIFEST /MANIFESTFILE:CMakeFiles\cmTC_4c950.dir/intermediate.manifest CMakeFiles\cmTC_4c950.dir/manifest.res" failed (exit code 1120) with the following output:
    testCCompiler.c.obj : error LNK2001: unresolved external symbol _RTC_InitBase
    testCCompiler.c.obj : error LNK2001: unresolved external symbol _RTC_Shutdown
    LINK : error LNK2001: unresolved external symbol mainCRTStartup
    C:\Program Files (x86)\Windows Kits\10\\lib\10.0.26100.0\\um\x86\kernel32.lib : warning LNK4272: library machine type 'x86' conflicts with target machine type 'x64'
    C:\Program Files (x86)\Windows Kits\10\\lib\10.0.26100.0\\um\x86\user32.lib : warning LNK4272: library machine type 'x86' conflicts with target machine type 'x64'
    C:\Program Files (x86)\Windows Kits\10\\lib\10.0.26100.0\\um\x86\gdi32.lib : warning LNK4272: library machine type 'x86' conflicts with target machine type 'x64'
    C:\Program Files (x86)\Windows Kits\10\\lib\10.0.26100.0\\um\x86\winspool.lib : warning LNK4272: library machine type 'x86' conflicts with target machine type 'x64'
    C:\Program Files (x86)\Windows Kits\10\\lib\10.0.26100.0\\um\x86\shell32.lib : warning LNK4272: library machine type 'x86' conflicts with target machine type 'x64'
    C:\Program Files (x86)\Windows Kits\10\\lib\10.0.26100.0\\um\x86\ole32.lib : warning LNK4272: library machine type 'x86' conflicts with target machine type 'x64'
    C:\Program Files (x86)\Windows Kits\10\\lib\10.0.26100.0\\um\x86\oleaut32.lib : warning LNK4272: library machine type 'x86' conflicts with target machine type 'x64'
    C:\Program Files (x86)\Windows Kits\10\\lib\10.0.26100.0\\um\x86\uuid.lib : warning LNK4272: library machine type 'x86' conflicts with target machine type 'x64'
    C:\Program Files (x86)\Windows Kits\10\\lib\10.0.26100.0\\um\x86\comdlg32.lib : warning LNK4272: library machine type 'x86' conflicts with target machine type 'x64'
    C:\Program Files (x86)\Windows Kits\10\\lib\10.0.26100.0\\um\x86\advapi32.lib : warning LNK4272: library machine type 'x86' conflicts with target machine type 'x64'
    C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\lib\x86\MSVCRTD.lib : warning LNK4272: library machine type 'x86' conflicts with target machine type 'x64'
    cmTC_4c950.exe : fatal error LNK1120: 3 unresolved externals
    ninja: build stopped: subcommand failed.

  CMake will not be able to correctly generate this project.
Call Stack (most recent call first):
  CMakeLists.txt:12 (project)


-- Configuring incomplete, errors occurred!
```

Consider, test
* vcvarsall.bat x86 10.0.26100.4948
* "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Auxiliary/Build/vcvarsall.bat" x86 10.0.26100.4948
```
C:\Users\yorke\Documents\dev\cmake>"C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Auxiliary/Build/vcvarsall.bat" x86 10.0.26100.4948
[DEBUG:vcvarsall.bat] init with arguments 'x86 10.0.26100.4948'
[DEBUG:vcvarsall.bat] Command line parse completed with values:
[DEBUG:vcvarsall.bat] __VCVARSALL_TARGET_ARCH='x86'
[DEBUG:vcvarsall.bat] __VCVARSALL_HOST_ARCH='x86'
[DEBUG:vcvarsall.bat] __VCVARSALL_WINSDK='10.0.26100.4948'
[DEBUG:vcvarsall.bat] __VCVARSALL_STORE=''
[DEBUG:vcvarsall.bat] __VCVARSALL_HELP=''
[DEBUG:vcvarsall.bat] __VCVARSALL_PARSE_ERROR='0'
[DEBUG:VsDevCmd] Writing pre-initialization environment to C:\Users\yorke\AppData\Local\Temp\dd_vsdevcmd17_preinit_env.log
[DEBUG:core\vsdevcmd_start] initializing with arguments ''
[DEBUG:core\parse_cmd.bat] initializaing with arguments ''
[DEBUG:VsDevCmd.bat] Found version "17.14.14"
**********************************************************************
** Visual Studio 2022 Developer Command Prompt v17.14.14
** Copyright (c) 2025 Microsoft Corporation
**********************************************************************
[DEBUG:VsDevCmd.bat] calling "core\dotnet.bat"
[DEBUG:core\dotnet.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "core\msbuild.bat"
[DEBUG:core\msbuild.bat] initializing...
[DEBUG:core\msbuild.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "core\winsdk.bat"
[DEBUG:winsdk.bat] initializing...
[ERROR:winsdk.bat] Windows SDK 10.0.26100.4948 : 'C:\Program Files (x86)\Windows Kits\10\include\10.0.26100.4948\um' not found or was incomplete
[ERROR:core\winsdk.bat] init:FAILED code:1
[DEBUG:VsDevCmd.bat] calling "ext\clang_cl.bat"
[DEBUG:ext\clang_cl.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\cmake.bat"
[DEBUG:ext\cmake.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\ConnectionManagerExe.bat"
[DEBUG:ext\ConnectionManagerExe.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\diaghub.bat"
[DEBUG:ext\diaghub.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\html_help.bat"
[DEBUG:ext\html_help.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\netfxsdk.bat"
[DEBUG:ext\netfxsdk.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\perf_tools.bat"
[DEBUG:ext\perf_tools.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\roslyn.bat"
[DEBUG:ext\roslyn.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\team_explorer.bat"
[DEBUG:ext\team_explorer.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\testwindow.bat"
[DEBUG:ext\testwindow.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\vcpkg.bat"
[DEBUG:ext\vcpkg.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\vcvars.bat"
[DEBUG:ext\vcvars.bat] VCToolsVersion = "14.44.35207"
[DEBUG:ext\vcvars.bat] IFCPATH was not modified. IFCPATH already set: "C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\ifc\x64".
[DEBUG:ext\vcvars.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] Sending telemetry
[DEBUG:core\vsdevcmd_end] initializing with arguments ''
[ERROR:VsDevCmd.bat] *** VsDevCmd.bat encountered errors. Environment may be incomplete and/or incorrect. ***
[ERROR:VsDevCmd.bat] In an uninitialized command prompt, please 'set VSCMD_DEBUG=[value]' and then re-run
[ERROR:VsDevCmd.bat] vsdevcmd.bat [args] for additional details.
[ERROR:VsDevCmd.bat] Where [value] is:
[ERROR:VsDevCmd.bat]    1 : basic debug logging
[ERROR:VsDevCmd.bat]    2 : detailed debug logging
[ERROR:VsDevCmd.bat]    3 : trace level logging. Redirection of output to a file when using this level is recommended.
[ERROR:VsDevCmd.bat] Example: set VSCMD_DEBUG=3
[ERROR:VsDevCmd.bat]          vsdevcmd.bat > vsdevcmd.trace.txt 2>&1
[DEBUG:VsDevCmd] Writing post-execution environment to C:\Users\yorke\AppData\Local\Temp\dd_vsdevcmd17_env.log
```

Consider, test
* vsdevcmd.bat
```
C:\Users\yorke\Documents\dev\cmake>vsdevcmd.bat
[DEBUG:VsDevCmd] Writing pre-initialization environment to C:\Users\yorke\AppData\Local\Temp\dd_vsdevcmd17_preinit_env.log
[DEBUG:core\vsdevcmd_start] initializing with arguments ''
[DEBUG:core\parse_cmd.bat] initializaing with arguments ''
[DEBUG:VsDevCmd.bat] Found version "17.14.14"
**********************************************************************
** Visual Studio 2022 Developer Command Prompt v17.14.14
** Copyright (c) 2025 Microsoft Corporation
**********************************************************************
[DEBUG:VsDevCmd.bat] calling "core\dotnet.bat"
[DEBUG:core\dotnet.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "core\msbuild.bat"
[DEBUG:core\msbuild.bat] initializing...
[DEBUG:core\msbuild.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "core\winsdk.bat"
[DEBUG:winsdk.bat] initializing...
[DEBUG:core\winsdk.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\clang_cl.bat"
[DEBUG:ext\clang_cl.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\cmake.bat"
[DEBUG:ext\cmake.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\ConnectionManagerExe.bat"
[DEBUG:ext\ConnectionManagerExe.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\diaghub.bat"
[DEBUG:ext\diaghub.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\html_help.bat"
[DEBUG:ext\html_help.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\netfxsdk.bat"
[DEBUG:ext\netfxsdk.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\perf_tools.bat"
[DEBUG:ext\perf_tools.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\roslyn.bat"
[DEBUG:ext\roslyn.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\team_explorer.bat"
[DEBUG:ext\team_explorer.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\testwindow.bat"
[DEBUG:ext\testwindow.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\vcpkg.bat"
[DEBUG:ext\vcpkg.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] calling "ext\vcvars.bat"
[DEBUG:ext\vcvars.bat] VCToolsVersion = "14.44.35207"
[DEBUG:ext\vcvars.bat] IFCPATH was not modified. IFCPATH already set: "C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\ifc\x64".
[DEBUG:ext\vcvars.bat] init:COMPLETE
[DEBUG:VsDevCmd.bat] Sending telemetry
[DEBUG:core\vsdevcmd_end] initializing with arguments ''
[DEBUG:VsDevCmd] Writing post-execution environment to C:\Users\yorke\AppData\Local\Temp\dd_vsdevcmd17_env.log
```

Consider, test
* C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\bin\Hostx86\x86
* cmake -S src -B bld -G "Ninja" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_COMPILER="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx86/x86/cl.exe" -DCMAKE_C_COMPILER="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx86/x86/cl.exe" -DCMAKE_LINKER="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx86/x86/link.exe"
```
C:\Users\yorke\Documents\dev\cmake>cmake -S src -B bld -G "Ninja" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_COMPILER="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx86/x86/cl.exe" -DCMAKE_C_COMPILER="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx86/x86/cl.exe" -DCMAKE_LINKER="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx86/x86/link.exe"
-- The C compiler identification is MSVC 19.44.35216.0
-- The CXX compiler identification is MSVC 19.44.35216.0
-- Detecting C compiler ABI info
-- Detecting C compiler ABI info - failed
-- Check for working C compiler: C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx86/x86/cl.exe
-- Check for working C compiler: C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx86/x86/cl.exe - broken
CMake Error at C:/Program Files/CMake/share/cmake-3.28/Modules/CMakeTestCCompiler.cmake:67 (message):
  The C compiler

    "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.44.35207/bin/Hostx86/x86/cl.exe"

  is not able to compile a simple test program.

  It fails with the following output:

    Change Dir: 'C:/Users/yorke/Documents/dev/cmake/bld/CMakeFiles/CMakeScratch/TryCompile-cjjy3f'

    Run Build Command(s): C:/Users/yorke/Documents/env/ninja-win/ninja.exe -v cmTC_a7ee9
    [1/2] C:\PROGRA~1\MICROS~3\2022\COMMUN~1\VC\Tools\MSVC\1444~1.352\bin\Hostx86\x86\cl.exe  /nologo   /DWIN32 /D_WINDOWS /W3  /MDd /Zi /Ob0 /Od /RTC1 /showIncludes /FoCMakeFiles\cmTC_a7ee9.dir\testCCompiler.c.obj /FdCMakeFiles\cmTC_a7ee9.dir\ /FS -c C:\Users\yorke\Documents\dev\cmake\bld\CMakeFiles\CMakeScratch\TryCompile-cjjy3f\testCCompiler.c
    [2/2] C:\WINDOWS\system32\cmd.exe /C "cd . && "C:\Program Files\CMake\bin\cmake.exe" -E vs_link_exe --intdir=CMakeFiles\cmTC_a7ee9.dir --rc=C:\PROGRA~2\WI3CF2~1\10\bin\100261~1.0\x86\rc.exe --mt=C:\PROGRA~2\WI3CF2~1\10\bin\100261~1.0\x86\mt.exe --manifests  -- C:\PROGRA~1\MICROS~3\2022\COMMUN~1\VC\Tools\MSVC\1444~1.352\bin\Hostx86\x86\link.exe /nologo CMakeFiles\cmTC_a7ee9.dir\testCCompiler.c.obj  /out:cmTC_a7ee9.exe /implib:cmTC_a7ee9.lib /pdb:cmTC_a7ee9.pdb /version:0.0 /machine:x64  /debug /INCREMENTAL /subsystem:console  kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib && cd ."
    FAILED: [code=4294967295] cmTC_a7ee9.exe
    C:\WINDOWS\system32\cmd.exe /C "cd . && "C:\Program Files\CMake\bin\cmake.exe" -E vs_link_exe --intdir=CMakeFiles\cmTC_a7ee9.dir --rc=C:\PROGRA~2\WI3CF2~1\10\bin\100261~1.0\x86\rc.exe --mt=C:\PROGRA~2\WI3CF2~1\10\bin\100261~1.0\x86\mt.exe --manifests  -- C:\PROGRA~1\MICROS~3\2022\COMMUN~1\VC\Tools\MSVC\1444~1.352\bin\Hostx86\x86\link.exe /nologo CMakeFiles\cmTC_a7ee9.dir\testCCompiler.c.obj  /out:cmTC_a7ee9.exe /implib:cmTC_a7ee9.lib /pdb:cmTC_a7ee9.pdb /version:0.0 /machine:x64  /debug /INCREMENTAL /subsystem:console  kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib && cd ."
    LINK Pass 1: command "C:\PROGRA~1\MICROS~3\2022\COMMUN~1\VC\Tools\MSVC\1444~1.352\bin\Hostx86\x86\link.exe /nologo CMakeFiles\cmTC_a7ee9.dir\testCCompiler.c.obj /out:cmTC_a7ee9.exe /implib:cmTC_a7ee9.lib /pdb:cmTC_a7ee9.pdb /version:0.0 /machine:x64 /debug /INCREMENTAL /subsystem:console kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib /MANIFEST /MANIFESTFILE:CMakeFiles\cmTC_a7ee9.dir/intermediate.manifest CMakeFiles\cmTC_a7ee9.dir/manifest.res" failed (exit code 1112) with the following output:
    CMakeFiles\cmTC_a7ee9.dir\testCCompiler.c.obj : fatal error LNK1112: module machine type 'x86' conflicts with target machine type 'x64'
    ninja: build stopped: subcommand failed.


  CMake will not be able to correctly generate this project.
Call Stack (most recent call first):
  CMakeLists.txt:12 (project)


-- Configuring incomplete, errors occurred!
```



### Step 1 - Clang toolchain


#### Visual Studio 17 2022 - generator
Success 

<todo: try>
```
cmake -S ./src -B ./bld-clg-vsc -G "Visual Studio 17 2022" -T ClangCL -A x64
```

Precursors
* Install CMake, standalone, Necessary, unclear if this is being used or Visual Studio 2022 Community CMake seperate install, see Notes above
* Install Visual Studio 2022 Community, Necessary for CMake to make Visual Studio 17 2022 default generator option, otherwise NMake is Windows default generator
* Install Windows SDK 10.0.26100.4948 for Windows 11. Windows 11 SDK, Don't know if this was necessary or not
* New command prompt, cmd shell, no environement variable setup scripts were run, cmd shell used as default when newly opened

Directory contents of dev env before build
```
C:\Users\yorke\Documents\dev\cmake>dir
 Volume in drive C has no label.
 Volume Serial Number is 7EE5-8235

 Directory of C:\Users\yorke\Documents\dev\cmake

17/09/2025  15:08    <DIR>          .
17/09/2025  15:08    <DIR>          ..
15/09/2025  13:57    <DIR>          bld
17/09/2025  15:12    <DIR>          bld-clg-nnj
12/09/2025  18:28    <DIR>          orig
18/09/2025  13:41            66,238 README.md
15/09/2025  09:17    <DIR>          src
               1 File(s)         66,238 bytes
               6 Dir(s)  755,735,846,912 bytes free
```

Consider, test
* generate binary directory and files
* cmake -S ./src -B ./bld-clg-vsc -G "Visual Studio 17 2022" -T ClangCL -A x64
* Success
```
C:\Users\yorke\Documents\dev\cmake>cmake -S ./src -B ./bld-clg-vsc -G "Visual Studio 17 2022" -T ClangCL -A x64
-- Selecting Windows SDK version 10.0.26100.0 to target Windows 10.0.19045.
-- The C compiler identification is Clang 19.1.5 with MSVC-like command-line
-- The CXX compiler identification is Clang 19.1.5 with MSVC-like command-line
-- Detecting C compiler ABI info
-- Detecting C compiler ABI info - done
-- Check for working C compiler: C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/Llvm/x64/bin/clang-cl.exe - skipped
-- Detecting C compile features
-- Detecting C compile features - done
-- Detecting CXX compiler ABI info
-- Detecting CXX compiler ABI info - done
-- Check for working CXX compiler: C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/Llvm/x64/bin/clang-cl.exe - skipped
-- Detecting CXX compile features
-- Detecting CXX compile features - done
-- Configuring done (9.7s)
-- Generating done (0.0s)
-- Build files have been written to: C:/Users/yorke/Documents/dev/cmake/bld-clg-vsc
```

Consider, test
* Dirctory structure after build
* shows build directory bld-clg-vsc created as generation command argument required
```
C:\Users\yorke\Documents\dev\cmake>dir
 Volume in drive C has no label.
 Volume Serial Number is 7EE5-8235

 Directory of C:\Users\yorke\Documents\dev\cmake

18/09/2025  13:49    <DIR>          .
18/09/2025  13:49    <DIR>          ..
15/09/2025  13:57    <DIR>          bld
17/09/2025  15:12    <DIR>          bld-clg-nnj
18/09/2025  13:49    <DIR>          bld-clg-vsc
12/09/2025  18:28    <DIR>          orig
18/09/2025  13:50            68,083 README.md
15/09/2025  09:17    <DIR>          src
               1 File(s)         68,083 bytes
               7 Dir(s)  755,734,089,728 bytes free
```

Consider, test
* Dirctory structure and contents of bld-clg-vsc directory
```
C:\Users\yorke\Documents\dev\cmake>cd bld-clg-vsc

C:\Users\yorke\Documents\dev\cmake\bld-clg-vsc>dir
 Volume in drive C has no label.
 Volume Serial Number is 7EE5-8235

 Directory of C:\Users\yorke\Documents\dev\cmake\bld-clg-vsc

18/09/2025  13:49    <DIR>          .
18/09/2025  13:49    <DIR>          ..
18/09/2025  13:49            46,439 ALL_BUILD.vcxproj
18/09/2025  13:49               293 ALL_BUILD.vcxproj.filters
18/09/2025  13:49            15,913 CMakeCache.txt
18/09/2025  13:49    <DIR>          CMakeFiles
18/09/2025  13:49             1,457 cmake_install.cmake
18/09/2025  13:49             3,116 Tutorial.sln
18/09/2025  13:49            55,891 Tutorial.vcxproj
18/09/2025  13:49               593 Tutorial.vcxproj.filters
18/09/2025  13:49            46,515 ZERO_CHECK.vcxproj
18/09/2025  13:49               538 ZERO_CHECK.vcxproj.filters
               9 File(s)        170,755 bytes
```

Consider, test
* build, executable
* cmake --build ./bld-clg-vsc
* Success
```
C:\Users\yorke\Documents\dev\cmake\bld-clg-vsc>cd ../

C:\Users\yorke\Documents\dev\cmake>cmake --build ./bld-clg-vsc
MSBuild version 17.14.23+b0019275e for .NET Framework

  1>Checking Build System
  Building Custom Rule C:/Users/yorke/Documents/dev/cmake/src/CMakeLists.txt
  Tutorial.vcxproj -> C:\Users\yorke\Documents\dev\cmake\bld-clg-vsc\Debug\Tutorial.exe
  Building Custom Rule C:/Users/yorke/Documents/dev/cmake/src/CMakeLists.txt
```

Consider, 
* show build directory structure after build
```
C:\Users\yorke\Documents\dev\cmake>cd bld-clg-vsc

C:\Users\yorke\Documents\dev\cmake\bld-clg-vsc>dir
 Volume in drive C has no label.
 Volume Serial Number is 7EE5-8235

 Directory of C:\Users\yorke\Documents\dev\cmake\bld-clg-vsc

18/09/2025  13:59    <DIR>          .
18/09/2025  13:59    <DIR>          ..
18/09/2025  13:49            46,439 ALL_BUILD.vcxproj
18/09/2025  13:49               293 ALL_BUILD.vcxproj.filters
18/09/2025  13:49            15,913 CMakeCache.txt
18/09/2025  13:59    <DIR>          CMakeFiles
18/09/2025  13:49             1,457 cmake_install.cmake
18/09/2025  13:59    <DIR>          Debug
18/09/2025  13:59    <DIR>          Tutorial.dir
18/09/2025  13:49             3,116 Tutorial.sln
18/09/2025  13:49            55,891 Tutorial.vcxproj
18/09/2025  13:49               593 Tutorial.vcxproj.filters
18/09/2025  13:59    <DIR>          x64
18/09/2025  13:49            46,515 ZERO_CHECK.vcxproj
18/09/2025  13:49               538 ZERO_CHECK.vcxproj.filters
               9 File(s)        170,755 bytes
               6 Dir(s)  755,735,199,744 bytes free
```

Consider,
* show Debug directory contents and structure as outcome of cmake build command
```
C:\Users\yorke\Documents\dev\cmake\bld-clg-vsc>cd Debug

C:\Users\yorke\Documents\dev\cmake\bld-clg-vsc\Debug>dir
 Volume in drive C has no label.
 Volume Serial Number is 7EE5-8235

 Directory of C:\Users\yorke\Documents\dev\cmake\bld-clg-vsc\Debug

18/09/2025  13:59    <DIR>          .
18/09/2025  13:59    <DIR>          ..
18/09/2025  13:59            21,504 Tutorial.exe
18/09/2025  13:59           487,424 Tutorial.pdb
               2 File(s)        508,928 bytes
               2 Dir(s)  755,736,584,192 bytes free
```

Consider, test
* run executable
* Success
* note, MS Calculator, Scientific, returns; 2.6457513110645905905016157536393
```
C:\Users\yorke\Documents\dev\cmake\bld-clg-vsc\Debug>cd ../../

C:\Users\yorke\Documents\dev\cmake>bld-clg-vsc\Debug\Tutorial.exe 7
The square root of 7 is 2.64575

```

#### Ninja - generator 1
* <todo: set cmd env for cmake to look for things not Visual Studio 2022 Community for cmake --build >
* <todo: read, LLVM Home | Documentation»User Guides »Building LLVM with CMake, link below References, >

<todo: try Ninja and clang>
* Use command line options -DCMAKE_C_COMPILER or -DCMAKE_CXX_COMPILER to set compiler instances for generator
```
cmake -S ./src -B ./bld-clg-nnj -G "Ninja Multi-Config" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_C_COMPILER="C:/Program Files/LLVM/bin/clang.exe" -DCMAKE_CXX_COMPILER="C:/Program Files/LLVM/bin/clang++.exe"
cmake --build ./bld-clg-nnj --config Release
```

Environmet setup
* Unix type OS's
* Not recommended
* Use cmake command line options instead, 
* However these env vars are recognised by CMake,  
```
$env:CC="C:\Program Files\LLVM\bin\clang.exe"
$env:CXX="C:\Program Files\LLVM\bin\clang++.exe"
```

Precursors
* Install CMake, <todo: note, haveing installed VS 2022 Community, has its cmake version corrupted standalone install? >
* Install Ninja
* LLMV install loation, C:\Program Files\LLVM\bin
* new cmd command prompt, likely will require some configuration of environment variables? 

Consider, test
* Command prompt - windows cmd version
* similar version number as Windows 10 SDK, SDK archive [WS](https://developer.microsoft.com/en-us/windows/downloads/sdk-archive/), 
* Windows 10 SDK, version 2004 (10.0.19041.0)	Released in conjunction with Windows 10, version 2004. Includes servicing updates 10.0.19041.5609. Updated 4/2/2025
* <todo: consider inatalling, or reinstalling Windows 10 SDK, version 2004 (10.0.19041.0) Includes servicing updates 10.0.19041.5609. Updated 4/2/2025 > 
```
C:\Users\yorke>cmd
Microsoft Windows [Version 10.0.19045.6332]
(c) Microsoft Corporation. All rights reserved.
```

Consider, test
* directory structure of test directory
```
C:\Users\yorke\Documents\dev\cmake>dir
 Volume in drive C has no label.
 Volume Serial Number is 7EE5-8235

 Directory of C:\Users\yorke\Documents\dev\cmake

15/09/2025  13:49    <DIR>          .
15/09/2025  13:49    <DIR>          ..
15/09/2025  13:57    <DIR>          bld
12/09/2025  18:28    <DIR>          orig
17/09/2025  13:31            52,435 README.md
15/09/2025  09:17    <DIR>          src
               1 File(s)         52,435 bytes
               5 Dir(s)  756,236,574,720 bytes free
```

Consider, test
* call to generate binaries and directory, Ninja Multi-Config generator, clang compiler, 
* consider, -D CMAKE_RC_COMPILER="llvm-rc", necessary otherwise returns error
```
CMake Error at C:/Program Files/CMake/share/cmake-3.28/Modules/Platform/Windows-Clang.cmake:135 (enable_language):
  No CMAKE_RC_COMPILER could be found.
 ```
* cmake -S ./src -B ./bld-clg-nnj -G "Ninja Multi-Config" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_C_COMPILER="C:/Program Files/LLVM/bin/clang.exe" -DCMAKE_CXX_COMPILER="C:/Program Files/LLVM/bin/clang++.exe" -D CMAKE_RC_COMPILER="llvm-rc"
* Success
```
C:\Users\yorke\Documents\dev\cmake>cmake -S ./src -B ./bld-clg-nnj -G "Ninja Multi-Config" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_C_COMPILER="C:/Program Files/LLVM/bin/clang.exe" -DCMAKE_CXX_COMPILER="C:/Program Files/LLVM/bin/clang++.exe" -D CMAKE_RC_COMPILER="llvm-rc"
-- The C compiler identification is Clang 18.1.8 with GNU-like command-line
-- The CXX compiler identification is Clang 18.1.8 with GNU-like command-line
-- Detecting C compiler ABI info
-- Detecting C compiler ABI info - done
-- Check for working C compiler: C:/Program Files/LLVM/bin/clang.exe - skipped
-- Detecting C compile features
-- Detecting C compile features - done
-- Detecting CXX compiler ABI info
-- Detecting CXX compiler ABI info - done
-- Check for working CXX compiler: C:/Program Files/LLVM/bin/clang++.exe - skipped
-- Detecting CXX compile features
-- Detecting CXX compile features - done
-- Configuring done (3.3s)
-- Generating done (0.0s)
-- Build files have been written to: C:/Users/yorke/Documents/dev/cmake/bld-clg-nnj
```

Consider, test
* list directory, bld-clg-nnj after Ninja Multi-Config generator call, 
```
C:\Users\yorke\Documents\dev\cmake\bld-clg-nnj>dir
 Volume in drive C has no label.
 Volume Serial Number is 7EE5-8235

 Directory of C:\Users\yorke\Documents\dev\cmake\bld-clg-nnj

17/09/2025  15:07    <DIR>          .
17/09/2025  15:07    <DIR>          ..
17/09/2025  15:07               587 build-Debug.ninja
17/09/2025  15:07               599 build-Release.ninja
17/09/2025  15:07               641 build-RelWithDebInfo.ninja
17/09/2025  15:07               549 build.ninja
17/09/2025  15:07            17,394 CMakeCache.txt
17/09/2025  15:07    <DIR>          CMakeFiles
17/09/2025  15:07             1,618 cmake_install.cmake
17/09/2025  15:07    <DIR>          Debug
17/09/2025  15:07    <DIR>          Release
17/09/2025  15:07    <DIR>          RelWithDebInfo
               6 File(s)         21,388 bytes
               6 Dir(s)  755,970,174,976 bytes free
```

Consider, test
* cmake --build ./bld-clg-nnj --config Release
* Fails, with error
```
C:\Users\yorke\Documents\dev\cmake>cmake --build ./bld-clg-nnj --config Release
[1/2] Building CXX object CMakeFiles/Tutorial.dir/Release/tutorial.cxx.obj
FAILED: [code=1] CMakeFiles/Tutorial.dir/Release/tutorial.cxx.obj
C:\PROGRA~1\LLVM\bin\CLANG_~1.EXE -DCMAKE_INTDIR=\"Release\"  -O3 -DNDEBUG -D_DLL -D_MT -Xclang --dependent-lib=msvcrt -MD -MT CMakeFiles/Tutorial.dir/Release/tutorial.cxx.obj -MF CMakeFiles\Tutorial.dir\Release\tutorial.cxx.obj.d -o CMakeFiles/Tutorial.dir/Release/tutorial.cxx.obj -c C:/Users/yorke/Documents/dev/cmake/src/tutorial.cxx
In file included from C:/Users/yorke/Documents/dev/cmake/src/tutorial.cxx:5:
In file included from C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\include\cmath:8:
In file included from C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\include\yvals.h:12:
C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\include\yvals_core.h:908:1: error: static assertion failed: error STL1000: Unexpected compiler version, expected Clang 19.0.0 or newer.
  908 | _EMIT_STL_ERROR(STL1000, "Unexpected compiler version, expected Clang 19.0.0 or newer.");
      | ^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\include\yvals_core.h:534:58: note: expanded from macro '_EMIT_STL_ERROR'
  534 | #define _EMIT_STL_ERROR(NUMBER, MESSAGE)   static_assert(false, "error " #NUMBER ": " MESSAGE)
      |                                                          ^~~~~
1 error generated.
ninja: build stopped: subcommand failed.
```

Consider, test
* call to generate binaries and directory, Ninja generator, clang compiler, 
* consider, -D CMAKE_RC_COMPILER="llvm-rc", necessary otherwise returns error
```
CMake Error at C:/Program Files/CMake/share/cmake-3.28/Modules/Platform/Windows-Clang.cmake:135 (enable_language):
  No CMAKE_RC_COMPILER could be found.
 ```
* cmake -S ./src -B ./bld-clg-nnj -G "Ninja" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_C_COMPILER="C:/Program Files/LLVM/bin/clang.exe" -DCMAKE_CXX_COMPILER="C:/Program Files/LLVM/bin/clang++.exe" -D CMAKE_RC_COMPILER="llvm-rc"
* Success
```
C:\Users\yorke\Documents\dev\cmake>cmake -S ./src -B ./bld-clg-nnj -G "Ninja" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe" -DCMAKE_C_COMPILER="C:/Program Files/LLVM/bin/clang.exe" -DCMAKE_CXX_COMPILER="C:/Program Files/LLVM/bin/clang++.exe" -D CMAKE_RC_COMPILER="llvm-rc"
-- The C compiler identification is Clang 18.1.8 with GNU-like command-line
-- The CXX compiler identification is Clang 18.1.8 with GNU-like command-line
-- Detecting C compiler ABI info
-- Detecting C compiler ABI info - done
-- Check for working C compiler: C:/Program Files/LLVM/bin/clang.exe - skipped
-- Detecting C compile features
-- Detecting C compile features - done
-- Detecting CXX compiler ABI info
-- Detecting CXX compiler ABI info - done
-- Check for working CXX compiler: C:/Program Files/LLVM/bin/clang++.exe - skipped
-- Detecting CXX compile features
-- Detecting CXX compile features - done
-- Configuring done (2.7s)
-- Generating done (0.0s)
-- Build files have been written to: C:/Users/yorke/Documents/dev/cmake/bld-clg-nnj
```

Consider, test
* list directory, bld-clg-nnj after Ninja generator call, 
```
C:\Users\yorke\Documents\dev\cmake\bld-clg-nnj>dir
 Volume in drive C has no label.
 Volume Serial Number is 7EE5-8235

 Directory of C:\Users\yorke\Documents\dev\cmake\bld-clg-nnj

17/09/2025  15:01    <DIR>          .
17/09/2025  15:01    <DIR>          ..
17/09/2025  15:01            22,831 build.ninja
17/09/2025  15:01            17,281 CMakeCache.txt
17/09/2025  15:01    <DIR>          CMakeFiles
17/09/2025  15:01             1,616 cmake_install.cmake
               3 File(s)         41,728 bytes
               3 Dir(s)  755,973,996,544 bytes free
```

Consider, test
* cmake --build ./bld-clg-nnj
* Fails, with error
* why is it including Visual Studio 2022 Community files? what system env vars are directing cmake to VS2022C?
```
C:\Users\yorke\Documents\dev\cmake>cmake --build ./bld-clg-nnj
[1/2] Building CXX object CMakeFiles/Tutorial.dir/tutorial.cxx.obj
FAILED: [code=1] CMakeFiles/Tutorial.dir/tutorial.cxx.obj
C:\PROGRA~1\LLVM\bin\CLANG_~1.EXE   -O0 -g -Xclang -gcodeview -D_DEBUG -D_DLL -D_MT -Xclang --dependent-lib=msvcrtd -MD -MT CMakeFiles/Tutorial.dir/tutorial.cxx.obj -MF CMakeFiles\Tutorial.dir\tutorial.cxx.obj.d -o CMakeFiles/Tutorial.dir/tutorial.cxx.obj -c C:/Users/yorke/Documents/dev/cmake/src/tutorial.cxx
In file included from C:/Users/yorke/Documents/dev/cmake/src/tutorial.cxx:5:
In file included from C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\include\cmath:8:
In file included from C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\include\yvals.h:12:
C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\include\yvals_core.h:908:1: error: static assertion failed: error STL1000: Unexpected compiler version, expected Clang 19.0.0 or newer.
  908 | _EMIT_STL_ERROR(STL1000, "Unexpected compiler version, expected Clang 19.0.0 or newer.");
      | ^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.44.35207\include\yvals_core.h:534:58: note: expanded from macro '_EMIT_STL_ERROR'
  534 | #define _EMIT_STL_ERROR(NUMBER, MESSAGE)   static_assert(false, "error " #NUMBER ": " MESSAGE)
      |                                                          ^~~~~
1 error generated.
ninja: build stopped: subcommand failed.
```

Consider, text, try, based on success of 'Visual Studio 17 2022 - generator'
* -A x64, Ninja does not support platform specification
*-T ClangCL, Ninja does not support toolset specification,
* conslusion; Ninja does not appear to suppport these command line options 
* Failed
```
cmake -S ./src -B ./bld-clg-nnj -G "Ninja" -DCMAKE_MAKE_PROGRAM="C:/Users/yorke/Documents/env/ninja-win/ninja.exe"  
```


### Step 1 - GCC toolchain


### Step 1 - ARM toolchain




## References

Documents
* LLVM Home | Documentation»User Guides »Building LLVM with CMake, org [WS](https://llvm.org/docs/CMake.html), LLVM
* LLVM Home | Documentation»Getting Started/Tutorials »Getting Started with the LLVM System, org [WS](https://llvm.org/docs/GettingStarted.html), LLVM

News Papers - linkers
* CMake: use a custom linker, [WS](https://stackoverflow.com/questions/1867745/cmake-use-a-custom-linker), asked Dec 8, 2009, edited May 12, 2024, StackOverflow, 
* `CMAKE_LINKER` does not do what it is thought to do, [GL](https://gitlab.kitware.com/cmake/cmake/-/issues/24990), 10 Jun 2023, Cristian Le, CMake CMake Issues #24990

News Papers - SDK
* How do I install Windows 10 SDK for use with Visual Studio 2017, [WS](https://stackoverflow.com/questions/50590700/how-do-i-install-windows-10-sdk-for-use-with-visual-studio-2017), StackOverflow, 
* How to get installed Windows SDK version? [WS](https://stackoverflow.com/questions/2665755/how-to-get-installed-windows-sdk-version)
* ...

News Papers - environment variables
* Why does CMake ignore exported CXX and CC environment variables?, [WS](https://stackoverflow.com/questions/37787796/why-does-cmake-ignore-exported-cxx-and-cc-environment-variables), stackoverflow
* How run clang from command line on Windows? [WS](https://stackoverflow.com/questions/18711595/how-run-clang-from-command-line-on-windows), Stackoverflow
* ...

News Papers - compilers
* CMake Error: No CMAKE_RC_COMPILER could be found, [WS](https://stackoverflow.com/questions/72152658/cmake-error-no-cmake-rc-compiler-could-be-found)
* Ninja: No CMAKE_RC_COMPILER could be found, [WS](https://stackoverflow.com/questions/57226146/ninja-no-cmake-rc-compiler-could-be-found), 
* Windows: No CMAKE_RC_COMPILER could be found #1660 [GH](https://github.com/google/filament/issues/1660), google/filament Public
* ...


