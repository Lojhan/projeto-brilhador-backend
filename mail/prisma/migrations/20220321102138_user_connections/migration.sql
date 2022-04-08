-- AlterTable
ALTER TABLE "users" ADD COLUMN     "facebookConnection" BOOLEAN NOT NULL DEFAULT false,
ADD COLUMN     "googleConnection" BOOLEAN NOT NULL DEFAULT false;
