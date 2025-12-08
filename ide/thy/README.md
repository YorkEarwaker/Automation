# Thonny thy

things tbc

## Notes

### Issue
* defect; tiny tiny menu text size when opening thonny UI after install
* status; fixed
* resolution; alter configuration.ini file entries, see below

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
* editor_font_size = 14 , affected editor/shell text size
* ui_theme = Raspberry Pi , this value was not changed
* syntax_theme , this value was not tried/tested, 

Defaults file entries, further investigation necessary for use case
* defaults.ini
* ...

## TODO
* <todo: connect to RPi microcontroller, via thonny ide, ubuntu linux, >

## DONE
* <done: menu item issues, text size, problem is known, okay on windows not on linux ubuntu, see notes issue fix elsewhere on this page, >
* ...

## Software
* Thonny, wiki [GH](https://github.com/thonny/thonny/wiki), Github, 
* Thonny, org [WS](https://thonny.org/), Thonny
* Thonny, io [WS](https://snapcraft.io/thonny), snapcraft, 
* Thonny, net [WS](https://launchpad.net/thonny), Launchpad, Thonny, 
* Thonny, net [WS](https://launchpad.net/thonny-snap), Launchpad, Thonny Snap
* Thonny, rpi, org [WS](https://projects.raspberrypi.org/en/projects/thonny-install), Raspberry Pi

## References

Thonny, issues
* Menu bar, assistant, etc font super small #1113 [GH](https://github.com/thonny/thonny/issues/1113), Github, thonny

Thonny, configuration
* [GH](https://github.com/thonny/thonny/wiki/MicroPython#advanced-configuration), Github, thonny, wiki, 

Ubuntu related font size issue 
* How do I increase the text size of the text on a console?, [WS](https://askubuntu.com/questions/29328/how-do-i-increase-the-text-size-of-the-text-on-a-console), 23 June 2011, StackExchange, Ubuntu



