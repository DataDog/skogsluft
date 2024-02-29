# Welcome to Skogsluft!

This is a fork of [OpenJDK JDK repo](https://github.com/openjdk/jdk) containing work on improving profiling features of JDK/JFR.

### Development

The development of features is going to be carried on `feature/*` branches. This is supposed to make the work on features in parallel easier.

Both [Issues](https://github.com/skogsluft/jdk-skogsluft/issues) and [Discussions](https://github.com/skogsluft/jdk-skogsluft/discussions) can be used to facilitate collaboration and share information.

### Building

For build instructions please see the
[online documentation](https://openjdk.org/groups/build/doc/building.html),
or either of these files:

- [doc/building.html](doc/building.html) (html version)
- [doc/building.md](doc/building.md) (markdown version)

See <https://openjdk.org/> for more information about the OpenJDK
Community and the JDK and see <https://bugs.openjdk.org> for JDK issue
tracking.

### Testing

The sanity PR checks in this repository will run `jdk_jfr` and `tier2_serviceability` tests on top of what is regularly run for OpenJDK PRs.
The extra tests are necessary to make sure that the new profiling features are not inadvertently breaking any existing functionality.

The automated sanity checks will be run only for PRs against `master` and `feature/*` branches, as well as any commits/merges to `master`.
For intermediary checks one should trigger the [sanity run](https://github.com/skogsluft/jdk-skogsluft/actions/workflows/main.yml) manually.

### Contributing

Contributions will only be considered from the members of the Skogsluft organization. All members must have an active signed [OCA(Oracle Contributor License)](https://oca.opensource.oracle.com/?ojr=faq).
The terms of the OCA are applicable to all forms of information shared within this project.
