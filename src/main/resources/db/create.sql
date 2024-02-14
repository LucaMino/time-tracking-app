CREATE TABLE "activity_task"(
    "id" BIGINT NOT NULL,
    "activity_id" BIGINT NULL,
    "task_id" BIGINT NOT NULL
);
ALTER TABLE
    "activity_task" ADD PRIMARY KEY("id");
CREATE TABLE "users"(
    "id" BIGINT NOT NULL,
    "first_name" VARCHAR(255) NOT NULL,
    "last_name" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    "email_verified_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL
);
ALTER TABLE
    "users" ADD PRIMARY KEY("id");
CREATE TABLE "organization_user"(
    "id" BIGINT NOT NULL,
    "user_id" BIGINT NOT NULL,
    "organization_id" BIGINT NOT NULL,
    "role_id" BIGINT NOT NULL,
    "start_date" DATE NOT NULL,
    "end_date" DATE NOT NULL
);
ALTER TABLE
    "organization_user" ADD PRIMARY KEY("id");
CREATE TABLE "activities"(
    "id" BIGINT NOT NULL,
    "name" BIGINT NOT NULL,
    "hours_logged" DOUBLE PRECISION NOT NULL
);
ALTER TABLE
    "activities" ADD PRIMARY KEY("id");
CREATE TABLE "projects"(
    "id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "slug" VARCHAR(255) NOT NULL,
    "time_limit" BIGINT NOT NULL,
    "icon" VARCHAR(255) NOT NULL,
    "organization_id" BIGINT NOT NULL
);
ALTER TABLE
    "projects" ADD PRIMARY KEY("id");
CREATE TABLE "tasks"(
    "id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "slug" VARCHAR(255) NOT NULL,
    "time_limit" BIGINT NOT NULL,
    "project_id" BIGINT NOT NULL
);
ALTER TABLE
    "tasks" ADD PRIMARY KEY("id");
CREATE TABLE "roles"(
    "id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "slug" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "roles" ADD PRIMARY KEY("id");
CREATE TABLE "organizations"(
    "id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "slug" VARCHAR(255) NOT NULL,
    "vat_number" BIGINT NOT NULL,
    "icon" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "organizations" ADD PRIMARY KEY("id");
ALTER TABLE
    "activity_task" ADD CONSTRAINT "activity_task_activity_id_foreign" FOREIGN KEY("activity_id") REFERENCES "activities"("id");
ALTER TABLE
    "organization_user" ADD CONSTRAINT "organization_user_organization_id_foreign" FOREIGN KEY("organization_id") REFERENCES "organizations"("id");
ALTER TABLE
    "tasks" ADD CONSTRAINT "tasks_project_id_foreign" FOREIGN KEY("project_id") REFERENCES "projects"("id");
ALTER TABLE
    "organization_user" ADD CONSTRAINT "organization_user_role_id_foreign" FOREIGN KEY("role_id") REFERENCES "roles"("id");
ALTER TABLE
    "projects" ADD CONSTRAINT "projects_organization_id_foreign" FOREIGN KEY("organization_id") REFERENCES "organizations"("id");
ALTER TABLE
    "organization_user" ADD CONSTRAINT "organization_user_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "users"("id");
ALTER TABLE
    "activity_task" ADD CONSTRAINT "activity_task_task_id_foreign" FOREIGN KEY("task_id") REFERENCES "tasks"("id");