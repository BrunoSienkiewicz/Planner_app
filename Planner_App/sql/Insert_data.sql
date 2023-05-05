-- Insert example data for 'events' table
INSERT INTO events (title, description, date)
VALUES
    ('Team meeting', 'Discuss project progress and next steps', '2023-05-10 14:00:00'),
    ('Client call', 'Discuss project requirements and deliverables', '2023-05-12 10:00:00'),
    ('Product demo', 'Present new features to stakeholders', '2023-05-15 13:30:00'),
    ('Marketing event', 'Attend industry conference', '2023-05-20 09:00:00'),
    ('Product launch', 'Release new product to market', '2023-05-25 12:00:00');

-- Insert example data for 'to_do' table
INSERT INTO to_do (title, description, date, status_id)
VALUES
    ('Research competitors', 'Analyze market trends and competition', '2023-05-08 10:00:00', 1),
    ('Design prototype', 'Create wireframes and mockups', '2023-05-11 14:00:00', 2),
    ('Develop feature', 'Write code for new feature', '2023-05-14 09:00:00', 2),
    ('Test functionality', 'Perform manual and automated tests', '2023-05-18 11:00:00', 2),
    ('Prepare release notes', 'Write documentation and update website', '2023-05-22 16:00:00', 3);
