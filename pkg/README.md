# Packaging pkg

Version control, managing packages of code artifacts, repository integration, 

## Status

TODO
* <todo: consider, rename to version control, >
* <todo: consider, open GitLab account, practice with git >
* <todo: consider, use of gitweb interface, defacto CGI based front end distributed with git, as basic management interface, testing confirmation, >
* <todo: consider, use of tcl/tk GUI interface, defacto C based front end distributed with git, as basic management interface, testing confirmation, >
* <todo: consider, Open Hub, https://openhub.net/ a catalogue of foss projects, move elsewhere? >
* <todo: consider, git init git remote add git fetch git merge , to return only .git folder contents from a remote repository, not source code, problem retrieve only .git from remote repository as local disk has source files already, >

DONE
* <done: consider, intent to commit, >
* <done: consider, install git, >
* <done: consider, getting started Pro Git book, basic setup of git and theory background info, >
* <done: consider, learn basic command for use with GitHub, practice with git, wip >
* <done: consider, getting a repository Pro Git book, no need for a dead tree version at the moment,  >

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
* - Personal access tokens (classic), [WS](https://github.com/settings/tokens), GitHub, classic c-PAT, course grained across all repos of the account, authentication from cli client side to GitHub hosting service via GitHub API server side with PAT as password using HTTP, OAuth scopes, if two factor authentication is enabled on GitHub then the user must complete the 2FA challenge also.
* - Fine-grained personal access tokens [WS](https://github.com/settings/personal-access-tokens), GitHub, fine grained fg-PAT, fine grained repo specific of the account?, <todo: consider, first use, more research required, >, <todo: consider, will c-PAT and fg-PAT conflict if both are used at the same time, more research required, >
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

## Output
<info: prerequisite installing Git on your local host machine, >
<info: prerequisite having an online account on your Git kind source control hosting service of choice, in this example GitHub, >

### Git to GitHub - first push to GitHub 
* Status: Success!
* <info: following the instructions on the GitHub page for a new repo, with addition of LICENSE file and .gitignore file, >
```
create a new repository on the command line

echo "# <your-repo-name>" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/<your-account-name>/<your-repo-name>.git
git push -u origin main
```
* <info: requirement create a personal access token PAT to use as password, see elsewhere for how, >
```
$ git push -u origin main
Username for 'https://github.com': YorkEarwaker
Password for 'https://YorkEarwaker@github.com': 
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 8 threads
Compressing objects: 100% (2/2), done.
Writing objects: 100% (5/5), 367 bytes | 367.00 KiB/s, done.
Total 5 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
To https://github.com/YorkEarwaker/World-Peace.git
 * [new branch]      main -> main
branch 'main' set up to track 'origin/main'.
```

Add some more suggested files to the repo
```
$ echo "# License pending " >> LICENSE
$ git add LICENSE
$ echo "# Content pending " >> .gitignore
$ git add .gitignore
$ git commit -m "update"
$ git push
<info: login stuff happens and is displayed here. as below >
```
Make changes to the README.md file and upload them
```
$ git add README.md

$ git commit -m "update"
[main feb356b] update
 1 file changed, 8 insertions(+)

$ git push
Username for 'https://github.com': YorkEarwaker
Password for 'https://YorkEarwaker@github.com': 
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 8 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 361 bytes | 361.00 KiB/s, done.
Total 3 (delta 1), reused 0 (delta 0), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
To https://github.com/YorkEarwaker/World-Peace.git
   725a8d2..feb356b  main -> main
```

### Git from GitHub - first clone
* Status: Success!
* <info: first cloned remote repo>
* <info: second make changes to a file on local host and push back changes to remote repo, the 'origin' or 'upstream' host >

Clone a remote repo and check the directory contents
```
$ git clone https://github.com/YorkEarwaker/Networks networks
Cloning into 'networks'...
remote: Enumerating objects: 70, done.
remote: Counting objects: 100% (70/70), done.
remote: Compressing objects: 100% (70/70), done.
remote: Total 70 (delta 21), reused 0 (delta 0), pack-reused 0 (from 0)
Receiving objects: 100% (70/70), 22.90 KiB | 3.27 MiB/s, done.
Resolving deltas: 100% (21/21), done.

$ dir
application	 data			 librebank	 networks\ (Copy)
automation	 electrical-engineering  librebank-sd-1  nexus-1
butterflyeffect  findingthingsout	 logic		 operating-system
climate-model	 graphics		 music		 web
coding-practice  hybrid-power		 networks	 world-peace

$ cd networks
$ dir
README.md
$ dir .git
config	description  HEAD  hooks  index  info  logs  objects  packed-refs  refs
$ ls -a
.  ..  .git  .gitignore  README.md
$ ls -al
total 20
drwxrwxr-x  3 york-earwaker york-earwaker 4096 Mar 27 13:39 .
drwxr-xr-x 22 york-earwaker york-earwaker 4096 Mar 27 13:39 ..
drwxrwxr-x  7 york-earwaker york-earwaker 4096 Mar 27 13:39 .git
-rw-rw-r--  1 york-earwaker york-earwaker  270 Mar 27 13:39 .gitignore
-rw-rw-r--  1 york-earwaker york-earwaker 2729 Mar 27 13:39 README.md
```
Change the remote repo name, it was missing a .git extension
```
$ git remote -v
origin	https://github.com/YorkEarwaker/Networks (fetch)
origin	https://github.com/YorkEarwaker/Networks (push)

$ git remote set-url origin https://github.com/YorkEarwaker/Networks.git

$ git remote -v
origin	https://github.com/YorkEarwaker/Networks.git (fetch)
origin	https://github.com/YorkEarwaker/Networks.git (push)
```
Check whether anything needs to be committed 
```
$ git status
On branch main
Your branch is up to date with 'origin/main'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
	modified:   README.md

no changes added to commit (use "git add" and/or "git commit -a")

$ git diff --cached
$ git diff -v
diff --git a/README.md b/README.md
index 87344a3..0325f6f 100644
--- a/README.md
+++ b/README.md
@@ -13,6 +13,7 @@ TODO
 * <todo: relation to neuromorphic computing, as interneuron interbrain substrait?, parallel multi gai processing, multi agent processing, >
 * <todo: relation to music, sonics, consider a music repository, pitch encoding and transmission, ! > 
 * <todo: consider, project re DNS DHCP on local host Ubuntu 24.04 or Ubuntu 26.04, using; pi-hole, dnsmasq, others tbd, objective to block predatory internet domains, >
+* <todo: consider, curl file transfer, to remote address, >^M
 
 DONE
 * <done: intent to commit>
```

Try and commit something, fail in first attempt
```
$ git commit -m "update git test"
On branch main
Your branch is up to date with 'origin/main'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
	modified:   README.md

no changes added to commit (use "git add" and/or "git commit -a")

$ git push
Username for 'https://github.com': YorkEarwaker
Password for 'https://YorkEarwaker@github.com': 
Everything up-to-date
```

Try and commit something, succeed in second attempt
```
$ git add README.md

$ git status
On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
	modified:   README.md

$ git commit -m "update - git test"
[main 0a7e248] update - git test
 1 file changed, 1 insertion(+)
york-earwaker@york-earwaker-XPS-15-9560:~/Documents/dev/repo/networks$ git status
On branch main
Your branch is ahead of 'origin/main' by 1 commit.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean

$ git remote -v
origin	https://github.com/YorkEarwaker/Networks.git (fetch)
origin	https://github.com/YorkEarwaker/Networks.git (push)

$ git push
Username for 'https://github.com': YorkEarwaker
Password for 'https://YorkEarwaker@github.com': 
remote: Invalid username or token. Password authentication is not supported for Git operations.
fatal: Authentication failed for 'https://github.com/YorkEarwaker/Networks.git/'
york-earwaker@york-earwaker-XPS-15-9560:~/Documents/dev/repo/networks$ git push
Username for 'https://github.com': YorkEarwaker
Password for 'https://YorkEarwaker@github.com': 
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 8 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 371 bytes | 371.00 KiB/s, done.
Total 3 (delta 1), reused 0 (delta 0), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
To https://github.com/YorkEarwaker/Networks.git
   1c6a7c8..0a7e248  main -> main
```

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

News Papers, Git - commands; clone, push, pull, archive, fetch, merge, checkout (switch?, restore?), commit, remote,  ...
* Git Clone: Just the files, please? [WS](https://stackoverflow.com/questions/3946538/git-clone-just-the-files-please), 23 May 2017 (edited), StackOverflow, 
* What does git checkout do? [WS](https://stackoverflow.com/questions/69826597/what-does-git-checkout-do), 3 November 2021, StackOverflow, 
* Clone only the .git directory of a git repo, [WS](https://stackoverflow.com/questions/38999901/clone-only-the-git-directory-of-a-git-repo), , StackOverflow
* Managing remote repositories, [WS](https://docs.github.com/en/get-started/git-basics/managing-remote-repositories), GitHub, docs 
* ...

