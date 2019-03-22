# cordova-plugin-notification-settings
[![NPM version][npm-version]][npm-url] [![NPM downloads][npm-downloads]][npm-url] [![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://fpcs.mit-license.org)

## Purpose

This plugin is for Android only. It attempts to open the notification settings for the current app. On Android 4.4, the app's main settings page will be opened, as there is no method to jump directly to notification settings.

## Installation

### Prerequisites
This plugin requires Android API level 19 or higher.

### Installing the plugin

This plugin is available on npm. To install the latest stable, simply run:

```bash
cordova plugin add cordova-plugin-notification-settings
```

To install the most recent version from the master branch (may be unstable!), instead run:

```bash
cordova plugin add https://github.com/fpcsjames/cordova-plugin-notification-settings
```

## Usage
The plugin defines the window.plugins.NotificationSettings object, which is available after `deviceready`. To launch the app's notification settings, call:

```js
window.plugins.NotificationSettings.launch(successCallback, failureCallback)
```

*Note: if your project includes other platforms, it is recommended to wrap calls in `if(cordova.platformId == 'android')`.*

## Credits

TODO

## License
[The MIT License (MIT)](http://www.opensource.org/licenses/mit-license.html)

Copyright (c) 2019 Flashpoint Computer Services, LLC <info@flashpointcs.net>

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
