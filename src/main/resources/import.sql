INSERT INTO Transaction(name, transactionTypeId, transactionDate, amount, category) VALUES (
    'Ifood', 
    1, 
    '2025-03-26', 
    -52.00, 
    'Food'
);
INSERT INTO Transaction(name, transactionTypeId, transactionDate, amount, category) VALUES (
    'Salary', 
    2, 
    '2025-03-27', 
    5300.00, 
    'Salary'
);

INSERT INTO Transaction_Type(name) VALUES ('Expense');
INSERT INTO Transaction_Type(name) VALUES ('Income');

INSERT INTO Bank_Account(name, accountNumber, agencyNumber) VALUES (
    'José da Silva', 
    '123456', 
    '001'
);
INSERT INTO Bank_Account(name, accountNumber, agencyNumber) VALUES (
    'Rafael Pinto', 
    '41232', 
    '004'
);