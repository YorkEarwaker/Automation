# Thonny thy

things tbc

## Notes

Micropython python development
* Successfully used on Windows 10. Working 'out of the box' with no issues that were not the 'standard' dev env setup ones. 
* Attempting to use on Ubuntu LTS 24.04.3 linux 

## Issues

### Issue 1
Some or all of this might be achievable through the thonny menu. But as the menu could not be read without magnification it was done through the thonny configuration files. 
* TBD a description of all thonny config files. 
* TBD a description of all the thonny config file properties/entries and legal entries and examples.

Description
* defect; tiny tiny menu text size when opening thonny UI after install
* status; fixed
* resolution; alter configuration.ini file entries, see below
* os; Linux, Ubuntu LTS 24.04.3 
* hw; Dell laptop, Dell XPS 15 9560

Ubuntu snap install
* configuration.ini, 
* location shell; ~/snap/thonny/239 $ , 
* location files; /home/your-user-name/snap/thonny/239 , 

Configuration file entries
* configuration.ini
* general.scaling
* view.ui_font_size 
* view.editor_font_size
* view.io_font_size
* view.ui_theme
* view.syntax_theme
* ...

Values for configuration file entries used, to fix tiny tiny menu text size
* scaling = 2.0 , seemed to have a direct effect on menu text size, 
* io_font_size = 14 , ? not sure of effect, but value was retained in configuration file
* ui_font_size = 14 , ? not sure of effect, but value was retained in configuration file
* editor_font_size = 14 , affected thonny editor/shell text size
* ui_theme = Raspberry Pi , this value was not changed
* syntax_theme , this value was not tried/tested, 

Defaults file entries, further investigation necessary for use case
* defaults.ini
* ...

### Issue 2

Description
* defect; Unable to connect to Raspberry Pi Pico with Thonny IDE
* status; open
* resolution; consider adding user to dialout group
* os; Linux, Ubuntu LTS 24.04.3 
* hw; Dell laptop, Dell XPS 15 9560



## TODO
* <todo: consider, connect to RPi Pico 2 W microcontroller, via thonny ide, ubuntu LTS 24.04.3 linux, >
* <todo: consider, connect to RPi Z (Pi0) sbc, via thonny ide, ubuntu LTS 24.04.3 linux, is this possible? >
* <todo: consider, virtual environment venv for python on local file system instead of default thonny python, >

## DONE
* <done: menu item issues, text size, problem is known, okay on windows not on linux ubuntu, see notes issue fix elsewhere on this page, >
* ...

## Output
Successfully use Python in Thonny shell. 
```
Python 3.10.15 (/snap/thonny/239/bin/python3.10)
>>> print(f"Hello World, ", 'Arthur P. Dent')
Hello World,  Arthur P. Dent
>>> 
```
## Software
* Thonny, wiki [GH](https://github.com/thonny/thonny/wiki), Github, 
* Thonny, org [WS](https://thonny.org/), Thonny
* Thonny, io [WS](https://snapcraft.io/thonny), snapcraft, 
* Thonny, net [WS](https://launchpad.net/thonny), Launchpad, Thonny, 
* Thonny, net [WS](https://launchpad.net/thonny-snap), Launchpad, Thonny Snap
* Thonny, net [WS](https://launchpad.net/ubuntu/+source/thonny), Launchpad, Thonny Snap, Ubuntu
* Thonny, rpi, org [WS](https://projects.raspberrypi.org/en/projects/thonny-install), Raspberry Pi

## References

Thonny, issues
* Menu bar, assistant, etc font super small #1113 [GH](https://github.com/thonny/thonny/issues/1113), Github, thonny

Thonny, configuration
* Micropython, advanced configuration, [GH](https://github.com/thonny/thonny/wiki/MicroPython#advanced-configuration), Github, thonny, wiki, 

Ubuntu related font size issue 
* How do I increase the text size of the text on a console?, [WS](https://askubuntu.com/questions/29328/how-do-i-increase-the-text-size-of-the-text-on-a-console), 23 June 2011, StackExchange, Ubuntu

Raspberry Pi
* Not able to connect Raspberry Pi Pico, [WS](https://raspberrypi.stackexchange.com/questions/120775/not-able-to-connect-raspberry-pi-pico), StackExchange, Raspberry Pi 





