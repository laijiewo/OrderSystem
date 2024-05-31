
USE ordersystem;


INSERT INTO person (PersonID, Fname, Lname, password, PhoneNumber, Gender) VALUES
('M00001', 'John', 'Doe', '123456', '12345678901', 'male'),
('M00002', 'Jane', 'Smith', '123456', '12345678902', 'female'),
('P00001', 'Michael', 'Brown', '123456', '12345678903', 'male'),
('P00002', 'Emily', 'Davis', '123456', '12345678904', 'female'),
('DP0001', 'Mi', 'Bran', '123456', '12345678905', 'male'),
('DP0002', 'Mike', 'Bill', '123456', '12345678906', 'male'),
('DP0003', 'Emi', 'Diva', '123456', '12345678907', 'female');


INSERT INTO deliveryperson (PersonID, DeliveryArea, Status) VALUES
('DP0001', 'FIRST_TEACHING_BUILDING', 'WAITING'),
('DP0002', 'SECOND_TEACHING_BUILDING', 'DELIVERING'),
('DP0003', 'THIRD_TEACHING_BUILDING', 'RESTING');


INSERT INTO `order` (OrderID, Date, PersonID) VALUES
('O000001', '2024-01-01 12:00:00', 'P00001'),
('O000002', '2024-01-02 13:00:00', 'P00002');


INSERT INTO deliver (OrderID, Deli_PersonID, DeliveryStatus) VALUES
('O000001', 'DP0001', 'WAITING_FOR_DELIVERING'),
('O000002', 'DP0002', 'DELIVERING');


INSERT INTO restaurant (RestaurantID, RestaurantName, Address, ContactInformation, BusinessHours, M_PersonID) VALUES
('R00001', 'Tasty Food', '123 Main St', '123-456-7890', '9:00 AM - 9:00 PM', 'M00001'),
('R00002', 'Yummy Bites', '456 Elm St', '123-456-7891', '10:00 AM - 10:00 PM', 'M00002');


INSERT INTO dish (DishID, Name, Price, Availability, D_RestaurantID) VALUES
('D001', 'Burger', 5.99, 1, 'R00001'),
('D002', 'Pizza', 8.99, 1, 'R00001'),
('D003', 'Salad', 4.99, 1, 'R00002');


INSERT INTO orderlist (DishID, OrderID, Comment, number) VALUES
('D001', 'O000001', 'Extra cheese', 2),
('D002', 'O000001', 'No onions', 1),
('D003', 'O000002', 'Add chicken', 3);


INSERT INTO restaurantmanager (PersonID, DateOfStartManager, RestaurantID) VALUES
('M00001', '2023-01-01', 'R00001'),
('M00002', '2023-02-01', 'R00002');


INSERT INTO review (R_PersonID, Date, Rating, ReviewContent, RestaurantID) VALUES
('P00001', '2024-01-10 14:00:00', 4.5, 'Great food!', 'R00001'),
('P00002', '2024-01-11 15:00:00', 3.8, 'Good service.', 'R00002');


INSERT INTO user (PersonID, Address) VALUES
('P00001', 'FIRST_TEACHING_BUILDING'),
('P00002', 'SECOND_TEACHING_BUILDING');

