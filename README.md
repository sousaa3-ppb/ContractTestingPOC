# Consumer-driven Contract Testing POC
This is a Consumer Driven Contract Testing (CDCT) approach POC to explain core concepts of contract testing methodology using Pact
framework. 

- Spring boot consumer service: to implement consumer contract tests with Pact-jvm-consumer-Junit5
- Spring boot provider service: to implement contract verification tests with Pact Sprint/Junit Runners
- Docker to spin up an image of Pact Broker to publish and retrieve pacts 

# Motivations to adopt contract testing

A contract is implicitly made between two parties on an integration: a consumer service and a provider service. 

As a **provider** 
I want to assure that the contracts between me and my consumers don't break
so i can deploy safely new developments

As a **consumer**
I want to be assured that my providers still respect the contracts
so i can deploy safely new developments 

Other benefits of Contract testing:

- Helps Providers make changes without being scared of accidentally breaking their Consumers;
- Lets Consumers know that the APIs they consume won’t suddenly break;
- Allows Consumers to develop against API definitions before the Provider API has actually been developed;
- Makes integrating and testing a service in a microservice landscape easier; and
- Serves as an efficient communication tool between Provider and Consumer teams.

# CDCT Pact flow

![pactflow](/docs/pact_flow.png)

#Services 

**Agendas-Consumer**

This is a consumer service which consumes Konami-All-Day agendas from the Konami-all-day-provider service. In the CDCT flow
defines programmatically through unit tests it's contract expectations on two operation of Konami-all-day-provider service.

**Konami-all-day-agendas-provider** 

This is a provider service which provides two operations with Konami-All-Day agendas:

- agendas: retrieves all existing agendas 
- agendas/sprint/{id}: retrieves an agenda by sprint id

# Maven commands

Publish contracts to Pact Broken instance running on Docker: **mvn verify pact:publish**

# Logging

**Matching body (FAILED)**

Getting Agenda from SprintId: 105
    returns a response which
      has status code 200 (OK)
      includes headers
        "Content-Type" with value "application/json" (OK)
      has a matching body (FAILED)

0) get Konami All-Day Agenda 105 returns a response which has a matching body
      $ -> Expected uuid='example' but was missing

        Diff:

        {
        -    "date": "EwrRmN68t2i2Bwpd89zy",
        +    "uuids": "K\ufffd\ufffdQz\ufffdL",
        +    "description": null,
        +    "date": "18/02/2022",
            "sprintId": 105,
            "ceremonies": {
        -        "lunch": "ketiVcmB85e6yQC0X0N2",
        -        "planning": "VJT90OUVNBxXrg3Uwwgh",
        -        "sharingsessions": "qU48HBqRDfGzN0AUBD7M",
        -        "refinement": "srPbSIvfxFrEp2PasfaF",
        -        "retrospective": "NQ5qRgbhwp4kTB0AYc4O"
        -    },
        -    "uuid": "example"
        +        "lunch": "09:30",
        +        "planning": "10:30",
        +        "sharingsessions": "15:00",
        +        "refinement": "09:30",
        +        "retrospective": "09:30"
        +    }
        }

* provider body field + 
* consumer body field - 

**PathMismatch**

20:41:54.168 [Thread-4] DEBUG au.com.dius.pact.core.matchers.RequestMatching - Request mismatch: [PathMismatch(expected=agendas/sprint/105, actual=/agendas/sprint/105, mismatch=null)]

# Future

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
