Software Engineering Concepts Assignment 2 - README

This assignment can be built and run using the following commands:

./gradlew build
./gradlew run

The project may take some time to build.

Once the menu is navigated to, if the user wishes to add a Plugin, they may do so by selecting

Manage Plugins>Add Plugin

At this point, the user will need to specify the desired plugin in the following format:

<Package Name>.<Class Name>

For example:

- ProgressPlugin.Progress
- NativePackage.NativeProgressImpl
- MathPlugin.MathFunctions

After a plugin is successfully loaded, the plugin will be run after a python expression is successfully evaluated.

To run a math function such as factorial or fibonacci, the function must be included in the expression:
Examples:
    "factorial(x)"
    "fibonacci(x)"
