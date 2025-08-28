# CMake cmk

Meta build tool. Configuration? and orchestration? of native build tools. 

## Notes

Bosch Sensortec requirement, 2025-08-25, for building BMV080 C code driver for RPi SBC RPi-0 to RPi-5 inclusive.

CMake generator (command runner) location - e.g. Ninja
* cmake -S . -B ./build -G "Ninja" -DCMAKE_MAKE_PROGRAM="C:/path/to/ninja.exe"

CMake compiler location
* cmake -S . -B ./build -G "Ninja" -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_COMPILER="C:/Program Files/path/to/cl.exe"

CMakeLists.txt file - basic entries
* project(YourProjectName LANGUAGES C CXX)

## Status
TODO
* <todo: consider, work toward Bosch BMV080 SDK build for RPi Pico 2 RP2350, in first instance >
* <todo: consider, hello world CMake project, >
* <todo: consider, CMake tutorial, >

DONE
* <done: consider, intent to commit>

## Libs

CMake stuff
* CMake, org [WS](https://cmake.org/)
* CMake tutorial, [WS](https://cmake.org/cmake/help/latest/guide/tutorial/index.html)
* CMake repository, [GL](https://gitlab.kitware.com/cmake/cmake),
* CMake, reference documenation, [WS](https://cmake.org/cmake/help/latest/)
* ...

RPi
* https://github.com/raspberrypi/pico-bootrom-rp2350

ARM
* GCC for RPi Pico 2 W, <todo: source this. >

## References

Terms
* CMake, [WP](https://en.wikipedia.org/wiki/CMake), 

News Papers - CMake Windows
* Cmake on windows, [WS](https://www.reddit.com/r/cpp_questions/comments/1324tyc/cmake_on_windows/?rdt=47935), reddit, cpp, 
* Best CMake generators for Windows, [WS](https://www.reddit.com/answers/60341894-39d1-401a-983b-f903382bbfd1/?q=Best%20CMake%20generators%20for%20Windows&source=PDP), reddit, cpp
* MarkSchofield/WindowsToolchain, [GH](https://github.com/MarkSchofield/WindowsToolchain), A repository containing a CMake toolchain for using MSVC

News Papers - CMake Java
* Can't figure out how to make CMake / Ninja generate a .jar file, [WS](https://www.reddit.com/r/cmake/comments/1h2ruws/cant_figure_out_how_to_make_cmake_ninja_generate/), reddit, cmake, 

News Papers - CMake project directory samples
* Zero to CMake: A beginner's guide to why CMake works [WS](https://www.reddit.com/r/cpp/comments/1hb01j3/zero_to_cmake_a_beginners_guide_to_why_cmake_works/), reddit, cpp
* cmake-init - The missing CMake project initializer, [GH](https://github.com/friendlyanon/cmake-init/tree/master/tools), py?, friendlyanon/cmake-init

News Papers - CMake compiler, 
* Cmake with Ninja on Windows (msvc) [WS](https://www.reddit.com/r/cpp_questions/comments/1icn3nk/cmake_with_ninja_on_windows_msvc/), reddit, cpp
* CMake with Ninja on Windows using MSVC [WS](https://www.reddit.com/answers/b307c9e2-80ec-450b-8190-95319a589701/?q=CMake%20with%20Ninja%20on%20Windows%20using%20MSVC&source=PDP), reddit, cpp

News Papers - CMake generator (command runner), gmake, nmake, Ninja, ...
* Best practices for using CMake with Ninja, [WS](https://www.reddit.com/answers/271dce77-ec79-4df1-b94d-9d02f9567c1f/?q=Best%20practices%20for%20using%20CMake%20with%20Ninja&source=PDP), reddit, cpp