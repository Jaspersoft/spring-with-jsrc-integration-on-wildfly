JSRC integration with Spring
============================

To run your [Spring](http://spring.io) application on [WildFly 8.1](http://wildfly.org) Application Server you can make a few simple steps. First of all `JSRC` is written on [Jersey](https://jersey.java.net) so it is very important to exclude WildFly's JSR 311 implementation [RestEasy](http://resteasy.jboss.org) from your AS and replace it with Jersey implementaion. The proper exclusions in your `WildFly Deployment Structure Descriptor` could be done in the way like this:

```xml
<jboss-deployment-structure>
    <deployment>
        <exclusions>
            <module name="javaee.api" />
            <module name="javax.ws.rs.api"/>
            <module name="org.codehaus.jackson.jackson-core-asl" />
            <module name="org.jboss.resteasy.resteasy-atom-provider" />
            <module name="org.jboss.resteasy.resteasy-cdi" />
            <module name="org.jboss.resteasy.resteasy-crypto" />
            <module name="org.jboss.resteasy.resteasy-jackson-provider" />
            <module name="org.jboss.resteasy.resteasy-jaxb-provider" />
            <module name="org.jboss.resteasy.resteasy-jaxrs" />
            <module name="org.jboss.resteasy.resteasy-jettison-provider" />
            <module name="org.jboss.resteasy.resteasy-jsapi" />
            <module name="org.jboss.resteasy.resteasy-json-p-provider" />
            <module name="org.jboss.resteasy.resteasy-multipart-provider" />
            <module name="org.jboss.resteasy.resteasy-validator-provider-11" />
            <module name="org.jboss.resteasy.resteasy-yaml-provider" />
        </exclusions>
    </deployment>
</jboss-deployment-structure>
```
Also you need to include in your pom file these dependencies
```xml
<dependency>
    <groupId>org.glassfish.jersey.containers</groupId>
    <artifactId>jersey-container-servlet</artifactId>
    <version>2.13</version>
</dependency>
<dependency>
    <groupId>org.glassfish.jersey.containers.glassfish</groupId>
    <artifactId>jersey-gf-cdi</artifactId>
    <version>2.13</version>
</dependency>
```
Module `jersey-gf-cdi` tells the CDI container to leave injections in Jersey code to be handled by Jersey itself.
