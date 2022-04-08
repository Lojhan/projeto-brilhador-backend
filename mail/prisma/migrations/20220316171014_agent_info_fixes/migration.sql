/*
  Warnings:

  - The values [CEO,WORKER] on the enum `HierarchyLevel` will be removed. If these variants are still used in the database, this will fail.
  - The `accessLevel` column on the `agent_infos` table would be dropped and recreated. This will lead to data loss if there is data in the column.
  - Made the column `hierarchyLevel` on table `agent_infos` required. This step will fail if there are existing NULL values in that column.
  - Made the column `functionDescription` on table `agent_infos` required. This step will fail if there are existing NULL values in that column.

*/
-- AlterEnum
BEGIN;
CREATE TYPE "HierarchyLevel_new" AS ENUM ('UNDEFINED', 'PRESIDENT', 'VICE_PRESIDENT', 'DIRECTOR', 'MANAGER', 'COORDINATOR', 'SUPERVISOR', 'TECHNICIAN', 'ADVISOR');
ALTER TABLE "agent_infos" ALTER COLUMN "hierarchyLevel" TYPE "HierarchyLevel_new" USING ("hierarchyLevel"::text::"HierarchyLevel_new");
ALTER TYPE "HierarchyLevel" RENAME TO "HierarchyLevel_old";
ALTER TYPE "HierarchyLevel_new" RENAME TO "HierarchyLevel";
DROP TYPE "HierarchyLevel_old";
COMMIT;

-- AlterTable
ALTER TABLE "agent_infos" ALTER COLUMN "hierarchyLevel" SET NOT NULL,
ALTER COLUMN "hierarchyLevel" SET DEFAULT E'UNDEFINED',
DROP COLUMN "accessLevel",
ADD COLUMN     "accessLevel" INTEGER NOT NULL DEFAULT 1,
ALTER COLUMN "functionDescription" SET NOT NULL;

-- DropEnum
DROP TYPE "AccessLevel";
