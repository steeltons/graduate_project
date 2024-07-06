insert into fire_danger ("name")
values ('Отсутвует'),
('Малая'),
('Средняя'),
('Высокая'),
('Чрезвычайная');

insert into project_role("name")
values
('ADMINISTRATOR'),
('SPECIALIST');

insert into users(login, email, password, role_id)
VALUES
('tcvetkov.so', 'tcvetkov.so@dvfu.ru', '$2a$12$mtloDhRgrrlmOOLJ5W6PQ.ha.v9MvSHDv14Wl.PlWQktYg1lwgFwa', 1);

insert into weather_data (id, "name")
values
('2d85f9cc-1c95-4329-aaaf-b969795521f6'::UUID, 'Температура воздуха'),
('01b4a98b-255f-4777-b765-a7d093a1b1d5'::UUID, 'Температура точки росы'),
('8b205197-8761-468a-bdd4-0e0538e68ff3'::UUID, 'Суточные осадки');

insert into ffwi(id, name, formula)
values ('e86e01f0-bf91-42d9-9873-2e07b1abcb1c'::UUID, 'КППО_Нестеров', '($T_0 + $T_d) * $T_0');

insert into fwi (id, "name", min_value, max_value, ffwi_id, fire_danger_id)
values
(gen_random_uuid(), 'КПО_Нестеров_1', 0, 1000, 'e86e01f0-bf91-42d9-9873-2e07b1abcb1c'::UUID, 1),
(gen_random_uuid(), 'КПО_Нестеров_2', 1001, 4000, 'e86e01f0-bf91-42d9-9873-2e07b1abcb1c'::UUID, 2),
(gen_random_uuid(), 'КПО_Нестеров_3', 4001, 8000, 'e86e01f0-bf91-42d9-9873-2e07b1abcb1c'::UUID, 3),
(gen_random_uuid(), 'КПО_Нестеров_4', 8001, 10000, 'e86e01f0-bf91-42d9-9873-2e07b1abcb1c'::UUID, 4),
(gen_random_uuid(), 'КПО_Нестеров_5', 10001, 10000000.0, 'e86e01f0-bf91-42d9-9873-2e07b1abcb1c'::UUID, 5);

insert into precipitation_table (ffwi_id, min_value, max_value, value)
values ('e86e01f0-bf91-42d9-9873-2e07b1abcb1c'::UUID, 0, 100000000.0, 3);

insert into ffwi_parameter (ffwi_id, weather_data_id, weather_name, formula_parameter)
values
('e86e01f0-bf91-42d9-9873-2e07b1abcb1c'::UUID, '2d85f9cc-1c95-4329-aaaf-b969795521f6'::UUID, 'Температура воздуха', 'T_0'),
('e86e01f0-bf91-42d9-9873-2e07b1abcb1c'::UUID, '01b4a98b-255f-4777-b765-a7d093a1b1d5'::UUID, 'Температура точки росы', 'T_d');