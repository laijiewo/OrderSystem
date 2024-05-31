create database ordersystem;
use ordersystem;
create table if not exists person
(
    PersonID    char(6)                 not null
        primary key,
    Fname       varchar(50)             not null,
    Lname       varchar(50)             not null,
    password    varchar(25)             not null,
    PhoneNumber char(11)                not null,
    Gender      enum ('male', 'female') not null,
    constraint PersonID
        unique (PersonID)
);

create table if not exists deliveryperson
(
    PersonID     char(8)                                                                                                                               not null
        primary key,
    DeliveryArea enum ('FIRST_TEACHING_BUILDING', 'SECOND_TEACHING_BUILDING', 'THIRD_TEACHING_BUILDING', 'FOURTH_TEACHING_BUILDING', 'GYM', 'LIBRARY') not null,
    Status       enum ('DELIVERING', 'WAITING', 'RESTING')                                                                                             not null,
    constraint deliveryperson_ibfk_1
        foreign key (PersonID) references person (PersonID)
            on update cascade on delete cascade
);

create table if not exists `order`
(
    OrderID  char(8)  not null
        primary key,
    Date     datetime not null,
    PersonID char(6)  not null,
    constraint OrderID
        unique (OrderID),
    constraint order_ibfk_1
        foreign key (PersonID) references person (PersonID)
            on update cascade on delete cascade
);

create table if not exists deliver
(
    OrderID        char(8)                                                  not null
        primary key,
    Deli_PersonID  char(6)                                                  not null,
    DeliveryStatus enum ('WAITING_FOR_DELIVERING', 'DELIVERING', 'ARRIVED') not null,
    constraint deliver_ibfk_1
        foreign key (OrderID) references `order` (OrderID)
            on update cascade on delete cascade,
    constraint deliver_ibfk_2
        foreign key (Deli_PersonID) references person (PersonID)
            on update cascade on delete cascade
);

create index Deli_PersonID
    on deliver (Deli_PersonID);

create index PersonID
    on `order` (PersonID);

create table if not exists restaurant
(
    RestaurantID       char(7)     not null
        primary key,
    RestaurantName     varchar(20) not null,
    Address            varchar(50) not null,
    ContactInformation varchar(50) not null,
    BusinessHours      varchar(50) not null,
    M_PersonID         char(6)     not null,
    constraint RestaurantID
        unique (RestaurantID)
);

create table if not exists dish
(
    DishID         char(4)     not null
        primary key,
    Name           varchar(50) not null,
    Price          float       not null,
    Availability   tinyint(1)  not null,
    D_RestaurantID char(7)     not null,
    constraint dish_ibfk_1
        foreign key (D_RestaurantID) references restaurant (RestaurantID)
            on update cascade on delete cascade
);

create index D_RestaurantID
    on dish (D_RestaurantID);

create table if not exists orderlist
(
    DishID  char(4)      not null,
    OrderID char(8)      not null,
    Comment varchar(100) null,
    number  int          not null,
    primary key (OrderID, DishID),
    constraint orderlist_dish_DishID_fk
        foreign key (DishID) references dish (DishID)
            on update cascade on delete cascade,
    constraint orderlist_order_OrderID_fk
        foreign key (OrderID) references `order` (OrderID)
            on update cascade on delete cascade
);

create table if not exists restaurantmanager
(
    PersonID           char(6) not null
        primary key,
    DateOfStartManager date    not null,
    RestaurantID       char(7) not null,
    constraint restaurantmanager_ibfk_1
        foreign key (PersonID) references person (PersonID)
            on update cascade on delete cascade,
    constraint restaurantmanager_ibfk_2
        foreign key (RestaurantID) references restaurant (RestaurantID)
            on update cascade on delete cascade
);

create index RestaurantID
    on restaurantmanager (RestaurantID);

create table if not exists review
(
    R_PersonID    char(6)      not null,
    Date          datetime     not null,
    Rating        float        not null,
    ReviewContent varchar(100) null,
    RestaurantID  char(7)      not null,
    primary key (R_PersonID, Date),
    constraint review_ibfk_1
        foreign key (R_PersonID) references person (PersonID)
            on update cascade on delete cascade,
    constraint review_ibfk_2
        foreign key (RestaurantID) references restaurant (RestaurantID)
            on update cascade on delete cascade
);

create index RestaurantID
    on review (RestaurantID);

create table if not exists user
(
    PersonID char(6)                                                                                                                               not null
        primary key,
    Address  enum ('FIRST_TEACHING_BUILDING', 'SECOND_TEACHING_BUILDING', 'THIRD_TEACHING_BUILDING', 'FOURTH_TEACHING_BUILDING', 'GYM', 'LIBRARY') null,
    constraint user_ibfk_1
        foreign key (PersonID) references person (PersonID)
            on update cascade on delete cascade
);

    q`w1`