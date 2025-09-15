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
* <todo: consider, consider install earlier Windows 10 SDK, >

DONE
* <done: consider, intent to commit>
* <done: consider, windows toolchain build, on windows host, wip >
* <done: consider, windows toolchain, rerun as is with errors to reflect new directory structure /src /bld source directory and build directory respectively>
* <done: consider, include link to tutorial page.>
* <done: consider, reduced directory depth, move for evaulation, /dev/cmake >
* <done: consider, environment set up script, C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Auxiliary/Build/vcvarsall.bat, but with SDK errors, >

## Output

### Step 1 - Windows toolchain
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



### Step 1 - Clang toolchain


### Step 1 - GCC toolchain


### Step 1 - ARM toolchain




## References

News Papers - linkers
* CMake: use a custom linker, [WS](https://stackoverflow.com/questions/1867745/cmake-use-a-custom-linker), asked Dec 8, 2009, edited May 12, 2024, StackOverflow, 
* `CMAKE_LINKER` does not do what it is thought to do, [GL](https://gitlab.kitware.com/cmake/cmake/-/issues/24990), 10 Jun 2023, Cristian Le, CMake CMake Issues #24990

News Papers - SDK
* How do I install Windows 10 SDK for use with Visual Studio 2017, [WS](https://stackoverflow.com/questions/50590700/how-do-i-install-windows-10-sdk-for-use-with-visual-studio-2017), StackOverflow, 
* How to get installed Windows SDK version? [WS](https://stackoverflow.com/questions/2665755/how-to-get-installed-windows-sdk-version)
* ...

