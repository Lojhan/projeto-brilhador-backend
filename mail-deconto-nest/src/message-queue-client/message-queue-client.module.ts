import { Module } from '@nestjs/common';
import { MailService } from 'src/mail/mail.service';
import { MessageQueueClientSController } from './message-queue-client.controller';
import { RabbitMQModule } from '@golevelup/nestjs-rabbitmq';


@Module({
  imports: [
    RabbitMQModule.forRoot(RabbitMQModule, {
      uri: 'amqp://guest:guest@rabbitmq-server:5673',
      enableControllerDiscovery: true,
    }),
  ],
  providers: [MailService],
  controllers: [MessageQueueClientSController],

})
export class MessageQueueClientModule {}
