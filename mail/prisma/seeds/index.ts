import { PrismaClient } from '@prisma/client';
import UserSeed from './User';

const prisma = new PrismaClient();

async function main() {
  console.log(`🌱 Start seeding ...`);

  await UserSeed(prisma);

  console.log(`🌱 Seeding complete!`);
}

main()
  .catch((e) => {
    console.error(e);
    process.exit(1);
  })
  .finally(async () => {
    await prisma.$disconnect();
  });
