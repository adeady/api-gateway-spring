# About
This is a grails spring security app with oauth2.  It is a prototype for an authentication service.  

## To Use
Fire it up `grails app-run`

Navigate to: http://localhost:9090/grails-oauth-service/oauth/authorize?response_type=code&client_id=my-client&scope=read

http://localhost:9090/grails-oauth-service/oauth/authorize?response_type=token&client_id=my-client&scope=read

This will redirect you to the login page.  user: `user` and password: `password`.  Hopefully you had dev tools running to copy the code right before it redirects to randomland.

code kinda looks like `code=24Gfn7`  You will want this.

NOW:


code: code=24Gfn7