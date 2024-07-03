INSERT INTO fire_danger(id, name)
VALUES
(1, 'Незначительная'),
(2, 'Малая'),
(3, 'Средняя');

INSERT INTO weather_data(id, name)
VALUES
('6384666f-d9dc-48b8-b8d2-31baef06b271'::UUID, 'Тестовое название 1'),
('c7d351d0-2b5b-4a75-8bf3-9e46ebbc8ab1'::UUID, 'Тестовое название 2'),
('d1eb4634-e738-48f6-a9cd-f262f2f1ecc3'::UUID ,'Тестовое название 3'),
('51de31d9-27d2-4085-a723-8a6e4b58e7fc'::UUID ,'Тестовое имя для контроллера');

INSERT INTO ffwi(id, name, formula)
VALUES
('10825f4d-2265-4c4f-942b-5a1c5a5839c2'::UUID, 'КППО_для_чтения', '$T_0 * ($T_0 - $T_d)'),
('64fa94d4-b1e3-48ef-9c66-49edb1a9709a'::UUID, 'КППО_для_изменения', 'aafa'),
('b6c057e0-21bb-4656-9625-83dac3eb3af8'::UUID, 'КППО_для_удаления', 'afsfas');

INSERT INTO fwi(id, name, min_value, max_value, ffwi_id, fire_danger_id)
VALUES
('bdcc3917-c9e0-4f89-b151-52b2f826af69'::UUID, 'КПО_чтение_1', 0, 1000, '10825f4d-2265-4c4f-942b-5a1c5a5839c2'::UUID, 1),
('c22e8ac1-a7c6-404b-8318-b9330f87d1cc'::UUID, 'КПО_изменение_2', 1000, 1050, '10825f4d-2265-4c4f-942b-5a1c5a5839c2'::UUID, 2),
('ec6c933d-1936-4a35-b4a3-3daafe87264d'::UUID, 'КПО_удаление_3', 4000, 8000, '10825f4d-2265-4c4f-942b-5a1c5a5839c2'::UUID, 3);