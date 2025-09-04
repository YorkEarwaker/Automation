# Part 1 prt 01

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







