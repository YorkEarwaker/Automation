# CMake Pro Part 1

Notes on Part 1 free download of

Professional CMake: A Practical Guide
21st Edition
ISBN 978-1-925904-36-9
© 2018-2025 by Craig Scott [WS](https://crascit.com/professional-cmake/)

Taking, typing, the notes helps to secure it to memory. Toward C/C++ build capability for the Anthropogenic Global Warming AGW project.

These notes are taken using the following CMake version to test/query against;
```
cmake --version
cmake version 3.28.1

CMake suite maintained and supported by Kitware (kitware.com/cmake).
```

## Chapter 1 - Introduction

### CMake pipeline

The CMake toolchain pipeline high level context view.

| CMake                    |       | CTest | CPack   |
| :----------------------- | :---- | :---- | :------ |
| Project file generation  | Build | Test  | Package |
| Configure -> Generate    |       |       |         |

## Chapter 2 - Setting Up A Project

CMakeLists.txt file. Platform independent description of project. The file controls setup and build for the project.

Directories
* Source directory, contains CMakeLists.txt file and source code files, C/C++, Fortan, ...
* Binary directory, contains build artifacts and binary code files, machine code

The binary directory is the build directory. Binary directory CMake terminology, Build directory developer terminology common use. 

Things that create files in the build directory.
* CMake, build tool - aka generator or command runner - used by CMake; make, Ninja, 
* CTest
* CPack

Things that are created in the build directory
* Executables, libraries
* Test output
* Packages
* CMakeCache.txt

Recomended directory structure, out of source build
* Project_Name - base directory - top level - created by developer
* - src - source directory - second level - created by developer
* - - CMakeLists.txt - created by developer
* - - ... source files - nested directory structure, e.g. org/agw/nwp - created by developer
* - bld - build directory aka binary directory - second level - created by CMake toolchain
* - - CMakeCache.txt - created by CMake toolchain
* - - ... build output files - nested directory structure, - created by CMake toolchain

One source folder to rule them all. That is one source folder and multiple different build folders. Depending on modifications to CMakeLists.txt entries and to command line variables and environment variables. So that binary builds might be created for multiple target architecturs. And multiple binary builds for a single target architecture but where the builds differ say for optimal performance or greater modularity or best backward compatibility and so on. Utilising different pipeline toolchains for example for different DevSecOps scenarios and so on.

So there might be CMakeLists.txt varients and cmake command line varients which stipulate;
* -B ./bld or -B ./bld_win_32  or -B ./bld_win_64 or -B ./bld_aix or -B ./bld_lnx_64 or -B ./bld_arm_A or -B ./bld_arm_R or -B ./bld_arm_M and so on.
* -B ./bld_prd or -B ./bld_qa or -B ./bld_tst or -B ./bld_dev and so on.
* -B ./bld_dbg or -B ./bld_rel and so on.
* -B ./bld_gov_nhs or -B ./bld_gov_mod or -B ./bld_gov_doe or -B ./bld_gov_ho or -B ./bld_gov_fo or -B ./bld_gov_co and so on. In a UK government context.
* Business function or Business domain or Market A or Market B or Product X or Product Y or Module P or Module Q and so on.
* or by any number of other categorisation.

One use case for multi configuration would be benchmarking. For example a generic vanilla build vs a bespoke architecture tweaked build. Which tweeks get the best performance but at what additional cost. Considering no change/delta to the source code base.
* <todo: consider using different work to teaked above as it has a specific meaning in CMake versioning, >

Common generators, command runners, 

| Category      | Generator          | Multi config |
| :------------ | :----------------: | -----------: |
| Visual Studio | Visual Studio 2022 | Yes          |
|               | Visual Studio 2019 |              |
| Xcode         | Xcode              | Yes          |
| Ninja         | Ninja              | No           |
|               | Ninja Multi-Config | Yes          |
| Makefiles     | Unix Makefiles     | No           |
|               | NMake Makefiles    |              |

See Appendix A, running cmake --help on the command line lists the generators that CMake has the capability to use if they are avialble on the host machine CMake is installed on.

<todo: consider, more detail on mulit-config options, >

Command line, CMakeLists.txt entries, environment variables
* cmake -G "Ninja Multi-Config" -B bld - the simplest manner to call CMake via the command line, stating name of generator by passing the -G , and the build directory name and location with cli option -B .
* CMAKE_GENERATOR - the environment variable to set a default generator, otherwise it defaults to the hosts platform default,

Output of successful build ends with
```
-- Configuring done
-- Generating done
-- Build files have been written to: /some/path/build
```

Assuming the environment has been setup as necessary a bare bones simple example follows.

Project binary file generation - simple example
* cmake -G "Ninja" -B bld 

Build tool use - simple example
* cmake --build /path/to/build --config Debug --target AGW_App


## Chapter 3 - Minimal Project

Bare bones basic CMakeLists.txt file contents with three CMake commands.
```
cmake_minimum_required(VERSION 3.2)
project(AGW_App)
add_executable(AGW_Exe main.cpp)
```
Arguments to commands are space separated. Arguments to commands my run over several lines.
```
add_executable(AGW_Exe
				main.cpp
				src01.cpp
				src02.cpp)
```
CMake commands are not case sensitive. The following are the same and don't result in different outcomes or errors.
```
cmake_minimum_required(VERSION 3.2)
CMake_Minimum_Required(VERSION 3.2)
cmAKE_minIMUm_reQuiReD(VERSION 3.2)
CMAKE_MINIMUM_REQUIRED(VERSION 3.2)
```
But convension is to use all lower case for commands. It is also the CMake documentation standard to use lower case for commands.

CMake profiles 
* <todo: consider, further investigation of CMake profiles, CMake versions, >

CMakeLists.txt command arguments.
```
# must always be first command in any CMakeLists.txt file
cmake_minimum_required(VERSION major.minor[.patch[.tweak]])

# must appear in CMakeLists.txt file often second command. 
project(projectName
        [VERSION major.minor[.patch[.tweak]]]
		[LANGUAGES languageName ...])
		
# must appear in CMakesLists.txt file often third command. There may be more than one. 
# A seperate executable will be created for each such comand line.
# The targetName is used as an identifier throughout the CMakeLists.txt file.
add_executable(targetName source01 [source02 ...])
```

Comments in the CMakeLists.txt file. Line comments start with a hash # sign. Everything on the line after the hash/pound sign # is considered a comment. Block comments start with #[==[ and end with a matching brackets and equal signs ]==] . There may be no equals sign characters or several but the start and end must have the same number.

Example CMakes file with line comments and block comments. See Appendix B for thoughts on starter for ten on AGW CMakeListes.txt file. 
* <todo: consider, replacing with a simpler generic example, Overly complex for a simple vanilla example >
```
cmake_minimum_required(VERSION 3.2)

# Won't be using C++ compiler, so ensure the project command does not attempt to find one otherwise it will fail 
# if one cannot be found. No point failing unecessarily if all that is needed is the C compiler.
project(AGW_App VERSION 1.5.9 LANGUAGES C)

# The core functional capability for this tool set
# Weather Station tooling
add_executable(WS_Sensors
    main.c 
	sensors.c
	debug.c)

# A diagnostic tool for development and testing
# To be basis of diagnositic support tool
add_executable(WS_Sensors_Tester
    sensorTester.c )
				
# The following tools are not ready yet so disable them all with a block comment
#[=[
# Data logger functional capability for this tool set
# Weather Station tooling
add_executable(WS_DataLogger 
   dataLogger.c
   sdcard.c
   ssd.c)
	
# Numerical Weather Prediction capability for this tool set
# Climate Model tooling
add_executable(CM_NWP
    grid.c 
	profile.c )
]=]
```

Good practice is to use Semantic Versioning for project command VERSION argument Major.Minor.Patch see link in references section.

## Chapter 4 - Building Simple Targets

CMake permits the developer define several different library types and executable types some platform specific for Apple and Linux and Windows. 

Executables. A more complete form of the command definition of add_executable() for executables.
```
add_executable(targetName [WIN32] [MACOSX_BUNDLE]
               [EXCLUDE_FROM_ALL]
			   source01, [source02 ...])
```

An example of more complete form of add_executable in CMakeLists.txt file format.
```
# Main GUI app built as part of the default "ALL" target
add_executable(AGW_App WIN32 MACOSX_BUNDLE
    main.cpp
	widgets.cpp
	)

# Command line tools for testing and diagnostics
add_executable(checker checker.cpp EXCLUDE_FROM_ALL)
add_executable(reporter reporter.cpp EXCLUDE_FROM_ALL)
```

Calls in the command line interface cli shell.

Given CMakeLists.txt above will only build the app.
```
cmake --build /path/to/build
```
Given CMakeLists.txt above will build the helper tool.
```
cmake --build /path/to/build --target checker
```

Libraries. A command defintion in simplest basic form for add_library() for libraries. 
```
add_library(targetName [STATIC | SHARED | MODULE]
             [EXCLUDE_FROM_ALL]
			 source01 [sourc02 ...])
```
* STATIC - default name on
* - Windows; targetName.lib 
* - Unix like; libtargetName.a 
* SHARED - default name on
* - Windows; targetName.dll
* - Apple; libtargetName.dylib
* - other Unix like; libtargetName.so 
* MODULE - 
* - plugins or optional components

Common practice to omit STATIC SHARED MODULE values and to leave it to the developer on the command line. If BUILD_SHARED_LIBS = YES then a shared libarary is built otherwise a static library is built.
```
cmake -DBUILD_SHARED_LIBS=YES -B /path/to/build 
```

It might be set in the CMakeLists.txt file but would then require the developer to modify it. So easier to leave it to the command line request. Set in CMakeLists.txt file above add_library() command statements.
```
set(BUILD_SHARED_LIBS YES)
```

Linking targets. Library dependency management.
* PRIVATE
* PUBLIC
* INTERFACE

The target_link_libraries() command. 
```
target_link_libraries(targetName
    <PRIVATE|PUBLIC|INTERFACE> item01 [item02 ...]
	[<PRIVATE|PUBLIC|INTERFACE> item03 [item04 ...]])
```

In a partial CMakeLists.txt example
```
add_library(Collector src01.cpp)
add_library(Aldo src02.cpp)
add_library(Engine src03.cpp)
add_library(Ui src04.cpp)

target_link_libraries(Collector
    PUBLIC Ui
	PRIVATE Algo Engine
	) 
	
target_link_libraries(MyApp PRIVATE Collector)

```

Linking Non targets. 
* Full path to library file
* Plain library name
* Link flag

The target_link_libraries() command linking to libraries other than targets defined by targetName in the CMakeLists.txt file.

The project name and target names are not the same thing. There is a one to many relationship between a project and targets within it . A project as it matures will likely have more than one target. Good practice is to use different values for the project name and the target names in commands like add_executable() add_library() and so on. Choose target names related to the capability/behaviour of the thing. Important good practice in preparation for projects which are multi-target. 

## Chapter 5 - Basic Testing and Deployment

Testing, a seperate command line tool ctest is provided with CMake.

A project with some test cases as a minimal example.
```
cmake_minimum_required(VERSION 3.19)
project(AGW_Proj VERSION 0.1.9) # projectName = AGW_Proj, Major = 0, Minor = 1, Patch = 9

enable_testing() # as a general heuristic, call just after project, entry point for ctest

add_executable(testSomeAGW_thing testSomeAGW_thing.cpp) # targetName = testSomeAGW_thing 

add_test(NAME SomeAGW_thingWorks COMMAND testSomeAGW_thing) # the target = testSomeAGW_thing
add_test(NAME ExternalTool COMMAND /path/to/tool anArg anOtherArg yetAnOtherArg ...)
```
Exit code of 0 for test pass success. Other codes may be returned.

Steps to configure, build, and test a project.
```
cmake -G Ninja -B build -DCMAKE_BUILD_TYPE=Debug
cd Build
cmake --build .
ctest
```
For multi-configuration generators like Xcode, Visual Studio, Ninja Multi-Config .
```
cmake -G "Ninja Multi-Config" -B Build
cd Build
cmake --build . --config Debug
ctest --build-config debug # -C can be used with ctest command instead of longer --build-config for convenience
```

Non trivial tests that may take a long time to run can be run in parallel. The number after the key word states how many tests may be run at the same time.
```
ctest --paralell 16 # the reduced -j option can be used in place of --paralell
```
A test may be allocated more than one CPU in some more complex, compute intensive or multi threaded or other, tests. Output from ctest is sparse and concise. Full output can be achived using -V or --verbose option, for output for only failed tests --output-on-failure . 

Installing. Copy things from the biuld directory and possibly also the source directory to deployment location. 

Minimal install() example. For CMake 3.14 or greater.
```
cmake_minimum_required(VERSION 3.15)
project(AGW_Proj VERSION 0.1.9)

add_executable(AGW_App ...)
add_library(Cm_Nwp SHARED ...) # numerical weather prediction
add_library(Cm_Ema_SDK STATIC ...) # extreme meteorological attribution 

# this concise form requires CMake 3.14 or greater
install(TARGETS AGW_App Cm_Nwp Cm_Ema_SDK)
```
CMake 3.14 or greater will use default install locations for Unix and Windows, Apple bundles/frameworks differ. Default installed to subdidirectories below the base install location. In Window DLL's are stored in bin rather than lib.
* Executables to bin subdirectory
* Libraries to lib subdirectory 
* Headers to include subdirectory

CMake 3.13 and earlier form of install explicitly states directories. 
```
install(TARGETS AGW_App Cm_Nwp Cm_Ema_SDK
    RUNTIME DESTINATION bin
	LIBRARY DESTINATION lib
	ARCHIVE DESTINATION lib
	)
```
<todo: other examples not copied here>

Example to configure, build and install a project.
```
cmake -G Ninja -B build -DCMAKE_BUILD_TYPE=Debug
cd build
cmake --build .
cmake --install . prefix /path/to/somewhere
```

Multi-configuration generators are available for install too as they are for test. 
```
cmake -G "Ninja Multi-Config" -B build
cd build
cmake --build . --config Debug
cmake --install . --config Debug --prefix /path/to/somewhere
```

Packaging. 


## Appendix A
Command line help option for cmake. The stared option in the output is the default for the platform. On windows it defaults to NMake. On windows it defaults to Visual Studio XXXX if it is installed .

```
cmake --help
Usage

  cmake [options] <path-to-source>
  cmake [options] <path-to-existing-build>
  cmake [options] -S <path-to-source> -B <path-to-build>

Specify a source directory to (re-)generate a build system for it in the
current working directory.  Specify an existing build directory to
re-generate its build system.

Options
  -S <path-to-source>          = Explicitly specify a source directory.
  -B <path-to-build>           = Explicitly specify a build directory.
  -C <initial-cache>           = Pre-load a script to populate the cache.
  -D <var>[:<type>]=<value>    = Create or update a cmake cache entry.
  -U <globbing_expr>           = Remove matching entries from CMake cache.
  -G <generator-name>          = Specify a build system generator.
  -T <toolset-name>            = Specify toolset name if supported by
                                 generator.
  -A <platform-name>           = Specify platform name if supported by
                                 generator.
  --toolchain <file>           = Specify toolchain file
                                 [CMAKE_TOOLCHAIN_FILE].
  --install-prefix <directory> = Specify install directory
                                 [CMAKE_INSTALL_PREFIX].
  -Wdev                        = Enable developer warnings.
  -Wno-dev                     = Suppress developer warnings.
  -Werror=dev                  = Make developer warnings errors.
  -Wno-error=dev               = Make developer warnings not errors.
  -Wdeprecated                 = Enable deprecation warnings.
  -Wno-deprecated              = Suppress deprecation warnings.
  -Werror=deprecated           = Make deprecated macro and function warnings
                                 errors.
  -Wno-error=deprecated        = Make deprecated macro and function warnings
                                 not errors.
  --preset <preset>,--preset=<preset>
                               = Specify a configure preset.
  --list-presets[=<type>]      = List available presets.
  -E                           = CMake command mode.
  -L[A][H]                     = List non-advanced cached variables.
  --fresh                      = Configure a fresh build tree, removing any
                                 existing cache file.
  --build <dir>                = Build a CMake-generated project binary tree.
  --install <dir>              = Install a CMake-generated project binary
                                 tree.
  --open <dir>                 = Open generated project in the associated
                                 application.
  -N                           = View mode only.
  -P <file>                    = Process script mode.
  --find-package               = Legacy pkg-config like mode.  Do not use.
  --graphviz=<file>            = Generate graphviz of dependencies, see
                                 CMakeGraphVizOptions.cmake for more.
  --system-information [file]  = Dump information about this system.
  --log-level=<ERROR|WARNING|NOTICE|STATUS|VERBOSE|DEBUG|TRACE>
                               = Set the verbosity of messages from CMake
                                 files.  --loglevel is also accepted for
                                 backward compatibility reasons.
  --log-context                = Prepend log messages with context, if given
  --debug-trycompile           = Do not delete the try_compile build tree.
                                 Only useful on one try_compile at a time.
  --debug-output               = Put cmake in a debug mode.
  --debug-find                 = Put cmake find in a debug mode.
  --debug-find-pkg=<pkg-name>[,...]
                               = Limit cmake debug-find to the
                                 comma-separated list of packages
  --debug-find-var=<var-name>[,...]
                               = Limit cmake debug-find to the
                                 comma-separated list of result variables
  --trace                      = Put cmake in trace mode.
  --trace-expand               = Put cmake in trace mode with variable
                                 expansion.
  --trace-format=<human|json-v1>
                               = Set the output format of the trace.
  --trace-source=<file>        = Trace only this CMake file/module.  Multiple
                                 options allowed.
  --trace-redirect=<file>      = Redirect trace output to a file instead of
                                 stderr.
  --warn-uninitialized         = Warn about uninitialized values.
  --no-warn-unused-cli         = Don't warn about command line options.
  --check-system-vars          = Find problems with variable usage in system
                                 files.
  --compile-no-warning-as-error= Ignore COMPILE_WARNING_AS_ERROR property and
                                 CMAKE_COMPILE_WARNING_AS_ERROR variable.
  --profiling-format=<fmt>     = Output data for profiling CMake scripts.
                                 Supported formats: google-trace
  --profiling-output=<file>    = Select an output path for the profiling data
                                 enabled through --profiling-format.
  -h,-H,--help,-help,-usage,/? = Print usage information and exit.
  --version,-version,/V [<file>]
                               = Print version number and exit.
  --help <keyword> [<file>]    = Print help for one keyword and exit.
  --help-full [<file>]         = Print all help manuals and exit.
  --help-manual <man> [<file>] = Print one help manual and exit.
  --help-manual-list [<file>]  = List help manuals available and exit.
  --help-command <cmd> [<file>]= Print help for one command and exit.
  --help-command-list [<file>] = List commands with help available and exit.
  --help-commands [<file>]     = Print cmake-commands manual and exit.
  --help-module <mod> [<file>] = Print help for one module and exit.
  --help-module-list [<file>]  = List modules with help available and exit.
  --help-modules [<file>]      = Print cmake-modules manual and exit.
  --help-policy <cmp> [<file>] = Print help for one policy and exit.
  --help-policy-list [<file>]  = List policies with help available and exit.
  --help-policies [<file>]     = Print cmake-policies manual and exit.
  --help-property <prop> [<file>]
                               = Print help for one property and exit.
  --help-property-list [<file>]= List properties with help available and
                                 exit.
  --help-properties [<file>]   = Print cmake-properties manual and exit.
  --help-variable var [<file>] = Print help for one variable and exit.
  --help-variable-list [<file>]= List variables with help available and exit.
  --help-variables [<file>]    = Print cmake-variables manual and exit.

Generators

The following generators are available on this platform (* marks default):
* Visual Studio 17 2022        = Generates Visual Studio 2022 project files.
                                 Use -A option to specify architecture.
  Visual Studio 16 2019        = Generates Visual Studio 2019 project files.
                                 Use -A option to specify architecture.
  Visual Studio 15 2017 [arch] = Generates Visual Studio 2017 project files.
                                 Optional [arch] can be "Win64" or "ARM".
  Visual Studio 14 2015 [arch] = Generates Visual Studio 2015 project files.
                                 Optional [arch] can be "Win64" or "ARM".
  Visual Studio 12 2013 [arch] = Deprecated.  Generates Visual Studio 2013
                                 project files.  Optional [arch] can be
                                 "Win64" or "ARM".
  Visual Studio 9 2008 [arch]  = Deprecated.  Generates Visual Studio 2008
                                 project files.  Optional [arch] can be
                                 "Win64" or "IA64".
  Borland Makefiles            = Generates Borland makefiles.
  NMake Makefiles              = Generates NMake makefiles.
  NMake Makefiles JOM          = Generates JOM makefiles.
  MSYS Makefiles               = Generates MSYS makefiles.
  MinGW Makefiles              = Generates a make file for use with
                                 mingw32-make.
  Green Hills MULTI            = Generates Green Hills MULTI files
                                 (experimental, work-in-progress).
  Unix Makefiles               = Generates standard UNIX makefiles.
  Ninja                        = Generates build.ninja files.
  Ninja Multi-Config           = Generates build-<Config>.ninja files.
  Watcom WMake                 = Generates Watcom WMake makefiles.
  CodeBlocks - MinGW Makefiles = Generates CodeBlocks project files
                                 (deprecated).
  CodeBlocks - NMake Makefiles = Generates CodeBlocks project files
                                 (deprecated).
  CodeBlocks - NMake Makefiles JOM
                               = Generates CodeBlocks project files
                                 (deprecated).
  CodeBlocks - Ninja           = Generates CodeBlocks project files
                                 (deprecated).
  CodeBlocks - Unix Makefiles  = Generates CodeBlocks project files
                                 (deprecated).
  CodeLite - MinGW Makefiles   = Generates CodeLite project files
                                 (deprecated).
  CodeLite - NMake Makefiles   = Generates CodeLite project files
                                 (deprecated).
  CodeLite - Ninja             = Generates CodeLite project files
                                 (deprecated).
  CodeLite - Unix Makefiles    = Generates CodeLite project files
                                 (deprecated).
  Eclipse CDT4 - NMake Makefiles
                               = Generates Eclipse CDT 4.0 project files
                                 (deprecated).
  Eclipse CDT4 - MinGW Makefiles
                               = Generates Eclipse CDT 4.0 project files
                                 (deprecated).
  Eclipse CDT4 - Ninja         = Generates Eclipse CDT 4.0 project files
                                 (deprecated).
  Eclipse CDT4 - Unix Makefiles= Generates Eclipse CDT 4.0 project files
                                 (deprecated).
  Kate - MinGW Makefiles       = Generates Kate project files (deprecated).
  Kate - NMake Makefiles       = Generates Kate project files (deprecated).
  Kate - Ninja                 = Generates Kate project files (deprecated).
  Kate - Ninja Multi-Config    = Generates Kate project files (deprecated).
  Kate - Unix Makefiles        = Generates Kate project files (deprecated).
  Sublime Text 2 - MinGW Makefiles
                               = Generates Sublime Text 2 project files
                                 (deprecated).
  Sublime Text 2 - NMake Makefiles
                               = Generates Sublime Text 2 project files
                                 (deprecated).
  Sublime Text 2 - Ninja       = Generates Sublime Text 2 project files
                                 (deprecated).
  Sublime Text 2 - Unix Makefiles
                               = Generates Sublime Text 2 project files
                                 (deprecated).
```

## Appendix B - initial thoughts on a less abstract example for an Anthropogenic Global Warming example CMakeLists.txt file
```
# Anthropogenic Global Warming
# An AGW application, 

cmake_minimum_required(VERSION 3.2)

# Won't be using C++ compiler, so ensure the project command does not attempt to find one otherwise it will fail 
# if one cannot be found. No point failing unecessarily if all that is needed is the C compiler.
project(AGW_App VERSION 1.5.9 LANGUAGES C)

# The core functional capability for this tool set
# Weather Station tooling
add_executable(WS_Sensors
    main.c 
	sensors.c
	debug.c)

# A diagnostic tool for development and testing
# To be basis of diagnositic support tool
add_executable(WS_Sensors_Tester
    sensorTester.c )
				
# The following tools are not ready yet so disable them all with a block comment
#[=[
# Data logger functional capability for this tool set
# Weather Station tooling
add_executable(WS_DataLogger 
   dataLogger.c
   sdcard.c
   ssd.c)
   
# Networking functional capability for this tool set
# Weather Station tooling
add_executable(WS_Networking
    ethernet.c
	bluetooth.c
	wifi.c)
	
# Numerical Weather Prediction capability for this tool set
# Climate Model tooling
add_executable(CM_NWP
    grid.c 
	profile.c )
	
# Extreme Weather Attribution capability for this tool set
# Climate Model tooling
add_executable(CM_EWA
    extremeEvent.c)
]=]
```

## References

* Semantic Versioning [WS](https://semver.org/), 