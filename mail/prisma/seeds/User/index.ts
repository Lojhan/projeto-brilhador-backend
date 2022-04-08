import {
  HierarchyLevel,
  Prisma,
  PrismaClient,
  Role,
  UserStatus,
} from '@prisma/client';
import { hash } from 'bcryptjs';
import * as names from './names.json';

const hashPassword = async (password: string) => await hash(password, 10);

const UserSeed = async (prisma: PrismaClient): Promise<void> => {
  console.log(`👤 Start User seeding...`);

  names.map(async (name) => {
    console.log(`👤 Seeding ${name}...`);

    // Get random Role
    const role: Role = [Role.INVESTOR, Role.RUBI_AGENT, Role.STARTUP][
      Math.floor(Math.random() * 3)
    ];

    let startup: Prisma.StartupCreateWithoutUserOwnerInput = undefined;
    if (role === Role.STARTUP)
      startup = {
        corporateName: `${name} Inc`,
        documentNumber: `${Math.floor(Math.random() * 1000000000)}`,
        fantasyName: `${name}`,
        foundingDate: new Date(),
      };

    let agentInfo: Prisma.AgentInfoCreateWithoutUserInput = undefined;
    if (role === Role.RUBI_AGENT)
      agentInfo = {
        functionDescription: `${name}`,
        accessLevel: Math.round(Math.random() * 1 + 1),
        hierarchyLevel: 'UNDEFINED',
        registrationNumber: `${Math.floor(Math.random() * 1000000000)}`,
      };

    // Generate default UserInfo
    const UserInfo: Prisma.UserCreateInput = {
      name,
      email: `${name}@prisma.io`,
      password: 'P@ssw0rd',
      role,
      status: UserStatus.ACTIVE,
      documentNumber: `${Math.floor(Math.random() * 1000000000)}`,
    };

    // Creates user
    await prisma.user.create({
      data: {
        ...UserInfo,
        password: await hashPassword(UserInfo.password),
        startup: {
          create: startup,
        },
        agentInfo: {
          create: agentInfo,
        },
      },
    });
  });
};

export default UserSeed;
