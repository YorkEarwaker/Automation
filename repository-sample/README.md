# Repository Samples

Sample project structures for different coding languages. Organising project files in a sensible way. Attempts toward standardisation.


## Notes

Rationale for this initiative
* Principle objective, in first instance, toward dir structures for AWG project, Climate Model etc, as unifying focus, 

Build system capability maturity uplift requirement
* There is a emerging strong case for a generic cross language project directory structure
* Having a single directory structure to build them all would be a great asset for developers and devops teams
* There should be efforts for a standardisation between build systems, native build systems and meta build systems 
* Differences in dirctory structures between current build systems seem arbitrary and possibly deliberately obfuscatory and a vendor lock in issue
* With a common generic dir structure, as an interim step in build process could be put artifacts/things in beskpoke build system structure at start of build
* Other build system standards inititives would be useful, common standard command run standard, just/make other? project meta data, 
* Python maturing toward standard Java and Cpp project repository structures. But Rust unlike C and Java, due to Cargo build system.
* Current state is a unecessaryly complex, a Bable of avoidable conflicting confusion,for development team and build team 
* Current state is a barrier to productivity. Makes moving between projects and programming languages needlessly difficult for programmers and builders
* Current state is tight couplig of devleopment team and build team. The developer practitioner project code should be decoupled from the devops practioners build system constraints, 
* Current state is an acident of history with built in lack of seperation of concern 
* Current state is a reflection of relative immaturity of the state of the art of systems enginnering and software engineering 
* The development code directory struacture must not be dictated by the build directory structure or visa versa

Development code directory structure
* Core, /doc - every project should be documented, /src - every project must have source code, /tst - every project should be tested

## Status

TODO
* <todo: consider how to manage repository structure for multicode base? use case for project with; java, python, cpp, for example,  >
* <todo: don't like this approach. Java - in the first case, see java/org/agw/sgwm, Python - in the second case, see py/org/agw/sgwm, Cpp - in the third case, see cpp/org/agw/sgwm> 
* <todo: consider base project repository structure; C/Cpp/ASM, Java, JS/TS, Python, . src, test, lib, bin, config, . Consider deltas with specific tech as seperate, >
* <todo: Maven, stubb, prioritise!, as used in; enterprise java, OSGi projects, IoT M2M, ... >
* <todo: OSGi, stubb, prioritise? see Maven, >
* <todo: Gradle, stubb?, necessary at this point? >
* <todo: Java, web projects, a seperate strcture is required, >
* <done: JS/TS, web projects, JavaScript/TypeScript, a seperate strcture is required, >
* <todo: Node, any different from standrad JS/TS structure? is it even necessary? >
* <todo: others?, >
* <todo: better comprehensive view of necessary non functionals, >
* <todo: iterate, c/c++/asm, wip, >
* <todo: iterate, Python, not happy with this, confused,>
* <todo: consider, renameing in all sample repository structures test dirctory, from /test or /tests to /tst >
* <todo: consider, continous integration and deployment directory /cid for each type of project, >
* <todo: consider, glossary with description of each directory type in each coding type structure, >
* <todo: consider, faq? for what purpose? >

DONE
* <done: Python, applications, first cut, v0.1>
* <done: Java, applications, first cut, v0.1>
* <done: C and Cpp and ASM, applications, first cut, v0.1>
* <done: JS/TS, stubb, applications, JavaScript/TypeScript, vanilla, wip 60%? >
* <done: Maven, stubb, wip, >
* <done: OSGi, stubb, wip, >
* <done: consider, Rust, stubb, wip >
* <done: consider renaming /cpp to /cpa as it inclusive of C/C++/ASM >

## Design Patterns

Software Engineering Principles 
* DRY
* KIS(S)
* SOLID, [WP](https://en.wikipedia.org/wiki/SOLID)
* YAGNI

Packaging Principles
* R??

## References

Software Engineering 
* Law of Triviality, [WP](https://en.wikipedia.org/wiki/Law_of_triviality), bike shedding, 
* Non functional requirements NFR's
* Project struture
* Repository
* Standards
* Packaging principles,
* Design Patterns 

NFR's to consider
* Maintainabiligy, 
* Testability, 
* 

Repository
* Mono repository strategy
* Multi repository strategy

DevOps Tools
* Bitbucket
* GitHub
* GitLab
* Heroku,  PaaS
* Maven
* ...

News Papers
* Two code bases in one repository... is there ever a good reason to do this?, [WS](https://softwareengineering.stackexchange.com/questions/361048/two-code-bases-in-one-repository-is-there-ever-a-good-reason-to-do-this), 21 November 2017 , Software Engineering, Stackexchange,
* 
