# Flight search
> The application has been designed as flight search.

## Table of contents
* [General info](#general-info)
* [Features](#features)
* [Technologies](#technologies)
* [Status](#status)
* [Inspiration](#inspiration)

## General info
>The main feature of the application is flight search system. Not authenticated users has the ability to search one way or multiple flights between two cities, filter them and sign in with facebook or google by oAuth2. 
Logged users can add single flights to their favourite flights, which causes that they will get email with changing price of flight every day.

## Features

### Home search page
![Guest view](./docs/guest_main.png) 
> An unregistered user has the ability to check available cars, departments and have the option of register and sign in. 

![Guest view](./docs/guest_cars.png) 
>User has the ability to view available cars by segments.

![Guest view](./docs/guest_departments.png) 
>User has the ability to view available departments.

### Users view
>The logged in user, in addition to functionalities regarding guests, also have additional features. One of them is the ability to reservation cars.
![Users view](./docs/reservation_1.png) 
> The first step of the booking is to choose the place, date and time of booking. All data is checked and only after checking the correctness of completing the form can you proceed to the next step

![Users view](./docs/reservation_2.png) 
> The second step of booking is to choose a car from the list of available cars in a given time and in a given department.

![Users view](./docs/reservation_3.png) 
> The third step of booking is the optional selection of additional equipment and the number of, for example child seats.

![Users view](./docs/reservation_4.png) 
> The last step of the reservation is its summary with the simultaneous calculation of the total price of the reservation takes into account all the elements of the reservation that the user has entered

![Users view](./docs/user_reservationsList.png) 
>  When the user has made a reservation, he can check the list of reservations, see the details and delete the reservation.

### Worker view
![Worker view](./docs/worker.png)
> Employees have access to orders assigned to them.

>### Coordinator view
 ![Coordinator view](./docs/coordinator.png)
 > Coordinators have the option of assigning orders to employees in a given branch.

>>### Admin view
  ![Admin view](./docs/admin_users.png)
  > Administrators have access to the list of all users and the ability to grant employee rights to users.

>![Admin view](./docs/admin_privilages.png)
   > In addition, they have the option of changing the department and changing employees positions.
>
>### User authentication 
 ![Guest view](./docs/guest_registration.png) 
 ![Guest view](./docs/guest_signIn.png) 
 > Access to individual functionalities depends on the user's authorization, the application has three levels of authorization: 
 guest, user, worker, coordinator and administrator. All data is validated and checked. 
 By logging in, the user is checked the authorization level and access to individual functionalities.

## Technologies
* Java SE 12
* Java EE 8
* Hibernate ORM 5.4.2
* REST API
* Docker
* Wildfly 17.0.1
* Maven 3.3.9
* Freemarker 2.3.29
* Bootstrap 4.3.1
* HTML5, CSS3, JS
* jQuery, AJAX

## Status
Project is: _finished_.

## Inspiration
Own idea.