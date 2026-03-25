# Packaging pkg

Version control, managing packages of code artifacts, repository integration, 

## Status

TODO
* <todo: consider, rename to version control, >
* <todo: consider, learn basic command for use with GitHub, practice with git, >
* <todo: consider, open GitLab account, practice with git >
* <todo: consider, getting a repository Pro Git book, >
* <todo: consider, use of gitweb interface, defacto CGI based front end distributed with git, as basic management interface, testing confirmation, >
* <todo: consider, use of tcl/tk GUI interface, defacto C based front end distributed with git, as basic management interface, testing confirmation, >  
* <todo: consider, Open Hub, https://openhub.net/ a catalogue of foss projects, move elsewhere? >

DONE
* <done: consider, intent to commit, >
* <done: consider, install git, >
* <done: consider, getting started Pro Git book, basic setup of git and theory background info, >

## Software

### Version Control Systems VCS's
* <info: concentrate on git in the first instance, greatest usage near universal circa Q1 2026, >
* <info: see references below, links to content about this topic and to similar topics, >

Git - client side, repositories, content addressable file system, 
* git, com [WS](https://git-scm.com/), Git, docs [WS](https://git-scm.com/docs), [WP](https://en.wikipedia.org/wiki/Git), Wikipedia
* Pro Git, book [WS](https://git-scm.com/book/en/v2), Git, Apress, Scott Chacon, Ben Straub, Creative Commons, 
* Install git, [WS](https://git-scm.com/install/linux), Git, 
* A3.1 Appendix C: Git Commands - Setup and Config, [WS](https://git-scm.com/book/en/v2/Appendix-C:-Git-Commands-Setup-and-Config), Git, 
* nano, [WS](https://nano-editor.org/), nano, preinstalled default command line text editor for Ubuntu 24.04 and above, 

Git - server side, cloud, repositories as a service, source code hosting, 
* BitBucket, product cli ?, default cli git
* GitHub, product cli gh, default cli git, 
* - docs [WS](https://docs.github.com/en),
* - Personal access tokens (classic), [WS](https://github.com/settings/tokens), GitHub, PAT, course grained across all repos, authentication from cli client side to GitHub hosting service via GitHub API server side with PAT as password using HTTP, if two factor authentication is enabled on GitHub then the user must complete the 2FA challenge also.
* - Fine-grained personal access tokens [WS](https://github.com/settings/personal-access-tokens), GitHub, FGT, fine grained repo specific?, <todo: consider, first use, more research required, >, <todo: consider, will PAT and FGT conflict if both are used at the same time, more research required, >
* GitLab, product cli glab, default cli git
* SourceForge, product cli ?, default cli git

CVS
* cvs, Concurrent Versions System org, [WS](https://www.nongnu.org/cvs/), CVS, 

Hg
* hg, Mercurial, org, [WS](https://www.mercurial-scm.org/), Hg, [WP](https://en.wikipedia.org/wiki/Mercurial), Wikipedia
* ...

SVN
* svn, Subversion, org, [WS](https://subversion.apache.org/), Apache, 
* <todo: others to list, >

## References

Terms
* Comparison of source-code-hosting facilities, [WP](https://en.wikipedia.org/wiki/Comparison_of_source-code-hosting_facilities), list, 
* Comparison of version-control software, [WP](https://en.wikipedia.org/wiki/Comparison_of_source-code-hosting_facilities), list
* Collaborative Development Environment CDE, [WP](https://en.wikipedia.org/wiki/Collaborative_development_environment), article
* Source Code Management SCM, see source control management
* Source Control Management SCM, implying more than just code artifacts, data artifacts, wider project artifacts, artifacts of disciplines other than only development, DevSecOps, and so on
* Version Control System, 

News Papers, Ubuntu
* git-ubuntu, [WS](https://documentation.ubuntu.com/project/how-ubuntu-is-made/processes/git-ubuntu/), Ubuntu

News Papers, Git - authentication with GitHub, others, HTTP, SSH, OAuth, 
* Whenever I want to push any change from my local to my github via terminal, showing "Remote: Invalid username or password." I deleted my personal token from the github and reinstalled the git in my system. But not working. #133133 [WS](https://github.com/orgs/community/discussions/133133), 22 July 2024, GitHub, Community, 
* Why is Git always asking for my credentials?, [WS](https://docs.github.com/en/get-started/git-basics/why-is-git-always-asking-for-my-credentials), GitHub, Docs, Git Basics, 
* Scopes for OAuth apps, [WS](https://docs.github.com/en/apps/oauth-apps/building-oauth-apps/scopes-for-oauth-apps), GitHub, Docs
* Authenticating to the REST API, [WS](https://docs.github.com/en/rest/authentication/authenticating-to-the-rest-api?apiVersion=2026-03-10#basic-authentication), GitHub, Docs, REST API,
* 7.14 Git Tools - Credential Storage [WS](https://git-scm.com/book/en/v2/Git-Tools-Credential-Storage), Git, Pro Git, online, 

News Papers, Git - sudo, root, don't do so, use without sudo for normal git operations, 
* Should we use sudo for git operations? [WS](https://stackoverflow.com/questions/45001405/should-we-use-sudo-for-git-operations), 9 Jul 2017, StackOverflow, 

News Papers, Git - nested repositories
* Nested Git Repositories, [WS](https://stackoverflow.com/questions/1871282/nested-git-repositories), StackOverflow, 
* I have nested git repos, will it cause a problem?, [WS](https://unix.stackexchange.com/questions/323489/i-have-nested-git-repos-will-it-cause-a-problem), 15 November 2016, StackExchange, 
* ...

