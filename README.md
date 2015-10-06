This is a prototype system for an authentication service in a Service Oriented Architecture (SOA) or Microservices.  

The current design is 3 spring boot applications:
  - **authentication service**: Uses spring oauth2 to authenticate users
  - **resource service**: A basic rest service that authenticates with the authentication service
  - **ui service**: Uses zuul routing to create a lightweight api gateway and simple angluar application for UI

# To run:
1. go into each directory and type `gradle bootRun`
2. when the authentication service starts, pay attention to the default password that pops up in the console.
  eg.
```
...
2015-09-30 16:51:19.695  INFO 8664 --- [ost-startStop-1] b.a.s.AuthenticationManagerConfiguration :

Using default security password: 4fda5d23-3103-42e8-b94e-6a91f0759302

2015-09-30 16:51:20.105  INFO 8664 --- [ost-startStop-1] .s.o.p.e.FrameworkEndpointHandlerMapping : Mapped "{[/oauth/token],methods=[GET]}" onto public org.springframework.http.ResponseEntity<org.springframework.security.oauth2.common.OAuth2AccessToken> org.springframework.security.oauth2.provider.endpoint.TokenEndpoint.getAccessToken(java.security.Principal,java.util.Map<java.lang.String, java.lang.String>) throws org.springframework.web.HttpRequestMethodNotSupportedException
...
```

3. navigate to the ui homepage at `http://localhost:8080/`
4. click login.  Login with **user**: *user* **password**: *~copied from log~*
5. you should be navigated back to the homepage with a filled in message.  The content from the message is served from the resource service.

## Flow:

1. sign-in:
http://localhost:9999/uaa/oauth/authorize?client_id=acme&redirect_uri=http://localhost:8080/login&response_type=code
> note: client_id and redirect_uri will be specific to the mobile app

> pay attention to the XSRF-TOKEN cookie, you will need to copy it and paste it into the header below

2. GET on resource token: http://localhost:8080/resource with header `X-XSRF-TOKEN:(copied XSRF-TOKEN)`

# TODO:
- [x] ~~stop making you check accept for user client at loging~~ Turns out the user only accepts once.
  - [ ] understand how the domain model is accessed
- [x] get pure http calls working so that I know how to call stuffs
- [ ] get h2 working with security service again
- [ ] create script to at least fire up auth service and rest service
- [ ] allow user to create account on auth service
- [ ] create design diagram with arrows explaining web traffic
