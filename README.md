# Consumer-driven Contract Testing POC
This is a Consumer Driven Contract Testing (CDCT) approach POC to explain core concepts of contract testing methodology using Pact
framework. 

- Spring boot consumer service: to implement consumer contract tests with Pact-jvm-consumer-Junit5
- Spring boot provider service: to implement contract verification tests with Pact Sprint/Junit Runners
- Docker to spin up an image of Pact Broker to publish and retrieve pacts 

# CDCT Pact flow

![pactflow](/docs/pact_flow.png)

# Maven commands

Publish contracts to Pact Broken instance running on Docker: **mvn verify pact:publish**

#Future

Enhancements in progress: 

- Authentication token header on consumer contract tests and use provider states to create it before running verification contracts 
- Provider states - OK 
- Breaking changes examples - OK
- Using Matchers for complex types - OK
- Support Documentation

Themes to explore:
 
 - CI/CD pipeline integrations (e.g: can_i_deploy tool, web hooks to trigger provider verification build) 
 - Parallel execution
 - Running junit with current testNG unit tests
 - Dependencies
 - Message-driven contract testing
