**SWAPI - Information Service** 
    
    -> /information service to find Attacking Starship & check if Princess is on Planet or not
    -> Integration Tests 

**Assumptions & Hypothesis**

    -> SWAPIs are not having Query Params Search functionality, so used Paginated Search approach to look for Entities 
    -> Used Rest Assured to interact with SWAPIs 
    -> Synchrnoized /information service 
    -> Focus on Integration Tests only

**High Level Design of CI/CD**

<img width="1068" alt="Screenshot 2024-01-05 at 8 09 34 AM" src="https://github.com/speektoankur/swapi.sprinter.prod/assets/101249539/8f7891a0-bb45-4cea-9006-fe689fa0162e">


**APIs Interactions Flow**

<img width="1188" alt="Screenshot 2024-01-05 at 2 01 17 AM" src="https://github.com/speektoankur/swapi.sprinter.prod/assets/101249539/e41404cb-5160-4fb0-a102-a9dc3142118f">

**Circle CI - WorkFlow**
    
<img width="1505" alt="Screenshot 2024-01-05 at 1 43 54 AM" src="https://github.com/speektoankur/swapi.sprinter.prod/assets/101249539/855ce64e-9686-4133-bf87-7b517bfb8d07">


**Circle CI - Test Artifacts Capturing**

<img width="1237" alt="Screenshot 2024-01-05 at 1 45 19 AM" src="https://github.com/speektoankur/swapi.sprinter.prod/assets/101249539/70c9f17f-206f-4676-aa93-aa1b329af0d9">


