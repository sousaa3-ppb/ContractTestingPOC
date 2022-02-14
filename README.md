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
