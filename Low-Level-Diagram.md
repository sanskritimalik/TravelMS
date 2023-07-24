~~~text
+----------------------------------+
|          TravelAgency     |
+----------------------------------+
| - id : string
| - travelPackages : List<TravelPackage>
+----------------------------------+
| + addTravelPackage() : void |
| + removeTravelPackage(travelPackage : TravelPackage) : void |
| + getId() : string |
| + setId(id : string) : void |
+----------------------------------+
          ^
          |
          | 1..*
+---------------------------------------+
|             TravelPackage             |
+---------------------------------------+
| - id :string
  - name : string                       |
| - passengerCapacity : int             |
| - itinerary : List<Destination>       |
| - passengers : List<Passenger>        |
+---------------------------------------+
| + getName() : string                  |
| + setName(name : string) : void       |
| + getPassengerCapacity() : int        |
| + setPassengerCapacity(capacity : int) : void
| + getDestinations() : List<Destination>  |
| + addDestination(destination: Destination) : void
| + addPassenger(passenger : Passenger) : void
| + getPassengers() : List<Passenger> 
  + removePassenger(passenger : Passenger) : void
  + removeDestination(destination: Destination) : void
  + printItinerary() : void
  + printPassengerList() : void
  + printPassengerDetails(passenger : Passenger) : void
  + printAvailableActivities() : void 
+---------------------------------------+

          ^
          |
          | 1..*
+-------------------+
|   Destination    |
+-------------------+
| - id : string
  - name : string   |
| - activities : List<Activity> |
+-------------------+
| + getName() : string |
| + setName(name : string) : void |
| + getActivities() : List<Activity> |
| + addActivity(activity : Activity) : void |
| + removeActivity(activity : Activity) : void |
+-------------------+

          ^
          |
          | 1..*
+-------------------+
|     Activity      |
+-------------------+
| - id : string
  - name : string   |
| - description : string |
| - cost : double   |
| - capacity : int  
  - destination : Destination
  - passengers : List<Passenger> |
+-------------------+
| + getName() : string |
| + setName(name : string) : void |
| + getDescription() : string |
| + setDescription(description : string) : void |
| + getCost() : double |
| + setCost(cost : double) : void |
| + getCapacity() : int |
| + setCapacity(capacity : int) : void |
  + addPassenger(passenger: Passenger) : bool
  + getPassengers() : List<Passenger>
  + getSpacesAvailable() : int
+-------------------+
          ^
          |
          | 1..*
+----------------------------------+
|          User      |
+----------------------------------+
| - id : string
| - name : string
+----------------------------------+
| + getName() : string |
| + setName(name: string) : void |
| + getId() : string |
| + setId(id : string) : void |
+----------------------------------+
          ^
          |
          | 1..*
+-------------------+
|     Passenger     |
+-------------------+
|                         |
| - passengerNumber : int |
| - passengerType : PassengerType |
| - balance : double 
  - activities : List<Activity> activities
+-------------------+
| + getName() : string |
| + setName(name : string) : void |
| + getPassengerNumber() : int |
| + setPassengerNumber(number : int) : void |
| + getPassengerType() : PassengerType |
| + setPassengerType(type : PassengerType) : void |
| + getBalance() : double |
| + setBalance(balance : double) : void |
| + addActivity(activity : Activity) : boolean |
| + getActivities() : List<Activity> 
  + getPassengerDetails() : string |
+-------------------+
~~~

