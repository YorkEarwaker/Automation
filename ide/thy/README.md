# Thonny thy

things tbc

## Notes

Micropython python development
* Successfully used on Windows 10. Working 'out of the box' with no issues that were not the 'standard' dev env setup ones. 
* Attempting to use Thonny IDE on Ubuntu LTS 24.04.3 Linux, success! After resolution of issue 1 and issue 2.
* Attempting to use on Ubuntu LTS 24.04.3 Linux, Issues ongoing, Linux kernel USB related, likely requires Linux kernel defect raising, see issue 3.

## Status

### TODO
* <todo: consider, connect to RPi Z (Pi0) sbc, via thonny ide, ubuntu LTS 24.04.3 linux, is this possible? >
* <todo: consider, virtual environment venv for python on local file system instead of default thonny python, >

### DONE
* <done: menu item issues, text size, problem is known, okay on windows not on linux ubuntu, see notes issue fix elsewhere on this page, >
* <done: consider, connect to RPi Pico W microcontroller, 2040 MCU, via thonny ide, ubuntu LTS 24.04.3 linux, >
* <done: consider, connect to RPi Pico 2 W microcontroller, 2035 MCU, via thonny ide, ubuntu LTS 24.04.3 linux, >
* ...

## Issues

### Issue 1
Some or all of this might be achievable through the thonny menu. But as the menu could not be read without magnification it was done through the thonny configuration files. 
* TBD a description of all thonny config files. 
* TBD a description of all the thonny config file properties/entries and legal entries and examples.

Description
* defect; tiny tiny menu text size when opening thonny UI after install
* status; fixed, closed
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
* defect; Unable to connect to Raspberry Pi Pico W, RP2040 MCU, with Thonny IDE to install MicroPython from the IDE, 
* status; fixed, closed
* resolution; consider adding user to dialout group, don't know if this was necessary! Consider backing out and test for ability to connect.
* resolution; consider drag and drip UF2 file to flash drive, RPI_PICO_W-20251209-v1.27.0.uf2, seemed to work success!
* os; Linux, Ubuntu LTS 24.04.3 
* hw; Dell laptop, Dell XPS 15 9560

Attempt 1, attempting to connect to a Raspberry Pi Pico W, RP2040 MCU, which has not been flashed with MicroPython
* Thonny IDE, cannot 'see'  Rasbperry Pi Pico W (RPi PiW)
* The RPi PiW is not recognized when using Thonny bottom right hand menu 'Configure Interpreter' .
* The issue continued to persist even after 'dialout' workaround attempt.

Attempt 1, Work around? Attempt one - don't know if this was necessary, didn't work so might have to back it out
* 1) Add user to dialout group
```
$ groups york-earwaker
york-earwaker : york-earwaker adm cdrom sudo dip plugdev users lpadmin

$ sudo usermod -a -G dialout york-earwaker

$ groups york-earwaker
york-earwaker : york-earwaker adm dialout cdrom sudo dip plugdev users lpadmin
```
* 2) Reboot computer
* 3) Plug in Raspberry Pi to USB first before opening Thonny IDE
* 3.1) Don't hold down 'Bootloader' on Raspberry Pi before plugging in USB into computer
* 4) Open Thonny IDE

Attempt 2, Falsh Raspberry Pi Pico W, 2040 MCU, with MicroPython UF2 file
* Plug RPi PiW USB into computer with Ubuntu OS 
* The RPi PiW is mounted as a USB drive by the Ubuntu LTS 24.04.3 system Gnome desktop 
* Download UF2 file from Raspberry Pi MicroPython page, See references below for link to Raspberry Pi MicroPython page which has link to latest UF2 file!
* Drag UF2 file to RPi PiW USB drive 
* After being flashed RPi PiW with RPI_PICO_W-20251209-v1.27.0.uf2 the RPi PiW drive is unmounted 
* Start Thonny IDE

Thonny IDE reports in shell window, after flashing with UF2 file, 
* Success!
* First contact with an RP2040! take me to your leader.
```
MicroPython v1.27.0 on 2025-12-09; Raspberry Pi Pico W with RP2040
Type "help()" for more information.
>>> 
MicroPython v1.27.0 on 2025-12-09; Raspberry Pi Pico W with RP2040
Type "help()" for more information.
>>> 
```

