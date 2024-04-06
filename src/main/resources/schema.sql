CREATE TABLE Product (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         price DOUBLE NOT NULL,
                         ordered INT NOT NULL,
                         available INT NOT NULL
);
INSERT INTO Product (price, ordered, available)
VALUES
    (10.99, 5, 10),
    (20.49, 3, 15),
    (15.79, 7, 20);


CREATE TABLE coupon (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        code VARCHAR(255) NOT NULL,
                        discount DOUBLE NOT NULL
);
CREATE TABLE Users (
                      user_Id BIGINT PRIMARY KEY
);
CREATE TABLE Orders (
                         order_Id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         amount DOUBLE PRECISION NOT NULL,
                         date DATE NOT NULL,
                         coupon VARCHAR(255),
                         user_Id BIGINT REFERENCES Users(user_Id)

);
INSERT INTO coupon (code, discount) VALUES ('OFF5', 5.0);
INSERT INTO coupon (code, discount) VALUES ('OFF10', 10.0);




INSERT INTO Users (user_Id)
VALUES
    (10001);


-- Insert Order data (if not already inserted)
INSERT INTO Orders (order_Id, amount, date, coupon, user_Id)
VALUES
    (100, 950.00, '2021-11-25', 'OFF5', 10001),
    (101, 900.00, '2021-12-10', NULL, 10001);


-- Create the Transactions table
CREATE TABLE Transactions (
                              transaction_Id VARCHAR(255) PRIMARY KEY,
                              description VARCHAR(255),
                              status VARCHAR(255),
                              order_Id BIGINT REFERENCES Orders(order_Id)
);

-- Insert random data into the Transactions table
-- INSERT INTO Transactions (transaction_Id, description, status, order_Id) VALUES
--                                                                              ('tran010100001', 'Payment successful', 'successful', 100),
--                                                                              ('tran010100002', 'Payment failed as amount is invalid', 'failed', 100),
--                                                                              ('tran010100003', 'Payment failed from bank', 'failed', 100),
--                                                                              ('tran010100004', 'Payment failed due to invalid order id', 'failed', 100),
--                                                                              ('tran010100005', 'No response from payment server', 'failed', 100),
--                                                                              ('tran010100006', 'Order is already paid for', 'failed', 100);
