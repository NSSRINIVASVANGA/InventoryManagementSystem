-- Insert initial suppliers
INSERT INTO supplier (name, contact_info) VALUES ('Supplier A', 'contactA@example.com');
INSERT INTO supplier (name, contact_info) VALUES ('Supplier B', 'contactB@example.com');

-- Insert initial items
INSERT INTO item (name, description, stock_level) VALUES ('Item 1', 'Description for Item 1', 100);
INSERT INTO item (name, description, stock_level) VALUES ('Item 2', 'Description for Item 2', 200);

-- Insert initial orders
INSERT INTO orders (customer_name, order_date, status) VALUES ('Customer 1', '2024-07-01', 'PENDING');
INSERT INTO orders (customer_name, order_date, status) VALUES ('Customer 2', '2024-07-02', 'SHIPPED');

-- Insert initial restock orders
INSERT INTO restock_order (supplier_id, order_date, status) VALUES (1, '2024-07-01', 'ORDERED');
INSERT INTO restock_order (supplier_id, order_date, status) VALUES (2, '2024-07-02', 'RECEIVED');

-- Insert initial order items
INSERT INTO order_item (restock_order_id, order_id, item_id, quantity) VALUES (1, 1, 1, 50);
INSERT INTO order_item (restock_order_id, order_id, item_id, quantity) VALUES (2, 1, 2, 30);