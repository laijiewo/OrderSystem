create table `order`
(
    OrderID       int(8)     not null
        primary key,
    Date          date       not null,
    PaymentStatus tinyint(1) not null,
    U_PersonID    int(6)     not null
);

create table orderlist
(
    OrderID  int(8) not null
        primary key,
    DishID   int(4) not null,
    Comments char   null,
    constraint DishID
        unique (DishID)
);

create table person
(
    PersonID    int(6)                  not null
        primary key,
    Fname       char                    not null,
    Lname       char                    not null,
    password    int                     not null,
    PhoneNumber int                     not null,
    Gender      enum ('male', 'female') not null
);

create table deliver
(
    OrderID               int                                       not null
        primary key,
    Deli_PersonID         int                                       not null,
    DeliveryStatus        enum ('delivering', 'waiting', 'resting') not null,
    EstimatesDeliveryTime datetime                                  not null,
    constraint Deliver_order_OrderID_fk
        foreign key (OrderID) references `order` (OrderID),
    constraint Deliver_person_PersonID_fk
        foreign key (Deli_PersonID) references person (PersonID)
);

create table deliveryperson
(
    PersonID     int  not null
        primary key,
    DeliveryArea char not null,
    Status       char not null,
    constraint DeliveryPerson_person_PersonID_fk
        foreign key (PersonID) references person (PersonID)
);

create table restaurant
(
    RestaurantID       int(7) not null
        primary key,
    RestaurantName     char   not null,
    Address            char   not null,
    ContactInformation char   not null,
    BusinessHours      char   not null,
    M_PersonID         int(6) not null
);

create table dish
(
    DishID         int(4)     not null
        primary key,
    Name           char       not null,
    Price          float      not null,
    Availability   tinyint(1) null,
    Category       char       not null,
    D_RestaurantID int(7)     not null,
    constraint D_RestaurantID
        foreign key (D_RestaurantID) references restaurant (RestaurantID)
);

create table restaurantmanager
(
    PersonID           int(6) not null
        primary key,
    DateofStartManager date   not null,
    RestaurantID       int(7) not null,
    constraint restaurantmanager_person_PersonID_fk
        foreign key (PersonID) references person (PersonID),
    constraint restaurantmanager_restaurant_RestaurantID_fk
        foreign key (RestaurantID) references restaurant (RestaurantID)
);

create table review
(
    R_PersonID    int(6) not null
        primary key,
    Date          date   not null,
    Rating        float  not null,
    ReviewContent char   null,
    RestaurantID  int(7) not null,
    constraint Date
        unique (Date),
    constraint review_restaurant_RestaurantID_fk
        foreign key (RestaurantID) references restaurant (RestaurantID)
);

create table user
(
    PersonID int not null
        primary key,
    Address  int null,
    constraint User_person_PersonID_fk
        foreign key (PersonID) references person (PersonID)
);





