-- Insert dummy data into todos table
INSERT INTO todos (id, title, description, done, created_on, updated_on) VALUES
('1c58a3fc-39e8-4d6a-b6f8-a7d4eb0c5887', 'Buy groceries', 'Purchase fruits, vegetables, and milk.', false, CURRENT_TIMESTAMP, NULL),
('2d20e4dd-9f92-4ef8-8416-b8c67b1e2bcb', 'Clean the house', 'Vacuum and organize the living room and bedrooms.', true, CURRENT_TIMESTAMP - INTERVAL 1 DAY, CURRENT_TIMESTAMP - INTERVAL 1 HOUR),
('3e30f5ee-af63-4ff9-9827-c9d89f2e3cba', 'Read a book', 'Finish reading the last 3 chapters of "The Great Gatsby".', false, CURRENT_TIMESTAMP - INTERVAL 2 DAY, NULL),
('4f40g6ff-b074-4ffe-8438-dae90c4f3dc9', 'Workout', 'Do a 30-minute cardio session.', true, CURRENT_TIMESTAMP - INTERVAL 5 DAY, CURRENT_TIMESTAMP - INTERVAL 3 DAY),
('5g50h7gg-c185-4fff-9649-eaf01c5f4ebc', 'Prepare presentation', 'Create slides for the upcoming project meeting.', false, CURRENT_TIMESTAMP - INTERVAL 3 DAY, NULL);