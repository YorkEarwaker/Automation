# CMake Pro Part 1

Notes on Part 1 free download of

Professional CMake: A Practical Guide
21st Edition
ISBN 978-1-925904-36-9
© 2018-2025 by Craig Scott 

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

One source folder to rule them all. That is one source folder and multiple different build folders. Depending on modifications to CMakeLists.txt entries and to command line variables and environment variables. So that binary builds might be created for multiple target architecturs. And multiple binary builds for a single target architecture but where the builds differ say for optimal performance or greater modularity or best backward compatibility ans so on. Utilising different pipline tool chains for example for different DevSecOps scenarios and so on.

So there might be CMakeLists.txt varients and cmake command line varients which stipulate;
* -B ./bld or -B ./bld_win_32  or -B ./bld_win_64 or -B ./bld_aix or -B ./bld_lnx_64 or -B ./bld_arm_A or -B ./bld_arm_R or -B ./bld_arm_M and so on.
* -B ./bld_prd or -B ./bld_tst or -B ./bld_qa or -B ./bld_dev and so on.
* -B ./bld_gov_nhs or -B ./bld_gov_mod or -B ./bld_gov_doe or -B ./bld_gov_ho or -B ./bld_gov_fo or -B ./bld_gov_co and so on. In a UK government context.
* or by any number of other categorisation.
 





