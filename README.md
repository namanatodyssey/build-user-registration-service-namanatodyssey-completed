# Task Overview

Utkrusht is building a lightweight user onboarding service where learners can register for access to assessments and learning journeys. A basic Spring Boot application has been created with a single registration endpoint, but it currently accepts invalid data and performs all work synchronously. This can lead to bad data in the system and slower response times when additional background setup is introduced.

You are responsible for improving the registration flow so that invalid requests are rejected with clear messages and the non-critical background operations run asynchronously without blocking the main HTTP request. The product team wants a more robust, responsive API that still keeps the code simple and easy to maintain.

## Objectives

- Implement validation rules on the user registration request so that only well-formed data (username, email, password, age) is accepted by the API.
- Ensure the registration endpoint triggers validation and returns a structured error response when incoming data does not meet the business rules.
- Build a mechanism to consistently handle validation errors across the application and return readable JSON responses with details about which fields failed.
- Introduce a simple asynchronous background step that simulates post-registration processing (such as creating a default profile) without delaying the main registration response.
- Ensure the main registration call remains focused on validating input, creating a new user record, and returning a clear success result.
- Keep controller, service, and data access logic separated so that responsibilities are clearly defined and the code is easy to extend and test.
- Maintain straightforward, readable code that follows common naming conventions and is understandable to other team members reviewing it.

## How to Verify

- Start the application and confirm that it runs without startup errors and exposes the /api/users/register endpoint.
- Send a valid registration request with all required fields populated correctly and confirm that the API returns a successful response with appropriate user information.
- Send registration requests with missing or malformed fields (for example, an empty username, invalid email format, too short password, or age outside the allowed range) and verify that the API returns a 400-style error with clear details for each invalid field.
- Confirm that validation errors are returned in a consistent JSON structure, including which field failed and a human-readable message.
- Check that the core registration response is returned quickly even if there is additional background processing, indicating that asynchronous behavior is working as expected.
- Try multiple registration calls in quick succession and ensure the application remains responsive while background work still runs.
- Review the code organization to verify that validation is applied at the model level, that error handling is centralized, and that the async behavior is isolated within the appropriate service layer.

## Helpful Tips

- Consider how to declare constraints directly on the registration request fields so that invalid data is rejected early in the request lifecycle.
- Think about how the web layer can trigger validation automatically when handling incoming JSON payloads.
- Explore how a centralized error handling component can catch validation-related exceptions and convert them into a clean error response format.
- Review how to separate the immediate work required for registration from additional background steps that do not need to complete before sending the HTTP response.
- Look into how simple asynchronous execution can be enabled in a Spring Boot application and how it affects the flow of control.
- Consider which parts of the process should remain synchronous for correctness and which can safely be moved to background execution.
- Think about how to keep the service layer focused on business rules and data interaction, leaving request mapping and response creation to the controller.
- Explore how to represent error information so that API clients can easily understand and display validation messages to end users.
- Review how dependency injection can help wire controllers, services, and repositories without manual object creation.
- Consider basic performance implications of doing unnecessary heavy work inside controller methods and how offloading that work can improve responsiveness.
