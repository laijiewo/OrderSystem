create database orderSystem;
USE orderSystem;

create table person
(
    PersonID    CHAR(6)                  not null
        primary key,
    Fname       VARCHAR(50)                    not null,
    Lname       VARCHAR(50)              not null,
    password    VARCHAR(25)              not null,
    PhoneNumber     CHAR(11)            not null,
    Gender      enum ('male', 'female') not null,
    UNIQUE (PersonID)
);

create table restaurant
(
    RestaurantID       CHAR(7) not null
        primary key,
    RestaurantName     VARCHAR(20)   not null,
    Address            VARCHAR(50)   not null,
    ContactInformation VARCHAR(50)   not null,
    BusinessHours      VARCHAR(50)   not null,
    M_PersonID         CHAR(6)       not null,
    UNIQUE (RestaurantID)
);
    create table `order`
(
    OrderID       CHAR(8)        not null
        primary key,
    Date          DATETIME       not null,
    PaymentStatus boolean        not null,
    PersonID      CHAR(6)        not null,
    UNIQUE (OrderID),
    FOREIGN KEY (PersonID) REFERENCES person(PersonID) ON DELETE CASCADE ON UPDATE CASCADE
);

create table dish
(
    DishID         CHAR(4)     not null
        primary key,
    Name           VARCHAR(50)        not null,
    Price          float       not null,
    Availability   boolean     not null,
    D_RestaurantID CHAR(7)     not null,
    foreign key (D_RestaurantID) references restaurant (RestaurantID)
);


create table orderlist
(
    OrderID  CHAR(8) not null
        primary key,
    DishID   CHAR(4) not null,
    Comments VARCHAR(100)   null,
    FOREIGN KEY (OrderID) REFERENCES `order`(OrderID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (DishID) REFERENCES dish(DishID) ON DELETE CASCADE ON UPDATE CASCADE
);

create table deliver
(
    OrderID               char(8)                                       not null
        primary key,
    Deli_PersonID         char(6)                                       not null,
    DeliveryStatus        enum ('DELIVERING', 'WAITING_FOR_DELIVERY', 'ARRIVED') not null,
    foreign key (OrderID) references `order` (OrderID) ON DELETE CASCADE,
    foreign key (Deli_PersonID) references person (PersonID)
);
create table deliveryPerson
(
    PersonID     CHAR(8)  not null
        primary key,
    DeliveryArea ENUM ('FIRST_TEACHING_BUILDING', 'SECOND_TEACHING_BUILDING', 'THIRD_TEACHING_BUILDING', 'Fourth_TEACHING_BUILDING',
    'GYM', 'LIBRARY') not null,
    Status       ENUM ('DELIVERING', 'WAITING', 'RESTING') not null,
    foreign key (PersonID) references person (PersonID) ON DELETE CASCADE
);




create table restaurantManager
(
    PersonID           CHAR(6) not null
        primary key,
    DateOfStartManager date   not null,
    RestaurantID       CHAR(7) not null,
    foreign key (PersonID) references person (PersonID) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (RestaurantID) references restaurant (RestaurantID) ON DELETE CASCADE ON UPDATE CASCADE
);

create table review
(
    R_PersonID    CHAR(6) not null,
    Date          DATETIME   not null,
    Rating        float  not null,
    ReviewContent VARCHAR(100)   null,
    RestaurantID  CHAR(7) not null,
    PRIMARY KEY (R_PersonID, Date),
    foreign key (R_PersonID) references person(PersonID) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (RestaurantID) references restaurant (RestaurantID) ON DELETE CASCADE ON UPDATE CASCADE
);

create table user
(
    PersonID CHAR(6) not null
        primary key,
    Address VARCHAR(50) null,
    foreign key (PersonID) references person (PersonID) ON DELETE CASCADE ON UPDATE CASCADE
);

