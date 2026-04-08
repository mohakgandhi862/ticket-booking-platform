# ticket-booking-platform

Please refer to below attached doc to check the detailed solution
Solution doc : https://docs.google.com/document/d/1LXNpt_mw1BB9LH8FYG4E1wOpFQt0QmLSRuBxG6mva-k/edit?tab=t.0

Please check Application.java file for sample code run
& output in booking.platform/src/main/resources/Run file for output

## Sections implemented :
1. Read scenario to find all theatres, screens displaying movie shows 
in particular city
2. Write scenario to create shows & create bookings for customers.
3. Fetch details of bookings
4. Get details of all shows, theatres, screens, movies & individual entity.
5. Creation of these entities show, theatre, screen, movie, individual

## Skipped sections :
1. Unique Id generation of all entities - currently we are passing all ids while creating. 
2. Payment endpoints implementation 
3. Fetching & Writing to DB schema 
4. Repository/Dao implementations interacting with schema
5. Use of interfaces for simplicity

## Design Principles followed :
1. Single Responsibility Principle
2. Dependency Injection
Others are not followed effectively but can be used with interfaces