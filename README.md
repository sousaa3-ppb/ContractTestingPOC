# Consumer-driven Contract Testing POC
This a Consumer Driven Contract Testing (CDCT) approach POC to explain core concepts of contract testing methodology using Pact
framework. 

- Spring boot consumer service: to implement consumer contract tests
- Spring boot provider service: to implement contract verification tests 
- Docker to spin up an image of Pact Broker to publish and retrieve pacts 

##Maven commands

Publish contracts to Pact Broken instance running on Docker: **mvn verify pact:publish**



Enhancements in progress: 

- Authentication token on consumer contract tests 
- Provider states 
- Breaking changes examples
- Using Matchers for complex types 
- Support Documentation
