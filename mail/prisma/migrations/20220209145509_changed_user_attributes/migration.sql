-- CreateEnum
CREATE TYPE "Role" AS ENUM ('ADMIN', 'USER');

-- CreateEnum
CREATE TYPE "HierarchyLevel" AS ENUM ('CEO', 'DIRECTOR', 'MANAGER', 'WORKER');

-- CreateEnum
CREATE TYPE "StartupInterest" AS ENUM ('GROWTH');

-- AlterTable
ALTER TABLE "users" ADD COLUMN     "birthDate" TIMESTAMP(3),
ADD COLUMN     "corporateName" TEXT,
ADD COLUMN     "facebook" TEXT,
ADD COLUMN     "functionDescription" TEXT,
ADD COLUMN     "hierarchyLevel" INTEGER,
ADD COLUMN     "instagram" TEXT,
ADD COLUMN     "linkedin" TEXT,
ALTER COLUMN "documentNumber" DROP NOT NULL,
ALTER COLUMN "phone" DROP NOT NULL;
