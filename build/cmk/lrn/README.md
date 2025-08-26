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

## Libs

Docs
* CMake tutorial, [WS](https://cmake.org/cmake/help/latest/guide/tutorial/index.html)
* CMake, Help, guide, tutorial, [GL](https://gitlab.kitware.com/cmake/cmake/-/tree/master/Help/guide/tutorial?ref_type=heads), tutorial code artifacts, 
* CMake, generators, [WS](https://cmake.org/cmake/help/latest/manual/cmake-generators.7.html), command runner

Generators
* MSBuild, [WP](https://en.wikipedia.org/wiki/MSBuild)
* nmake, 

## References

Learning
* CMake Tutorial for Absolute Beginners - From GCC to CMake including Make and Ninja [YT](https://www.youtube.com/watch?v=NGPo7mz1oa4), Garry Explains, 
* ...
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