However Ubuntu terminal shell reports flashed RPi PiW, RP2040 MCU, as USB device 014, see Issue 3 below.
```
$ lsusb
Bus 001 Device 001: ID 1d6b:0002 Linux Foundation 2.0 root hub
Bus 001 Device 002: ID 0cf3:e300 Qualcomm Atheros Communications QCA61x4 Bluetooth 4.0
Bus 001 Device 003: ID 138a:0091 Validity Sensors, Inc. VFS7552 Touch Fingerprint Sensor
Bus 001 Device 004: ID 04f3:24a1 Elan Microelectronics Corp. Touchscreen
Bus 001 Device 005: ID 0c45:6713 Microdia Integrated_Webcam_HD
Bus 001 Device 014: ID 2e8a:0005 MicroPython Board in FS mode
Bus 002 Device 001: ID 1d6b:0003 Linux Foundation 3.0 root hub
```

When attempting to connect to a Raspberry Pi Pico 2 W, 2035 MCU, that had previously been flashed with MicroPython on Windows 10.
* Thonny IDE, can successfully connect to Rasbperry Pi Pico 2 W (RPi Pi2W) and see the RPi Pi2W directory structure .
* Hello old friend.
```
MPY: soft reboot
MicroPython v1.25.0-preview.539.gdb8542707 on 2025-04-10; Raspberry Pi Pico 2 W with RP2350
Type "help()" for more information.
>>> 
```

However Ubuntu terminal shell reports flashed RPi Pi2W, RP2035 MCU, as USB device 012, see Issue 3 below.
* This dmesg was carried out before the RPi PiW, RP2040 MCU, had been successfully flashed, which explains USB device count discrepency
```
$ sudo dmesg
[sudo] password for york-earwaker: 
[    0.000000] Linux version 6.14.0-37-generic (buildd@lcy02-amd64-031) (x86_64-linux-gnu-gcc-13 (Ubuntu 13.3.0-6ubuntu2~24.04) 13.3.0, GNU ld (GNU Binutils for Ubuntu) 2.42) #37~24.04.1-Ubuntu SMP PREEMPT_DYNAMIC Thu Nov 20 10:25:38 UTC 2 (Ubuntu 6.14.0-37.37~24.04.1-generic 6.14.11)

...

[ 4446.958998] audit: type=1400 audit(1765910334.960:389): apparmor="DENIED" operation="open" class="file" profile="snap.brave.brave" name="/proc/3937/smaps_rollup" pid=3937 comm="MemoryInfra" requested_mask="r" denied_mask="r" fsuid=1000 ouid=1000
[ 4453.853840] usb 1-2: USB disconnect, device number 11
[ 4559.211814] usb 1-2: new full-speed USB device number 12 using xhci_hcd
[ 4559.336439] usb 1-2: New USB device found, idVendor=2e8a, idProduct=0005, bcdDevice= 1.00
[ 4559.336456] usb 1-2: New USB device strings: Mfr=1, Product=2, SerialNumber=3
[ 4559.336463] usb 1-2: Product: Board in FS mode
[ 4559.336469] usb 1-2: Manufacturer: MicroPython
[ 4559.336491] usb 1-2: SerialNumber: d71deaf4f4f02def
[ 4559.362687] cdc_acm 1-2:1.0: ttyACM0: USB ACM device
[ 4559.362714] usbcore: registered new interface driver cdc_acm
[ 4559.362716] cdc_acm: USB Abstract Control Model driver for USB modems and ISDN adapters
[ 4559.390510] pcieport 0000:00:1d.0: AER: Correctable error message received from 0000:04:00.0
[ 4559.390520] nvme 0000:04:00.0: PCIe Bus Error: severity=Correctable, type=Physical Layer, (Receiver ID)
[ 4559.390541] nvme 0000:04:00.0:   device [144d:a809] error status/mask=00000001/0000e000
[ 4559.390544] nvme 0000:04:00.0:    [ 0] RxErr                  (First)

$ lsusb
Bus 001 Device 001: ID 1d6b:0002 Linux Foundation 2.0 root hub
Bus 001 Device 002: ID 0cf3:e300 Qualcomm Atheros Communications QCA61x4 Bluetooth 4.0
Bus 001 Device 003: ID 138a:0091 Validity Sensors, Inc. VFS7552 Touch Fingerprint Sensor
Bus 001 Device 004: ID 04f3:24a1 Elan Microelectronics Corp. Touchscreen
Bus 001 Device 005: ID 0c45:6713 Microdia Integrated_Webcam_HD
Bus 001 Device 012: ID 2e8a:0005 MicroPython Board in FS mode
Bus 002 Device 001: ID 1d6b:0003 Linux Foundation 3.0 root hub
```

