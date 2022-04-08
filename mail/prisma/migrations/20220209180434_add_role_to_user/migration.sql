/*
  Warnings:

  - The `hierarchyLevel` column on the `users` table would be dropped and recreated. This will lead to data loss if there is data in the column.

*/
-- AlterTable
ALTER TABLE "users" ADD COLUMN     "role" "Role" NOT NULL DEFAULT E'USER',
DROP COLUMN "hierarchyLevel",
ADD COLUMN     "hierarchyLevel" "HierarchyLevel";
