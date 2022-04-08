/*
  Warnings:

  - You are about to drop the column `corporateName` on the `users` table. All the data in the column will be lost.
  - You are about to drop the column `functionDescription` on the `users` table. All the data in the column will be lost.
  - You are about to drop the column `hierarchyLevel` on the `users` table. All the data in the column will be lost.

*/
-- CreateEnum
CREATE TYPE "AccessLevel" AS ENUM ('PRESIDENT', 'VICE_PRESIDENT', 'DIRECTOR', 'MANAGER', 'COORDINATOR');

-- AlterTable
ALTER TABLE "users" DROP COLUMN "corporateName",
DROP COLUMN "functionDescription",
DROP COLUMN "hierarchyLevel",
ADD COLUMN     "gender" TEXT,
ADD COLUMN     "profilePicture" TEXT;

-- DropEnum
DROP TYPE "UserType";

-- CreateTable
CREATE TABLE "agent_infos" (
    "id" TEXT NOT NULL,
    "userId" TEXT NOT NULL,
    "hierarchyLevel" "HierarchyLevel",
    "accessLevel" "AccessLevel",
    "registrationNumber" TEXT,
    "functionDescription" TEXT,

    CONSTRAINT "agent_infos_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "startups" (
    "id" TEXT NOT NULL,
    "userOwnerId" TEXT NOT NULL,
    "documentNumber" TEXT NOT NULL,
    "corporateName" TEXT NOT NULL,
    "fantasyName" TEXT NOT NULL,
    "foundingDate" TIMESTAMP(3) NOT NULL,
    "interest" "StartupInterest" NOT NULL DEFAULT E'GROWTH',
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT "startups_pkey" PRIMARY KEY ("id")
);

-- CreateIndex
CREATE UNIQUE INDEX "agent_infos_userId_key" ON "agent_infos"("userId");

-- CreateIndex
CREATE UNIQUE INDEX "startups_userOwnerId_key" ON "startups"("userOwnerId");

-- CreateIndex
CREATE UNIQUE INDEX "startups_documentNumber_key" ON "startups"("documentNumber");

-- AddForeignKey
ALTER TABLE "agent_infos" ADD CONSTRAINT "agent_infos_userId_fkey" FOREIGN KEY ("userId") REFERENCES "users"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "startups" ADD CONSTRAINT "startups_userOwnerId_fkey" FOREIGN KEY ("userOwnerId") REFERENCES "users"("id") ON DELETE RESTRICT ON UPDATE CASCADE;