### Issue 3
This appears to be a Linux kernel issue and not directly connected to Thonny IDE, 
* but likely a Linux kernel USB issue with Raspberry Pi specifically.
* see xhci_hcd reference in dmesg output below
* see link in references below to uhubctl Linux issue

Description
* defect; Ubuntu LTS 24.04.3 Raspberry Pi Pico W, 2040 MCU, kernel appears to keep USB device 'in memory' despite RPi Pico USB being disconnected
* status; open
* resolution; consider, kernel usb data update/purge , 
* os; Linux, Ubuntu LTS 24.04.3 
* hw; Dell laptop, Dell XPS 15 9560


```
$ lsusb
Bus 001 Device 001: ID 1d6b:0002 Linux Foundation 2.0 root hub
Bus 001 Device 002: ID 0cf3:e300 Qualcomm Atheros Communications QCA61x4 Bluetooth 4.0
Bus 001 Device 003: ID 138a:0091 Validity Sensors, Inc. VFS7552 Touch Fingerprint Sensor
Bus 001 Device 004: ID 04f3:24a1 Elan Microelectronics Corp. Touchscreen
Bus 001 Device 005: ID 0c45:6713 Microdia Integrated_Webcam_HD
Bus 001 Device 009: ID 2e8a:0003 Raspberry Pi RP2 Boot
Bus 002 Device 001: ID 1d6b:0003 Linux Foundation 3.0 root hub

$ lsusb
Bus 001 Device 001: ID 1d6b:0002 Linux Foundation 2.0 root hub
Bus 001 Device 002: ID 0cf3:e300 Qualcomm Atheros Communications QCA61x4 Bluetooth 4.0
Bus 001 Device 003: ID 138a:0091 Validity Sensors, Inc. VFS7552 Touch Fingerprint Sensor
Bus 001 Device 004: ID 04f3:24a1 Elan Microelectronics Corp. Touchscreen
Bus 001 Device 005: ID 0c45:6713 Microdia Integrated_Webcam_HD
Bus 002 Device 001: ID 1d6b:0003 Linux Foundation 3.0 root hub

$ lsusb
Bus 001 Device 001: ID 1d6b:0002 Linux Foundation 2.0 root hub
Bus 001 Device 002: ID 0cf3:e300 Qualcomm Atheros Communications QCA61x4 Bluetooth 4.0
Bus 001 Device 003: ID 138a:0091 Validity Sensors, Inc. VFS7552 Touch Fingerprint Sensor
Bus 001 Device 004: ID 04f3:24a1 Elan Microelectronics Corp. Touchscreen
Bus 001 Device 005: ID 0c45:6713 Microdia Integrated_Webcam_HD
Bus 001 Device 010: ID 2e8a:0003 Raspberry Pi RP2 Boot
Bus 002 Device 001: ID 1d6b:0003 Linux Foundation 3.0 root hub

$ lsusb
Bus 001 Device 001: ID 1d6b:0002 Linux Foundation 2.0 root hub
Bus 001 Device 002: ID 0cf3:e300 Qualcomm Atheros Communications QCA61x4 Bluetooth 4.0
Bus 001 Device 003: ID 138a:0091 Validity Sensors, Inc. VFS7552 Touch Fingerprint Sensor
Bus 001 Device 004: ID 04f3:24a1 Elan Microelectronics Corp. Touchscreen
Bus 001 Device 005: ID 0c45:6713 Microdia Integrated_Webcam_HD
Bus 002 Device 001: ID 1d6b:0003 Linux Foundation 3.0 root hub

$ lsusb
Bus 001 Device 001: ID 1d6b:0002 Linux Foundation 2.0 root hub
Bus 001 Device 002: ID 0cf3:e300 Qualcomm Atheros Communications QCA61x4 Bluetooth 4.0
Bus 001 Device 003: ID 138a:0091 Validity Sensors, Inc. VFS7552 Touch Fingerprint Sensor
Bus 001 Device 004: ID 04f3:24a1 Elan Microelectronics Corp. Touchscreen
Bus 001 Device 005: ID 0c45:6713 Microdia Integrated_Webcam_HD
Bus 001 Device 011: ID 2e8a:0003 Raspberry Pi RP2 Boot
Bus 002 Device 001: ID 1d6b:0003 Linux Foundation 3.0 root hub

...

$ sudo dmesg
[sudo] password for york-earwaker: 
[    0.000000] Linux version 6.14.0-37-generic (buildd@lcy02-amd64-031) (x86_64-linux-gnu-gcc-13 (Ubuntu 13.3.0-6ubuntu2~24.04) 13.3.0, GNU ld (GNU Binutils for Ubuntu) 2.42) #37~24.04.1-Ubuntu SMP PREEMPT_DYNAMIC Thu Nov 20 10:25:38 UTC 2 (Ubuntu 6.14.0-37.37~24.04.1-generic 6.14.11)

...

[ 1887.101215] audit: type=1400 audit(1765907775.088:291): apparmor="DENIED" operation="open" class="file" profile="snap.brave.brave" name="/proc/3937/smaps_rollup" pid=3937 comm="MemoryInfra" requested_mask="r" denied_mask="r" fsuid=1000 ouid=1000
[ 1897.086793] usb 1-2: USB disconnect, device number 10
[ 1897.104519] FAT-fs (sda1): unable to read boot sector to mark fs as dirty
[ 1905.243524] usb 1-2: new full-speed USB device number 11 using xhci_hcd
[ 1905.367904] usb 1-2: New USB device found, idVendor=2e8a, idProduct=0003, bcdDevice= 1.00
[ 1905.367921] usb 1-2: New USB device strings: Mfr=1, Product=2, SerialNumber=3
[ 1905.367930] usb 1-2: Product: RP2 Boot
[ 1905.367936] usb 1-2: Manufacturer: Raspberry Pi
[ 1905.367942] usb 1-2: SerialNumber: E0C9125B0D9B
[ 1905.372089] usb-storage 1-2:1.0: USB Mass Storage device detected
[ 1905.372772] scsi host2: usb-storage 1-2:1.0
[ 1906.423426] scsi 2:0:0:0: Direct-Access     RPI      RP2              3    PQ: 0 ANSI: 2
[ 1906.424088] sd 2:0:0:0: Attached scsi generic sg0 type 0
[ 1906.425534] sd 2:0:0:0: [sda] 262144 512-byte logical blocks: (134 MB/128 MiB)
[ 1906.426020] sd 2:0:0:0: [sda] Write Protect is off
[ 1906.426029] sd 2:0:0:0: [sda] Mode Sense: 03 00 00 00
[ 1906.426535] sd 2:0:0:0: [sda] No Caching mode page found
[ 1906.426545] sd 2:0:0:0: [sda] Assuming drive cache: write through
[ 1906.441973]  sda: sda1
[ 1906.442082] sd 2:0:0:0: [sda] Attached SCSI removable disk

```

