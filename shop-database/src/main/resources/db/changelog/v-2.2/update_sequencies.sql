SELECT setval('manufacturer_id_seq', (select max(id)+1 from manufacturer), FALSE);
SELECT setval('category_id_seq', (select max(id)+1 from category), FALSE);
SELECT setval('roles_id_seq', (select max(id)+1 from roles), FALSE);
SELECT setval('users_id_seq', (select max(id)+1 from users), FALSE);