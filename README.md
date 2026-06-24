# JAX-RPC for Jakarta EE 10

This is an unofficial and minimal (core modules only) port of Apache Axis 1.4.1-SNAPSHOT to Jakarta EE 10. Jakarta EE 10 requires Java 11+.

## Background

The last official release of Axis is 1.4 (from 2006). It is so old that it was built with Ant, not Maven. Fortunately, the Axis repository also contains an unreleased snapshot with important improvements, among them:
 - Maven support,
 - two fixes to support Java 8+ ([AXIS-2909](https://issues.apache.org/jira/browse/AXIS-2909) and [AXIS-2929](https://issues.apache.org/jira/browse/AXIS-2929)),
 - fixes for [all CVEs](https://mvnrepository.com/artifact/org.apache.axis/axis/1.4) that affect Axis 1.4:
   - [CVE-2012-5784](https://www.cve.org/CVERecord?id=CVE-2012-5784), discussed in [AXIS-2883](https://issues.apache.org/jira/browse/AXIS-2883), fixed along with CVE-2014-3596;
   - [CVE-2014-3596](https://www.cve.org/CVERecord?id=CVE-2014-3596), discussed in [AXIS-2905](https://issues.apache.org/jira/browse/AXIS-2905), fixed by commit [af9c7ce](https://github.com/pnavato/jaxrpc4jakarta/commit/af9c7ce8a5b0136b0f31d5571d69173f41bc4b7f);
   - [CVE-2018-8032](https://www.cve.org/CVERecord?id=CVE-2018-8032), discussed in [AXIS-2924](https://issues.apache.org/jira/browse/AXIS-2924), fixed by commit [2e0a5d6](https://github.com/pnavato/jaxrpc4jakarta/commit/2e0a5d6fe66b82ab5b89c8029247dc15e6e17d46);
   - [CVE-2019-0227](https://www.cve.org/CVERecord?id=CVE-2019-0227), fixed by commit [3fcac2c](https://github.com/pnavato/jaxrpc4jakarta/commit/3fcac2ce6f5c6f6c68c42dc8d76564a3ef0575e9);
   - [CVE-2023-40743](https://www.cve.org/CVERecord?id=CVE-2023-40743), fixed by commit [7e66753](https://github.com/pnavato/jaxrpc4jakarta/commit/7e66753427466590d6def0125e448d2791723210).

Another important change in that snapshot is a refactoring of the Maven modules: the main Axis jar has been split into `axis-rt-core` and `axis-rt-jws` (and more). `axis-wsdl4j` has been replaced by [`wsdl4j`](https://mvnrepository.com/artifact/wsdl4j/wsdl4j). The groupId has also changed.

## Rationale

The code of this fork can coexist in your Jakarta EE application with JAX-WS: you can, and should, expose your web service both with JAX-RPC and JAX-WS, sharing the business logic between them, to allow a smooth migration of existing client applications.

## Usage

This project is not published to Maven Central. You need to deploy it to your organization's Maven repository (e.g. Nexus, Artifactory): configure your `settings.xml` / `distributionManagement` as appropriate for your internal repository and execute `mvn deploy`.

The only Axis dependency your Jakarta application should need is:

```xml
<dependency>
    <groupId>org.apache.axis</groupId>
    <artifactId>axis-rt-jws</artifactId>
    <version>1.7.0</version>
</dependency>
```

An intermediate Java 8 release also exists.  It is tagged `1.6.0`.  You can use it to configure this Axis fork in the POMs of your Java 8 application (before migrating to Jakarta) and to test it in your real-world scenarios.  Later, during your migration to Jakarta, you'll simply need to update the version number from `1.6.0` to `1.7.0`.

According to my tests, version 1.6.0 is fully compatible with Axis 1.4 in a Java 8 application (no code changes are required) but with one caveat due to the fix for CVE-2012-5784/CVE-2014-3596.  Suppose that you have a server named `ws-host.mycompany.com` that has an SSL certificate containing the same name, but you have configured a URL like `https://ws-host/path/` because your company's DNS assumes the `mycompany.com` suffix by default.  This URL is no longer accepted by Axis: you have to configure a server name that exactly matches the certificate.

The source code still contains all the original Maven modules, but only the following are referenced by the main POM file:

- `axis-rt-core`
- `axis-rt-jws`
- `axis-jaxrpc`
- `axis-saaj`


## Disclaimer

Your feedback is appreciated, but please be aware that, even after this porting effort, this is legacy, unsupported, build-by-yourself, fix-by-yourself software, and you should plan to migrate away from it as soon as possible.