## Output

### Test Thonny with default Python
Successfully use Python in Thonny shell. 
```
Python 3.10.15 (/snap/thonny/239/bin/python3.10)
>>> print(f"Hello World, ", 'Arthur P. Dent')
Hello World,  Arthur P. Dent
>>> 
```

### Test Thonny connection to Pico WH, 2040 MUC, after flashing with UF2 file, see issue 2 above
Successfully use MicroPython in Thonny shell, first time connecting to a RP2040 !
```
MicroPython v1.27.0 on 2025-12-09; Raspberry Pi Pico W with RP2040
Type "help()" for more information.
>>> 
MicroPython v1.27.0 on 2025-12-09; Raspberry Pi Pico W with RP2040
Type "help()" for more information.
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

Raspberry Pi - USB
* Not able to connect Raspberry Pi Pico, [WS](https://raspberrypi.stackexchange.com/questions/120775/not-able-to-connect-raspberry-pi-pico), StackExchange, Raspberry Pi 
* How to get a list of used USB ports, [WS](https://forums.raspberrypi.com/viewtopic.php?t=289108), Raspberry Pi Forum, 
* Raspberry doesn't recognize me disconnecting a USB device, [WS](https://raspberrypi.stackexchange.com/questions/113756/raspberry-doesnt-recognize-me-disconnecting-a-usb-device)
* ...

Raspberry Pi - MicroPython
* MicroPython, [WS](https://www.raspberrypi.com/documentation/microcontrollers/micropython.html), Raspberry Pi, Flash 2040 MCU with file  RPI_PICO_W-20251209-v1.27.0.uf2

Linux
* USB devices are not removed after port power down on Linux, [WS](https://github.com/mvp/uhubctl#usb-devices-are-not-removed-after-port-power-down-on-linux), Github, Linux


