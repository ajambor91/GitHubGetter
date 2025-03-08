# GithubGetter

A simple application for  getting basic Github user and branches data

## Requirements
- Java 23: Required for development and JAR builds.
- GraalVM 23: Required for native builds. Linux is strongly recommended, as native builds on Windows may encounter compatibility issues.
- Quarkus CLI for live coding and extra features (optional)
## Development mode

To run application in dev mode with live coding please run the following command in the application's main directory:

```shell script
./mvnw quarkus:dev
```
Or if you have already installed quarkus-cli, you can execute this:
```bash
quarkus dev
```

## Building

To build application run:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/GitHubGetter-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

You can then execute your native executable with: `./target/GitHubGetter-1.0.0-SNAPSHOT-runner`

### Usage

For get user and his branch informations please go to your browser and type
```bash
    http://localhost:8080/repos/{userName}
```
For a successful response, you should see something like this:
```bash
[
  {
    "repositoryName": "Name of repository",
    "ownerName": "Searched user",
    "branches": [
      {
        "branchName": "Example branch name",
        "lastCommitSHA": "Last commit hash"
      },
      {
        "branchName": "Another branch",
        "lastCommitSHA": "Commit"
      },
    ]
  },
  {
    "repositoryName": "Another respotisoty",
    "ownerName": "Searched user",
    "branches": [
      {
        "branchName": "Example branch name",
        "lastCommitSHA": "Last commit hash"
      }
    ]
  }  
]
```
If GitHub returns an error, such as 'user not found', you will see a response like this.
```bash
{
  "status": 404,
  "message": "Not Found"
}
```

### Testing

For run test, execute this command:

```bash
    mvn test
```

### Note
- Development Mode: Works perfectly on both Windows 11 and Ubuntu 24.04.2 LTS using Java 23.0.2.
- JAR Build: Successfully tested on both platforms.
- Native Build (GraalVM): Works on Ubuntu 24.04.2 LTS but fails on Windows 11 due to compatibility issues.
- Docker Build: Unsuccessful due to compatibility problems with GraalVM and Java 23.

