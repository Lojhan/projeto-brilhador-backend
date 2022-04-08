import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { MailModule } from './mail/mail.module';
import { MessageQueueClientModule } from './message-queue-client/message-queue-client.module';

@Module({
  imports: [
    ConfigModule.forRoot({
      isGlobal: true,
    }),
    MessageQueueClientModule,
    MailModule,
  ],
})
export class AppModule {}
