alter table finances add active tinyint;
alter table expenses add active tinyint;
update finances set active = 1;
update expenses set active = 1;
